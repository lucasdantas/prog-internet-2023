package controllers;

import java.util.List;

import models.Pessoa;
import models.Veiculo;
import play.mvc.Controller;

public class Veiculos extends Controller {
	
	public static void form() {
		List<Pessoa> pessoas = Pessoa.findAll();
		render(pessoas);
	}
	
	public static void salvar(Veiculo v) {
		v.save();
		listar();
	}
	
	public static void listar() {
		List<Veiculo> veiculos = Veiculo.findAll();
		render(veiculos);
	}

}
