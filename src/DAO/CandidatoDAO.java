package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Candidato;
import Controler.ConnectionFactory;

public class CandidatoDAO {
	private Connection connection;
	
	public CandidatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Candidato candidato) {
		String sql = "insert into candidato " +
		            "(nome,email,descricao,cidade,endereco,telefone,dataNascimento,cargos,empresas,cursos,escolas,login,senha)" +
		            " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        stmt.setString(1, candidato.getNome());
	        stmt.setString(2, candidato.getEmail());
	        stmt.setString(3, candidato.getDescricao());
	        stmt.setString(4, candidato.getCidade());
	        stmt.setString(5, candidato.getEndereco());
	        stmt.setString(6, candidato.getTelefone());
	        stmt.setString(7, candidato.getDataNascimento());
	        stmt.setString(8, candidato.getCargos());
	        stmt.setString(9, candidato.getEmpresas());
	        stmt.setString(10, candidato.getCursos());
	        stmt.setString(11, candidato.getEscolas());
	        stmt.setString(12, candidato.getLogin());
	        stmt.setString(13, candidato.getSenha());

	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void deleta(Candidato candidato) {
		String sql = "DELETE FROM candidato " +
		            " WHERE id = ?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        stmt.setLong(1, candidato.getId());

	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void atualiza(Candidato candidato) {
		String sql = "UPDATE candidato " +
		            " SET nome = ?, email = ?,descricao = ?,cidade = ?,endereco = ?,telefone = ?,dataNascimento = ?,cargos = ?,empresas = ?,cursos = ?,escolas = ?,login = ?,senha = ?" +
		            " WHERE id = ?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        stmt.setString(1, candidato.getNome());
	        stmt.setString(2, candidato.getEmail());
	        stmt.setString(3, candidato.getDescricao());
	        stmt.setString(4, candidato.getCidade());
	        stmt.setString(5, candidato.getEndereco());
	        stmt.setString(6, candidato.getTelefone());
	        stmt.setString(7, candidato.getDataNascimento());
	        stmt.setString(8, candidato.getCargos());
	        stmt.setString(9, candidato.getEmpresas());
	        stmt.setString(10, candidato.getCursos());
	        stmt.setString(11, candidato.getEscolas());
	        stmt.setString(12, candidato.getLogin());
	        stmt.setString(13, candidato.getSenha());
	        stmt.setLong(14, candidato.getId());

	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public Candidato login(String login, String senha) {
		Candidato candidato = new Candidato();
		try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs;

        	rs = stmt.executeQuery("SELECT * FROM candidato WHERE login LIKE '" + login + "' AND senha LIKE '" + senha + "'");
        	while (rs.next()) {
        		candidato.setId(rs.getLong("id"));
        		candidato.setCidade(rs.getString("cidade"));
				candidato.setDataNascimento(rs.getString("dataNascimento"));
				candidato.setDescricao(rs.getString("descricao"));
				candidato.setEmail(rs.getString("email"));
				candidato.setEndereco(rs.getString("endereco"));
				candidato.setNome(rs.getString("nome"));
				candidato.setTelefone(rs.getString("telefone"));
				candidato.setCargos(rs.getString("cargos"));
				candidato.setEmpresas(rs.getString("empresas"));
				candidato.setCursos(rs.getString("cursos"));
				candidato.setEscolas(rs.getString("escolas"));
        	}
        	connection.close();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		return candidato;
	}
	
	public List<Candidato> pegaTodasCandidatos() {
		List<Candidato> candidatos = new ArrayList<>();
		try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs;

        	rs = stmt.executeQuery("SELECT * FROM candidato");
        	while (rs.next()) {
        		Candidato candidato = new Candidato();
        		candidato.setId(rs.getLong("id"));
        		candidato.setCidade(rs.getString("cidade"));
				candidato.setDataNascimento(rs.getString("dataNascimento"));
				candidato.setDescricao(rs.getString("descricao"));
				candidato.setEmail(rs.getString("email"));
				candidato.setEndereco(rs.getString("endereco"));
				candidato.setNome(rs.getString("nome"));
				candidato.setTelefone(rs.getString("telefone"));
				candidato.setCargos(rs.getString("cargos"));
				candidato.setEmpresas(rs.getString("empresas"));
				candidato.setCursos(rs.getString("cursos"));
				candidato.setEscolas(rs.getString("escolas"));
				
				candidatos.add(candidato);
        	}
        	connection.close();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		return candidatos;
	}
	
	public List<Candidato> procuraTodasCandidatos(String nome, String cidade, String empresa, String escola, String cargo, String curso) {
		List<Candidato> candidatos = new ArrayList<>();
		try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs;
        	
        	String query = "SELECT * FROM candidato WHERE 1 = 1";

			if(nome != null && !nome.trim().equals(""))
				query += " AND nome LIKE '%" + nome + "%'";
			if(cidade != null && !cidade.trim().equals(""))
				query += " AND cidade LIKE '%" + cidade + "%'";
			if(empresa != null && !empresa.trim().equals(""))
				query += " AND empresas LIKE '%" + empresa + "%'";
			if(escola != null && !escola.trim().equals(""))
				query += " AND escolas LIKE '%" + escola + "%'";
			if(cargo != null && !cargo.trim().equals(""))
				query += " AND cargos LIKE '%" + cargo + "%'";
			if(curso != null && !curso.trim().equals(""))
				query += " AND cursos LIKE '%" + curso + "%'";			
        			
			rs = stmt.executeQuery(query);
        	while (rs.next()) {
        		Candidato candidato = new Candidato();
        		candidato.setId(rs.getLong("id"));
        		candidato.setCidade(rs.getString("cidade"));
				candidato.setDataNascimento(rs.getString("dataNascimento"));
				candidato.setDescricao(rs.getString("descricao"));
				candidato.setEmail(rs.getString("email"));
				candidato.setEndereco(rs.getString("endereco"));
				candidato.setNome(rs.getString("nome"));
				candidato.setTelefone(rs.getString("telefone"));
				candidato.setCargos(rs.getString("cargos"));
				candidato.setEmpresas(rs.getString("empresas"));
				candidato.setCursos(rs.getString("cursos"));
				candidato.setEscolas(rs.getString("escolas"));
				
				candidatos.add(candidato);
        	}
        	connection.close();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		return candidatos;
	}
	
	public Long pegaIdUltimoCadastro() {
		Long id = null;
		try {
        	Statement stmt = connection.createStatement();
        	ResultSet rs;

        	rs = stmt.executeQuery("SELECT MAX(id) as 'id' FROM candidato");
        	while ( rs.next() ) {
        		id = rs.getLong("id");
        	}
        	connection.close();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		return id;
	}
}
