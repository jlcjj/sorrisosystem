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
@Table(name="odontogramaCliente")
public class OdontogramaCliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "odontogramacliente_id")
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long odontogramacliente_id;
	
	
	@Column(nullable = true, length = 500)
	private String observacao;
	@IdentificaCampoPesquisa(descricaoCampo = "Cliente", campoConsulta = "clientes.nome")
	@Basic
	@ManyToOne
	@JoinColumn(name = "clientes", nullable = false)
	@ForeignKey(name = "agendamento_est_fk")
	private Clientes clientes = new Clientes();
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getOdontogramacliente_id() {
		return odontogramacliente_id;
	}

	public void setOdontogramacliente_id(Long odontogramacliente_id) {
		this.odontogramacliente_id = odontogramacliente_id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
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
		OdontogramaCliente other = (OdontogramaCliente) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OdontogramaCliente [odontogramacliente_id=" + odontogramacliente_id + ", observacao=" + observacao
				+ ", clientes=" + clientes + "]";
	}

	
}
