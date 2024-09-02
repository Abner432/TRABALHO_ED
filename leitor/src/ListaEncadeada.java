public class ListaEncadeada<T> {
    
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho = 0;

    private final int NAO_ENCONTRADO = -1;

    public ListaEncadeada(){
        this.primeiro=null;
    }

    public void adiciona(T elemento){
        No<T> celula = new No<T>(elemento);
        if(this.tamanho==0){
            this.primeiro = celula;
        } else{
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }
    
    public int getTamanho(){
        return this.tamanho;
    }

    public void limpa (){
        for(No<T> atual = this.primeiro; atual!=null;){
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public int busca(T elemento){
        No<T> noAtual = this.primeiro;
        int pos = 0;
        while (noAtual != null) {
            if (noAtual.getElemento().equals(noAtual)) {
                return pos;
            }
            pos ++;
            noAtual = noAtual.getProximo();

        }
        
        return NAO_ENCONTRADO;
    }

    @Override
    public String toString() {
        if(this.tamanho==0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        No<T> atual = this.primeiro;
        for(int i=0; i<this.tamanho - 1; i++){
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento());
        return builder.toString();
    }

    
}
