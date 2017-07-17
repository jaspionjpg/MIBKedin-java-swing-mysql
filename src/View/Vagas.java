package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Beans.Vaga;
import DAO.VagaDAO;

public class Vagas extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Integer largura = 500;
	Integer altura = 720;
	
	Color corLetra = Color.BLUE;
	Color corFundo = Color.WHITE;
	
	Integer numeroPagina;
	VagaDAO vag = new VagaDAO();
	List<Vaga> vagas;
	
	JLabel txtLinha;
	JLabel titulotxtbusca;
	JLabel cidadetxtbusca;
	JLabel setortxtbusca;
	JLabel empresatxtbusca;
	
	JLabel titulo;
	JLabel cidade;
	JLabel setor;
	JLabel empresa;
	
	JTextField titulobusca;
	JTextField cidadebusca;
	JTextField setorbusca;
	JTextField empresasbusca;
	
	List<JButton> detalhes;
	List<JButton> paginas;
	JButton buscar;
	
	public Vagas() {
		this.vagas = vag.pegaTodasVagas();
		this.numeroPagina = 0;
		inicializaComponents();
		setVisible(true);
	}
	
	public Vagas(List<Vaga> vagas, Integer pagina) {
		this.vagas = vagas;
		this.numeroPagina = pagina;
		inicializaComponents();
		setVisible(true);
	}
	
	private void inicializaComponents() {
		setTitle("Vagas MIBKedin");
		getContentPane().setBackground(corFundo);
		
		setResizable(false);
		setLayout(null);
		
		titulotxtbusca = new JLabel("Titulo:");
		titulotxtbusca.setFont(new Font("arial",15,15));
		titulotxtbusca.setBounds(5,10,100,25);
        titulotxtbusca.setForeground(corLetra);
        add(titulotxtbusca);
        
		titulobusca = new JTextField();
        titulobusca.setFont(new Font("arial",15,15));
        titulobusca.setBounds(50,10,150,25);
        titulobusca.setForeground(corLetra);
        add(titulobusca);
    	
        cidadetxtbusca = new JLabel("Cidade:");
        cidadetxtbusca.setFont(new Font("arial",15,15));
        cidadetxtbusca.setBounds(200,10,100,25);
        cidadetxtbusca.setForeground(corLetra);
        add(cidadetxtbusca);
        
        cidadebusca = new JTextField();
        cidadebusca.setFont(new Font("arial",15,15));
        cidadebusca.setBounds(265,10,150,25);
        cidadebusca.setForeground(corLetra);
        add(cidadebusca);
        
        setortxtbusca = new JLabel("Setor:");
        setortxtbusca.setFont(new Font("arial",15,15));
        setortxtbusca.setBounds(5,40,100,25);
        setortxtbusca.setForeground(corLetra);
        add(setortxtbusca);
        
        setorbusca = new JTextField();
		setorbusca.setFont(new Font("arial",15,15));
		setorbusca.setBounds(50,40,150,25);
        setorbusca.setForeground(corLetra);
        add(setorbusca);
    	
        empresatxtbusca = new JLabel("Empresa:");
        empresatxtbusca.setFont(new Font("arial",15,15));
        empresatxtbusca.setBounds(200,40,100,25);
        empresatxtbusca.setForeground(corLetra);
        add(empresatxtbusca);
        
        empresasbusca = new JTextField();
        empresasbusca.setFont(new Font("arial",15,15));
        empresasbusca.setBounds(265,40,150,25);
        empresasbusca.setForeground(corLetra);
        add(empresasbusca);
		
        buscar = new JButton("busca");
        buscar.setFont(new Font("arial",18,15));
        buscar.setBounds(415,25,80,25);
        buscar.setForeground(corLetra);
        buscar.addActionListener(this);
        add(buscar);
        
		txtLinha = new JLabel();
		txtLinha.setOpaque(true);
		txtLinha.setBackground(Color.black);
		txtLinha.setBounds(0, 70, 500, 2);
		add(txtLinha);
		
		Integer nmaximo = vagas.size();
		if(numeroPagina * 7 + 7 < vagas.size()){
			nmaximo = numeroPagina * 7 + 7;
		}
		detalhes = new ArrayList<>();
		int j = 0;
		for(int i = numeroPagina * 7; i < nmaximo; i++){
			titulo = new JLabel("Titulo: "+ vagas.get(i).getTitulo());
			titulo.setFont(new Font("arial",15,15));
			titulo.setBounds(20, 70 + j * 60, 200,25);
			titulo.setForeground(corLetra);
	        add(titulo);
	        
	        cidade = new JLabel("Cidade: " + vagas.get(i).getCidade());
	        cidade.setFont(new Font("arial",15,15));
	        cidade.setBounds(250, 70 + j * 60,200,25);
	        cidade.setForeground(corLetra);	
	        add(cidade);
	        
	        setor = new JLabel("Setor: " + vagas.get(i).getSetor());
	        setor.setFont(new Font("arial",15,15));
	        setor.setBounds(20,100 + j * 60,200,25);
	        setor.setForeground(corLetra);
	        add(setor);
	        
	        empresa = new JLabel("Empresa: " + vagas.get(i).getIdEmpresa());
	        empresa.setFont(new Font("arial",15,15));
	        empresa.setBounds(250, 100 + j * 60,200,25);
	        empresa.setForeground(corLetra);
	        add(empresa);
	        
	        JLabel linha = new JLabel();
	        linha.setOpaque(true);
	        linha.setBackground(Color.black);
	        linha.setBounds(0, 125 + j * 60, 500, 2);
			add(linha);
			
			JButton detalhes = new JButton("Detalhes");
	        detalhes.setBounds(400, 75 + j * 60, 75,45);
	        detalhes.setBorder(new TitledBorder(""));
	        detalhes.addActionListener(this);
			add(detalhes);
			this.detalhes.add(detalhes);
			j++;
		}
		Integer numeroEmpresas = (int) Math.ceil(vagas.size()/new Double(7));
		paginas = new ArrayList<>();
		for(int i = 0; i < numeroEmpresas; i++){
			JButton pagina = new JButton(i+"");
	        pagina.setBounds((largura - (numeroEmpresas * 50) + i * 100)/2, 135 + ((nmaximo - numeroPagina * 7)-1) * 60, 50,40);
	        pagina.addActionListener(this);
			add(pagina);
			this.paginas.add(pagina);
		}       

		setSize(largura, 135 + ((nmaximo - numeroPagina * 7)-1) * 60 +80);
		setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < paginas.size(); i ++){
			if(e.getSource().equals(paginas.get(i))){
				this.setVisible(false);
				new Vagas(this.vagas, i);
				break;
			}
		}
		for(int i = 0; i < detalhes.size(); i ++){
			if(e.getSource().equals(detalhes.get(i))){
				this.setVisible(false);
				//new Vaga(this.vagas.get(numeroPagina * 7 + i));
				break;
			}
		}
	}
}
