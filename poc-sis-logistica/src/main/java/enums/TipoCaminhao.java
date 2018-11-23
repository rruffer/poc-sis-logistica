package enums;

public enum TipoCaminhao {
	
	PENDENTE("Pendente"), 
	RECEBIDO("Coletado");
	
	private String descricao;
	
	private TipoCaminhao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
