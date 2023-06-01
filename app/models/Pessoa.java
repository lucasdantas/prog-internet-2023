package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Pessoa extends Model {
	
	public String nome;
	public String email;
	public String senha;
	
	@Temporal(TemporalType.DATE)
	public Date nascimento;

	@Override
	public String toString() {
		return nome + " " + email;
	}
}
