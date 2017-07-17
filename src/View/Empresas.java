package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Beans.Empresa;
import DAO.EmpresaDAO;

public class Empresas extends JFrame implements ActionListener, KeyListener  {
	private static final long serialVersionUID = 1L;
	Integer largura = 500;
	Integer altura = 620;
	
	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	Integer numeroPagina;
	EmpresaDAO emp = new EmpresaDAO();
	List<Empresa> empresas;

	JLabel txtLinha;
	JLabel nometxtbusca;
	JLabel setortxtbusca;
	
	List<JLabel> nome;
	List<JLabel> setor;
	List<JLabel> cidadeSede;
	List<JLabel> tamanhoEmpresa;
	
	JTextField nomebusca;
	JTextField setorbusca;
	
	List<JButton> detalhes;
	List<JButton> paginas;
	JButton buscar;
	
	public Empresas() {
		this.empresas = emp.pegaTodasEmpresas();
		this.numeroPagina = 0;
		inicializaComponents();
		setVisible(true);
	}
	
	public Empresas(List<Empresa> empresas, Integer pagina) {
		this.empresas = empresas;
		this.numeroPagina = pagina;
		inicializaComponents();
		setVisible(true);
	}
	
	private void inicializaComponents() {
		setTitle("Empresas MIBKedin");
		setSize(largura, altura);
		getContentPane().setBackground(corFundo);

		setLocationRelativeTo(null);
		setLayout(null);
        setResizable(false);
        
		nometxtbusca = new JLabel("Nome:");
		nometxtbusca.setFont(new Font("arial",15,15));
		nometxtbusca.setBounds(10,10,100,25);
        nometxtbusca.setForeground(corLetra);
        add(nometxtbusca);
        
		nomebusca = new JTextField();
        nomebusca.setFont(new Font("arial",15,15));
        nomebusca.setBounds(55,10,150,25);
        nomebusca.setForeground(corLetra);
        nomebusca.addKeyListener(this);
        add(nomebusca);
    	
        setortxtbusca = new JLabel("Setor:");
        setortxtbusca.setFont(new Font("arial",15,15));
        setortxtbusca.setBounds(205,10,100,25);
        setortxtbusca.setForeground(corLetra);
        add(setortxtbusca);
        
        setorbusca = new JTextField();
        setorbusca.setFont(new Font("arial",15,15));
        setorbusca.setBounds(250,10,150,25);
        setorbusca.setForeground(corLetra);
        setorbusca.addKeyListener(this);
        add(setorbusca);

		txtLinha = new JLabel();
		txtLinha.setOpaque(true);
		txtLinha.setBackground(Color.black);
		txtLinha.setBounds(0, 40, 500, 2);
		add(txtLinha);
		
		colocaEmpresas();
	}
	
	private void removeEmpresas() {
		for(JButton detalhe : detalhes){
			remove(detalhe);
		}
		for(JButton pagina : paginas){
			remove(pagina);
		}
		for(JLabel detalhe : nome){
			remove(detalhe);
		}
		for(JLabel pagina : setor){
			remove(pagina);
		}
		for(JLabel detalhe : cidadeSede){
			remove(detalhe);
		}
		for(JLabel pagina : tamanhoEmpresa){
			remove(pagina);
		}
	}

	private void colocaEmpresas() {
		Integer nmaximo = empresas.size();
		if(numeroPagina * 7 + 7 < empresas.size()){
			nmaximo = numeroPagina * 7 + 7;
		}
		detalhes = new ArrayList<>();
		int j = 0;
		nome = new ArrayList<>();
		tamanhoEmpresa = new ArrayList<>();
		setor = new ArrayList<>();
		cidadeSede = new ArrayList<>();
		for(int i = numeroPagina * 7; i < nmaximo; i++){
			JLabel nome = new JLabel("Nome: "+ empresas.get(i).getNome());
	        nome.setFont(new Font("arial",15,15));
	        nome.setBounds(20, 50 + j * 70, 200,25);
	        nome.setForeground(corLetra);
	        add(nome);
	        this.nome.add(nome);
	        
	        JLabel tamanhoEmpresa = new JLabel(empresas.get(i).getTamanhoEmpresa());
	        tamanhoEmpresa.setFont(new Font("arial",15,15));
	        tamanhoEmpresa.setBounds(250, 50 + j * 70,200,25);
	        tamanhoEmpresa.setForeground(corLetra);	
	        add(tamanhoEmpresa);
	        this.tamanhoEmpresa.add(tamanhoEmpresa);
	        
	        JLabel setor = new JLabel("Setor: " + empresas.get(i).getSetor());
	        setor.setFont(new Font("arial",15,15));
	        setor.setBounds(20,80 + j * 70,200,25);
	        setor.setForeground(corLetra);
	        add(setor);
	        this.setor.add(setor);
	        
	        JLabel cidadeSede = new JLabel("Cidade: " + empresas.get(i).getCidadeSede());
	        cidadeSede.setFont(new Font("arial",15,15));
	        cidadeSede.setBounds(250, 80 + j * 70,200,25);
	        cidadeSede.setForeground(corLetra);
	        add(cidadeSede);
	        this.cidadeSede.add(cidadeSede);
	        
	        JLabel linha = new JLabel();
	        linha.setOpaque(true);
	        linha.setBackground(Color.black);
	        linha.setBounds(0, 110 + j * 70, 500, 2);
			add(linha);
			
			JButton detalhes = new JButton("Detalhes");
	        detalhes.setBounds(400, 50 + j * 70, 75,50);
	        detalhes.setBorder(new TitledBorder(""));
	        detalhes.addActionListener(this);
			add(detalhes);
			this.detalhes.add(detalhes);
			j++;
		}
		Integer numeroEmpresas = (int) Math.ceil(empresas.size()/new Double(7));
		paginas = new ArrayList<>();
		for(int i = 0; i < numeroEmpresas; i++){
			JButton pagina = new JButton(i+"");
	        pagina.setBounds((largura - (numeroEmpresas * 50) + i * 100)/2, 120 + ((nmaximo - numeroPagina * 7)-1) * 70, 50,40);
	        pagina.addActionListener(this);
			add(pagina);
			this.paginas.add(pagina);
		}
		setSize(largura, 120 + ((nmaximo - numeroPagina * 7)-1) * 70 +80);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < paginas.size(); i ++){
			if(e.getSource().equals(paginas.get(i))){
				this.setVisible(false);
				new Empresas(this.empresas, i);
				break;
			}
		}
		for(int i = 0; i < detalhes.size(); i ++){
			if(e.getSource().equals(detalhes.get(i))){
				this.setVisible(false);
				new PerfilEmpresa(this.empresas.get(numeroPagina * 7 + i), true);
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		emp = new EmpresaDAO();
		this.empresas = emp.procuraTodasEmpresas(nomebusca.getText(), setorbusca.getText());
		removeEmpresas();
		colocaEmpresas();
		repaint();
	}
}
