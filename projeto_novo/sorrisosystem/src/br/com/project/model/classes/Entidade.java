package br.com.project.model.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Audited
@javax.persistence.Entity
@Table(name="entidade")
public class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long ent_codigo;

	private String ent_login = null;

	private String ent_senha;

	private String ent_nome;
	
	private int ent_inativo = 0;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date ent_ultimoacesso;
	
	@OneToMany
	private List<EntidadeAcesso> entidadeAcesso;
	
	
	
	public List<EntidadeAcesso> getEntidadeAcesso() {
		return entidadeAcesso;
	}

	public void setEntidadeAcesso(List<EntidadeAcesso> entidadeAcesso) {
		this.entidadeAcesso = entidadeAcesso;
	}

	public Date getEnt_ultimoacesso() {
		return ent_ultimoacesso;
	}

	public void setEnt_ultimoacesso(Date ent_ultimoacesso) {
		this.ent_ultimoacesso = ent_ultimoacesso;
	}

	
	public int getEnt_inativo() {
		return ent_inativo;
	}

	public void setEnt_inativo(int ent_inativo) {
		this.ent_inativo = ent_inativo;
	}

	public void setEnt_login(String ent_login) {
		this.ent_login = ent_login;
	}

	public String getEnt_login() {
		return ent_login;
	}

	public void setEnt_senha(String ent_senha) {
		this.ent_senha = ent_senha;
	}

	public String getEnt_senha() {
		return ent_senha;
	}
	
	public void setEnt_codigo(Long ent_codigo) {
		this.ent_codigo = ent_codigo;
	}
	
	public Long getEnt_codigo() {
		return ent_codigo;
	}

	public String getEnt_nome() {
		return ent_nome;
	}

	public void setEnt_nome(String ent_nome) {
		this.ent_nome = ent_nome;
	}

}
