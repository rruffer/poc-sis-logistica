package service;

import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.AutenticacaoDAO;
import dto.TokenDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.Autenticacao;
import model.TipoEsquema;
import util.UtilDate;

@Local
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AutenticacaoService {

	private static final long EXPIRATION_TIME = 864_000_000;

	@Inject
	private AutenticacaoDAO autenticacaoDAO;
	
	public Autenticacao obterAutenticacao(String usuario, String senha) {
		return autenticacaoDAO.obterAutenticacao(usuario, senha);
	}

	public Autenticacao obterAutenticacaoPorEsquema(TipoEsquema esquema) {
		return autenticacaoDAO.obterAutenticacao(esquema);
		
	}

	public TokenDTO obterToken(Autenticacao autenticacao) {
		Date dateExpiration = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
		String token = Jwts.builder().setSubject(autenticacao.getUsuario()).setExpiration(dateExpiration).signWith(SignatureAlgorithm.HS512, autenticacao.getChave()).compact();
		return new TokenDTO(token, UtilDate.converterDateEmLocalDateTime(dateExpiration));
	}

}
