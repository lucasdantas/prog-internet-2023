package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Veiculo extends Model {
	public String placa;
	public Integer ano;
	public String modelo;
	
	@Override
	public String toString() {
		return placa + " / " + ano + " - " + modelo;
	}

}
