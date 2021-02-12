package arvoreBinaria2;

public class Program {

	public static void main(String[] args) {
		
		Arvore a = new Arvore();
		a.inserir(new Elemento(10));
		a.inserir(new Elemento(5));
		a.inserir(new Elemento(15));
		a.inserir(new Elemento(3));
		a.inserir(new Elemento(8));
		a.inserir(new Elemento(12));
		a.inserir(new Elemento(17));
		
		a.inOrdem();
		System.out.println("");
		
		a.remover(8);
		a.inOrdem();
		

	}

}
