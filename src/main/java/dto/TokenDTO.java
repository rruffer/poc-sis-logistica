package dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TokenDTO {

	private String token;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataExpiracao;

	public TokenDTO() {

	}
	
	
	/**
	 * @param token
	 * @param dataExpiracao
	 */
	public TokenDTO(String token, LocalDateTime dataExpiracao) {
		super();
		this.token = token;
		this.dataExpiracao = dataExpiracao;
	}


	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the dataExpiracao
	 */
	public LocalDateTime getDataExpiracao() {
		return dataExpiracao;
	}

	/**
	 * @param dataExpiracao the dataExpiracao to set
	 */
	public void setDataExpiracao(LocalDateTime dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	@Override
	public String toString() {
		return String.format("Token: %s, Expira em: %s", this.token, this.dataExpiracao);
	}

}
