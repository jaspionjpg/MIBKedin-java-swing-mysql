package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Beans.Vaga;

public class PerfilVaga extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 500;
	Integer altura = 500;
	
	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;

	Vaga vaga;
	
	public PerfilVaga(Vaga vaga) {
		this.vaga = vaga;
		inicializaComponents();
		setVisible(true);
	}
	
	private void inicializaComponents() {
		setTitle("Vaga MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}