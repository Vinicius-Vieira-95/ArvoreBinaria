package arvoreBinaria2;

public class Arvore {

	private Elemento elemento;
	private Arvore dir;
	private Arvore esq;

	public Arvore(Elemento elemento) {
		this.elemento = elemento;
		this.esq = null;
		this.dir = null;
	}

	public Arvore() {
		this.elemento = null;
		this.esq = null;
		this.dir = null;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public Arvore getDir() {
		return dir;
	}

	public void setDir(Arvore dir) {
		this.dir = dir;
	}

	public Arvore getEsq() {
		return esq;
	}

	public void setEsq(Arvore esq) {
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

	public void inserir(Elemento novo) {
		if (vazio()) {
			this.elemento = novo;
		} else {
			Arvore novaArvore = new Arvore(novo);
			if (novo.getValor() < this.elemento.getValor()) {
				if (this.esq == null) {
					this.esq = novaArvore;
				} else {
					this.esq.inserir(novo);
				}
			} else if (novo.getValor() > this.elemento.getValor()) {
				if (this.dir == null) {
					this.dir = novaArvore;
				} else {
					this.dir.inserir(novo);
				}
			}
		}

	}
	
	public boolean busca(Integer elemento) {
		if(vazio()) {
			return false;
		}
		if(this.elemento.getValor() == elemento) {
			return true;
		}
		else {
			if(elemento < this.elemento.getValor()) {
				if(this.esq == null) {
					return false;
				}
				else {
					return this.esq.busca(elemento);
				}
			}
			else if(elemento > this.elemento.getValor()) {
				if(this.dir == null) {
					return false;
				}
				else {
					return this.dir.busca(elemento);
				}
			}
			return false;
		}
	}

	public Arvore remover(Integer elemento) {
		if (this.elemento.getValor() == elemento) {
			if (this.esq == null && this.dir == null) {
				return null;
			} else {

				if (this.esq != null && this.dir == null) {
					return this.esq;
				} else if (this.dir != null && this.esq == null) {
					return this.dir;
				} else {
					Arvore aux = this.dir;
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
	
	public String toString() {
		return ""+this.elemento+" ";
	}

}
