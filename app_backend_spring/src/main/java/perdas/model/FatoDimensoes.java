package perdas.model;

import java.io.Serializable;
import java.util.Date;

public class FatoDimensoes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	public FatoDimensoes(int idFato, int total, double perdaAgua, double perdaFinanceira, int idOrganizacao,
			int empresa, String nomeEmpresa, int regiao, String nomeRegiao, int unidade, String siglaUnidade,
			int localidade, String nomeLocalidade, int setor, int idEndereco, String uf, String municipio,
			String bairro, String logradouro, int idServico, int tipo, String descTipo, int espec, String descEspec,
			int idTempo, Date datadia, int ano, int mes, String nomemes, int dia, int diaAno, String diaSemana,
			String quarto, String anoQuarto, String anoMes, Date inicioSemana, Date finalSemana, Date inicioMes,
			Date finalMes) {
		super();
		this.idFato = idFato;
		this.total = total;
		this.perdaAgua = perdaAgua;
		this.perdaFinanceira = perdaFinanceira;
		this.idOrganizacao = idOrganizacao;
		this.empresa = empresa;
		this.nomeEmpresa = nomeEmpresa;
		this.regiao = regiao;
		this.nomeRegiao = nomeRegiao;
		this.unidade = unidade;
		this.siglaUnidade = siglaUnidade;
		this.localidade = localidade;
		this.nomeLocalidade = nomeLocalidade;
		this.setor = setor;
		this.idEndereco = idEndereco;
		this.uf = uf;
		this.municipio = municipio;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.idServico = idServico;
		this.tipo = tipo;
		this.descTipo = descTipo;
		this.espec = espec;
		this.descEspec = descEspec;
		this.idTempo = idTempo;
		this.dataDia = datadia;
		this.ano = ano;
		this.mes = mes;
		this.nomeMes = nomemes;
		this.dia = dia;
		this.diaAno = diaAno;
		this.diaSemana = diaSemana;
		this.quarto = quarto;
		this.anoQuarto = anoQuarto;
		this.anoMes = anoMes;
		this.inicioSemana = inicioSemana;
		this.finalSemana = finalSemana;
		this.inicioMes = inicioMes;
		this.finalMes = finalMes;
	}
	public int getIdFato() {
		return idFato;
	}
	public int getTotal() {
		return total;
	}
	public double getPerdaAgua() {
		perdaAgua = Math.round(perdaAgua * 100.0) / 100.0;
		return perdaAgua;
	}
	public double getPerdaFinanceira() {
		perdaFinanceira = Math.round(perdaFinanceira * 100.0) / 100.0;
		return perdaFinanceira;
	}
	public int getIdOrganizacao() {
		return idOrganizacao;
	}
	public int getEmpresa() {
		return empresa;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public int getRegiao() {
		return regiao;
	}
	public String getNomeRegiao() {
		return nomeRegiao;
	}
	public int getUnidade() {
		return unidade;
	}
	public String getSiglaUnidade() {
		return siglaUnidade;
	}
	public int getLocalidade() {
		return localidade;
	}
	public String getNomeLocalidade() {
		return nomeLocalidade;
	}
	public int getSetor() {
		return setor;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public String getUf() {
		return uf;
	}
	public String getMunicipio() {
		return municipio;
	}
	public String getBairro() {
		return bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public int getIdServico() {
		return idServico;
	}
	public int getTipo() {
		return tipo;
	}
	public String getDescTipo() {
		return descTipo;
	}
	public int getEspec() {
		return espec;
	}
	public String getDescEspec() {
		return descEspec;
	}
	public int getIdTempo() {
		return idTempo;
	}
	public Date getDatadia() {
		return dataDia;
	}
	public int getAno() {
		return ano;
	}
	public int getMes() {
		return mes;
	}
	public String getNomemes() {
		return nomeMes;
	}
	public int getDia() {
		return dia;
	}
	public int getDiaAno() {
		return diaAno;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public String getQuarto() {
		return quarto;
	}
	public String getAnoQuarto() {
		return anoQuarto;
	}
	public String getAnoMes() {
		return anoMes;
	}
	public Date getInicioSemana() {
		return inicioSemana;
	}
	public Date getFinalSemana() {
		return finalSemana;
	}
	public Date getInicioMes() {
		return inicioMes;
	}
	public Date getFinalMes() {
		return finalMes;
	}
	private int idFato;
	private int total;
	private double perdaAgua;
	private double perdaFinanceira;
	private int idOrganizacao;
	private int empresa;
	private String nomeEmpresa;
	private int regiao;
	private String nomeRegiao;
	private int unidade;
	private String siglaUnidade;
	private int localidade;
	private String nomeLocalidade;
	private int setor;
	private int idEndereco;
	private String uf;
	private String municipio;
	private String bairro;
	private String logradouro;
	private int idServico;
	private int tipo;
	private String descTipo;
	private int espec;
	private String descEspec;
	private int idTempo;
	private Date dataDia;
	private int ano;
	private int mes;
	private String nomeMes;
	private int dia;
	private int diaAno;
	private String diaSemana;
	private String quarto;
	private String anoQuarto;
	private String anoMes;
	private Date inicioSemana;
	private Date finalSemana;	
	private Date inicioMes;
	private Date finalMes;
	
	
	

}
