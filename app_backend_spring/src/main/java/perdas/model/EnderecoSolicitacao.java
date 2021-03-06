package perdas.model;
// Generated 22/02/2019 16:25:43 by Hibernate Tools 4.3.1


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * DimensaoEndereco generated by hbm2java
 */
@Entity(name="endereco_solicitacao")
public class EnderecoSolicitacao  implements Serializable {

	private static final long serialVersionUID = 1L; 

	public int getIdEndereco() {
		return idEndereco;
	}
	public String getUf() {
		return uf;
	}
	public Integer getMunicipio() {
		return municipio;
	}
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}
	public Integer getLocalidade() {
		return localidade;
	}
	public Integer getSetor() {
		return setor;
	}
	public Integer getBairro() {
		return bairro;
	}
	public String getNomeBairro() {
		return nomeBairro;
	}
	public Integer getLogradouro() {
		return logradouro;
	}
	public String getNomeLogradouro() {
		return nomeLogradouro;
	}
	@Id
	 @NotBlank(message="{notblank}")
    private int idEndereco;
    @Column
    private String uf;
    @Column
    private Integer municipio;
    @Column
    private String nomeMunicipio;
    @Column
    private Integer localidade;
    @Column
    private Integer setor;
    @Column
    private Integer bairro;
    @Column
    private String nomeBairro;
    @Column
    private Integer logradouro;
    @Column
    private String nomeLogradouro;	

 
    /*
    public DimensaoEndereco() {
    }

	
    public DimensaoEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    public DimensaoEndereco(int idEndereco, DofLocalidade dofLocalidade, String uf, Integer municipio, String nomeMunicipio, Integer setor, Integer bairro, String nomeBairro, Integer logradouro, String nomeLogradouro, Set fatos) {
       this.idEndereco = idEndereco;
       this.dofLocalidade = dofLocalidade;
       this.uf = uf;
       this.municipio = municipio;
       this.nomeMunicipio = nomeMunicipio;
       this.setor = setor;
       this.bairro = bairro;
       this.nomeBairro = nomeBairro;
       this.logradouro = logradouro;
       this.nomeLogradouro = nomeLogradouro;
       this.fatos = fatos;
    }
   
    public int getIdEndereco() {
        return this.idEndereco;
    }
    
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    public DofLocalidade getDofLocalidade() {
        return this.dofLocalidade;
    }
    
    public void setDofLocalidade(DofLocalidade dofLocalidade) {
        this.dofLocalidade = dofLocalidade;
    }
    public String getUf() {
        return this.uf;
    }
    
    public void setUf(String uf) {
        this.uf = uf;
    }
    public Integer getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }
    public String getNomeMunicipio() {
        return this.nomeMunicipio;
    }
    
    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }
    public Integer getSetor() {
        return this.setor;
    }
    
    public void setSetor(Integer setor) {
        this.setor = setor;
    }
    public Integer getBairro() {
        return this.bairro;
    }
    
    public void setBairro(Integer bairro) {
        this.bairro = bairro;
    }
    public String getNomeBairro() {
        return this.nomeBairro;
    }
    
    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }
    public Integer getLogradouro() {
        return this.logradouro;
    }
    
    public void setLogradouro(Integer logradouro) {
        this.logradouro = logradouro;
    }
    public String getNomeLogradouro() {
        return this.nomeLogradouro;
    }
    
    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }
    public Set getFatos() {
        return this.fatos;
    }
    
    public void setFatos(Set fatos) {
        this.fatos = fatos;
    }

*/


}


