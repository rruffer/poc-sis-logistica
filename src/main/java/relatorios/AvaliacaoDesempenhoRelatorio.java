package relatorios;

public class AvaliacaoDesempenhoRelatorio {

	private String fatorDescricao;
	private Integer nota;
	
	public AvaliacaoDesempenhoRelatorio() {

	}

	public AvaliacaoDesempenhoRelatorio(String fatorDescricao, Integer nota) {
		super();
		this.fatorDescricao = fatorDescricao;
		this.nota = nota;
	}

	public String getFatorDescricao() {
		return fatorDescricao;
	}

	public void setFatorDescricao(String fatorDescricao) {
		this.fatorDescricao = fatorDescricao;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return String.format("Fator: %s, Nota: %d", this.fatorDescricao, this.nota);
	}
	
}
