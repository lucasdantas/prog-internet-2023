package controllers;

import java.util.List;

import models.Pessoa;
import models.Veiculo;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Veiculos extends Controller {

	public static void form() {
		List<Pessoa> pessoas = Pessoa.findAll();
		render(pessoas);
	}
	
	public static void salvar(Veiculo v) {
		
		if (v.ano == null || v.ano == 0) {
			flash.error("É necessário informar um valor para ano");
			form();
		} else if (v.ano != null && v.ano < 1000) {
			flash.error("Ano inválido");
			form();
		}
		
		v.save();
		flash.success("Veículo cadastrado com sucesso.");
		listar();
	}
	
	public static void listar() {
		List<Veiculo> veiculos = Veiculo.findAll();
		render(veiculos);
	}

}
