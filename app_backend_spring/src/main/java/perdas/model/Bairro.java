package perdas.model;

import java.io.Serializable;

public class Bairro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String getBairro() {
		return bairro;
	}
	public int getTotal() {
		return total;
	}
	public double getPerdaA() {
		perdaA = Math.round(perdaA * 100.0) / 100.0;
		return perdaA;
	}
	public double getPerdaF() {
		perdaF = Math.round(perdaF * 100.0) / 100.0;
		return perdaF;
	}
	
	public Bairro(String bairro, int total, double perdaA, double perdaF) {
		super();
		this.bairro = bairro;
		this.total = total;
		this.perdaA = perdaA;
		this.perdaF = perdaF;
	}

	private String bairro;
	private int total;
	private double perdaA;
	private double perdaF;
	
}
