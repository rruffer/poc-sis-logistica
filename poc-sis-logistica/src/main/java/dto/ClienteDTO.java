package dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import model.Endereco;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 4857789627021900180L;

	private Long id;

	@ApiModelProperty(hidden = true)
	private String razaoSocial;
	
/*	@ApiModelProperty(hidden = true)
	private Endereco endereco;*/
	
	@ApiModelProperty(hidden = true)
	private String telefone;
	
	@ApiModelProperty(hidden = true)
	private String cnpj;
	
	@ApiModelProperty(hidden = true)
	private String inscEstadual;
	
	@ApiModelProperty(hidden = true)
	private String inscMunicipal;
	
	@ApiModelProperty(hidden = true)
	private String email;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

/*	*//**
	 * @return the endereco
	 *//*
	public Endereco getEndereco() {
		return endereco;
	}*/

/*	*//**
	 * @param endereco the endereco to set
	 *//*
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}*/

	/**
	 * @return the tel
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the inscEstadual
	 */
	public String getInscEstadual() {
		return inscEstadual;
	}

	/**
	 * @param inscEstadual the inscEstadual to set
	 */
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	/**
	 * @return the inscMunicipal
	 */
	public String getInscMunicipal() {
		return inscMunicipal;
	}

	/**
	 * @param inscMunicipal the inscMunicipal to set
	 */
	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ClienteDTO other = (ClienteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}