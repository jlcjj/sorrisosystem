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
@Table(name="avaliacao")
public class Avaliacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "avaliacao_id")
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long avaliacao_id;
	
	//@IdentificaCampoPesquisa(descricaoCampo = "Tipo Avaliação", campoConsulta = "tipoAval")
	@Column(nullable = false, length = 30)
	private String tipoAval;

	//@IdentificaCampoPesquisa(descricaoCampo = "Data", campoConsulta = "data_avaliacao")
	@Column(nullable = false, length = 20)	
	private String data_avaliacao;
	
	@Column(nullable = false, length = 20)
	private String horario_agendamento;
	
	
	@Column(nullable = true, length = 20)
	private String status;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Cliente", campoConsulta = "clientes.nome")
	@Basic
	@ManyToOne
	@JoinColumn(name = "clientes", nullable = false)
	@ForeignKey(name = "avaliacao_fk")
	private Clientes clientes = new Clientes();
	
	
	@ManyToOne
	@JoinColumn(name = "entidade", nullable = false)
	@ForeignKey(name = "avaliacao_fk_2")
	private Entidade entidade = new Entidade();
	
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getAvaliacao_id() {
		return avaliacao_id;
	}

	public void setAvaliacao_id(Long avaliacao_id) {
		this.avaliacao_id = avaliacao_id;
	}

	public String getTipoAval() {
		return tipoAval;
	}

	public void setTipoAval(String tipoAval) {
		this.tipoAval = tipoAval;
	}

	public String getData_avaliacao() {
		return data_avaliacao;
	}

	public void setData_avaliacao(String data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}

	public String getHorario_agendamento() {
		return horario_agendamento;
	}

	public void setHorario_agendamento(String horario_agendamento) {
		this.horario_agendamento = horario_agendamento;
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
		result = prime * result + ((avaliacao_id == null) ? 0 : avaliacao_id.hashCode());
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
		Avaliacao other = (Avaliacao) obj;
		if (avaliacao_id == null) {
			if (other.avaliacao_id != null)
				return false;
		} else if (!avaliacao_id.equals(other.avaliacao_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avaliacao [avaliacao_id=" + avaliacao_id + ", tipoAval=" + tipoAval + ", data_avaliacao="
				+ data_avaliacao + ", horario_agendamento=" + horario_agendamento + ", status=" + status + ", clientes="
				+ clientes + ", versionNum=" + versionNum + "]";
	}

	
	
	
}
