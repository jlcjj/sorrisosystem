package br.com.project.model.classes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name="procedimentos")
public class Procedimentos implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long procedimento_id;

	@IdentificaCampoPesquisa(descricaoCampo = "Cod. Interno", campoConsulta = "codigo_interno")
	@Column(nullable = true, length = 15)
	private String codigo_interno;

	@IdentificaCampoPesquisa(descricaoCampo = "Descrição", campoConsulta = "descricao")
	@Column(nullable = false, length = 100)
	private String descricao;
	
	

	@Column(nullable = false, length = 20)
	private String  valor_procedimento;
		
	@OneToMany
	private List<Agendamentos> agendamentos;
	
	public Long getProcedimento_id() {
		return procedimento_id;
	}

	public void setProcedimento_id(Long procedimento_id) {
		this.procedimento_id = procedimento_id;
	}

	public String getCodigo_interno() {
		return codigo_interno;
	}

	public void setCodigo_interno(String codigo_interno) {
		this.codigo_interno = codigo_interno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getValor_procedimento() {
		return valor_procedimento;
	}

	public void setValor_procedimento(String valor_procedimento) {
		this.valor_procedimento = valor_procedimento;
	}

	
	
	public List<Agendamentos> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamentos> agendamentos) {
		this.agendamentos = agendamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((procedimento_id == null) ? 0 : procedimento_id.hashCode());
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
		Procedimentos other = (Procedimentos) obj;
		if (procedimento_id == null) {
			if (other.procedimento_id != null)
				return false;
		} else if (!procedimento_id.equals(other.procedimento_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Procedimentos [procedimento_id=" + procedimento_id + ", codigo_interno=" + codigo_interno
				+ ", descricao=" + descricao + "]";
	}

	
	

}
