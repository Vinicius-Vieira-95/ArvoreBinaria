package arvoreAVL;

public class ArvoreAVL{

	private No node;

	public ArvoreAVL() {
		node = null;
	}

	public ArvoreAVL(int valor) {
		node.setValor(valor);
	}

	public No getNo() {
		return node;
	}

	public Integer noRaiz() {
		return node.getValor();
	}

	public void inserir(Integer valor) {
		No novo = new No(); // cria um novo Nó
		novo.setValor(valor); // atribui o valor recebido ao item de dados do Nó
		novo.setDireito(null);
		novo.setEsquerdo(null);
		novo.setBalanco(0);

		if (node == null) { // se Raiz é igual a null
			node = novo;
		} else { // se nao for a raiz
			No atual = node;
			No anterior;
			while (true) {
				anterior = atual;
				if (valor <= atual.getValor()) { // ir para esquerda
					atual = atual.getEsquerdo();
					if (atual == null) {
						anterior.setEsquerdo(novo);
						return;
					}
				} // fim da condição ir a esquerda
				else { // ir para direita
					atual = atual.getDireito();
					if (atual == null) {
						anterior.setDireito(novo);
						return;
					}
				} // fim da condição ir a direita
			} // fim do laço while
		} // fim do else não raiz

	}

	public No buscar(Integer chave) {
		if (node == null)
			return null; // se arvore vazia
		No atual = node; // começa a procurar desde raiz
		while (atual.getValor() != chave) { // enquanto nao encontrou
			if (chave < atual.getValor())
				atual = atual.getEsquerdo(); // caminha para esquerda
			else
				atual = atual.getDireito(); // caminha para direita
			if (atual == null)
				return null; // encontrou uma folha -> sai
		} // fim laço while
		return atual; // terminou o laço while e chegou aqui é pq encontrou item
	}

	public No removeValorMinimoDaArvore(No node) {
		if (node == null) {
			System.out.println(" ERROR! ");
		} else if (node.getEsquerdo() != null) {
			node.setEsquerdo(removeValorMinimoDaArvore(node.getEsquerdo()));
			return node;
		} else {
			// Se não tiver elemento esquerdo só nos resta o da direita
			return node.getDireito();
		}
		return null;
	}
	
	public void fatorBalanceamento(No no) {
		if(no.getDireito() == null && no.getEsquerdo()== null) {
			no.setBalanco(0);
		}
		else if(no.getEsquerdo() == null && no.getDireito() != null) {
			no.setBalanco(altura(no.getDireito()) - 0);
		}
		else if(no.getEsquerdo() != null && no.getDireito() == null) {
			no.setBalanco(0 - altura(no.getEsquerdo()));
		}
		else {
			no.setBalanco(altura(no.getEsquerdo()) - altura(no.getDireito()));
		}
	}
	
	public int maior(int x, int y) {
		int valor = (x > y) ? x : y; //expressão condicional ternaria
		return valor;
	}
	
	public void RotacaoLL(No no) {
		No novoNo = new No();
		novoNo = node.getEsquerdo();
		node.setEsquerdo(novoNo.getDireito());
		novoNo.setDireito(node);
		
		//problema na altura
		/*
		no.setBalanco(maior(no.getEsquerdo().getBalanco(), no.getDireito().getBalanco() + 1));
		novoNo.setBalanco(maior(novoNo.getEsquerdo().getBalanco(), no.getBalanco() + 1));
		no = novoNo;
		*/
	}
	
	public void RotacaoRR(No no) {
		No novoNo = new No();
		novoNo = no.getDireito();
		no.setDireito(novoNo.getEsquerdo());
		novoNo.setEsquerdo(no);
		
		/*
		//problema na altura
		no.setBalanco(maior(no.getEsquerdo().getBalanco(), no.getDireito().getBalanco() + 1));
		novoNo.setBalanco(maior(novoNo.getDireito().getBalanco(), no.getBalanco()+ 1));
		no = novoNo;
		*/
	}
	
	public void RotacaoLR(No no) {
		RotacaoLL(no);
		RotacaoRR(no);
	}
	
