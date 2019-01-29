package relatorios;

public class SolicitacaoRel {

	private Long id;
	private String nomeCliente;
	private String dataColeta;
	private String dataEntrega;
	private String status;

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
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the dataColeta
	 */
	public String getDataColeta() {
		return dataColeta;
	}

	/**
	 * @param dataColeta the dataColeta to set
	 */
	public void setDataColeta(String dataColeta) {
		this.dataColeta = dataColeta;
	}

	/**
	 * @return the dataEntrega
	 */
	public String getDataEntrega() {
		return dataEntrega;
	}

	/**
	 * @param dataEntrega the dataEntrega to set
	 */
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
