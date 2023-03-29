package arvoreAVL2;

import arvoreAVL.No;

public class ArvoreAVL {

	private Elemento elemento;
	private ArvoreAVL dir;
	private ArvoreAVL esq;
	private Integer balaceamento;

	public ArvoreAVL(Elemento elemento) {
		this.elemento = elemento;
		this.esq = null;
		this.dir = null;
		this.balaceamento = 0;
	}

	public ArvoreAVL() {
		this.elemento = null;
		this.esq = null;
		this.dir = null;
		this.balaceamento = 0;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public ArvoreAVL getDir() {
		return dir;
	}

	public void setDir(ArvoreAVL dir) {
		this.dir = dir;
	}

	public Integer getBalaceamento() {
		return balaceamento;
	}

	public void setBalaceamento(Integer balaceamento) {
		this.balaceamento = balaceamento;
	}

	public ArvoreAVL getEsq() {
		return esq;
	}

	public void setEsq(ArvoreAVL esq) {
		this.esq = esq;
	}

	public boolean vazio() {
		return (this.elemento == null);
	}

	public void preOrdem() {
		if (!vazio()) {
			System.out.print(this.elemento.getValor() + " ");
			if (this.esq != null) {
				this.esq.preOrdem();
			}
			if (this.dir != null) {
				this.dir.preOrdem();
			}
		}
	}

	public void inOrdem() {
		if (!vazio()) {
			if (this.esq != null) {
				this.esq.inOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");
			if (this.dir != null) {
				this.dir.inOrdem();
			}
		}
	}

	public void posOrdem() {
		if (!vazio()) {
			if (this.esq != null) {
				this.esq.inOrdem();
			}
			if (this.dir != null) {
				this.dir.inOrdem();
			}
			System.out.print(this.elemento.getValor() + " ");
		}
	}

	public ArvoreAVL inserir(Elemento novo) {
		if (vazio()) {
			this.elemento = novo;
		} else {
			ArvoreAVL novaArvore = new ArvoreAVL(novo);
			if (novo.getValor() < this.elemento.getValor()) {
				if (this.esq == null) {
					this.esq = novaArvore;
				} else {
					this.esq = this.esq.inserir(novo);
				}
			} else if (novo.getValor() > this.elemento.getValor()) {
				if (this.dir == null) {
					this.dir = novaArvore;
				} else {
					this.dir = this.dir.inserir(novo);
				}
			}
		}
		return this;
	}

	public void calcularBalanceamento() {
		if (this.dir == null && this.esq == null) {
			this.balaceamento = 0;
		} else if (this.dir != null && this.esq == null) {
			this.balaceamento = this.dir.altura();
		} else if (this.dir == null && this.esq != null) {
			this.balaceamento = this.esq.altura();
		} else {
			this.balaceamento = this.dir.altura() - this.esq.altura();
		}
		if (this.dir != null)
			this.dir.calcularBalanceamento();
		if (this.esq != null)
			this.esq.calcularBalanceamento();
	}

	public ArvoreAVL verificarBalanceamento() {
		if (this.balaceamento >= 2 || this.balaceamento <= -2) {
			if (this.balaceamento >= 2) {
				if (this.balaceamento * this.dir.getBalaceamento() > 0) {
					System.out.println("Rotação simple a direita");
					return rotacaoRR();
				} else {
					System.out.println("Rotação dupla a direita");
					return rotacaoRL();
				}
			} else {
				if (this.balaceamento * this.esq.getBalaceamento() > 0) {
					System.out.println("Rotação simples a esquerda");
					return rotacaoLL();
				} else {
					System.out.println("Rotação dupla a esquerda");
					return rotacaoLR();
				}
			}
		}
		this.calcularBalanceamento();
		if (this.esq != null)
			this.esq = this.esq.verificarBalanceamento();
		if (this.dir != null)
			this.dir = this.dir.verificarBalanceamento();
		return this;
	}

	public ArvoreAVL rotacaoRR() {
		ArvoreAVL filhoDir;
		ArvoreAVL filhoDoFilho = null;
		
		filhoDir = this.getDir();
		if(this.dir != null) {
			if(this.dir.getEsq() != null) {
				filhoDoFilho = filhoDir.getEsq();
			}
		}
		filhoDir.setEsq(this);
		this.setDir(filhoDoFilho);
		return filhoDir;
	}

	public ArvoreAVL rotacaoLL() {
		ArvoreAVL filhoEsq;
		ArvoreAVL filhoDoFilho = null;
		
		filhoEsq = this.getEsq();
		if(this.esq != null) {
			if(this.esq.getDir() != null) {
				filhoDoFilho = filhoEsq.getDir();
			}
		}
		filhoEsq.setDir(this);
		this.setEsq(filhoDoFilho);
		return filhoEsq;
	}

	public ArvoreAVL rotacaoRL() {
		ArvoreAVL arvore = this;
		ArvoreAVL filhoDir = this.getDir();
		ArvoreAVL filhoDoFilho = filhoDir.getEsq();
		ArvoreAVL noInserido = filhoDoFilho.getDir();
		
		filhoDir.setEsq(noInserido);
		filhoDoFilho.setDir(filhoDir);
		this.setDir(filhoDoFilho);
		
		ArvoreAVL novo = this.getDir();
		arvore.setDir(null);
		novo.setEsq(arvore);
		
		return novo;
	}

	public ArvoreAVL rotacaoLR() {
		ArvoreAVL arvore = this;
		ArvoreAVL filhoEsq = this.getEsq();
		ArvoreAVL filhoDoFilho = filhoEsq.getDir();
		ArvoreAVL noInserido = filhoDoFilho.getEsq();
		
		filhoEsq.setDir(noInserido);
		filhoDoFilho.setEsq(filhoEsq);
		this.setEsq(filhoDoFilho);
		
		ArvoreAVL novo = this.getEsq();
		arvore.setEsq(null);
		novo.setDir(arvore);
		
		return novo;
	}

	public boolean busca(Integer elemento) {
		if (vazio()) {
			return false;
		}
		if (this.elemento.getValor() == elemento) {
			return true;
		} else {
			if (elemento < this.elemento.getValor()) {
				if (this.esq == null) {
					return false;
				} else {
					return this.esq.busca(elemento);
				}
			} else if (elemento > this.elemento.getValor()) {
				if (this.dir == null) {
					return false;
				} else {
					return this.dir.busca(elemento);
				}
			}
			return false;
		}
	}

	public ArvoreAVL remover(Integer elemento) {
		if (this.elemento.getValor() == elemento) {
			if (this.esq == null && this.dir == null) {
				return null;
			} else {

				if (this.esq != null && this.dir == null) {
					return this.esq;
				} else if (this.dir != null && this.esq == null) {
					return this.dir;
				} else {
					ArvoreAVL aux = this.dir;
					while (aux.esq != null) {
						aux = aux.esq;
					}
					this.setElemento(aux.getElemento());
					aux.getElemento().setValor(elemento);
					this.dir = dir.remover(elemento);
				}
			}
		} else {
			if (elemento < this.elemento.getValor()) {
				if (this.esq != null) {
					this.esq = this.esq.remover(elemento);
				}
			} else if (elemento > this.elemento.getValor()) {
				if (this.dir != null) {
					this.dir = this.dir.remover(elemento);
				}
			}
		}
		return this;
	}

	public int altura() {
		if (this.esq == null && this.dir == null) {
			return 1;
		} else if (this.esq != null && this.dir == null) {
			return 1 + this.esq.altura();
		} else if (this.esq == null && this.dir != null) {
			return 1 + this.dir.altura();
		} else {
			return 1 + Math.max(this.esq.altura(), this.dir.altura());
		}
	}

	public int folhas(No atual) {
		if (atual == null)
			return 0;
		if (atual.getEsquerdo() == null && atual.getDireito() == null)
			return 1;
		return folhas(atual.getEsquerdo()) + folhas(atual.getDireito());
	}

	public String printArvore(Integer nivel) {
		String s = this.toString() + "\n";
		for (int i = 0; i < nivel; i++) {
			s += "\t";
		}
		if (this.esq != null) {
			s += "+-ESQ: " + this.esq.printArvore(nivel + 1);
		} else {
			s += "+-ESQ: NULL";
		}
		s += "\n";

		for (int i = 0; i < nivel; i++) {
			s += "\t";
		}
		if (this.dir != null) {
			s += "+-DIR: " + this.dir.printArvore(nivel + 1);
		} else {
			s += "+-DIR: NULL";
		}
		s += "\n";
		return s;
	}

	public String toString() {
		return "" + this.elemento.getValor() + " - [" + this.balaceamento + "]";
	}

}
