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

import Beans.Candidato;
import DAO.CandidatoDAO;

public class Candidatos extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 500;
	Integer altura = 720;
	
	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	Integer numeroPagina;
	CandidatoDAO cand = new CandidatoDAO();
	List<Candidato> candidatos;
	
	JLabel txtLinha;
	JLabel nometxtbusca;
	JLabel cidadetxtbusca;
	JLabel cargostxtbusca;
	JLabel empresastxtbusca;
	JLabel cursostxtbusca;
	JLabel escolastxtbusca;
	
	List<JLabel> nome;
	List<JLabel> email;
	List<JLabel> cidade;
	List<JLabel> telefone;
	List<JLabel> cargos;
	List<JLabel> cursos;
	
	JTextField nomebusca;
	JTextField cidadebusca;
	JTextField cargosbusca;
	JTextField empresasbusca;
	JTextField cursosbusca;
	JTextField escolasbusca;
	
	List<JButton> detalhes;
	List<JButton> paginas;
	
	public Candidatos() {
		this.candidatos = cand.pegaTodasCandidatos();
		this.numeroPagina = 0;
		inicializaComponents();
		setVisible(true);
	}
	
	public Candidatos(List<Candidato> candidatos, Integer pagina) {
		this.candidatos = candidatos;
		this.numeroPagina = pagina;
		inicializaComponents();
		setVisible(true);
	}
	
	private void inicializaComponents() {
		setTitle("Candidatos MIBKedin");
		getContentPane().setBackground(corFundo);

		setLayout(null);
        setResizable(false);
        
        nometxtbusca = new JLabel("Nome:");
		nometxtbusca.setFont(new Font("arial",15,15));
		nometxtbusca.setBounds(10,10,100,25);
        nometxtbusca.setForeground(corLetra);
        add(nometxtbusca);
        
		nomebusca = new JTextField();
        nomebusca.setFont(new Font("arial",15,15));
        nomebusca.setBounds(65,10,150,25);
        nomebusca.setForeground(corLetra);
        nomebusca.addKeyListener(this);
        add(nomebusca);
    	
        cidadetxtbusca = new JLabel("Cidade:");
        cidadetxtbusca.setFont(new Font("arial",15,15));
        cidadetxtbusca.setBounds(215,10,100,25);
        cidadetxtbusca.setForeground(corLetra);
        add(cidadetxtbusca);
        
        cidadebusca = new JTextField();
        cidadebusca.setFont(new Font("arial",15,15));
        cidadebusca.setBounds(280,10,150,25);
        cidadebusca.setForeground(corLetra);
        cidadebusca.addKeyListener(this);
        add(cidadebusca);
        
        cargostxtbusca = new JLabel("Cargos:");
        cargostxtbusca.setFont(new Font("arial",15,15));
        cargostxtbusca.setBounds(10,40,100,25);
        cargostxtbusca.setForeground(corLetra);
        add(cargostxtbusca);
        
        cargosbusca = new JTextField();
		cargosbusca.setFont(new Font("arial",15,15));
		cargosbusca.setBounds(65,40,150,25);
        cargosbusca.setForeground(corLetra);
        cargosbusca.addKeyListener(this);
        add(cargosbusca);
    	
        empresastxtbusca = new JLabel("Empresa:");
        empresastxtbusca.setFont(new Font("arial",15,15));
        empresastxtbusca.setBounds(215,40,100,25);
        empresastxtbusca.setForeground(corLetra);
        add(empresastxtbusca);
        
        empresasbusca = new JTextField();
        empresasbusca.setFont(new Font("arial",15,15));
        empresasbusca.setBounds(280,40,150,25);
        empresasbusca.setForeground(corLetra);
        empresasbusca.addKeyListener(this);
        add(empresasbusca);
        
        cursostxtbusca = new JLabel("Curso:");
        cursostxtbusca.setFont(new Font("arial",15,15));
        cursostxtbusca.setBounds(10,70,100,25);
        cursostxtbusca.setForeground(corLetra);
        add(cursostxtbusca);
        
        cursosbusca = new JTextField();
        cursosbusca.setFont(new Font("arial",15,15));
        cursosbusca.setBounds(65,70,150,25);
		cursosbusca.setForeground(corLetra);
		cursosbusca.addKeyListener(this);
        add(cursosbusca);
    	
        escolastxtbusca = new JLabel("Escola:");
        escolastxtbusca.setFont(new Font("arial",15,15));
        escolastxtbusca.setBounds(215,70,100,25);
        escolastxtbusca.setForeground(corLetra);
        add(escolastxtbusca);
        
        escolasbusca = new JTextField();
        escolasbusca.setFont(new Font("arial",15,15));
        escolasbusca.setBounds(280,70,150,25);
        escolasbusca.setForeground(corLetra);
        escolasbusca.addKeyListener(this);
        add(escolasbusca);

        txtLinha = new JLabel();
		txtLinha.setOpaque(true);
		txtLinha.setBackground(Color.black);
		txtLinha.setBounds(0, 100, 500, 2);
		add(txtLinha);
		
		colocaCandidatos();
	}

	private void colocaCandidatos() {
		Integer nmaximo = candidatos.size();
		if(numeroPagina * 6 + 6 < candidatos.size()){
			nmaximo = numeroPagina * 6 + 6;
		}
		detalhes = new ArrayList<>();
		int j = 0;
		nome = new ArrayList<>();
		email = new ArrayList<>();
		cidade = new ArrayList<>();
		telefone = new ArrayList<>();
		cargos = new ArrayList<>();
		cursos = new ArrayList<>();
		for(int i = numeroPagina * 6; i < nmaximo; i++){
			JLabel nome = new JLabel("Nome: " + candidatos.get(i).getNome());
	        nome.setFont(new Font("arial",15,15));
	        nome.setBounds(10, 105 + j * 100, 230,25);
	        nome.setForeground(corLetra);
	        add(nome);
	        this.nome.add(nome);
	        
	        JLabel email = new JLabel("Email: " + candidatos.get(i).getEmail());
	        email.setFont(new Font("arial",15,15));
	        email.setBounds(10, 135 + j * 100,220,25);
	        email.setForeground(corLetra);	
	        add(email);
	        this.email.add(email);
	        
	        JLabel cidade  = new JLabel("Cidade: " + candidatos.get(i).getCidade());
	        cidade.setFont(new Font("arial",15,15));
	        cidade.setBounds(240,105 + j * 100,200,25);
	        cidade.setForeground(corLetra);
	        add(cidade);
	        this.cidade.add(cidade);
	        
	        JLabel telefone = new JLabel("Telefone: "+ candidatos.get(i).getTelefone());
	        telefone.setFont(new Font("arial",15,15));
	        telefone.setBounds(240, 135 + j * 100,200,25);
	        telefone.setForeground(corLetra);
	        add(telefone);
	        this.telefone.add(telefone);
	        
	        JLabel cargos = new JLabel(candidatos.get(i).getCargos());
	        cargos.setFont(new Font("arial",15,15));
	        cargos.setBounds(10,165 + j * 100,230,25);
	        cargos.setForeground(corLetra);
	        add(cargos);
	        this.cargos.add(cargos);
	        
	        JLabel cursos = new JLabel(candidatos.get(i).getCursos());
	        cursos.setFont(new Font("arial",15,15));
	        cursos.setBounds(240, 165 + j * 100,250,25);
	        cursos.setForeground(corLetra);
	        add(cursos);
	        this.cursos.add(cursos);
	        
	        JLabel linha = new JLabel();
	        linha.setOpaque(true);
	        linha.setBackground(Color.black);
	        linha.setBounds(0, 195 + j * 100, 500, 2);
			add(linha);
			
			JButton detalhes = new JButton("Detalhes");
	        detalhes.setBounds(410, 108 + j * 100, 75,50);
	        detalhes.setBorder(new TitledBorder(""));
	        detalhes.addActionListener(this);
			add(detalhes);
			this.detalhes.add(detalhes);
			j++;
		}
		Integer numeroCandidatos = (int) Math.ceil(candidatos.size()/new Double(6));
		paginas = new ArrayList<>();
		for(int i = 0; i < numeroCandidatos; i++){
			JButton pagina = new JButton(i+"");
	        pagina.setBounds((largura - (numeroCandidatos * 50) + i * 100)/2, 205 + ((nmaximo - numeroPagina * 6)-1) * 100, 50,40);
	        pagina.addActionListener(this);
			add(pagina);
			this.paginas.add(pagina);
		}
		setSize(largura, 205 + ((nmaximo - numeroPagina * 6)-1) * 100 +80);
		setLocationRelativeTo(null);
	}
	
	private void removeCandidatos() {
		for(JButton detalhe : detalhes){
			remove(detalhe);
		}
		for(JButton pagina : paginas){
			remove(pagina);
		}
		for(JLabel detalhe : nome){
			remove(detalhe);
		}
		for(JLabel pagina : email){
			remove(pagina);
		}
		for(JLabel detalhe : cargos){
			remove(detalhe);
		}
		for(JLabel pagina : cursos){
			remove(pagina);
		}
		for(JLabel detalhe : cidade){
			remove(detalhe);
		}
		for(JLabel pagina : telefone){
			remove(pagina);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < paginas.size(); i ++){
			if(e.getSource().equals(paginas.get(i))){
				this.setVisible(false);
				new Candidatos(this.candidatos, i);
				break;
			}
		}
		for(int i = 0; i < detalhes.size(); i ++){
			if(e.getSource().equals(detalhes.get(i))){
				this.setVisible(false);
				new PerfilCandidato(this.candidatos.get(numeroPagina * 6 + i), true);
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
		cand = new CandidatoDAO();
		this.candidatos = cand.procuraTodasCandidatos(nomebusca.getText(), cidadebusca.getText(), empresasbusca.getText(), escolasbusca.getText(), cargosbusca.getText(), cursosbusca.getText());
		removeCandidatos();
		colocaCandidatos();
		repaint();
	}
}
