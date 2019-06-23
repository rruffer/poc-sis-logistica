package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Autenticacao.SEARCH_AUT, query="SELECT x FROM Autenticacao x where x.usuario = :usuario and x.senha = :senha")
@NamedQuery(name=Autenticacao.SEARCH_AUT_ESQUEMA, query="SELECT x FROM Autenticacao x where x.esquema = :esquema")
public class Autenticacao implements Serializable {

	private static final long serialVersionUID = 4857789627021900180L;
	public static final String SEARCH_AUT = "search_aut";
	public static final String SEARCH_AUT_ESQUEMA = "search_aut_esquema";
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ESQUEMA")
	private TipoEsquema esquema;

	@Column(name = "USUARIO")
	private String usuario;

	@Column(name = "SENHA")
	private String senha;

	@Column(name = "CHAVE")
	private String chave;

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

	public TipoEsquema getEsquema() {
		return esquema;
	}

	public void setEsquema(TipoEsquema esquema) {
		this.esquema = esquema;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	/**
	 * @return the chave
	 */
	public String getChave() {
		return chave;
	}

	/**
	 * @param chave the chave to set
	 */
	public void setChave(String chave) {
		this.chave = chave;
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
		Autenticacao other = (Autenticacao) obj;
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
