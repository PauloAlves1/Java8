package validacao;

public enum TipoDeEntrada {
	
	NOMECOMPLETO("nome_completo", new ValidadorString()),
	NOMECOMPLETOMAE("nome_completo_mae", new ValidadorNomeMae());
	
	private String descricao;
	private ValidadorSistemaProduto validador;

	TipoDeEntrada(String descricao, ValidadorSistemaProduto validador) {
		this.descricao = descricao;
		this.validador = validador;
	}
	
	
	
	public String getDescricao() {
		return descricao;
	}



	public static TipoDeEntrada toEnum(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			return null;
		}

		for (TipoDeEntrada tipo : TipoDeEntrada.values()) {
			if (descricao.equals(tipo.getDescricao())) {
				return tipo;
			}
		}

		throw new EnumInvalidoException("Entrada inv�lida: " + descricao);
	}

	/**
	 * Valida o campo 
	 */
	public Object valida(Object entrada) {
		if (this.validador == null) {
			return null;
		}
		return this.validador.validar(entrada);
	}
}
