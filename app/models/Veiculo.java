package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Veiculo extends Model {
	public String placa;
	public Integer ano;
	public String modelo;
	
	@ManyToOne
	public Pessoa pessoa;
	
	@Override
	public String toString() {
		return placa + " / " + ano + " - " + modelo;
	}

}
