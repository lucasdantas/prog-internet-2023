package controllers;

import play.*;
import play.mvc.*;

import java.util.*;


public class Application extends Controller {

    public static void index(String nome, String cidade) {
        render(nome, cidade);
    }

}