public class Arvore {
    private No root;

    public Arvore(){
        this.root = null;
    }

    public void insere_root(No no){
        this.root = no;
    }

    public No meu_nome_eh_root(){
        return this.root;
    }

    public boolean vazio(){
        if (this.root == null){
            return true;
        }else {
            return false;
        }
    }
}
