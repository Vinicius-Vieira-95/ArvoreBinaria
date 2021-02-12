package arvoreAVL;

public class No {

	private No esquerdo;
	private No direito;

	private Integer balanco;
	private Integer valor;

	public No() {
	}

	public No(Integer valor) {
		this.valor = valor;
	}

	public No(No esquerdo, No direito, Integer valor, int balanco) {
		super();
		this.esquerdo = esquerdo;
		this.direito = direito;
		this.valor = valor;
		this.balanco = balanco;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

	public Integer getBalanco() {
		return balanco;
	}

	public void setBalanco(Integer balanco) {
		this.balanco = balanco;
	}
	
	public int fatorBalanceamento() {
		return getEsquerdo().getBalanco() - getDireito().getBalanco();
	}
	
	@Override
	public String toString() {
		return "No [valor=" + valor +" balanço: "+this.balanco+ "]";
	}

}
