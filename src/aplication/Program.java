package aplication;

import arvoreAVL.ArvoreAVL;

public class Program {

	
	public static void main(String [] arg) {
		
		ArvoreAVL ab = new ArvoreAVL();
		
		ab.inserir(6);
		ab.inserir(4);
		ab.inserir(3);
		ab.inserir(2);
		ab.inserir(1);
		
		System.out.println("Chave encontrada: "+ ab.buscar(2));
		
		System.out.println("Raiz: "+ ab.getNo().toString());
		ab.caminhar();
		
	}
	
}
