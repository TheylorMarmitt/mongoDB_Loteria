package br.edu.unoesc.dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import br.edu.unoesc.model.Concurso;

public class ConcursoMongo implements ConcursoDAO {

	ConexaoMongo connect;
	private MongoCollection<Concurso> getCollection() {
		return ConexaoMongo.getDatabase().getCollection("loteria", Concurso.class);
	}

	@Override
	public void inserir(Concurso concurso) {
		getCollection().insertOne(concurso);
	}


	@Override
	public void alterar(Concurso concurso) {
		getCollection()
			.updateOne(eq("numero", concurso.getNumero()), 
					combine(
							set("data", concurso.getData()),
							set("numeros", concurso.getNumeros()),
							set("ganhadores", concurso.getGanhadores())));
	}

	@Override
	public Concurso buscar(Long numero) {
		return getCollection().find(eq("numero",numero)).first();
	}

	@Override
	public void remover(Long numero) {
		getCollection().deleteOne(eq("numero",numero));
	}

	@Override
	public List<Concurso> listar() {
		List<Concurso> concursos = new ArrayList<>();
		getCollection().find().iterator().forEachRemaining(concursos::add);
		return concursos;
	}

	
}
