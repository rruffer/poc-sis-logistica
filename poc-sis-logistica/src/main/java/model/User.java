package model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 738209758338926043L;
	private Integer matricula;
	private String senha;

	public User(Integer matricula, String senha) {
		this.matricula = matricula;
		this.senha = senha;
	}

	/**
	 * @return the matricula
	 */
	public Integer getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
