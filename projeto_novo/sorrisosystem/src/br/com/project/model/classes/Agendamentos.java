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
@Table(name="agendamentos")
public class Agendamentos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "agendamento_id")
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long agendamento_id;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Medico Resp.", campoConsulta = "nomeMedico")
	@Column(nullable = false, length = 30)
	private String nomeMedico;

	@IdentificaCampoPesquisa(descricaoCampo = "Data", campoConsulta = "data")
	@Column(nullable = false, length = 20)	
	private String data_agendamento;
	
	@Column(nullable = false, length = 20)
	private String horario_agendamento;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Procedimentos", campoConsulta = "procedimentos.descricao")
	@Basic
	@ManyToOne
	@JoinColumn(name = "procedimentos", nullable = false)
	@ForeignKey(name = "agendamento_proc_fk")
	private Procedimentos procedimentos = new Procedimentos();
	
	
	@Column(nullable = false, length = 80)
	private String nome_realizado;
	
	@Column(nullable = false, length = 20)
	private String data_realizado;
		
	@Column(nullable = false, length = 20)
	private String horario_realizado;
			
	
	@Column(nullable = false, length = 20)
	private String status;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Cliente", campoConsulta = "clientes.nome")
	@Basic
	@ManyToOne
	@JoinColumn(name = "clientes", nullable = false)
	@ForeignKey(name = "agendamento_est_fk")
	private Clientes clientes = new Clientes();
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getAgendamento_id() {
		return agendamento_id;
	}

	public void setAgendamento_id(Long agendamento_id) {
		this.agendamento_id = agendamento_id;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}



	public String getData_agendamento() {
		return data_agendamento;
	}

	public void setData_agendamento(String data_agendamento) {
		this.data_agendamento = data_agendamento;
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

	public int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	public Procedimentos getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Procedimentos procedimentos) {
		this.procedimentos = procedimentos;
	}

	public String getNome_realizado() {
		return nome_realizado;
	}

	public void setNome_realizado(String nome_realizado) {
		this.nome_realizado = nome_realizado;
	}

	public String getData_realizado() {
		return data_realizado;
	}

	public void setData_realizado(String data_realizado) {
		this.data_realizado = data_realizado;
	}

	public String getHorario_realizado() {
		return horario_realizado;
	}

	public void setHorario_realizado(String horario_realizado) {
		this.horario_realizado = horario_realizado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendamento_id == null) ? 0 : agendamento_id.hashCode());
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
		Agendamentos other = (Agendamentos) obj;
		if (agendamento_id == null) {
			if (other.agendamento_id != null)
				return false;
		} else if (!agendamento_id.equals(other.agendamento_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendamentos [agendamento_id=" + agendamento_id + ", nomeMedico=" + nomeMedico + ", data_agendamento="
				+ data_agendamento + ", horario_agendamento=" + horario_agendamento + ", procedimentos=" + procedimentos
				+ ", nome_realizado=" + nome_realizado + ", data_realizado=" + data_realizado + ", horario_realizado="
				+ horario_realizado + ", status=" + status + ", clientes=" + clientes + "]";
	}

	

	
	
}
