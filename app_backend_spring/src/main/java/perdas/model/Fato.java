package perdas.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity(name="tabela_fato")
public class Fato  implements Serializable {


	private static final long serialVersionUID = 1L;
	

	public int getIdFato() {
		return idFato;		
	}
	public int getIdOrganizacao() {
		return idOrganizacao;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public int getIdServico() {
		return idServico;
	}
	public int getIdTempo() {
		return idTempo;
	}

    public int getTotal() {
	    return total;
	}
	public Double getPerdaAgua() {
		perdaAgua = Math.round(perdaAgua * 100.0) / 100.0;
		return perdaAgua;
	}
	public Double getPerdaFinanceira() {
		perdaFinanceira = Math.round(perdaFinanceira * 100.0) / 100.0;
		return perdaFinanceira;
	}
	@Id
	@NotBlank(message="{notblank}")	
	private int idFato;
	@Column
	private int idOrganizacao;
	@Column
	private int idEndereco;
	@Column
	private int idServico;
	@Column
	private int idTempo;
	@Column
	private int total;
	@Column	
	private Double perdaAgua;
	@Column
	private Double perdaFinanceira;
	


    /*public TabelaFato() {
    }

	
    public TabelaFato(int idFato) {
        this.idFato = idFato;
    }
    public TabelaFato(int idFato, DimensaoEndereco dimensaoEndereco, DimensaoOrganizacional dimensaoOrganizacional, DimensaoServico dimensaoServico, DimensaoVazamento dimensaoVazamento, Integer idTempo, Double perdaAgua, Double perdaFinanceira) {
       this.idFato = idFato;
       this.dimensaoEndereco = dimensaoEndereco;
       this.dimensaoOrganizacional = dimensaoOrganizacional;
       this.dimensaoServico = dimensaoServico;
       this.dimensaoVazamento = dimensaoVazamento;
       this.idTempo = idTempo;
       this.perdaAgua = perdaAgua;
       this.perdaFinanceira = perdaFinanceira;
    }
   
    public int getIdFato() {
        return this.idFato;
    }
    
    public void setIdFato(int idFato) {
        this.idFato = idFato;
    }
    public DimensaoEndereco getDimensaoEndereco() {
        return this.dimensaoEndereco;
    }
    
    public void setDimensaoEndereco(DimensaoEndereco dimensaoEndereco) {
        this.dimensaoEndereco = dimensaoEndereco;
    }
    public DimensaoOrganizacional getDimensaoOrganizacional() {
        return this.dimensaoOrganizacional;
    }
    
    public void setDimensaoOrganizacional(DimensaoOrganizacional dimensaoOrganizacional) {
        this.dimensaoOrganizacional = dimensaoOrganizacional;
    }
    public DimensaoServico getDimensaoServico() {
        return this.dimensaoServico;
    }
    
    public void setDimensaoServico(DimensaoServico dimensaoServico) {
        this.dimensaoServico = dimensaoServico;
    }
    public DimensaoVazamento getDimensaoVazamento() {
        return this.dimensaoVazamento;
    }
    
    public void setDimensaoVazamento(DimensaoVazamento dimensaoVazamento) {
        this.dimensaoVazamento = dimensaoVazamento;
    }
    public Integer getIdTempo() {
        return this.idTempo;
    }
    
    public void setIdTempo(Integer idTempo) {
        this.idTempo = idTempo;
    }
    public Double getPerdaAgua() {
        return this.perdaAgua;
    }
    
    public void setPerdaAgua(Double perdaAgua) {
        this.perdaAgua = perdaAgua;
    }
    public Double getPerdaFinanceira() {
        return this.perdaFinanceira;
    }
    
    public void setPerdaFinanceira(Double perdaFinanceira) {
        this.perdaFinanceira = perdaFinanceira;
    }

*/


}


