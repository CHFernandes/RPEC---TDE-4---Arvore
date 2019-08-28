import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //parte 1

        Arvore a = new Arvore();

        a.insere_elemento("5","N/A");
        a.insere_elemento("12","N/A");
        a.insere_elemento("7","N/A");
        a.insere_elemento("9","N/A");
        a.insere_elemento("22","N/A");
        a.insere_elemento("3","N/A");
        a.insere_elemento("1","N/A");
        a.insere_elemento("4","N/A");
        a.insere_elemento("18","N/A");
        a.insere_elemento("16","N/A");
        a.insere_elemento("13","N/A");

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

        //parte 2

        Arvore treebeard = new Arvore();

        inserir_arquivos("C:\\Users\\chfer\\IdeaProjects\\RPEC - TDE 4\\src\\arqs" , treebeard);

        inputar(treebeard);

    }

    public static void inputar(Arvore groot){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        No resultado;
        while (true){
            System.out.print("Insira uma palavra: ");
            input = scanner.nextLine().toLowerCase();
            resultado = groot.encontra_elemento(input);
            if (resultado == null){
                System.out.println("Nenhuma ocorrência encontrada");
            }else {
                resultado.retorna_lista().mostra_lista();
            }
            System.out.println();
        }
    }

    public static void inserir_arquivos(String diretorio, Arvore groot){
        File dir = new File(diretorio);

        File[]arquivos = dir.listFiles();

        for (int i=0; i < arquivos.length; i++){
            if(arquivos[i].getName().endsWith(".txt")){
                try {
                    FileReader arq = new FileReader(arquivos[i]);
                    BufferedReader lerarq = new BufferedReader(arq);
                    String linha = lerarq.readLine();
                    while (linha != null){
                        if (!linha.equals("")){
                            groot.insere_elemento(linha.toLowerCase(), arquivos[i].getName());
                        }
                        linha = lerarq.readLine();
                    }
                    arq.close();
                }catch (IOException e){
                    System.out.println("Erro na abertura do arquivo: " + e.getMessage());
                }
                System.out.println();
            }
        }
    }
}
