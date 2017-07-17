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

import Beans.Empresa;

public class PerfilEmpresa extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 500;
	Integer altura = 500;
	
	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	Empresa empresa;
	
	JLabel imagem;
	JLabel nometxt;
	JLabel setortxt;
	JLabel fundacaotxt;
	JLabel cidadeSedetxt;
	JLabel telefonetxt;
	JLabel sitetxt;
	JLabel descricaotxt;
	JLabel enderecotxt;
	JLabel tamanhoEmpresatxt;
	JLabel nome;
	JLabel setor;
	JLabel fundacao;
	JLabel cidadeSede;
	JLabel telefone;
	JLabel site;
	JLabel descricao;
	JLabel endereco;
	JLabel tamanhoEmpresa;
	
	JButton inserirVaga;
	JButton empresas;
	JButton candidatos;
	JButton minhasVagas;
	
	JButton editar;
	JButton deletar;
	
	boolean visitante = false;
	
	public PerfilEmpresa(Empresa empresa) {
		this.empresa = empresa;
		inicializaComponents();
		setVisible(true);
	}
	
	public PerfilEmpresa(Empresa empresa, boolean visitante) {
		this.visitante = visitante;
		this.empresa = empresa;
		inicializaComponents();
		setVisible(true);
	}
	
	private void inicializaComponents() {
		setTitle("Perfil empresa MIBKedin");
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
        ImageIcon icon = new ImageIcon(getClass().getResource("../Imagens/anonimo.png"));
        imagem.setIcon(new ImageIcon(icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		add(imagem);
		
		nometxt = new JLabel("Nome:");
		nometxt.setFont(new Font("arial",15,15));
		nometxt.setBounds((largura)/2-45,10,100,25);
        nometxt.setForeground(corLetra);
        add(nometxt);
        
		nome = new JLabel(empresa.getNome());
        nome.setFont(new Font("arial",15,15));
        nome.setBounds((largura)/2+15,10,200,25);
        nome.setForeground(corLetra);
        add(nome);
        
        setortxt = new JLabel("Setor:");
        setortxt.setFont(new Font("arial",15,15));
        setortxt.setBounds((largura)/2-45,40,100,25);
        setortxt.setForeground(corLetra);
        add(setortxt);
        
        setor = new JLabel(empresa.getSetor());
        setor.setFont(new Font("arial",15,15));
        setor.setBounds((largura)/2+15,40,200,25);
        setor.setForeground(corLetra);
        add(setor);
        
        fundacaotxt = new JLabel("Ano Fundação:");
        fundacaotxt.setFont(new Font("arial",15,15));
        fundacaotxt.setBounds((largura)/2-45,70,100,25);
        fundacaotxt.setForeground(corLetra);
        add(fundacaotxt);
        
        fundacao = new JLabel(empresa.getFundacao()+"");
        fundacao.setFont(new Font("arial",15,15));
        fundacao.setBounds((largura)/2+55,70,200,25);
        fundacao.setForeground(corLetra);
        add(fundacao);
        
        telefonetxt = new JLabel("Telefone:");
        telefonetxt.setFont(new Font("arial",15,15));
        telefonetxt.setBounds((largura)/2-45,100,100,25);
        telefonetxt.setForeground(corLetra);
        add(telefonetxt);
        
        telefone = new JLabel(empresa.getTelefone());
        telefone.setFont(new Font("arial",15,15));
        telefone.setBounds((largura)/2+20,100,200,25);
        telefone.setForeground(corLetra);
        add(telefone);
	        
        cidadeSedetxt = new JLabel("Cidade Sede:");
        cidadeSedetxt.setFont(new Font("arial",15,15));
        cidadeSedetxt.setBounds((largura)/2-45,130,200,25);
        cidadeSedetxt.setForeground(corLetra);
        add(cidadeSedetxt);
        
        cidadeSede = new JLabel(empresa.getCidadeSede());
        cidadeSede.setFont(new Font("arial",15,15));
        cidadeSede.setBounds((largura)/2+75,130,200,25);
        cidadeSede.setForeground(corLetra);
        add(cidadeSede);
        
        inserirVaga = new JButton("Inserir Vaga");
        inserirVaga.setFont(new Font("arial",18,15));
        inserirVaga.setBounds(0,185,125,40);
        inserirVaga.setForeground(corLetra);
        inserirVaga.addActionListener(this);
        if(visitante)
        	inserirVaga.setEnabled(false);
        add(inserirVaga);

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
        add(minhasVagas);
        
        enderecotxt = new JLabel("Endereço:");
        enderecotxt.setFont(new Font("arial",20,20));
        enderecotxt.setBounds((largura)/2-200,240,100,25);
        enderecotxt.setForeground(corLetra);
        add(enderecotxt);
        
        endereco = new JLabel(empresa.getEndereco());
        endereco.setFont(new Font("arial",20,20));
        endereco.setBounds((largura)/2-100,240,380,25);
        endereco.setForeground(corLetra);
        add(endereco);
        
        sitetxt = new JLabel("Site:");
        sitetxt.setFont(new Font("arial",20,20));
        sitetxt.setBounds((largura)/2-200,275,100,25);
        sitetxt.setForeground(corLetra);
        add(sitetxt);
        
        site = new JLabel(empresa.getSite());
        site.setFont(new Font("arial",20,20));
        site.setBounds((largura)/2-100,275,380,25);
        site.setForeground(corLetra);
        add(site);
        
        tamanhoEmpresatxt = new JLabel("Tamanho:");
        tamanhoEmpresatxt.setFont(new Font("arial",20,20));
        tamanhoEmpresatxt.setBounds((largura)/2-200,310,100,25);
        tamanhoEmpresatxt.setForeground(corLetra);
        add(tamanhoEmpresatxt);
        
        tamanhoEmpresa = new JLabel(empresa.getTamanhoEmpresa());
        tamanhoEmpresa.setFont(new Font("arial",20,20));
        tamanhoEmpresa.setBounds((largura)/2-100,310,380,25);
        tamanhoEmpresa.setForeground(corLetra);
        add(tamanhoEmpresa);
        
        descricaotxt = new JLabel("Descrição:");
        descricaotxt.setFont(new Font("arial",20,20));
        descricaotxt.setBounds((largura)/2-45,350,100,25);
        descricaotxt.setForeground(corLetra);
        add(descricaotxt);
        
        descricao = new JLabel(empresa.getDescricao());
        descricao.setFont(new Font("arial",15,15));
        descricao.setBounds(10,380,500,60);
        descricao.setForeground(corLetra);
        add(descricao);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(inserirVaga)){
			new CadastrarVaga(empresa);
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
			this.setVisible(false);
			new CadastroEmpresa(empresa);
		} else if(e.getSource().equals(deletar)){
			this.setVisible(false);
			new CadastradoComSucesso(empresa, 1);
		}
	}
}
