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
@Table(name="entidadeacesso")
public class EntidadeAcesso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "ent_acesso_id")
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long ent_acesso_id;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Tipo Acesso", campoConsulta = "esa_codigo")
	@Column(nullable = false, length = 70)
	private String esa_codigo;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Usuario", campoConsulta = "entidade.ent_nome")
	@Basic
	@ManyToOne
	@JoinColumn(name = "ent_codigo", nullable = false)
	@ForeignKey(name = "entidadeacess_ent_fk")
	private Entidade entidade = new Entidade();
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getEnt_acesso_id() {
		return ent_acesso_id;
	}

	public void setEnt_acesso_id(Long ent_acesso_id) {
		this.ent_acesso_id = ent_acesso_id;
	}

	public String getEsa_codigo() {
		return esa_codigo;
	}

	public void setEsa_codigo(String esa_codigo) {
		this.esa_codigo = esa_codigo;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
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
		result = prime * result + ((ent_acesso_id == null) ? 0 : ent_acesso_id.hashCode());
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
		EntidadeAcesso other = (EntidadeAcesso) obj;
		if (ent_acesso_id == null) {
			if (other.ent_acesso_id != null)
				return false;
		} else if (!ent_acesso_id.equals(other.ent_acesso_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntidadeAcesso [ent_acesso_id=" + ent_acesso_id + ", esa_codigo=" + esa_codigo + ", entidade="
				+ entidade + ", versionNum=" + versionNum + "]";
	}
	
	
}
