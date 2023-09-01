package jobs;

import models.Pessoa;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {
	
	@Override
	public void doJob() throws Exception {
		if (Pessoa.count() == 0) {
			Pessoa joao = new Pessoa();
			joao.nome = "Joao Silva";
			joao.email = "joaojj@gmail.com";
			joao.senha = "12345";
			joao.save();
			
			Pessoa maria = new Pessoa();
			maria.nome = "Maria Silva";
			maria.email = "mmmmjj@gmail.com";
			maria.senha = "54321";
			maria.save();
		}
	}

}
