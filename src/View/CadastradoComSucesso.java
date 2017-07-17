package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Beans.Candidato;
import Beans.Empresa;
import DAO.CandidatoDAO;
import DAO.EmpresaDAO;

public class CadastradoComSucesso extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 300;
	Integer altura = 180;
	
	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	JButton prosseguir;
	
	JLabel texto;
	JLabel textoInicial;
	
	Candidato candidato = null;
	Empresa empresa = null;
	
	int i = 0;
	
	public CadastradoComSucesso(Candidato candidato) {
		this.candidato = candidato;
		inicializaComponents();
	}
	
	public CadastradoComSucesso(Candidato candidato, int i) {
		this.i = i;
		this.candidato = candidato;
		inicializaComponents();
	}
	
	public CadastradoComSucesso(Empresa empresa) {
		this.empresa = empresa;
		inicializaComponents();
	}
	
	public CadastradoComSucesso(Empresa empresa, int i) {
		this.i = i;
		this.empresa = empresa;
		inicializaComponents();
	}

	private void inicializaComponents() {
		setTitle("MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
        
        if(i == 0)
        	textoInicial = new JLabel("Cadastrado com sucesso");
        if(i == 1)
        	textoInicial = new JLabel("Deletar?");
        textoInicial.setFont(new Font("arial",20,20));
        textoInicial.setBounds((largura-230)/2,5,230,25);
        textoInicial.setForeground(corLetra);
        add(textoInicial);
        
        textoInicial = new JLabel("Clique para prosseguir");
        textoInicial.setFont(new Font("arial",20,20));
        textoInicial.setBounds((largura-210)/2,35,200,25);
        textoInicial.setForeground(corLetra);
        add(textoInicial);
        
        prosseguir = new JButton("Prosseguir");
        prosseguir.setFont(new Font("arial",25,25));
        prosseguir.setBounds((largura-170)/2,90,170,40);
        prosseguir.setForeground(corLetra);
        prosseguir.addActionListener(this);
        add(prosseguir);
        
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		if(e.getSource().equals(prosseguir)){
			if(candidato != null){
				if(i == 0)
					new PerfilCandidato(candidato);
				if(i == 1){
					CandidatoDAO cand = new CandidatoDAO();
					cand.deleta(candidato);
					new Login();
				}
			} else if(empresa != null){
				if(i == 0)
					new PerfilEmpresa(empresa);
				if(i == 1){
					EmpresaDAO emp = new EmpresaDAO();
					emp.deleta(empresa);
					new Login();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Não é possivel redirecionar pos ocorreu um erro");
			}
		} 
	}
}