package controllers;

import play.mvc.Controller;

public class Logins extends Controller {

	public static void login() {
		render();
	}

	public static void logar(String email, String senha) {
		System.out.println(email + "/" + senha);
		Pessoas.form();
	}

}
