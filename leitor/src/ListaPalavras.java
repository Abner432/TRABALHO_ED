public class ListaPalavras {
    private Palavra[] palavras;
    private int tamanho;

    public ListaPalavras() {
        palavras = new Palavra[10];
        tamanho = 0;
    }

    private void redimensionar() {
        Palavra[] novaLista = new Palavra[palavras.length * 2];
        System.arraycopy(palavras, 0, novaLista, 0, palavras.length);
        palavras = novaLista;
    }

    public void adicionarPalavra(String texto, int linha) {
        for (int i = 0; i < tamanho; i++) {
            if (palavras[i].getTexto().equalsIgnoreCase(texto)) {
                palavras[i].adicionarOcorrencia(linha);
                return;
            }
        }
        if (tamanho == palavras.length) {
            redimensionar();
        }
        Palavra novaPalavra = new Palavra(texto);
        novaPalavra.adicionarOcorrencia(linha);
        palavras[tamanho++] = novaPalavra;
    }

    public Palavra[] getPalavras() {
        Palavra[] resultado = new Palavra[tamanho];
        System.arraycopy(palavras, 0, resultado, 0, tamanho);
        return resultado;
    }
}
