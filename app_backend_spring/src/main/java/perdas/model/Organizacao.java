package perdas.model;

import java.io.Serializable;

public class Organizacao implements Serializable {


	private static final long serialVersionUID = 1L;
	
	public Organizacao(int setor, int total, double perdaA, double perdaF) {

		this.setor = setor;
		this.total = total;
		this.perdaA = perdaA;
		this.perdaF = perdaF;
	}
	public int getSetor() {
		return setor;
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
	private int setor;
	private int total;
	private double perdaA;
	private double perdaF;
	

}
