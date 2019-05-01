public class Lista {

    private NoLista primeiro;
    private NoLista ultimo;

    public Lista(){

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
        int soma = 0;

        while (p != null){
            System.out.println(p.getDado() + " " + p.getCount());
            soma = soma + p.getCount();
            p = p.getProximo();
        }
        System.out.println("Total de ocorrências: " + soma);
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
}
