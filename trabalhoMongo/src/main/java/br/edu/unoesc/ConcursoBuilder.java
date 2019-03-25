package br.edu.unoesc;

import java.util.Date;
import java.util.Random;

import br.edu.unoesc.dao.ConcursoDAO;
import br.edu.unoesc.dao.ConcursoMongo;
import br.edu.unoesc.model.Concurso;

public class ConcursoBuilder {
	
	// adicionando concursos no banco
	ConcursoDAO concursoDao= new ConcursoMongo();
	Random random = new Random();
	
	public void adicionarConcursosNoBanco() {
		Concurso concurso1= new Concurso();
		concurso1.setNumero(1L);
		concurso1.setData(new Date());
		concurso1.adicionarNumeros(2, 4, 6, 8, 10, 12);
		
		concursoDao.inserir(concurso1);		
		
		Concurso concurso2= new Concurso();
		concurso2.setNumero(2L);
		concurso2.setData(new Date());
		concurso2.adicionarNumeros(random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100));
		
		concursoDao.inserir(concurso2);
		
		Concurso concurso3= new Concurso();
		concurso3.setNumero(3L);
		concurso3.setData(new Date());
		concurso3.adicionarNumeros(random.nextInt(100), random.nextInt(100), 
				random.nextInt(100), random.nextInt(100), 
				random.nextInt(100), random.nextInt(100));
		
		concursoDao.inserir(concurso3);
	}
	

}
