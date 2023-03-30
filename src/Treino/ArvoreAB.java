package Treino;

public class ArvoreAB {

    private ArvoreAB filho_esquerdo;
    private ArvoreAB filho_direito;
    private Elemento elemento;

    public ArvoreAB(ArvoreAB filho_esquerdo, ArvoreAB filho_direito, Elemento elemento) {
        this.filho_esquerdo = filho_esquerdo;
        this.filho_direito = filho_direito;
        this.elemento = elemento;
    }

    public ArvoreAB getFilho_esquerdo() {
        return filho_esquerdo;
    }

    public void setFilho_esquerdo(ArvoreAB filho_esquerdo) {
        this.filho_esquerdo = filho_esquerdo;
    }

    public ArvoreAB getFilho_direito() {
        return filho_direito;
    }

    public void setFilho_direito(ArvoreAB filho_direito) {
        this.filho_direito = filho_direito;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public void inserir(Integer valor) {
        if (this.elemento == null) {
            this.elemento = new Elemento(valor);
        } else if (valor < this.elemento.getValor()) {
            if (filho_esquerdo == null) {
                filho_esquerdo = new ArvoreAB(null, null, new Elemento(valor));
            } else {
                filho_esquerdo.inserir(valor);
            }
           
        } else if (valor > this.elemento.getValor()) {
            if (filho_direito == null) {
                filho_direito = new ArvoreAB(null, null, new Elemento(valor));
            }
            else {
                filho_direito.inserir(valor);
            }
        }
    }
    
    public void  preOrdem() {
    	System.out.println(this.elemento.getValor());
    	if(filho_esquerdo != null)
    		filho_esquerdo.preOrdem();
    	if(filho_direito != null)
    		filho_direito.preOrdem();
    }
    
    public void emOrdem() {
    	if(filho_esquerdo != null)
    		filho_esquerdo.emOrdem();
    	System.out.println(this.elemento.getValor());
    	if(filho_direito != null)
    		filho_direito.emOrdem();
    }
    
    public void posOrdem() {
    	if(filho_esquerdo != null)
    		filho_esquerdo.posOrdem();
    	if(filho_direito != null)
    		filho_direito.posOrdem();
    	System.out.println(this.elemento.getValor());
    }

}
