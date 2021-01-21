package aplication;

import arvoreBinaria.ArvoreBinaria;

public class Program {

	
	public static void main(String [] arg) {
		
		ArvoreBinaria ab = new ArvoreBinaria();
		
		ab.inserir(40);
		ab.inserir(35);
		ab.inserir(20);
		ab.inserir(50);
		ab.inserir(55);
		ab.inserir(49);
		ab.inserir(48);
		
		System.out.println("Chave encontrada"+ ab.buscar(35));
		
		System.out.println(ab.getNo().toString());
		
		System.out.println("Chave encontrada"+ ab.buscar(20));
		
		ab.caminhar();
		System.out.println("//////////////////////////////////////////////////");
		
		ab.remover_ArvoreBinaria(50);
		ab.remover_ArvoreBinaria(20);
		ab.caminhar();
		
		
	}
	
}
