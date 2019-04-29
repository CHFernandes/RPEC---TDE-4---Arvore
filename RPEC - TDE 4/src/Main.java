public class Main {
    public static void main(String[] args) {

        Arvore a = new Arvore();

        a.insere_elemento("5");
        a.insere_elemento("12");
        a.insere_elemento("7");
        a.insere_elemento("9");
        a.insere_elemento("22");
        a.insere_elemento("3");
        a.insere_elemento("1");
        a.insere_elemento("4");
        a.insere_elemento("18");
        a.insere_elemento("16");
        a.insere_elemento("13");

        a.inordem(a.meu_nome_eh_root());

        System.out.println();

        a.preordem(a.meu_nome_eh_root());

        System.out.println();

        a.posordem(a.meu_nome_eh_root());

        System.out.println();

        System.out.println(a.altura());

        System.out.println();

        a.remover("3");

        System.out.println("Inordem");

        a.inordem(a.meu_nome_eh_root());

        System.out.println();

        System.out.println("Preordem");

        a.preordem(a.meu_nome_eh_root());

        System.out.println();

        System.out.println("posordem");

        a.posordem(a.meu_nome_eh_root());

        System.out.println();

    }
}
