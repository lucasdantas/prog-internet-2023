package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Veiculo extends Model {
	@Required
	@MinSize(8)
	public String placa;
	@Required
	public Integer ano;
	
	public String modelo;
	
	@ManyToOne
	public Pessoa pessoa;
	
	@Override
	public String toString() {
		return placa + " / " + ano + " - " + modelo;
	}

}
