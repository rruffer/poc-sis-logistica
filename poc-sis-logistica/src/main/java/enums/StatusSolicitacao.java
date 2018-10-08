package enums;

public enum StatusSolicitacao {
	
	PENDENTE("Pendente"), 
	RECEBIDO("Coletado");
	
	private String descricao;
	
	private StatusSolicitacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
