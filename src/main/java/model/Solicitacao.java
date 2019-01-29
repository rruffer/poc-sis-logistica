package model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import enums.StatusSolicitacao;

@NamedQuery(name=Solicitacao.SEARCH_SOL, query="SELECT s FROM Solicitacao s where s.status = :status ")
@Entity
public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 3690495669934828690L;
	public static final String SEARCH_SOL = "search_sol";


	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "ID_MOTORISTA")
	private Motorista motorista;

	@Column
	private LocalDateTime dateColeta;

	@Column(name = "ID_ENDERECO_COLETA")
	private String endColeta;

	@Column
	private LocalDateTime dateEntrega;

	@Column(name = "ID_ENDERECO_ENTREGA")
	private String endEntrega;

	@Column
	private LocalDateTime dateCadastro;
	
	@Enumerated(EnumType.STRING)
	private StatusSolicitacao status;
	
	@Column
	private String natureza;
	
	@Column
	private String especie;
	
	@Column
	private Integer quantidade;
	
	@Column
	private Double peso;
	
	@Lob
	@Column
	private String observacao;
	
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
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
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

	/**
	 * @return the endColeta
	 */
	public String getEndColeta() {
		return endColeta;
	}

	/**
	 * @param endColeta the endColeta to set
	 */
	public void setEndColeta(String endColeta) {
		this.endColeta = endColeta;
	}

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

	/**
	 * @return the endEntrega
	 */
	public String getEndEntrega() {
		return endEntrega;
	}

	/**
	 * @param endEntrega the endEntrega to set
	 */
	public void setEndEntrega(String endEntrega) {
		this.endEntrega = endEntrega;
	}

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
	 * @return the status
	 */
	public StatusSolicitacao getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusSolicitacao status) {
		this.status = status;
	}

	/**
	 * @return the natureza
	 */
	public String getNatureza() {
		return natureza;
	}

	/**
	 * @param natureza the natureza to set
	 */
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	/**
	 * @return the especie
	 */
	public String getEspecie() {
		return especie;
	}

	/**
	 * @param especie the especie to set
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the motorista
	 */
	public Motorista getMotorista() {
		return motorista;
	}

	/**
	 * @param motorista the motorista to set
	 */
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
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
		Solicitacao other = (Solicitacao) obj;
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
