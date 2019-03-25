package br.edu.unoesc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import br.edu.unoesc.dao.ConcursoDAO;
import br.edu.unoesc.dao.ConcursoMongo;
import br.edu.unoesc.model.Concurso;
import br.edu.unoesc.model.Ganhador;

public class Main {

	public static void main(String[] args) {

		ConcursoDAO concursoDao= new ConcursoMongo();
		Ganhador ganhador = new Ganhador();
		Concurso concurso = new Concurso();
		Scanner sc = new Scanner(System.in);

		System.out.println("Para adicionar automaticamente concursos ---- 1");
		System.out.println("Para adicionar manualmente concursos -------- 2");
		System.out.println("Para continuar sem alterar ------------------ 0");
		int op = sc.nextInt();
		if(op == 1) {
			
			// adicionando concursos no banco
			ConcursoBuilder cb = new ConcursoBuilder();		
			cb.adicionarConcursosNoBanco();
		}else if(op == 2){
			System.out.println("Digite o numero do concurso");
			concurso.setNumero(sc.nextLong());
			concurso.setData(new Date());
			
			List<Integer> sorteados = new ArrayList<Integer>();
			System.out.println("Digite os 6 numeros sorteados ");
			for(int i=0; i<6; i++) {
				sorteados.add(sc.nextInt());			
			}
			concurso.setNumeros(sorteados);
			concursoDao.inserir(concurso);	
		}
		
		concursoDao.listar().forEach(conc->{
			System.out.println("Número do concurso: "+ conc.getNumero());
		});
		System.out.println("Escolha um concurso: ");
		Concurso escolhido = concursoDao.buscar(sc.nextLong());

		System.out.println("Digite o seu nome");
		ganhador.setNome(sc.next());
		
		List<Integer> palpites = new ArrayList<Integer>();
		System.out.println("Digite seus 6 palpites: ");
		for(int i=0; i<6; i++) {
			palpites.add(sc.nextInt());			
		}
		
		if(escolhido.validador(palpites, ganhador)) {
			concursoDao.alterar(escolhido);
			System.out.println(ganhador.getNome()+" ganhou com "+ ganhador.getQtd_acertos()+ " acertos");
		}else {
			System.out.println("Não foi dessa vez");
		}	
		
		sc.close();
	}

}
