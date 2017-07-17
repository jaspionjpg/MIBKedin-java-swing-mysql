package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Vaga;
import Controler.ConnectionFactory;

public class VagaDAO {
	private Connection connection;
	
	public VagaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Vaga vaga) {
		String sql = "insert into vaga " +
		            "(cidade,dataCadastro,descricao,setor,titulo,idEmpresa)" +
		            " values (?,?,?,?,?,?)";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        stmt.setString(1, vaga.getCidade());
	        stmt.setString(2, vaga.getDataCadastro());
	        stmt.setString(3, vaga.getDescricao());
	        stmt.setString(4, vaga.getSetor());
	        stmt.setString(5, vaga.getTitulo());
	        stmt.setLong(6, vaga.getIdEmpresa());

	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<Vaga> pegaTodasVagas() {
		List<Vaga> vagas = new ArrayList<>();
		try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs;

        	rs = stmt.executeQuery("SELECT * FROM vaga INNER JOIN empresa ON empresa.id = vaga.idEmpresa");
        	while (rs.next()) {
        		Vaga vaga = new Vaga();
        		vaga.setCidade(rs.getString("cidade"));
        		vaga.setDescricao(rs.getString("descricao"));
        		vaga.setDataCadastro(rs.getString("dataCadastro"));
        		vaga.setSetor(rs.getString("setor"));
				vaga.setTitulo(rs.getString("titulo"));
				vaga.setIdEmpresa(rs.getLong("idEmpresa"));
				vaga.setNomeEmpresa(rs.getString("nome"));
				
				vagas.add(vaga);
        	}
        	connection.close();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		return vagas;
	}
}
