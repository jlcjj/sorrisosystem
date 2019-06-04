package br.com.project.model.classes;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name="odontograma")
public class Odontograma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "odontograma_id")
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long odontograma_id;
	
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "atendimento", nullable = false)
	@ForeignKey(name = "odonto_avaliacao_fk")
	private Atendimento atendimento = new Atendimento();
	
	
	private String dente;
	
	private String descricao_dente;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Procedimentos", campoConsulta = "procedimentos.codigo_interno")
	@Basic
	@ManyToOne
	@JoinColumn(name = "procedimentos", nullable = false)
	@ForeignKey(name = "proc_odonto_fk")
	private Procedimentos procedimentos = new Procedimentos();
	
		
	private String situacao;

	@Version
	@Column(name = "versionNum")
	private int versionNum;
	
	public Long getOdontograma_id() {
		return odontograma_id;
	}

	public void setOdontograma_id(Long odontograma_id) {
		this.odontograma_id = odontograma_id;
	}

	
	
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public String getDente() {
		return dente;
	}

	public void setDente(String dente) {
		this.dente = dente;
	}

	public String getDescricao_dente() {
		return descricao_dente;
	}

	public void setDescricao_dente(String descricao_dente) {
		this.descricao_dente = descricao_dente;
	}

	public Procedimentos getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Procedimentos procedimentos) {
		this.procedimentos = procedimentos;
	}

	

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((odontograma_id == null) ? 0 : odontograma_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Odontograma other = (Odontograma) obj;
		if (odontograma_id == null) {
			if (other.odontograma_id != null)
				return false;
		} else if (!odontograma_id.equals(other.odontograma_id))
			return false;
		return true;
	}
	
	
	
}
