package controllers;

import java.util.List;

import models.Pessoa;
import play.mvc.Controller;

public class Pessoas extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void editar(Long id) {
		Pessoa p = Pessoa.findById(id);
		renderTemplate("Pessoas/form.html", p);
	}
	
	public static void remover(Long id) {
		Pessoa p = Pessoa.findById(id);
		
		if ("joao".equalsIgnoreCase(p.nome)) {
			flash.error("Joao nao pode ser removido do sistema");
		} else {
			p.delete();
			flash.success("A pessoa foi removida com sucesso.");
		}
		
		listar(null);
	}
	
	public static void listar(String termo) {
		List<Pessoa> pessoas = null;
		if (termo == null || termo.isEmpty()) {
			pessoas = Pessoa.findAll();			
		} else {
			pessoas = Pessoa.find("lower(nome) like ?1 or lower(email) like ?1",
					"%"+ termo.toLowerCase() +"%").fetch();
		}
		render(pessoas, termo);
	}
	
	public static void detalhar(Long id) {
		Pessoa pessoa = Pessoa.findById(id);
		render(pessoa);
	}
	
	public static void salvar(Pessoa pessoa) {
		pessoa.nome = pessoa.nome.toUpperCase();
		pessoa.email = pessoa.email.toLowerCase();
		pessoa.save();
		
		flash.success("A pessoa foi cadastrada com sucesso.");

		detalhar(pessoa.id);
	}
}
