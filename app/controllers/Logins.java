package controllers;

import models.Pessoa;
import play.mvc.Controller;

public class Logins extends Controller {

	public static void login() {
		render();
	}

	public static void logar(String email, String senha) {
		
		Pessoa pessoaBanco = Pessoa.find("email = ?1 and senha = ?2", email, senha).first();
		if (pessoaBanco != null) {
			session.put("usuarioLogado", pessoaBanco.nome);
			flash.success("Login realizado com sucesso!");
			Pessoas.listar("");
		}
		
		flash.error("Credenciais inválidas");
		login();
	}
	
	public static void logout() {
		session.clear();
		flash.success("Você saiu do sistema");
		login();
	}

}
