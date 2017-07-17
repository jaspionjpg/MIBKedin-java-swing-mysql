package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Empresa;
import Controler.ConnectionFactory;

public class EmpresaDAO {
	private Connection connection;
	public EmpresaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void deleta(Empresa empresa) {
		String sql = "DELETE FROM empresa " +
		            " WHERE id = ?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        stmt.setLong(1, empresa.getId());

	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void atualiza(Empresa empresa) {
		String sql = "UPDATE empresa " +
		            " SET nome = ?, setor = ?,fundacao = ?,cidadeSede = ?,telefone = ?,site = ?,endereco = ?,tamanhoEmpresa = ?,login = ?,senha = ?,descricao = ?" +
		            " WHERE id = ?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        stmt.setString(1, empresa.getNome());
	        stmt.setString(2, empresa.getSetor());
	        stmt.setInt(3, empresa.getFundacao());
	        stmt.setString(4, empresa.getCidadeSede());
	        stmt.setString(5, empresa.getTelefone());
	        stmt.setString(6, empresa.getSite());
	        stmt.setString(7, empresa.getEndereco());
	        stmt.setString(8, empresa.getTamanhoEmpresa());
	        stmt.setString(9, empresa.getLogin());
	        stmt.setString(10, empresa.getSenha());
	        stmt.setString(11, empresa.getDescricao());
	        stmt.setLong(12, empresa.getId());

	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<Empresa> procuraTodasEmpresas(String nome, String setor) {
		List<Empresa> empresas = new ArrayList<>();
		try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs;
        	
        	String query = "SELECT * FROM empresa WHERE 1 = 1";

			if(nome != null && !nome.trim().equals(""))
				query += " AND nome LIKE '%" + nome + "%'";
			if(setor != null && !setor.trim().equals(""))
				query += " AND setor LIKE '%" + setor + "%'";
        			
			rs = stmt.executeQuery(query);
        	while (rs.next()) {
        		Empresa empresa = new Empresa();
        		empresa.setId(rs.getLong("id"));
				empresa.setCidadeSede(rs.getString("cidadeSede"));
				empresa.setDescricao(rs.getString("descricao"));
				empresa.setEndereco(rs.getString("endereco"));
				empresa.setFundacao(rs.getInt("fundacao"));
				empresa.setNome(rs.getString("nome"));
				empresa.setSetor(rs.getString("setor"));
				empresa.setSite(rs.getString("site"));
				empresa.setTamanhoEmpresa(rs.getString("tamanhoEmpresa"));
				empresa.setTelefone(rs.getString("telefone"));
        		
				empresas.add(empresa);
        	}
        	connection.close();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		return empresas;
	}
	
	public void adiciona(Empresa empresa) {
		String sql = "insert into empresa " +
		            "(nome,setor,fundacao,cidadeSede,telefone,site,endereco,tamanhoEmpresa,login,senha,descricao)" +
		            " values (?,?,?,?,?,?,?,?,?,?,?)";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        stmt.setString(1, empresa.getNome());
	        stmt.setString(2, empresa.getSetor());
	        stmt.setInt(3, empresa.getFundacao());
	        stmt.setString(4, empresa.getCidadeSede());
	        stmt.setString(5, empresa.getTelefone());
	        stmt.setString(6, empresa.getSite());
	        stmt.setString(7, empresa.getEndereco());
	        stmt.setString(8, empresa.getTamanhoEmpresa());
	        stmt.setString(9, empresa.getLogin());
	        stmt.setString(10, empresa.getSenha());
	        stmt.setString(11, empresa.getDescricao());

	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public Empresa login(String login, String senha) {
		Empresa empresa = new Empresa();
		try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs;

        	rs = stmt.executeQuery("SELECT * FROM empresa WHERE login LIKE '" + login + "' AND senha LIKE '" + senha + "'");
        	while (rs.next()) {
        		empresa.setId(rs.getLong("id"));
        		empresa.setCidadeSede(rs.getString("cidadeSede"));
				empresa.setDescricao(rs.getString("descricao"));
				empresa.setEndereco(rs.getString("endereco"));
				empresa.setFundacao(rs.getInt("fundacao"));
				empresa.setNome(rs.getString("nome"));
				empresa.setSetor(rs.getString("setor"));
				empresa.setSite(rs.getString("site"));
				empresa.setTamanhoEmpresa(rs.getString("tamanhoEmpresa"));
				empresa.setTelefone(rs.getString("telefone"));
        	}
        	connection.close();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		return empresa;
	}
	
	public List<Empresa> pegaTodasEmpresas() {
		List<Empresa> empresas = new ArrayList<>();
		try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs;

        	rs = stmt.executeQuery("SELECT * FROM empresa");
        	while (rs.next()) {
        		Empresa empresa = new Empresa();
        		empresa.setId(rs.getLong("id"));
				empresa.setCidadeSede(rs.getString("cidadeSede"));
				empresa.setDescricao(rs.getString("descricao"));
				empresa.setEndereco(rs.getString("endereco"));
				empresa.setFundacao(rs.getInt("fundacao"));
				empresa.setNome(rs.getString("nome"));
				empresa.setSetor(rs.getString("setor"));
				empresa.setSite(rs.getString("site"));
				empresa.setTamanhoEmpresa(rs.getString("tamanhoEmpresa"));
				empresa.setTelefone(rs.getString("telefone"));
        		
				empresas.add(empresa);
        	}
        	connection.close();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		return empresas;
	}
	
	public Long pegaIdUltimoCadastro() {
		Long id = null;
		try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs;

        	rs = stmt.executeQuery("SELECT MAX(id) as 'id' FROM empresa");
        	while (rs.next()) {
        		id = rs.getLong("id");
        	}
        	connection.close();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		return id;
	}
}
