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
@Table(name="atendimento")
public class Atendimento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "atendimento_id")
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long atendimento_id;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Cliente", campoConsulta = "clientes.nome")
	@Basic
	@ManyToOne
	@JoinColumn(name = "clientes", nullable = false)
	@ForeignKey(name = "agendamento_est_fk")
	private Clientes clientes = new Clientes();
	
	
		
	@Column(nullable = false, length = 800)
	private String observacao;
			
	
	@Column(nullable = false, length = 20)
	private String status;
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;



	public Long getAtendimento_id() {
		return atendimento_id;
	}

	public void setAtendimento_id(Long atendimento_id) {
		this.atendimento_id = atendimento_id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
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
		result = prime * result + ((atendimento_id == null) ? 0 : atendimento_id.hashCode());
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
		Atendimento other = (Atendimento) obj;
		if (atendimento_id == null) {
			if (other.atendimento_id != null)
				return false;
		} else if (!atendimento_id.equals(other.atendimento_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atendimento [atendimento_id=" + atendimento_id + ", clientes=" + clientes + ", observacao=" + observacao
				+ ", status=" + status + ", versionNum=" + versionNum + "]";
	}

	

	
	
}
