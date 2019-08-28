public class NoLista {

        private String dado;
        private int count;
        private NoLista proximo;

        NoLista(String dado){
            this.dado = dado;
            this.count = 1;
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

        int getCount(){
            return this.count;
        }

        void incrementa(){
            this.count = this.count + 1;
        }
}
