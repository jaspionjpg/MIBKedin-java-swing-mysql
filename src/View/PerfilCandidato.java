package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import Beans.Candidato;

public class PerfilCandidato extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 500;
	Integer altura = 700;
	
	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	Candidato candidato;
	
	JLabel imagem;
	JLabel nomeTxt;
	JLabel emailTxt;
	JLabel cidadeTxt;
	JLabel telefoneTxt;
	JLabel dataNascimentoTxt;
	JLabel descricaoTxt;
	JLabel enderecoTxt;
	JLabel nome;
	JLabel email;
	JLabel cidade;
	JLabel telefone;
	JLabel dataNascimento;
	JLabel descricao;
	JLabel endereco;
	JLabel cargostxt;
	JLabel empresastxt;
	JLabel cursostxt;
	JLabel escolastxt;
	JLabel cargos;
	JLabel empresasb;
	JLabel cursos;
	JLabel escolas;
	
	JButton vagas;
	JButton empresas;
	JButton candidatos;
	JButton minhasVagas;
	JButton editar;
	JButton deletar;
	boolean visitante = false;
	
	public PerfilCandidato(Candidato candidato) {
		this.candidato = candidato;
		inicializaComponents();
		setVisible(true);
	}
	
	public PerfilCandidato(Candidato candidato, boolean visitante) {
		this.visitante = visitante;
		this.candidato = candidato;
		inicializaComponents();
		setVisible(true);
	}

	private void inicializaComponents() {
		setTitle("Perfil candidato MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
        
        editar = new JButton("Editar");
        editar.setFont(new Font("arial",18,15));
        editar.setBounds(400,30,85,40);
        editar.setForeground(corLetra);
        editar.addActionListener(this);
        if(visitante)
        	editar.setEnabled(false);
        add(editar);
        
        deletar = new JButton("Deletar");
        deletar.setFont(new Font("arial",18,15));
        deletar.setBounds(400,70,85,40);
        deletar.setForeground(corLetra);
        deletar.addActionListener(this);
        if(visitante)
        	deletar.setEnabled(false);
        add(deletar);
        
        imagem = new JLabel();
        imagem.setBounds((largura)/2-215,5,150,150);
        imagem.setBorder(new TitledBorder(""));
        imagem.setBackground(new java.awt.Color(0, 150, 0, 50));
		add(imagem);
		
		nomeTxt = new JLabel("Nome:");
        nomeTxt.setFont(new Font("arial",15,15));
        nomeTxt.setBounds((largura)/2-45,10,100,25);
        nomeTxt.setForeground(corLetra);
        add(nomeTxt);
        
		nome = new JLabel(candidato.getNome());
        nome.setFont(new Font("arial",15,15));
        nome.setBounds((largura)/2+15,10,200,25);
        nome.setForeground(corLetra);
        add(nome);
        
		emailTxt = new JLabel("Email:");
		emailTxt.setFont(new Font("arial",15,15));
		emailTxt.setBounds((largura)/2-45,40,100,25);
		emailTxt.setForeground(corLetra);
        add(emailTxt);
        
        email = new JLabel(candidato.getEmail());
        email.setFont(new Font("arial",15,15));
        email.setBounds((largura)/2+15,40,200,25);
        email.setForeground(corLetra);
        add(email);
        
        cidadeTxt = new JLabel("Cidade:");
        cidadeTxt.setFont(new Font("arial",15,15));
        cidadeTxt.setBounds((largura)/2-45,70,100,25);
        cidadeTxt.setForeground(corLetra);
        add(cidadeTxt);
        
        cidade = new JLabel(candidato.getCidade());
        cidade.setFont(new Font("arial",15,15));
        cidade.setBounds((largura)/2+15,70,200,25);
        cidade.setForeground(corLetra);
        add(cidade);
        
        telefoneTxt = new JLabel("Telefone:");
        telefoneTxt.setFont(new Font("arial",15,15));
        telefoneTxt.setBounds((largura)/2-45,100,100,25);
        telefoneTxt.setForeground(corLetra);
        add(telefoneTxt);
        
        telefone = new JLabel(candidato.getTelefone());
        telefone.setFont(new Font("arial",15,15));
        telefone.setBounds((largura)/2+20,100,200,25);
        telefone.setForeground(corLetra);
        add(telefone);
	        
        dataNascimentoTxt = new JLabel("Data Nascimento:");
        dataNascimentoTxt.setFont(new Font("arial",15,15));
        dataNascimentoTxt.setBounds((largura)/2-45,130,200,25);
        dataNascimentoTxt.setForeground(corLetra);
        add(dataNascimentoTxt);
        
        dataNascimento = new JLabel(candidato.getDataNascimento());
        dataNascimento.setFont(new Font("arial",15,15));
        dataNascimento.setBounds((largura)/2+75,130,200,25);
        dataNascimento.setForeground(corLetra);
        add(dataNascimento);
        
        vagas = new JButton("Vagas");
        vagas.setFont(new Font("arial",18,18));
        vagas.setBounds(0,185,125,40);
        vagas.setForeground(corLetra);
        vagas.addActionListener(this);
        add(vagas);

        empresas = new JButton("Empresas");
        empresas.setFont(new Font("arial",18,18));
        empresas.setBounds(125,185,125,40);
        empresas.setForeground(corLetra);
        empresas.addActionListener(this);
        add(empresas);
        
        candidatos = new JButton("Candidatos");
        candidatos.setFont(new Font("arial",18,18));
        candidatos.setBounds(250,185,125,40);
        candidatos.setForeground(corLetra);
        candidatos.addActionListener(this);
        add(candidatos);
        
        minhasVagas = new JButton("Minhas Vagas");
        minhasVagas.setFont(new Font("arial",18,15));
        minhasVagas.setBounds(375,185,125,40);
        minhasVagas.setForeground(corLetra);
        minhasVagas.addActionListener(this);
        if(visitante)
        	minhasVagas.setEnabled(false);
        add(minhasVagas);
        
        enderecoTxt = new JLabel("Endereço:");
        enderecoTxt.setFont(new Font("arial",20,20));
        enderecoTxt.setBounds((largura)/2-200,240,100,25);
        enderecoTxt.setForeground(corLetra);
        add(enderecoTxt);
        
        endereco = new JLabel(candidato.getEndereco());
        endereco.setFont(new Font("arial",20,20));
        endereco.setBounds((largura)/2-100,240,380,25);
        endereco.setForeground(corLetra);
        add(endereco);
        
        descricaoTxt = new JLabel("Descrição:");
        descricaoTxt.setFont(new Font("arial",20,20));
        descricaoTxt.setBounds((largura)/2-45,280,100,25);
        descricaoTxt.setForeground(corLetra);
        add(descricaoTxt);
        
        descricao = new JLabel(candidato.getDescricao());
        descricao.setFont(new Font("arial",15,15));
        descricao.setBounds(10,310,200,60);
        descricao.setForeground(corLetra);
        add(descricao);
        
        cargostxt = new JLabel("Cargos:");
        cargostxt.setFont(new Font("arial",20,20));
        cargostxt.setBounds(10,380,100,25);
        cargostxt.setForeground(corLetra);
        add(cargostxt);
        
        empresasb = new JLabel("Empresas:");
        empresasb.setFont(new Font("arial",20,20));
        empresasb.setBounds(260,380,100,25);
        empresasb.setForeground(corLetra);
        add(empresasb);
        
        int i = 0;
        for(String texto : candidato.getCargos().split(", ")){
        	cargos = new JLabel(texto);
        	cargos.setFont(new Font("arial",15,15));
        	cargos.setBounds(10,390 + i * 20,200,60);
        	cargos.setForeground(corLetra);
        	add(cargos);
        	i++;
        }
        
        i = 0;
        for(String texto : candidato.getEmpresas().split(", ")){
        	empresastxt = new JLabel(texto);
        	empresastxt.setFont(new Font("arial",15,15));
        	empresastxt.setBounds(260,390 + i * 20,200,60);
        	empresastxt.setForeground(corLetra);
        	add(empresastxt);
        	i++;
        }
        
        cursostxt = new JLabel("Cursos:");
        cursostxt.setFont(new Font("arial",20,20));
        cursostxt.setBounds(10,425 + i * 20,100,25);
        cursostxt.setForeground(corLetra);
        add(cursostxt);
        
        escolastxt = new JLabel("Escolas:");
        escolastxt.setFont(new Font("arial",20,20));
        escolastxt.setBounds(260,425 + i * 20,100,25);
        escolastxt.setForeground(corLetra);
        add(escolastxt);
        
        int j = 0;
        for(String texto : candidato.getCursos().split(", ")){
        	cursos = new JLabel(texto);
        	cursos.setFont(new Font("arial",15,15));
        	cursos.setBounds(10,425 + i * 20 + j * 20,200,60);
        	cursos.setForeground(corLetra);
        	add(cursos);
        	j++;
        }
        
        j = 0;
        for(String texto : candidato.getEscolas().split(", ")){
        	cursos = new JLabel(texto);
        	cursos.setFont(new Font("arial",15,15));
        	cursos.setBounds(260,425 + i * 20 + j * 20,200,60);
        	cursos.setForeground(corLetra);
        	add(cursos);
        	j++;
        }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vagas)){
			new Vagas();
		} else if(e.getSource().equals(empresas)){
			if(visitante)
				this.setVisible(false);
			new Empresas();
		} else if(e.getSource().equals(candidatos)){
			if(visitante)
				this.setVisible(false);
			new Candidatos();
		} else if(e.getSource().equals(minhasVagas)){
			
		} else if(e.getSource().equals(editar)){
			new CadastroCandidato(candidato);
		} else if(e.getSource().equals(deletar)){
			new CadastradoComSucesso(candidato, 1);
		}
	}
}