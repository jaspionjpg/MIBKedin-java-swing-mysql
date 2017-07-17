package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Beans.Empresa;
import Beans.Vaga;
import DAO.VagaDAO;

public class CadastrarVaga extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 550;
	Integer altura = 280;

	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	Empresa empresa;
	
	JLabel primeiroTxt;
	JLabel obsTxt;
	
	JLabel tituloTxt;
	JLabel descricaoTxt;
	JLabel cidadeTxt;
	JLabel setorTxt;
	
	JTextField titulo;
	JTextField descricao;
	JTextField cidade;
	JTextField setor;

	JButton cadastrar;
	
	public CadastrarVaga(Empresa empresa) {
		this.empresa = empresa;
		inicializaComponents();
		setVisible(true);
	}
	
	private void inicializaComponents() {
		setTitle("Cadastro vaga MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);	
        
        primeiroTxt = new JLabel("Cadastre sua Vaga");
        primeiroTxt.setFont(new Font("arial",20,20));
        primeiroTxt.setBounds((largura-170)/2,5,200,25);
        primeiroTxt.setForeground(corLetra);
        add(primeiroTxt);
        
        tituloTxt = new JLabel("*Titulo:");
        tituloTxt.setFont(new Font("arial",20,20));
        tituloTxt.setBounds((largura-160)/2-160,40,160,25);
        tituloTxt.setForeground(corLetra);
        add(tituloTxt);
        
        descricaoTxt = new JLabel("*Descrição:");
        descricaoTxt.setFont(new Font("arial",20,20));
        descricaoTxt.setBounds((largura-160)/2-160,75,160,25);
        descricaoTxt.setForeground(corLetra);
        add(descricaoTxt);
        
        setorTxt = new JLabel("*Setor:");
        setorTxt.setFont(new Font("arial",20,20));
        setorTxt.setBounds((largura-160)/2-160,110,160,25);
        setorTxt.setForeground(corLetra);
        add(setorTxt);
        
        cidadeTxt = new JLabel("*Cidade:");
        cidadeTxt.setFont(new Font("arial",20,20));
        cidadeTxt.setBounds((largura-160)/2-160,145,160,25);
        cidadeTxt.setForeground(corLetra);
        add(cidadeTxt);
        
        titulo = new JTextField();
        titulo.setFont(new Font("arial",20,20));
        titulo.setBounds((largura-160)/2+40,40,275,25);
        titulo.setForeground(corLetra);
        add(titulo);
        
        descricao = new JTextField();
        descricao.setFont(new Font("arial",20,20));
        descricao.setBounds((largura-160)/2+40,75,275,25);
        descricao.setForeground(corLetra);
        add(descricao);
        
        setor = new JTextField();
        setor.setFont(new Font("arial",20,20));
        setor.setBounds((largura-160)/2+40,110,275,25);
        setor.setForeground(corLetra);
        add(setor);
        
        cidade = new JTextField();
        cidade.setFont(new Font("arial",20,20));
        cidade.setBounds((largura-160)/2+40,145,275,25);
        cidade.setForeground(corLetra);
        add(cidade);
        
        cadastrar = new JButton("Cadastrar");
        cadastrar.setFont(new Font("arial",20,20));
        cadastrar.setBounds((largura-170)/2,190,170,40);
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
		if(e.getSource().equals(cadastrar)){
			Boolean cadastrar = true;
			if(titulo.getText().equals("")){
				titulo.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				titulo.setBorder(new LineBorder(Color.BLACK));
			}
			if(descricao.getText().equals("")){
				descricao.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				descricao.setBorder(new LineBorder(Color.BLACK));
			}
			if(setor.getText().equals("")){
				setor.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				setor.setBorder(new LineBorder(Color.BLACK));
			}
			if(cidade.getText().equals("")){
				cidade.setBorder(new LineBorder(Color.RED));
				cadastrar = false;
			} else {
				cidade.setBorder(new LineBorder(Color.BLACK));
			}
			if(cadastrar){
				VagaDAO vag = new VagaDAO();
				Vaga vaga = new Vaga();
				vaga.setCidade(cidade.getText());
				vaga.setDescricao(descricao.getText());
				vaga.setSetor(setor.getText());
				vaga.setTitulo(titulo.getText());
				
				vaga.setDataCadastro(new Date().toString());
				vaga.setIdEmpresa(this.empresa.getId());
				
				vag.adiciona(vaga);
				
				this.setVisible(false);
				new CadastradoComSucesso(this.empresa);
			}
		}
	}
}
