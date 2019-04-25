public class No {
    private No esquerda;
    private No direita;
    private int dado;

    public No(int dado){
        this.dado = dado;
        this.direita = null;
        this.esquerda = null;
    }

    public void insere_esquerda(No esquerda){
        this.esquerda = esquerda;
    }

    public void insere_direita(No direita){
        this.direita = direita;
    }

    public int retorna_dado(){
        return this.dado;
    }

    public void alt_dado(int dado){

        this.dado = dado;
    }

    public No esquerda(){
        return this.esquerda;
    }

    public No direita(){
        return this.direita;
    }

    public void altesq(No novo){
        this.esquerda = novo;
    }

    public void altdir(No novo){
        this.direita = novo;
    }
}
