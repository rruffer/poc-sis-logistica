package dto;

import java.time.LocalDateTime;

import enums.StatusSolicitacao;
import io.swagger.annotations.ApiModelProperty;

public class SolicitacaoDTO {

	@ApiModelProperty(hidden = true)
	private Long id;

	@ApiModelProperty(required=true, allowEmptyValue=false)
	private ClienteDTO cliente;

	@ApiModelProperty(required=true)
	private LocalDateTime dateColeta;

	@ApiModelProperty(required=true)
	private String endColeta;

	@ApiModelProperty(required=false)
	private LocalDateTime dateEntrega;

	@ApiModelProperty(required=true)
	private String endEntrega;

	@ApiModelProperty(hidden = true)
	private LocalDateTime dateCadastro;
	
	@ApiModelProperty(hidden = true)
	private StatusSolicitacao status;
	
	@ApiModelProperty(required=true)
	private String natureza;
	
	@ApiModelProperty(required=true)
	private String especie;
	
	@ApiModelProperty(required=true)
	private Integer quantidade;
	
	@ApiModelProperty(required=true)
	private Double peso;

	@ApiModelProperty(required=false)
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
