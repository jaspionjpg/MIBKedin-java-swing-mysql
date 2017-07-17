package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cadastrar extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Integer largura = 300;
	Integer altura = 240;
	
	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	JButton cadastrarEmpresa;
	JButton cadastrarCandidato;
	
	JLabel texto;
	JLabel textoInicial;
	
	public Cadastrar() {
		setTitle("Escolha usuário MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
        
        textoInicial = new JLabel("Escolha o tipo de");
        textoInicial.setFont(new Font("arial",20,20));
        textoInicial.setBounds((largura-160)/2,5,160,25);
        textoInicial.setForeground(corLetra);
        add(textoInicial);
        
        textoInicial = new JLabel("usuário a ser cadastrado");
        textoInicial.setFont(new Font("arial",20,20));
        textoInicial.setBounds((largura-220)/2,35,220,25);
        textoInicial.setForeground(corLetra);
        add(textoInicial);
        
        cadastrarEmpresa = new JButton("Empresa");
        cadastrarEmpresa.setFont(new Font("arial",30,30));
        cadastrarEmpresa.setBounds((largura-170)/2,90,170,40);
        cadastrarEmpresa.setForeground(corLetra);
        cadastrarEmpresa.addActionListener(this);
        add(cadastrarEmpresa);
        
        cadastrarCandidato = new JButton("Candidato");
        cadastrarCandidato.setFont(new Font("arial",30,30));
        cadastrarCandidato.setBounds((largura-170)/2,140,170,40);
        cadastrarCandidato.setForeground(corLetra);
        cadastrarCandidato.addActionListener(this);
        add(cadastrarCandidato);
        
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cadastrarCandidato)){
			new CadastroCandidato();
		} else if (e.getSource().equals(cadastrarEmpresa)){
			new CadastroEmpresa();
		} 
		setVisible(false);
	}
}