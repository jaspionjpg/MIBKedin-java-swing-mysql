package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Beans.Empresa;
import DAO.EmpresaDAO;

public class CadastroEmpresa extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 550;
	Integer altura = 540;

	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	Empresa empresa;

	JLabel tituloTxt;
	JLabel obsTxt;
	
	JLabel nomeTxt;
	JLabel descricaoTxt;
	JLabel siteTxt;
	JLabel setorTxt;
	JLabel tamanhoEmpresaTxt;
	JLabel enderecoTxt;
	JLabel cidadeSedeTxt;
	JLabel fundacaoTxt;
	JLabel telefoneTxt;
	JLabel loginTxt;
	JLabel senhaTxt;
	
	JTextField nome;
	JTextField descricao;
	JTextField site;
	JTextField setor;
	JTextField tamanhoEmpresa;
	JTextField endereco;
	JTextField cidadeSede;
	JTextField fundacao;
	JTextField telefone;
	JTextField login;
	JTextField senha;
	
	JButton cadastrar;
	JButton atualizar;
	 
	public CadastroEmpresa() {
		inicializaComponents();
		setVisible(true);
	}
	
	public CadastroEmpresa(Empresa empresa) {
		this.empresa = empresa;
		inicializaComponentsUpdate();
		setVisible(true);
	}

	private void inicializaComponentsUpdate() {
		setTitle("Atualize empresa MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
        
        tituloTxt = new JLabel("Atualize sua empresa");
        tituloTxt.setFont(new Font("arial",20,20));
        tituloTxt.setBounds((largura-220)/2,5,220,25);
        tituloTxt.setForeground(corLetra);
        add(tituloTxt);
        
        nomeTxt = new JLabel("*Nome empresa:");
        nomeTxt.setFont(new Font("arial",20,20));
        nomeTxt.setBounds((largura-160)/2-160,40,160,25);
        nomeTxt.setForeground(corLetra);
        add(nomeTxt);
        
        descricaoTxt = new JLabel("Descrição:");
        descricaoTxt.setFont(new Font("arial",20,20));
        descricaoTxt.setBounds((largura-160)/2-160,75,160,25);
        descricaoTxt.setForeground(corLetra);
        add(descricaoTxt);
        
        siteTxt = new JLabel("Site:");
        siteTxt.setFont(new Font("arial",20,20));
        siteTxt.setBounds((largura-160)/2-160,110,160,25);
        siteTxt.setForeground(corLetra);
        add(siteTxt);
        
        setorTxt = new JLabel("*Setor:");
        setorTxt.setFont(new Font("arial",20,20));
        setorTxt.setBounds((largura-160)/2-160,145,160,25);
        setorTxt.setForeground(corLetra);
        add(setorTxt);
        
        tamanhoEmpresaTxt = new JLabel("Numeros funcionarios:");
        tamanhoEmpresaTxt.setFont(new Font("arial",20,20));
        tamanhoEmpresaTxt.setBounds((largura-160)/2-160,180,200,25);
        tamanhoEmpresaTxt.setForeground(corLetra);
        add(tamanhoEmpresaTxt);
        
        enderecoTxt = new JLabel("Endereço:");
        enderecoTxt.setFont(new Font("arial",20,20));
        enderecoTxt.setBounds((largura-160)/2-160,215,160,25);
        enderecoTxt.setForeground(corLetra);
        add(enderecoTxt);
        
        cidadeSedeTxt = new JLabel("*Cidade:");
        cidadeSedeTxt.setFont(new Font("arial",20,20));
        cidadeSedeTxt.setBounds((largura-160)/2-160,250,160,25);
        cidadeSedeTxt.setForeground(corLetra);
        add(cidadeSedeTxt);
        
        fundacaoTxt = new JLabel("Ano fundacao:");
        fundacaoTxt.setFont(new Font("arial",20,20));
        fundacaoTxt.setBounds((largura-160)/2-160,285,160,25);
        fundacaoTxt.setForeground(corLetra);
        add(fundacaoTxt);
        
        telefoneTxt = new JLabel("*Telefone:");
        telefoneTxt.setFont(new Font("arial",20,20));
        telefoneTxt.setBounds((largura-160)/2-160,320,160,25);
        telefoneTxt.setForeground(corLetra);
        add(telefoneTxt);
        
        loginTxt = new JLabel("*Login:");
        loginTxt.setFont(new Font("arial",20,20));
        loginTxt.setBounds((largura-160)/2-160,355,160,25);
        loginTxt.setForeground(corLetra);
        add(loginTxt);
        
        senhaTxt = new JLabel("*Senha:");
        senhaTxt.setFont(new Font("arial",20,20));
        senhaTxt.setBounds((largura-160)/2-160,390,160,25);
        senhaTxt.setForeground(corLetra);
        add(senhaTxt);
        
        nome = new JTextField(empresa.getNome());
        nome.setFont(new Font("arial",20,20));
        nome.setBounds((largura-160)/2+40,40,275,25);
        nome.setForeground(corLetra);
        add(nome);
        
        descricao = new JTextField(empresa.getDescricao());
        descricao.setFont(new Font("arial",20,20));
        descricao.setBounds((largura-160)/2+40,75,275,25);
        descricao.setForeground(corLetra);
        add(descricao);
        
        site = new JTextField(empresa.getSite());
        site.setFont(new Font("arial",20,20));
        site.setBounds((largura-160)/2+40,110,275,25);
        site.setForeground(corLetra);
        add(site);
        
        setor = new JTextField(empresa.getSetor());
        setor.setFont(new Font("arial",20,20));
        setor.setBounds((largura-160)/2+40,145,275,25);
        setor.setForeground(corLetra);
        add(setor);
        
        tamanhoEmpresa = new JTextField(empresa.getTamanhoEmpresa());
        tamanhoEmpresa.setFont(new Font("arial",20,20));
        tamanhoEmpresa.setBounds((largura-160)/2+40,180,275,25);
        tamanhoEmpresa.setForeground(corLetra);
        add(tamanhoEmpresa);
        
        endereco = new JTextField(empresa.getEndereco());
        endereco.setFont(new Font("arial",20,20));
        endereco.setBounds((largura-160)/2+40,215,275,25);
        endereco.setForeground(corLetra);
        add(endereco);
        
        cidadeSede = new JTextField(empresa.getCidadeSede());
        cidadeSede.setFont(new Font("arial",20,20));
        cidadeSede.setBounds((largura-160)/2+40,250,275,25);
        cidadeSede.setForeground(corLetra);
        add(cidadeSede);
        
        fundacao = new JTextField(empresa.getFundacao());
        fundacao.setFont(new Font("arial",20,20));
        fundacao.setBounds((largura-160)/2+40,285,275,25);
        fundacao.setForeground(corLetra);
        add(fundacao);
        
        telefone = new JTextField(empresa.getTelefone());
        telefone.setFont(new Font("arial",20,20));
        telefone.setBounds((largura-160)/2+40,320,275,25);
        telefone.setForeground(corLetra);
        add(telefone);
        
        login = new JTextField(empresa.getLogin());
        login.setFont(new Font("arial",20,20));
        login.setBounds((largura-160)/2+40,355,275,25);
        login.setForeground(corLetra);
        add(login);
        
        senha = new JTextField(empresa.getSenha());
        senha.setFont(new Font("arial",20,20));
        senha.setBounds((largura-160)/2+40,390,275,25);
        senha.setForeground(corLetra);
        add(senha);
        
        atualizar = new JButton("Atualizar");
        atualizar.setFont(new Font("arial",20,20));
        atualizar.setBounds((largura-170)/2,430,170,40);
        atualizar.setForeground(corLetra);
        atualizar.addActionListener(this);
        add(atualizar);
        
        obsTxt = new JLabel("* = dados obrigatórios");
        obsTxt.setFont(new Font("arial",14,14));
        obsTxt.setBounds((largura-160)/2-160,475,160,25);
        add(obsTxt);
	}

	private void inicializaComponents() {
		setTitle("Cadastro empresa MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
        
        tituloTxt = new JLabel("Cadastre sua empresa");
        tituloTxt.setFont(new Font("arial",20,20));
        tituloTxt.setBounds((largura-220)/2,5,220,25);
        tituloTxt.setForeground(corLetra);
        add(tituloTxt);
        
        nomeTxt = new JLabel("*Nome empresa:");
        nomeTxt.setFont(new Font("arial",20,20));
        nomeTxt.setBounds((largura-160)/2-160,40,160,25);
        nomeTxt.setForeground(corLetra);
        add(nomeTxt);
        
        descricaoTxt = new JLabel("Descrição:");
        descricaoTxt.setFont(new Font("arial",20,20));
        descricaoTxt.setBounds((largura-160)/2-160,75,160,25);
        descricaoTxt.setForeground(corLetra);
        add(descricaoTxt);
        
        siteTxt = new JLabel("Site:");
        siteTxt.setFont(new Font("arial",20,20));
        siteTxt.setBounds((largura-160)/2-160,110,160,25);
        siteTxt.setForeground(corLetra);
        add(siteTxt);
        
        setorTxt = new JLabel("*Setor:");
        setorTxt.setFont(new Font("arial",20,20));
        setorTxt.setBounds((largura-160)/2-160,145,160,25);
        setorTxt.setForeground(corLetra);
        add(setorTxt);
        
        tamanhoEmpresaTxt = new JLabel("Numeros funcionarios:");
        tamanhoEmpresaTxt.setFont(new Font("arial",20,20));
        tamanhoEmpresaTxt.setBounds((largura-160)/2-160,180,200,25);
        tamanhoEmpresaTxt.setForeground(corLetra);
        add(tamanhoEmpresaTxt);
        
        enderecoTxt = new JLabel("Endereço:");
        enderecoTxt.setFont(new Font("arial",20,20));
        enderecoTxt.setBounds((largura-160)/2-160,215,160,25);
        enderecoTxt.setForeground(corLetra);
        add(enderecoTxt);
        
        cidadeSedeTxt = new JLabel("*Cidade:");
        cidadeSedeTxt.setFont(new Font("arial",20,20));
        cidadeSedeTxt.setBounds((largura-160)/2-160,250,160,25);
        cidadeSedeTxt.setForeground(corLetra);
        add(cidadeSedeTxt);
        
        fundacaoTxt = new JLabel("Ano fundacao:");
        fundacaoTxt.setFont(new Font("arial",20,20));
        fundacaoTxt.setBounds((largura-160)/2-160,285,160,25);
        fundacaoTxt.setForeground(corLetra);
        add(fundacaoTxt);
        
        telefoneTxt = new JLabel("*Telefone:");
        telefoneTxt.setFont(new Font("arial",20,20));
        telefoneTxt.setBounds((largura-160)/2-160,320,160,25);
        telefoneTxt.setForeground(corLetra);
        add(telefoneTxt);
        
        loginTxt = new JLabel("*Login:");
        loginTxt.setFont(new Font("arial",20,20));
        loginTxt.setBounds((largura-160)/2-160,355,160,25);
        loginTxt.setForeground(corLetra);
        add(loginTxt);
        
        senhaTxt = new JLabel("*Senha:");
        senhaTxt.setFont(new Font("arial",20,20));
        senhaTxt.setBounds((largura-160)/2-160,390,160,25);
        senhaTxt.setForeground(corLetra);
        add(senhaTxt);
        
        nome = new JTextField();
        nome.setFont(new Font("arial",20,20));
        nome.setBounds((largura-160)/2+40,40,275,25);
        nome.setForeground(corLetra);
        add(nome);
        
        descricao = new JTextField();
        descricao.setFont(new Font("arial",20,20));
        descricao.setBounds((largura-160)/2+40,75,275,25);
        descricao.setForeground(corLetra);
        add(descricao);
        
        site = new JTextField();
        site.setFont(new Font("arial",20,20));
        site.setBounds((largura-160)/2+40,110,275,25);
        site.setForeground(corLetra);
        add(site);
        
        setor = new JTextField();
        setor.setFont(new Font("arial",20,20));
        setor.setBounds((largura-160)/2+40,145,275,25);
        setor.setForeground(corLetra);
        add(setor);
        
        tamanhoEmpresa = new JTextField();
        tamanhoEmpresa.setFont(new Font("arial",20,20));
        tamanhoEmpresa.setBounds((largura-160)/2+40,180,275,25);
        tamanhoEmpresa.setForeground(corLetra);
        add(tamanhoEmpresa);
        
        endereco = new JTextField();
        endereco.setFont(new Font("arial",20,20));
        endereco.setBounds((largura-160)/2+40,215,275,25);
        endereco.setForeground(corLetra);
        add(endereco);
        
        cidadeSede = new JTextField();
        cidadeSede.setFont(new Font("arial",20,20));
        cidadeSede.setBounds((largura-160)/2+40,250,275,25);
        cidadeSede.setForeground(corLetra);
        add(cidadeSede);
        
        fundacao = new JTextField();
        fundacao.setFont(new Font("arial",20,20));
        fundacao.setBounds((largura-160)/2+40,285,275,25);
        fundacao.setForeground(corLetra);
        add(fundacao);
        
        telefone = new JTextField();
        telefone.setFont(new Font("arial",20,20));
        telefone.setBounds((largura-160)/2+40,320,275,25);
        telefone.setForeground(corLetra);
        add(telefone);
        
        login = new JTextField();
        login.setFont(new Font("arial",20,20));
        login.setBounds((largura-160)/2+40,355,275,25);
        login.setForeground(corLetra);
        add(login);
        
        senha = new JTextField();
        senha.setFont(new Font("arial",20,20));
        senha.setBounds((largura-160)/2+40,390,275,25);
        senha.setForeground(corLetra);
        add(senha);
        
        cadastrar = new JButton("Cadastrar");
        cadastrar.setFont(new Font("arial",20,20));
        cadastrar.setBounds((largura-170)/2,430,170,40);
        cadastrar.setForeground(corLetra);
        cadastrar.addActionListener(this);
        add(cadastrar);
        
        obsTxt = new JLabel("* = dados obrigatórios");
        obsTxt.setFont(new Font("arial",14,14));
        obsTxt.setBounds((largura-160)/2-160,475,160,25);
        add(obsTxt);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cadastrar)){
			Boolean cadastrar = true;
			if(login.getText().equals("")){
				login.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				login.setBorder(new LineBorder(Color.BLACK));
			}
			if(senha.getText().equals("")){
				senha.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				senha.setBorder(new LineBorder(Color.BLACK));
			}
			if(cidadeSede.getText().equals("")){
				cidadeSede.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				cidadeSede.setBorder(new LineBorder(Color.BLACK));
			}
			if(nome.getText().equals("")){
				nome.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				nome.setBorder(new LineBorder(Color.BLACK));
			}
			if(telefone.getText().equals("")){
				telefone.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				telefone.setBorder(new LineBorder(Color.BLACK));
			}
			if(setor.getText().equals("")){
				setor.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				setor.setBorder(new LineBorder(Color.BLACK));
			}
			if(cadastrar){
				EmpresaDAO emp = new EmpresaDAO();
				Empresa empresa = new Empresa();
				empresa.setCidadeSede(cidadeSede.getText());
				empresa.setDescricao(descricao.getText());
				empresa.setEndereco(endereco.getText());
				empresa.setFundacao(Integer.parseInt(fundacao.getText()));
				empresa.setLogin(login.getText());
				empresa.setNome(nome.getText());
				empresa.setSenha(senha.getText());
				empresa.setSetor(setor.getText());
				empresa.setSite(site.getText());
				empresa.setTamanhoEmpresa(tamanhoEmpresa.getText() + "Funcionário(s)");
				empresa.setTelefone(telefone.getText());
				
				emp.adiciona(empresa);
				empresa.setId(emp.pegaIdUltimoCadastro());
				
				this.setVisible(false);
				new CadastradoComSucesso(empresa);
			}
		} else if(e.getSource().equals(atualizar)){
			Boolean atualizar = true;
			if(login.getText().equals("")){
				login.setBorder(new LineBorder(Color.RED));
				atualizar = false;
			} else {
				login.setBorder(new LineBorder(Color.BLACK));
			}
			if(senha.getText().equals("")){
				senha.setBorder(new LineBorder(Color.RED));
				atualizar = false;
			} else {
				senha.setBorder(new LineBorder(Color.BLACK));
			}
			if(cidadeSede.getText().equals("")){
				cidadeSede.setBorder(new LineBorder(Color.RED));
				atualizar = false;
			} else {
				cidadeSede.setBorder(new LineBorder(Color.BLACK));
			}
			if(nome.getText().equals("")){
				nome.setBorder(new LineBorder(Color.RED));
				atualizar = false;
			} else {
				nome.setBorder(new LineBorder(Color.BLACK));
			}
			if(telefone.getText().equals("")){
				telefone.setBorder(new LineBorder(Color.RED));
				atualizar = false;
			} else {
				telefone.setBorder(new LineBorder(Color.BLACK));
			}
			if(setor.getText().equals("")){
				setor.setBorder(new LineBorder(Color.RED));
				atualizar = false;
			} else {
				setor.setBorder(new LineBorder(Color.BLACK));
			}
			if(atualizar){
				EmpresaDAO emp = new EmpresaDAO();
				empresa.setCidadeSede(cidadeSede.getText());
				empresa.setDescricao(descricao.getText());
				empresa.setEndereco(endereco.getText());
				empresa.setFundacao(Integer.parseInt(fundacao.getText()));
				empresa.setLogin(login.getText());
				empresa.setNome(nome.getText());
				empresa.setSenha(senha.getText());
				empresa.setSetor(setor.getText());
				empresa.setSite(site.getText());
				empresa.setTamanhoEmpresa(tamanhoEmpresa.getText() + "Funcionário(s)");
				empresa.setTelefone(telefone.getText());
				
				emp.atualiza(empresa);
				
				this.setVisible(false);
				new CadastradoComSucesso(empresa);
			}
		}
	}
}