package Beans;

public class Candidato {
	private Long id;
	
	private String nome;
	private String email;
	private String descricao;
	private String cidade;
	private String endereco;
	private String telefone;
	
	private String dataNascimento;
	
	private String cargos;
	private String empresas;
	private String cursos;
	private String escolas;

	private String login;
	private String senha;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCargos() {
		return cargos;
	}
	
	public void setCargos(String cargos) {
		this.cargos = cargos;
	}
	
	public String getEmpresas() {
		return empresas;
	}
	
	public void setEmpresas(String empresas) {
		this.empresas = empresas;
	}
	
	public String getCursos() {
		return cursos;
	}
	
	public void setCursos(String cursos) {
		this.cursos = cursos;
	}
	
	public String getEscolas() {
		return escolas;
	}
	
	public void setEscolas(String escolas) {
		this.escolas = escolas;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}