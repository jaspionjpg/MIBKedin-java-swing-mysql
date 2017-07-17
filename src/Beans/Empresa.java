package Beans;

public class Empresa {
	private Long id;
	
	private String nome;
	private String setor;
	private Integer fundacao;
	private String cidadeSede;
	private String telefone;

	private String site;
	private String descricao;
	private String endereco;
	private String tamanhoEmpresa;
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public String getSetor() {
		return setor;
	}
	
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String getTamanhoEmpresa() {
		return tamanhoEmpresa;
	}
	
	public void setTamanhoEmpresa(String tamanhoEmpresa) {
		this.tamanhoEmpresa = tamanhoEmpresa;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCidadeSede() {
		return cidadeSede;
	}
	
	public void setCidadeSede(String cidadeSede) {
		this.cidadeSede = cidadeSede;
	}
	
	public Integer getFundacao() {
		return fundacao;
	}
	
	public void setFundacao(Integer fundacao) {
		this.fundacao = fundacao;
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