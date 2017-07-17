package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Beans.Candidato;
import DAO.CandidatoDAO;

public class CadastroCandidato extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 550;
	Integer altura = 800;

	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	Candidato candidato;

	JLabel tituloTxt;
	JLabel obsTxt;
	
	JLabel nomeTxt;
	JLabel emailTxt;
	JLabel descricaoTxt;
	JLabel cidadeTxt;
	JLabel enderecoTxt;
	JLabel telefoneTxt;
	JLabel dataNascimentoTxt;
	JLabel loginTxt;
	JLabel senhaTxt;
	JLabel bordaTituloCargo;
	JLabel bordaTituloCurso;
	
	JTextField nome;
	JTextField email;
	JTextField descricao;
	JTextField cidade;
	JTextField endereco;
	JTextField telefone;
	JTextField dataNascimento;
	JTextField login;
	JTextField senha;
	JTextField cargo;
	JTextField empresa;
	JTextField curso;
	JTextField escola;
	
	JButton cadastrar;
	JButton removeCargo;
	JButton adicionarCargo;
	JButton removeCurso;
	JButton adicionarCurso;
	
	JButton atualizar;
	
	DefaultListModel<String> cargos;
	DefaultListModel<String> cursos;
	
	JList<String> listCargos;
	JList<String> listCursos;

	public CadastroCandidato() {
		inicializaComponents();
		setVisible(true);
	}
	
	public CadastroCandidato(Candidato candidato) {
		this.candidato = candidato;
		inicializaComponentsUpdate();
		setVisible(true);
	}
	
	private void inicializaComponentsUpdate() {
		setTitle("Update candidato MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
        
        tituloTxt = new JLabel("Atualize");
        tituloTxt.setFont(new Font("arial",20,20));
        tituloTxt.setBounds((largura-110)/2,5,110,25);
        tituloTxt.setForeground(corLetra);
        add(tituloTxt);
        
        nomeTxt = new JLabel("*Nome:");
        nomeTxt.setFont(new Font("arial",20,20));
        nomeTxt.setBounds((largura-160)/2-160,40,160,25);
        nomeTxt.setForeground(corLetra);
        add(nomeTxt);
        
        descricaoTxt = new JLabel("Descrição:");
        descricaoTxt.setFont(new Font("arial",20,20));
        descricaoTxt.setBounds((largura-160)/2-160,75,160,25);
        descricaoTxt.setForeground(corLetra);
        add(descricaoTxt);
        
        emailTxt = new JLabel("*Email:");
        emailTxt.setFont(new Font("arial",20,20));
        emailTxt.setBounds((largura-160)/2-160,110,160,25);
        emailTxt.setForeground(corLetra);
        add(emailTxt);
        
        cidadeTxt = new JLabel("*Cidade:");
        cidadeTxt.setFont(new Font("arial",20,20));
        cidadeTxt.setBounds((largura-160)/2-160,145,160,25);
        cidadeTxt.setForeground(corLetra);
        add(cidadeTxt);
        
        telefoneTxt = new JLabel("*Telefone:");
        telefoneTxt.setFont(new Font("arial",20,20));
        telefoneTxt.setBounds((largura-160)/2-160,180,200,25);
        telefoneTxt.setForeground(corLetra);
        add(telefoneTxt);
        
        enderecoTxt = new JLabel("Endereço:");
        enderecoTxt.setFont(new Font("arial",20,20));
        enderecoTxt.setBounds((largura-160)/2-160,215,160,25);
        enderecoTxt.setForeground(corLetra);
        add(enderecoTxt);
        
        dataNascimentoTxt = new JLabel("Data Nascimento:");
        dataNascimentoTxt.setFont(new Font("arial",20,20));
        dataNascimentoTxt.setBounds((largura-160)/2-160,250,160,25);
        dataNascimentoTxt.setForeground(corLetra);
        add(dataNascimentoTxt);
        
        loginTxt = new JLabel("*Login:");
        loginTxt.setFont(new Font("arial",20,20));
        loginTxt.setBounds((largura-160)/2-160,285,160,25);
        loginTxt.setForeground(corLetra);
        add(loginTxt);
        
        senhaTxt = new JLabel("*Senha:");
        senhaTxt.setFont(new Font("arial",20,20));
        senhaTxt.setBounds((largura-160)/2-160,320,160,25);
        senhaTxt.setForeground(corLetra);
        add(senhaTxt);
        
        nome = new JTextField(candidato.getNome());
        nome.setFont(new Font("arial",20,20));
        nome.setBounds((largura-160)/2+40,40,275,25);
        nome.setForeground(corLetra);
        add(nome);
        
        descricao = new JTextField(candidato.getDescricao());
        descricao.setFont(new Font("arial",20,20));
        descricao.setBounds((largura-160)/2+40,75,275,25);
        descricao.setForeground(corLetra);
        add(descricao);
        
        email = new JTextField(candidato.getEmail());
        email.setFont(new Font("arial",20,20));
        email.setBounds((largura-160)/2+40,110,275,25);
        email.setForeground(corLetra);
        add(email);
        
        cidade = new JTextField(candidato.getCidade());
        cidade.setFont(new Font("arial",20,20));
        cidade.setBounds((largura-160)/2+40,145,275,25);
        cidade.setForeground(corLetra);
        add(cidade);
        
        telefone = new JTextField(candidato.getTelefone());
        telefone.setFont(new Font("arial",20,20));
        telefone.setBounds((largura-160)/2+40,180,275,25);
        telefone.setForeground(corLetra);
        add(telefone);
        
        endereco = new JTextField(candidato.getEndereco());
        endereco.setFont(new Font("arial",20,20));
        endereco.setBounds((largura-160)/2+40,215,275,25);
        endereco.setForeground(corLetra);
        add(endereco);
        
        dataNascimento = new JTextField(candidato.getDataNascimento());
        dataNascimento.setFont(new Font("arial",20,20));
        dataNascimento.setBounds((largura-160)/2+40,250,275,25);
        dataNascimento.setForeground(corLetra);
        add(dataNascimento);
        
        login = new JTextField(candidato.getLogin());
        login.setFont(new Font("arial",20,20));
        login.setBounds((largura-160)/2+40,285,275,25);
        login.setForeground(corLetra);
        add(login);
        
        senha = new JTextField(candidato.getSenha());
        senha.setFont(new Font("arial",20,20));
        senha.setBounds((largura-160)/2+40,320,275,25);
        senha.setForeground(corLetra);
        add(senha);
        
		bordaTituloCargo = new JLabel();
		bordaTituloCargo.setBorder(new TitledBorder("Informe seus Cargos anteriores :"));
		bordaTituloCargo.setBackground(Color.black);
		bordaTituloCargo.setBounds((largura)/2-240, 350, (largura)/2+200, 170);
		add(bordaTituloCargo);
		
		cargo = new JTextField("Cargo");
		cargo.setFont(new Font("arial",20,20));
		cargo.setBounds((largura-160)/2-150, 375, 170, 25);
		cargo.setForeground(corLetra);
		add(cargo);
		
		empresa = new JTextField("Empresa");
		empresa.setFont(new Font("arial",20,20));
		empresa.setBounds((largura-160)/2+30, 375, 170, 25);
		empresa.setForeground(corLetra);
		empresa.addActionListener(this);
		add(empresa);
		
		adicionarCargo = new JButton();
		adicionarCargo.setBounds((largura)/2+140, 375, 45, 25);
		adicionarCargo.setText("+");
		adicionarCargo.addActionListener(this);
		add(adicionarCargo);
		
		removeCargo = new JButton();
		removeCargo.setBounds((largura)/2+180, 375, 45, 25);
		removeCargo.setText("-");
		removeCargo.addActionListener(this);
		add(removeCargo);
		
		cargos = new DefaultListModel<>();
		for(int i = 0 ; i < candidato.getCargos().split(" / ").length; i++){
			cargos.addElement(candidato.getCargos().split(" / ")[i] + " / " + candidato.getEmpresas().split(" / ")[i]);
		}
		
		listCargos = new JList<String>(cargos);
		listCargos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCargos.setLayoutOrientation(JList.VERTICAL_WRAP);
		listCargos.setVisibleRowCount(-1);
		listCargos.setBounds((largura)/2-230, 410 , (largura)/2+180, 100);
		listCargos.setBorder(new LineBorder(Color.BLACK));
		add(listCargos);
        
		bordaTituloCurso = new JLabel();
		bordaTituloCurso.setBorder(new TitledBorder("Informe seus Cargos anteriores :"));
		bordaTituloCurso.setBackground(Color.black);
		bordaTituloCurso.setBounds((largura)/2-240, 530, (largura)/2+200, 170);
		add(bordaTituloCurso);
		
		curso = new JTextField("Curso");
		curso.setFont(new Font("arial",20,20));
		curso.setBounds((largura-160)/2-150, 555, 170, 25);
		curso.setForeground(corLetra);
		add(curso);
		
		escola = new JTextField("Escola");
		escola.setFont(new Font("arial",20,20));
		escola.setBounds((largura-160)/2+30, 555, 170, 25);
		escola.setForeground(corLetra);
		escola.addActionListener(this);
		add(escola);
		
		adicionarCurso = new JButton();
		adicionarCurso.setBounds((largura)/2+140, 555, 45, 25);
		adicionarCurso.setText("+");
		adicionarCurso.addActionListener(this);
		add(adicionarCurso);
		
		removeCurso = new JButton();
		removeCurso.setBounds((largura)/2+180, 555, 45, 25);
		removeCurso.setText("-");
		removeCurso.addActionListener(this);
		add(removeCurso);
		
		cursos = new DefaultListModel<>();
		for(int i = 0 ; i < candidato.getCursos().split(" / ").length; i++){
			cursos.addElement(candidato.getCursos().split(" / ")[i] + " / " + candidato.getEscolas().split(" / ")[i]);
		}

		listCursos = new JList<String>(cursos);
		listCursos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listCursos.setLayoutOrientation(JList.VERTICAL_WRAP);
		listCursos.setVisibleRowCount(-1);
		listCursos.setBounds((largura)/2-230, 590 , (largura)/2+180, 100);
		listCursos.setBorder(new LineBorder(Color.BLACK));
		add(listCursos);
		
		atualizar = new JButton("Atualizar");
		atualizar.setFont(new Font("arial",20,20));
		atualizar.setBounds((largura-170)/2,700,170,40);
		atualizar.setForeground(corLetra);
		atualizar.addActionListener(this);
        add(atualizar);
        
        obsTxt = new JLabel("* = dados obrigatórios");
        obsTxt.setFont(new Font("arial",14,14));
        obsTxt.setBounds((largura-160)/2-160,5,160,25);
        add(obsTxt);
	}

	private void inicializaComponents() {
		setTitle("Cadastro candidato MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
        
        tituloTxt = new JLabel("Cadastre-se");
        tituloTxt.setFont(new Font("arial",20,20));
        tituloTxt.setBounds((largura-110)/2,5,110,25);
        tituloTxt.setForeground(corLetra);
        add(tituloTxt);
        
        nomeTxt = new JLabel("*Nome:");
        nomeTxt.setFont(new Font("arial",20,20));
        nomeTxt.setBounds((largura-160)/2-160,40,160,25);
        nomeTxt.setForeground(corLetra);
        add(nomeTxt);
        
        descricaoTxt = new JLabel("Descrição:");
        descricaoTxt.setFont(new Font("arial",20,20));
        descricaoTxt.setBounds((largura-160)/2-160,75,160,25);
        descricaoTxt.setForeground(corLetra);
        add(descricaoTxt);
        
        emailTxt = new JLabel("*Email:");
        emailTxt.setFont(new Font("arial",20,20));
        emailTxt.setBounds((largura-160)/2-160,110,160,25);
        emailTxt.setForeground(corLetra);
        add(emailTxt);
        
        cidadeTxt = new JLabel("*Cidade:");
        cidadeTxt.setFont(new Font("arial",20,20));
        cidadeTxt.setBounds((largura-160)/2-160,145,160,25);
        cidadeTxt.setForeground(corLetra);
        add(cidadeTxt);
        
        telefoneTxt = new JLabel("*Telefone:");
        telefoneTxt.setFont(new Font("arial",20,20));
        telefoneTxt.setBounds((largura-160)/2-160,180,200,25);
        telefoneTxt.setForeground(corLetra);
        add(telefoneTxt);
        
        enderecoTxt = new JLabel("Endereço:");
        enderecoTxt.setFont(new Font("arial",20,20));
        enderecoTxt.setBounds((largura-160)/2-160,215,160,25);
        enderecoTxt.setForeground(corLetra);
        add(enderecoTxt);
        
        dataNascimentoTxt = new JLabel("Data Nascimento:");
        dataNascimentoTxt.setFont(new Font("arial",20,20));
        dataNascimentoTxt.setBounds((largura-160)/2-160,250,160,25);
        dataNascimentoTxt.setForeground(corLetra);
        add(dataNascimentoTxt);
        
        loginTxt = new JLabel("*Login:");
        loginTxt.setFont(new Font("arial",20,20));
        loginTxt.setBounds((largura-160)/2-160,285,160,25);
        loginTxt.setForeground(corLetra);
        add(loginTxt);
        
        senhaTxt = new JLabel("*Senha:");
        senhaTxt.setFont(new Font("arial",20,20));
        senhaTxt.setBounds((largura-160)/2-160,320,160,25);
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
        
        email = new JTextField();
        email.setFont(new Font("arial",20,20));
        email.setBounds((largura-160)/2+40,110,275,25);
        email.setForeground(corLetra);
        add(email);
        
        cidade = new JTextField();
        cidade.setFont(new Font("arial",20,20));
        cidade.setBounds((largura-160)/2+40,145,275,25);
        cidade.setForeground(corLetra);
        add(cidade);
        
        telefone = new JTextField();
        telefone.setFont(new Font("arial",20,20));
        telefone.setBounds((largura-160)/2+40,180,275,25);
        telefone.setForeground(corLetra);
        add(telefone);
        
        endereco = new JTextField();
        endereco.setFont(new Font("arial",20,20));
        endereco.setBounds((largura-160)/2+40,215,275,25);
        endereco.setForeground(corLetra);
        add(endereco);
        
        dataNascimento = new JTextField();
        dataNascimento.setFont(new Font("arial",20,20));
        dataNascimento.setBounds((largura-160)/2+40,250,275,25);
        dataNascimento.setForeground(corLetra);
        add(dataNascimento);
        
        login = new JTextField();
        login.setFont(new Font("arial",20,20));
        login.setBounds((largura-160)/2+40,285,275,25);
        login.setForeground(corLetra);
        add(login);
        
        senha = new JTextField();
        senha.setFont(new Font("arial",20,20));
        senha.setBounds((largura-160)/2+40,320,275,25);
        senha.setForeground(corLetra);
        add(senha);
        
		bordaTituloCargo = new JLabel();
		bordaTituloCargo.setBorder(new TitledBorder("Informe seus Cargos anteriores :"));
		bordaTituloCargo.setBackground(Color.black);
		bordaTituloCargo.setBounds((largura)/2-240, 350, (largura)/2+200, 170);
		add(bordaTituloCargo);
		
		cargo = new JTextField("Cargo");
		cargo.setFont(new Font("arial",20,20));
		cargo.setBounds((largura-160)/2-150, 375, 170, 25);
		cargo.setForeground(corLetra);
		add(cargo);
		
		empresa = new JTextField("Empresa");
		empresa.setFont(new Font("arial",20,20));
		empresa.setBounds((largura-160)/2+30, 375, 170, 25);
		empresa.setForeground(corLetra);
		empresa.addActionListener(this);
		add(empresa);
		
		adicionarCargo = new JButton();
		adicionarCargo.setBounds((largura)/2+140, 375, 45, 25);
		adicionarCargo.setText("+");
		adicionarCargo.addActionListener(this);
		add(adicionarCargo);
		
		removeCargo = new JButton();
		removeCargo.setBounds((largura)/2+180, 375, 45, 25);
		removeCargo.setText("-");
		removeCargo.addActionListener(this);
		add(removeCargo);
		
		cargos = new DefaultListModel<>();
		
		listCargos = new JList<String>(cargos);
		listCargos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCargos.setLayoutOrientation(JList.VERTICAL_WRAP);
		listCargos.setVisibleRowCount(-1);
		listCargos.setBounds((largura)/2-230, 410 , (largura)/2+180, 100);
		listCargos.setBorder(new LineBorder(Color.BLACK));
		add(listCargos);
        
		bordaTituloCurso = new JLabel();
		bordaTituloCurso.setBorder(new TitledBorder("Informe seus Cargos anteriores :"));
		bordaTituloCurso.setBackground(Color.black);
		bordaTituloCurso.setBounds((largura)/2-240, 530, (largura)/2+200, 170);
		add(bordaTituloCurso);
		
		curso = new JTextField("Curso");
		curso.setFont(new Font("arial",20,20));
		curso.setBounds((largura-160)/2-150, 555, 170, 25);
		curso.setForeground(corLetra);
		add(curso);
		
		escola = new JTextField("Escola");
		escola.setFont(new Font("arial",20,20));
		escola.setBounds((largura-160)/2+30, 555, 170, 25);
		escola.setForeground(corLetra);
		escola.addActionListener(this);
		add(escola);
		
		adicionarCurso = new JButton();
		adicionarCurso.setBounds((largura)/2+140, 555, 45, 25);
		adicionarCurso.setText("+");
		adicionarCurso.addActionListener(this);
		add(adicionarCurso);
		
		removeCurso = new JButton();
		removeCurso.setBounds((largura)/2+180, 555, 45, 25);
		removeCurso.setText("-");
		removeCurso.addActionListener(this);
		add(removeCurso);
		
		cursos = new DefaultListModel<>();
				
		listCursos = new JList<String>(cursos);
		listCursos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listCursos.setLayoutOrientation(JList.VERTICAL_WRAP);
		listCursos.setVisibleRowCount(-1);
		listCursos.setBounds((largura)/2-230, 590 , (largura)/2+180, 100);
		listCursos.setBorder(new LineBorder(Color.BLACK));
		add(listCursos);
		
        cadastrar = new JButton("Cadastrar");
        cadastrar.setFont(new Font("arial",20,20));
        cadastrar.setBounds((largura-170)/2,700,170,40);
        cadastrar.setForeground(corLetra);
        cadastrar.addActionListener(this);
        add(cadastrar);
        
        obsTxt = new JLabel("* = dados obrigatórios");
        obsTxt.setFont(new Font("arial",14,14));
        obsTxt.setBounds((largura-160)/2-160,5,160,25);
        add(obsTxt);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adicionarCargo){
			String cargoT = cargo.getText();
			cargoT += " / " + empresa.getText();
			cargos.addElement(cargoT);
		} else if(e.getSource() == removeCargo){
			if(!listCargos.isSelectionEmpty()){
				cargos.remove(listCargos.getSelectedIndex());
			}
		} else if(e.getSource() == adicionarCurso){
			String cargoT = curso.getText();
			cargoT += " / " + escola.getText();
			cursos.addElement(cargoT);
		} else if(e.getSource() == removeCurso){
			if(!listCursos.isSelectionEmpty()){
				cursos.remove(listCursos.getSelectedIndex());
			}
		} else 
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
			if(email.getText().equals("")){
				email.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				email.setBorder(new LineBorder(Color.BLACK));
			}
			if(cidade.getText().equals("")){
				cidade.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				cidade.setBorder(new LineBorder(Color.BLACK));
			}
			if(cadastrar){
				CandidatoDAO cand = new CandidatoDAO();
				Candidato candidato = new Candidato();
				candidato.setCidade(cidade.getText());
				candidato.setDataNascimento(dataNascimento.getText());
				candidato.setDescricao(descricao.getText());
				candidato.setEmail(email.getText());
				candidato.setEndereco(endereco.getText());
				candidato.setLogin(login.getText());
				candidato.setNome(nome.getText());
				candidato.setSenha(senha.getText());
				candidato.setTelefone(telefone.getText());
				candidato.setCargos("");
				candidato.setEmpresas("");
				candidato.setCursos("");
				candidato.setEscolas("");
				
				for(int i = 0; i < cargos.size(); i++){
					candidato.setCargos(candidato.getCargos() + ", " + cargos.getElementAt(i).split(" / ")[0]);
					candidato.setEmpresas(candidato.getEmpresas() + ", " +  cargos.getElementAt(i).split(" / ")[1]);
				}
				
				for(int i = 0; i < cursos.size(); i++){
					candidato.setCursos(candidato.getCursos() + cursos.getElementAt(i).split(" / ")[0]);
					candidato.setEscolas(candidato.getEscolas() + cursos.getElementAt(i).split(" / ")[1]);
				}
				
				cand.adiciona(candidato);
				candidato.setId(cand.pegaIdUltimoCadastro());
				
				this.setVisible(false);
				new CadastradoComSucesso(candidato);
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
			if(email.getText().equals("")){
				email.setBorder(new LineBorder(Color.RED));
				atualizar = false;
			} else {
				email.setBorder(new LineBorder(Color.BLACK));
			}
			if(cidade.getText().equals("")){
				cidade.setBorder(new LineBorder(Color.RED));
				atualizar = false;
			} else {
				cidade.setBorder(new LineBorder(Color.BLACK));
			}
			if(atualizar){
				CandidatoDAO cand = new CandidatoDAO();
				candidato.setCidade(cidade.getText());
				candidato.setDataNascimento(dataNascimento.getText());
				candidato.setDescricao(descricao.getText());
				candidato.setEmail(email.getText());
				candidato.setEndereco(endereco.getText());
				candidato.setLogin(login.getText());
				candidato.setNome(nome.getText());
				candidato.setSenha(senha.getText());
				candidato.setTelefone(telefone.getText());
				candidato.setCargos("");
				candidato.setEmpresas("");
				candidato.setCursos("");
				candidato.setEscolas("");
				
				for(int i = 0; i < cargos.size(); i++){
					candidato.setCargos(candidato.getCargos() + ", " + cargos.getElementAt(i).split(" / ")[0]);
					candidato.setEmpresas(candidato.getEmpresas() + ", " + cargos.getElementAt(i).split(" / ")[1]);
				}
				
				for(int i = 0; i < cursos.size(); i++){
					candidato.setCursos(candidato.getCursos() + ", " + cursos.getElementAt(i).split(" / ")[0]);
					candidato.setEscolas(candidato.getEscolas() + ", " + cursos.getElementAt(i).split(" / ")[1]);
				}
				
				cand.atualiza(candidato);
				
				this.setVisible(false);
				new CadastradoComSucesso(candidato);
			}
		}
	}
}
