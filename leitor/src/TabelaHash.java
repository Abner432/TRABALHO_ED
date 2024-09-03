public class TabelaHash {
    private ListaPalavras[] tabela;

    public TabelaHash() {
        tabela = new ListaPalavras[26];
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = new ListaPalavras();
        }
    }

    private int hash(String palavra) {
        return Character.toLowerCase(palavra.charAt(0)) - 'a';
    }

    public void adicionarPalavra(String palavra, int linha) {
        int indice = hash(palavra);
        if (indice >= 0 && indice < tabela.length) {
            tabela[indice].adicionarPalavra(palavra, linha);
        }
    }

    public ListaPalavras getLista(char inicial) {
        int indice = Character.toLowerCase(inicial) - 'a';
        if (indice >= 0 && indice < tabela.length) {
            return tabela[indice];
        }
        return null;
    }
}
