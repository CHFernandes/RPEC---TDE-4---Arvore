class No {
    private No esquerda;
    private No direita;
    private String dado;
    private Lista lista;

    No(String dado, String endereco){
        this.dado = dado;
        this.direita = null;
        this.esquerda = null;
        this.lista = new Lista();
        lista.inserir(endereco);
    }

    void insere_esquerda(No esquerda){
        this.esquerda = esquerda;
    }

    void insere_direita(No direita){
        this.direita = direita;
    }

    String retorna_dado(){
        return this.dado;
    }

    Lista retorna_lista(){
        return this.lista;
    }

    void retorna_endereco(){
        this.lista.mostra_lista();
    }

    void alt_dado(String dado){

        this.dado = dado;
    }

    No esquerda(){
        return this.esquerda;
    }

    No direita(){
        return this.direita;
    }

    void altesq(No novo){
        this.esquerda = novo;
    }

    void altdir(No novo){
        this.direita = novo;
    }
}
