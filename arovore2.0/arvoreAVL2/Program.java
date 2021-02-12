package arvoreAVL2;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArvoreAVL a = new ArvoreAVL(new Elemento(sc.nextInt()));
		System.out.println(a.printArvore(0));
		
		while(true) {
			a = a.inserir(new Elemento(sc.nextInt()));
			System.out.println(a.printArvore(0));
		}
		
		
	}

}
