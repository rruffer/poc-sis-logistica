package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

public class SolicitacaoDTO implements Serializable {

	private static final long serialVersionUID = 3690495669934828690L;

	@ApiModelProperty(hidden = true)
	private Long id;

	private ClienteDTO cliente;

	private LocalDateTime dateColeta;

/*	@ManyToOne
	@JoinColumn(name = "ID_ENDERECO_COLETA")
	private Endereco endColeta;*/

	private LocalDateTime dateEntrega;

/*	@ManyToOne
	@JoinColumn(name = "ID_ENDERECO_ENTREGA")
	private Endereco endEntrega;*/

	private LocalDateTime dateCadastro;

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
	 * @return the cliente
	 */
	public ClienteDTO getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the dateColeta
	 */
	public LocalDateTime getDateColeta() {
		return dateColeta;
	}

	/**
	 * @param dateColeta the dateColeta to set
	 */
	public void setDateColeta(LocalDateTime dateColeta) {
		this.dateColeta = dateColeta;
	}

/*	*//**
	 * @return the endColeta
	 *//*
	public Endereco getEndColeta() {
		return endColeta;
	}

	*//**
	 * @param endColeta the endColeta to set
	 *//*
	public void setEndColeta(Endereco endColeta) {
		this.endColeta = endColeta;
	}*/

	/**
	 * @return the dateEntrega
	 */
	public LocalDateTime getDateEntrega() {
		return dateEntrega;
	}

	/**
	 * @param dateEntrega the dateEntrega to set
	 */
	public void setDateEntrega(LocalDateTime dateEntrega) {
		this.dateEntrega = dateEntrega;
	}

/*	*//**
	 * @return the endEntrega
	 *//*
	public Endereco getEndEntrega() {
		return endEntrega;
	}

	*//**
	 * @param endEntrega the endEntrega to set
	 *//*
	public void setEndEntrega(Endereco endEntrega) {
		this.endEntrega = endEntrega;
	}*/

	/**
	 * @return the dateCadastro
	 */
	public LocalDateTime getDateCadastro() {
		return dateCadastro;
	}

	/**
	 * @param dateCadastro the dateCadastro to set
	 */
	public void setDateCadastro(LocalDateTime dateCadastro) {
		this.dateCadastro = dateCadastro;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		SolicitacaoDTO other = (SolicitacaoDTO) obj;
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
