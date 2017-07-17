package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Beans.Candidato;
import Beans.Empresa;
import DAO.CandidatoDAO;
import DAO.EmpresaDAO;

public class Login extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 660;
	Integer altura = 300;
	
	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	JLabel bemVindoText;
	JLabel loginText;
	JLabel senhaText;
	
	JTextField loginField;
    JPasswordField senhaField;
	
	ButtonGroup usuarioRadio;
	JRadioButton empresaRadio;
	JRadioButton candidatoRadio;
	
	JButton entrarButton;
	JButton cadastrarButton;
	JButton esqueciSenhaButton;
	
	public Login() {
		inicializaComponents();
		
		setVisible(true);
	}

	private void inicializaComponents() {
		setTitle("Login MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
		
        bemVindoText = new JLabel("Bem vindo ao MIBKedin");
        bemVindoText.setFont(new Font("arial",30,30));
        bemVindoText.setBounds((largura-320)/2,5,320,30);
        bemVindoText.setForeground(corLetra);
        add(bemVindoText);
        
        loginText = new JLabel("Digite seu Login:");
        loginText.setFont(new Font("arial",20,20));
        loginText.setBounds((largura-170)/2-170,60,170,25);
        loginText.setForeground(corLetra);
        add(loginText);
        
        senhaText = new JLabel("Digite sua Senha:");
        senhaText.setFont(new Font("arial",20,20));
        senhaText.setBounds((largura-170)/2-170,105,170,25);
        senhaText.setForeground(corLetra);
        add(senhaText);
        
        loginField = new JTextField();
        loginField.setFont(new Font("arial",20,20));
        loginField.setBounds((largura-170)/2,60,340,25);
        loginField.setForeground(corLetra);
        add(loginField);
        
        senhaField = new JPasswordField();
        senhaField.setFont(new Font("arial",20,20));
        senhaField.setBounds((largura-170)/2,105,340,25);
        senhaField.setForeground(corLetra);
        add(senhaField);
        
        empresaRadio = new JRadioButton("Empresa"); 
        empresaRadio.setFont(new Font("arial",15,15));
        empresaRadio.setBounds((largura-130)/2-75,140,130,25);
        empresaRadio.setForeground(corLetra);
        add(empresaRadio);
        
        candidatoRadio = new JRadioButton("Candidato"); 
        candidatoRadio.setFont(new Font("arial",15,15));
        candidatoRadio.setBounds((largura-130)/2+75,140,130,25);
        candidatoRadio.setForeground(corLetra);
        add(candidatoRadio);
        
        usuarioRadio = new ButtonGroup();
        usuarioRadio.add(candidatoRadio);
        usuarioRadio.add(empresaRadio);
        
        entrarButton = new JButton("Entrar");
        entrarButton.setFont(new Font("arial",20,20));
        entrarButton.setBounds((largura-170)/2,185,170,40);
        entrarButton.setForeground(corLetra);
        entrarButton.addActionListener(this);
        add(entrarButton);
        
        cadastrarButton = new JButton("Cadastar usúario");
        cadastrarButton.setFont(new Font("arial",15,15));
        cadastrarButton.setBounds((largura-200)/2-110,235,200,20);
        cadastrarButton.setForeground(corLetra);
        cadastrarButton.setBorderPainted(false);
        cadastrarButton.setContentAreaFilled(false);
        cadastrarButton.setFocusPainted(false);
        cadastrarButton.addMouseListener(this);
        cadastrarButton.addActionListener(this);
        add(cadastrarButton);
        
        esqueciSenhaButton = new JButton("Esqueci minha senha");
        esqueciSenhaButton.setFont(new Font("arial",15,15));
        esqueciSenhaButton.setBounds((largura-200)/2+110,235,200,20);
        esqueciSenhaButton.setForeground(corLetra);
        esqueciSenhaButton.setBorderPainted(false);
        esqueciSenhaButton.setContentAreaFilled(false);
        esqueciSenhaButton.setFocusPainted(false);
        esqueciSenhaButton.addMouseListener(this);
        esqueciSenhaButton.addActionListener(this);
        add(esqueciSenhaButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cadastrarButton)){
			new Cadastrar();
		} else if (e.getSource().equals(esqueciSenhaButton)){
		} else if (e.getSource().equals(entrarButton)){
			if(empresaRadio.isSelected()){
				EmpresaDAO emp = new EmpresaDAO();
				Empresa empresa = emp.login(loginField.getText(), senhaField.getText());
				if(empresa.getId() != null){
					this.setVisible(false);
					new PerfilEmpresa(empresa);
				} else {
					JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
				}
			} else if(candidatoRadio.isSelected()){
				CandidatoDAO cand = new CandidatoDAO();
				Candidato candidato = cand.login(loginField.getText(), senhaField.getText());
				if(candidato.getId() != null){
					this.setVisible(false);
					new PerfilCandidato(candidato);
				} else {
					JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(cadastrarButton)){
			cadastrarButton.setForeground(Color.CYAN);
		} else if (e.getSource().equals(esqueciSenhaButton)){
			esqueciSenhaButton.setForeground(Color.CYAN);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(cadastrarButton)){
			cadastrarButton.setForeground(corLetra);
		} else if (e.getSource().equals(esqueciSenhaButton)){
			esqueciSenhaButton.setForeground(corLetra);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}