package br.com.ofinamedeiros.enumeradores;

public enum StatusServicos {

	SERVICO_EM_ORCAMENTO("SERVI�O_EM_OR�AMENTO", "SERVI�O EM OR�AMENTO"),
	ORcAMENTO_AGUARDANDO_APROVADO("OR�AMENTO_AGUARDANDO_APROVA��O", "OR�AMENTO AGUARDANDO APROVA��O"),
	ORCAMENTO_ACEITO_PELO_CLIENTE("OR�AMENTO_ACEITO_PELO_CLIENTE", "OR�AMENTO ACEITO PELO CLIENTE"),
	SERVICO_EM_ANDAMENTO("SERVICO_EM_ANDAMENTO", "SERVI�O EM ANDAMENTO"),
	SERVICO_CONCLUIDO("OR�AMENTO_ACEITO_PELO_CLIENTE", "SERVI�O CONCLUIDO"),
	SERVICO_CANCELADO("OR�AMENTO_ACEITO_PELO_CLIENTE", "SERVI�O CANCELADO");

	public String getDescricao() {
		return descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public static String[] getDescricaoComboBox() {
		String[] listaRetorno = new String[6];
		int i = 0;
		for (StatusServicos s : StatusServicos.values()) {
			listaRetorno[i] = s.getDescricao();
			i++;
		}
		return listaRetorno;
	}

	public static String getCodigoByDescricao(String descricao) {
		return null;
	}

	public static String getDescricaoBycodigo(String codigo) {
		return null;
	}

	private StatusServicos(String codigo, String descricao) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

	private String codigo;
	private String descricao;

}
