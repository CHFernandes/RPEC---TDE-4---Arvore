public class NoLista {

        private String dado;
        private NoLista proximo;

        NoLista(String dado){
            this.dado = dado;
            this.proximo = null;
        }

        void alteraproximo(NoLista proximo){
            this.proximo = proximo;
        }

        NoLista getProximo (){
            return this.proximo;
        }

        String getDado(){
            return this.dado;
        }
}
