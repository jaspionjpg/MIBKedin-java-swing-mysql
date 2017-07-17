package Controler;

import java.util.ArrayList;
import java.util.List;

import Beans.Candidato;
import Beans.Empresa;
import Beans.Vaga;
import View.CadastradoComSucesso;
import View.CadastrarVaga;
import View.CadastroCandidato;
import View.CadastroEmpresa;
import View.Candidatos;
import View.Empresas;
import View.Login;
import View.PerfilCandidato;
import View.PerfilEmpresa;
import View.Vagas;

public class Main {
	public static void main(String[] args) {
		Vaga vaga = new Vaga();
		vaga.setCidade("São paulo");
		vaga.setDataCadastro("13/03/2018");
		vaga.setDescricao("Trabalho escravo ambiente saudavel");
		vaga.setIdEmpresa(1l);
		vaga.setSetor("Tecnologia");
		vaga.setTitulo("Programador");
		
		Candidato candidato = new Candidato();
		candidato.setEmail("Richardx4000@hotmail.com");
		candidato.setNome("Richard Martins");
		candidato.setDescricao("Um cara sensacional");
		candidato.setCidade("São paulo");
		candidato.setEndereco("Rua Inacio Monteiro 6958");
		candidato.setDataNascimento("29/03/1998");
		candidato.setTelefone("11 - 949258749");
		candidato.setCargos("Desenvolvedor Java Jr, Desenvolvedor Java Pleno");
		candidato.setEmpresas("Lello Imoveis, Lello Imoveis");
		candidato.setCursos("Tecnico informática, Baicharel Ciêntista");
		candidato.setEscolas("ETEC Guaianazes, UNICID");
		
		Empresa empresa = new Empresa();
		empresa.setId(1l);
		empresa.setNome("3 Pães");
		empresa.setCidadeSede("São paulo");
		empresa.setDescricao("Uma ÓTIMA empresa para se trabalhar");
		empresa.setEndereco("Av dez paes sem bairro n 32");
		empresa.setFundacao(1233);
		empresa.setSetor("Tecnologia");
		empresa.setSite("www.jafuimelhor.com.br");
		empresa.setTamanhoEmpresa(100 + " Funcionarios");
		empresa.setTelefone("11 4002 - 8922");
		
		List<Empresa> empresas = new ArrayList<>();
		empresas.add(empresa);
		
		List<Candidato> candidatos = new ArrayList<>();
		candidatos.add(candidato);
		
		List<Vaga> vagas = new ArrayList<>();
		vagas.add(vaga);
		//new Login();
		new PerfilCandidato(candidato);
		//new PerfilEmpresa(empresa);
		//new CadastroCandidato();
		//new CadastroEmpresa();
		//new CadastrarVaga(empresa);
		//new CadastradoComSucesso(candidato);
		//new Vagas(vagas);
		//new Candidatos(candidatos);
		//new Empresas(empresas);
	}
}
