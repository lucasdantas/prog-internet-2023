package controllers;

import java.util.List;

import models.Veiculo;
import play.mvc.Controller;

public class Veiculos extends Controller {
	
	public static void form() {
		render();
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
