public class Palavra {
    private String texto;
    private ListaEncadeada<Integer> ocorrencias;

    public Palavra(String texto) {
        this.texto = texto;
        this.ocorrencias = new ListaEncadeada<>();
    }

    public String getTexto() {
        return texto;
    }

    public ListaEncadeada<Integer> getOcorrencias() {
        return ocorrencias;
    }

    public void adicionarOcorrencia(int linha) {
        ocorrencias.adiciona(linha);
    }
}
