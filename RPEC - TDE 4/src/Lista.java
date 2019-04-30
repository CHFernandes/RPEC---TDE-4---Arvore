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

    void insere_primeiro(int info){
        NoLista novo = new NoLista(info);
        if (vazia()){
            this.primeiro = novo;
            this.ultimo = novo;
        }else {
            novo.alteraproximo(this.primeiro);
            this.primeiro = novo;
        }

    }

    void insere_depois(NoLista no, int info){
        NoLista novo = new NoLista(info);
        novo.alteraproximo(no.getProximo());
        no.alteraproximo(novo);
    }

    void insere_ultimo(int info){
        NoLista novo = new NoLista(info);
        this.ultimo.alteraproximo(novo);
        this.ultimo = novo;
    }

    public void insere_ordenado(int info){
        if (vazia()){
            insere_primeiro(info);
        }else {
            if(this.primeiro.getDado() >= info){
                insere_primeiro(info);
            }else {
                if (info >= this.ultimo.getDado()){
                    insere_ultimo(info);
                }else {
                    NoLista p = this.primeiro;
                    while (p.getProximo().getDado() < info){
                        p = p.getProximo();
                    }
                    insere_depois(p,info);
                }
            }
        }
    }

    public void mostra_lista(){
        NoLista p = this.primeiro;

        while (p != null){
            System.out.println(p.getDado());
            p = p.getProximo();
        }
    }

    public NoLista acha_no(int info){
        NoLista p = this.primeiro;
        while (p != null){
            if(p.getDado() == info){
                return p;
            }
            p = p.getProximo();
        }
        return new NoLista(-1);
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

    public int retorna_ultimo(){
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
