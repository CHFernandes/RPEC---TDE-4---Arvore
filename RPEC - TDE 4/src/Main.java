public class Main {
    public static void main(String[] args) {

        Arvore a = new Arvore();

        insere_elemento(a, 5);
        insere_elemento(a, 12);
        insere_elemento(a, 7);
        insere_elemento(a, 9);
        insere_elemento(a, 22);
        insere_elemento(a, 3);
        insere_elemento(a, 1);
        insere_elemento(a, 4);
        insere_elemento(a, 18);
        insere_elemento(a, 16);
        insere_elemento(a, 13);

        inordem(a.meu_nome_eh_root());

        System.out.println();

        preordem(a.meu_nome_eh_root());

        System.out.println();

        posordem(a.meu_nome_eh_root());

        System.out.println();

        System.out.println(altura(a));

        System.out.println();

        remover(a,3);

        System.out.println("Inordem");

        inordem(a.meu_nome_eh_root());

        System.out.println();

        System.out.println("Preordem");

        preordem(a.meu_nome_eh_root());

        System.out.println();

        System.out.println("posordem");

        posordem(a.meu_nome_eh_root());

        System.out.println();

    }

    public static void inordem(No no){
        if (no != null){
            inordem(no.esquerda());
            System.out.println(no.retorna_dado());
            inordem(no.direita());
        }
    }

    public static void preordem(No no){
        if (no != null){
            System.out.println(no.retorna_dado());
            preordem(no.esquerda());
            preordem(no.direita());
        }
    }

    public static void posordem(No no){
        if (no != null){
            posordem(no.esquerda());
            posordem(no.direita());
            System.out.println(no.retorna_dado());
        }
    }

    public static void insere_elemento(Arvore groot, int dado) {

        if (groot.vazio()){
            groot.insere_root(new No(dado));
        }else {

            No no = groot.meu_nome_eh_root();
            No aux = null;

            while (no != null) {
                aux = no;
                if (dado < no.retorna_dado()) {
                    no = no.esquerda();
                } else {
                    no = no.direita();
                }

            }
            if (dado < aux.retorna_dado()) {
                aux.insere_esquerda(new No(dado));
            } else {
                aux.insere_direita(new No(dado));
            }
        }
    }

    public static void remover(Arvore groot, int dado){
        if (remove_elemento(groot,dado)){
            System.out.println("Elemento removido");
        }else {
            System.out.println("Elemento inexistente");
        }
    }

    public static boolean remove_elemento(Arvore groot, int dado){
        if (groot.vazio()){
            System.out.println("Árvore vazia");
            return false;
        }else {

            No no = groot.meu_nome_eh_root();
            No aux = null;

            while (no != null && no.retorna_dado()!= dado) {
                aux = no;
                if (dado < no.retorna_dado()) {
                    no = no.esquerda();
                } else {
                    no = no.direita();
                }
            }

            if (no == null){
                return false;
            }

            if (no.direita() == null && no.esquerda() == null){
                if (no == groot.meu_nome_eh_root()){
                    groot.insere_root(null);
                    return true;
                }
                if (aux.esquerda() == no){
                    aux.altesq(null);
                    return true;
                } else {
                    aux.altdir(null);
                    return true;
                }
            }

            if (no.esquerda() != null && no.direita() != null){
                No dir = no.direita();

                if (aux.esquerda() == no){
                    no.alt_dado(busca(dir, aux.esquerda()));
                    aux.altesq(no);
                    //nao removeu o na direita do no à esquerda do aux, apenas alterou o no à esquerda do aux

                }else {
                    no.alt_dado(busca(dir, aux.direita()));
                    aux.altdir(no);
                }

                return true;
            }else {
                if (no.direita() == null){
                    if (no == groot.meu_nome_eh_root()){
                        groot.insere_root(no.esquerda());
                        return true;
                    }
                    if (aux.esquerda() == no){
                        aux.altesq(no.esquerda());
                        return true;
                    } else {
                        aux.altdir(no.esquerda());
                        return true;
                    }
                } else {
                    if (no == groot.meu_nome_eh_root()) {
                        groot.insere_root(no.direita());
                        return true;
                    }
                    if (aux.esquerda() == no) {
                        aux.altesq(no.direita());
                        return true;
                    } else {
                        aux.altdir(no.direita());
                        return true;
                    }
                }
            }
        }
    }

    public static int busca(No no, No aux){
        No pai = aux;

        while (no.esquerda() != null){
            pai = no;
            no = no.esquerda();
        }

        if (pai != aux){
            pai.altesq(no.direita());
        }else {
            pai.altdir(null);
        }

        return no.retorna_dado();

    }

    public static int nivel(No no){
        if (no == null){
            return -1;
        }else {
            int esq = nivel(no.esquerda()) + 1;
            int dir = nivel(no.direita()) + 1;
            if (esq >= dir){
                return esq;
            }else {
                return dir;
            }
        }
    }

    public static int altura(Arvore groot){
        if (groot.vazio()){
            return -1;
        } else {
            return nivel(groot.meu_nome_eh_root());
        }
    }
}
