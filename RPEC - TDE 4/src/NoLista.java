public class NoLista {

        private int dado;
        private NoLista proximo;

        NoLista(int dado){
            this.dado = dado;
            this.proximo = null;
        }

        void alteraproximo(NoLista proximo){
            this.proximo = proximo;
        }

        NoLista getProximo (){
            return this.proximo;
        }

        int getDado(){
            return this.dado;
        }
}
