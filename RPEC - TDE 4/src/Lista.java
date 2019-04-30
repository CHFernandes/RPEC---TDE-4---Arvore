public class Lista {

    private NoLista primeiro;
    private NoLista ultimo;
    private int tamanho;

    public Lista(){
        this.tamanho = 0;
    }

    boolean vazia(){
        if (this.primeiro == null && this.ultimo == null){
            return true;
        }else {
            return false;
        }
    }

    void inserir(String info){
        if(vazia()){
            insere_primeiro(info);
        }else {
            insere_ultimo(info);
        }
    }

    void insere_primeiro(String info){
        NoLista novo = new NoLista(info);
        if (vazia()){
            this.primeiro = novo;
            this.ultimo = novo;
        }else {
            novo.alteraproximo(this.primeiro);
            this.primeiro = novo;
        }

    }

    void insere_ultimo(String info){
        NoLista novo = new NoLista(info);
        this.ultimo.alteraproximo(novo);
        this.ultimo = novo;
    }


    public void mostra_lista(){
        NoLista p = this.primeiro;

        while (p != null){
            System.out.println(p.getDado());
            p = p.getProximo();
        }
    }

    public NoLista acha_no(String info){
        NoLista p = this.primeiro;
        while (p != null){
            if(p.getDado().equals(info)){
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retira_primeiro(){
        System.out.println(this.primeiro.getDado());
        this.primeiro = this.primeiro.getProximo();
    }

    public void retira_depois(NoLista no){

        NoLista retirar, atual;
        retirar = no.getProximo();
        atual = this.primeiro;

        while (atual != null){
            if (atual.getProximo() == retirar){
                atual.alteraproximo(retirar.getProximo());
            }
            atual = atual.getProximo();
        }
    }

    public NoLista getprimeiro(){
        return this.primeiro;
    }

    public void nullify(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public void retira_ultimo(){
        NoLista p = this.primeiro;

        while (p.getProximo() != this.ultimo){
            p = p.getProximo();
        }

        System.out.println(this.ultimo.getDado());
        this.ultimo = p;
        p.alteraproximo(null);
    }

    public String retorna_ultimo(){
        return this.ultimo.getDado();
    }

    int size(NoLista p){
        if (p != null){
            return  size(p.getProximo()) + 1;
        }else {
            return  0;
        }
    }

    int soma(int contador, NoLista p){
        if (p != null){
            contador = contador + 1;
            return soma(contador, p.getProximo());
        }
        return contador;
    }

}
