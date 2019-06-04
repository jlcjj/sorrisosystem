package br.com.project.model.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cliente_id;

	@IdentificaCampoPesquisa(descricaoCampo = "Prontuario", campoConsulta = "prontuario")
	@Column(nullable = true, length = 20)
	private String prontuario;

	@IdentificaCampoPesquisa(descricaoCampo = "Nome", campoConsulta = "nome")
	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = true, length = 15)
	private String rg;
	
	@IdentificaCampoPesquisa(descricaoCampo = "CPF", campoConsulta = "cpf")
	@Column(nullable = false, length = 20)
	private String cpf;

	@Column(nullable = false, length = 100)
	private String endereco;

	@Column(nullable = true, length = 8)
	private String numero;

	@Column(nullable = true, length = 80)
	private String complemento;

	@Column(nullable = true, length = 80)
	private String bairro;

	@Column(nullable = true, length = 10)
	private String cep;

	@Column(nullable = true, length = 80)
	private String cidade;

	@Column(nullable = true, length = 15)
	private String UF;

	@Column(nullable = true, length = 20)
	private String tel_fixo;

	@Column(nullable = true, length = 20)
	private String tel_celular;

	@Column(nullable = true, length = 80)
	private String nome_Convenio;

	@Column(nullable = true, length = 80)
	private String plano;

	@Column(nullable = true, length = 80)
	private String num_cart_convenio;

	@Column(nullable = true, length = 80)
	private String data_validade_plano;

	@Column(nullable = true, length = 15)
	private String data_nascimento;

	@Column(nullable = true, length = 80)
	private String nome_sindicato;

	@Column(nullable = true, length = 80)
	private String num_cart_sindicato;

	@Column(nullable = true, length = 200)
	private String observacao;

	@Column(nullable = true, length = 20)
	private String status;

	@Column(nullable = true, length = 15)
	private String Data_hora_cad;

	@Column(nullable = true, length = 20)
	private String usuario_cad;

	@Column(nullable = true, length = 20)
	private String Data_hora_alt;

	@Column(nullable = true, length = 20)
	private String usuario_alt;

	@Column(nullable = true, length = 20)
	private String titular;

	@Column(nullable = true, length = 80)
	 private String nome_titular;
	

	@Version
	@Column(name = "versionNum")
	private int versionNum;

	@OneToMany
	private List<Agendamentos> agendamentos;
	


	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	

	public String getNome_titular() {
		return nome_titular;
	}

	public void setNome_titular(String nome_titular) {
		this.nome_titular = nome_titular;
	}

	public Long getCliente_id() {
		return cliente_id;
	}


	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getTel_fixo() {
		return tel_fixo;
	}

	public void setTel_fixo(String tel_fixo) {
		this.tel_fixo = tel_fixo;
	}

	public String getTel_celular() {
		return tel_celular;
	}

	public void setTel_celular(String tel_celular) {
		this.tel_celular = tel_celular;
	}

	public String getNome_Convenio() {
		return nome_Convenio;
	}

	public void setNome_Convenio(String nome_Convenio) {
		this.nome_Convenio = nome_Convenio;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getNum_cart_convenio() {
		return num_cart_convenio;
	}

	public void setNum_cart_convenio(String num_cart_convenio) {
		this.num_cart_convenio = num_cart_convenio;
	}

	public String getData_validade_plano() {
		return data_validade_plano;
	}

	public void setData_validade_plano(String data_validade_plano) {
		this.data_validade_plano = data_validade_plano;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getNome_sindicato() {
		return nome_sindicato;
	}

	public void setNome_sindicato(String nome_sindicato) {
		this.nome_sindicato = nome_sindicato;
	}

	public String getNum_cart_sindicato() {
		return num_cart_sindicato;
	}

	public void setNum_cart_sindicato(String num_cart_sindicato) {
		this.num_cart_sindicato = num_cart_sindicato;
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

	public String getData_hora_cad() {
		return Data_hora_cad;
	}

	public void setData_hora_cad(String data_hora_cad) {
		Data_hora_cad = data_hora_cad;
	}

	public String getUsuario_cad() {
		return usuario_cad;
	}

	public void setUsuario_cad(String usuario_cad) {
		this.usuario_cad = usuario_cad;
	}

	public String getData_hora_alt() {
		return Data_hora_alt;
	}

	public void setData_hora_alt(String data_hora_alt) {
		Data_hora_alt = data_hora_alt;
	}

	public String getUsuario_alt() {
		return usuario_alt;
	}

	public void setUsuario_alt(String usuario_alt) {
		this.usuario_alt = usuario_alt;
	}

	public int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
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
		result = prime * result + ((cliente_id == null) ? 0 : cliente_id.hashCode());
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
		Clientes other = (Clientes) obj;
		if (cliente_id == null) {
			if (other.cliente_id != null)
				return false;
		} else if (!cliente_id.equals(other.cliente_id))
			return false;
		return true;
	}

}