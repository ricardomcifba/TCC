package perdas.model;

import java.io.Serializable;

public class Tempo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Tempo(int mes, String nomeMes, int total, double perdaA, double perdaF) {
		super();
		this.mes = mes;
		this.nomeMes = nomeMes;
		this.total = total;
		this.perdaA = perdaA;
		this.perdaF = perdaF;
	}
	
	public int getMes() {
		return mes;
	}
	public String getNomeMes() {
		return nomeMes;
	}
	public int getTotal() {
		return total;
	}
	public double getPerdaA() {
		return perdaA;
	}
	public double getPerdaF() {
		return perdaF;
	}

	private int mes;
	private String nomeMes;
	private int total;
	private double perdaA;
	private double perdaF;
}
