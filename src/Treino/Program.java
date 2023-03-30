package Treino;

public class Program {
    public static void main(String[] args) {
        ArvoreAB arvoreAB = new ArvoreAB(null, null, null);

        arvoreAB.inserir(10);
        arvoreAB.inserir(5);
        arvoreAB.inserir(15);
        arvoreAB.inserir(6);
        arvoreAB.inserir(4);
        arvoreAB.inserir(12);
        arvoreAB.inserir(18);
        
        
        System.out.println("Arvore Binaria PreOrdem");
        arvoreAB.preOrdem();
        
        System.out.println("\n Arvore Binaria em Ordem");
        arvoreAB.emOrdem();
        
        System.out.println("\n Arvore Binaria PosOrdem");
        arvoreAB.posOrdem();
        
    }
}
