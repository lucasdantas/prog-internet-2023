package controllers;

import java.util.List;

import models.Pessoa;
import models.Veiculo;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Veiculos extends Controller {

	public static void form() {
		List<Pessoa> pessoas = Pessoa.findAll();
		render(pessoas);
	}
	
	public static void editar(Long id) {
		Veiculo v = Veiculo.findById(id);
		flash.put("v.id", v.id);
		flash.put("v.placa", v.placa);
		flash.put("v.ano", v.ano);
		flash.put("v.modelo", v.modelo);
		flash.put("v.pessoa.id", v.pessoa.id);
		form();	
	}
	
	public static void salvar(@Valid Veiculo v) {
		
		if (validation.hasErrors()) {
			redirecionarErros();
		}
		
		Veiculo vBanco = Veiculo.find("placa = ?1", v.placa).first();
		if (vBanco != null && vBanco.id != v.id) {
			flash.error("Já existe veículo cadastrado com a placa informada");
			redirecionarErros();
		}
		
		v.save();
		flash.success("Veículo cadastrado com sucesso.");
		listar();
	}
	
	private static void redirecionarErros() {
		params.flash();
		validation.keep();
		form();
	}
	
	public static void listar() {
		List<Veiculo> veiculos = Veiculo.findAll();
		render(veiculos);
	}

}