	public void RotacaoRL(No no) {
		RotacaoRR(no);
		RotacaoLL(no);
	}
	

	public boolean remover_ArvoreBinaria(Integer valor) {
		if (node == null) {// caso node for null retorna falso
			return false;
		}
		No atual = node;
		No ant = null;
		while (atual != null) {// enquato atual diferente de null
			if (valor == atual.getValor()) { // se valor for igual a valor de atual

				if (atual == node) {
					node = removerElemento(atual);
				} else {
					if (ant.getDireito() == atual) {
						ant.setDireito(removerElemento(atual)); //anterior-direito recebe valor do endereço do novo no
					} else {
						ant.setEsquerdo(removerElemento(atual)); //anterior-esquerdo recebe valor do endereço do novo no
					}
				}
				return true; //retorna verdadeiro se valor for removido
			}
			ant = atual;
			if (valor > atual.getValor()) {
				atual = atual.getDireito();
			} else {
				atual = atual.getEsquerdo();
			}
		}

		return false; //falso para valores não encontrado
	}

	private No removerElemento(No no) {
		No no1 = null;
		No no2 = null;

		if (no.getEsquerdo() == null) {
			no2 = no.getDireito();
			return no2;
		}
		no1 = no;
		no2 = no.getEsquerdo();
		while (no2.getDireito() != null) {
			no1 = no2;
			no2 = no2.getDireito();
		}
		if (no1 != no) {
			no1.setDireito(no2.getEsquerdo());
			no2.setEsquerdo(no.getEsquerdo());
		}
		no2.setDireito(no.getDireito());
		return no2;
	}

	public void caminhar() {
		System.out.print("\n Exibindo em ordem: ");
		inOrder(node);
		System.out.print("\n Exibindo em pos-ordem: ");
		posOrder(node);
		System.out.print("\n Exibindo em pre-ordem: ");
		preOrder(node);
		System.out.print("\n Altura da arvore: " + altura(node));
		System.out.print("\n Quantidade de folhas: " + folhas(node));
		System.out.print("\n Quantidade de Nós: " + contarNos(node));
		if (node != null) { // se arvore nao esta vazia
			System.out.print("\n Valor minimo: " + min().getValor());
			System.out.println("\n Valor maximo: " + max().getValor());
		}
	}

	public void inOrder(No atual) {
		if (atual != null) {
			inOrder(atual.getEsquerdo());
			System.out.print(atual.getValor() + " ");
			inOrder(atual.getDireito());
		}
	}

	public void preOrder(No atual) {
		if (atual != null) {
			System.out.print(atual.getValor() + " ");
			preOrder(atual.getEsquerdo());
			preOrder(atual.getDireito());
		}
	}

	public void posOrder(No atual) {
		if (atual != null) {
			posOrder(atual.getEsquerdo());
			posOrder(atual.getDireito());
			System.out.print(atual.getValor() + " ");
		}
	}

	public int altura(No atual) {
		if (atual == null || (atual.getEsquerdo() == null && atual.getDireito() == null))
			return 0;
		else {
			if (altura(atual.getEsquerdo()) > altura(atual.getDireito()))
				return (1 + altura(atual.getEsquerdo()));
			else
				return (1 + altura(atual.getDireito()));
		}
	}

	public int folhas(No atual) {
		if (atual == null)
			return 0;
		if (atual.getEsquerdo() == null && atual.getDireito() == null)
			return 1;
		return folhas(atual.getEsquerdo()) + folhas(atual.getDireito());
	}

	public int contarNos(No atual) {
		if (atual == null)
			return 0;
		else
			return (1 + contarNos(atual.getEsquerdo()) + contarNos(atual.getDireito()));
	}

	public No min() {
		No atual = node;
		No anterior = null;
		while (atual != null) {
			anterior = atual;
			atual = atual.getEsquerdo();
		}
		return anterior;
	}

	public No max() {
		No atual = node;
		No anterior = null;
		while (atual != null) {
			anterior = atual;
			atual = atual.getDireito();
		}
		return anterior;
	}

}



