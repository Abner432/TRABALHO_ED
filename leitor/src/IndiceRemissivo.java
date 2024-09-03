/*Abner Ferreira Costa – Mat. 2323829
 *Anyele Ventura Lima – Mat. 2323813
 *David Khauan Santos Lima – Mat. 2323791
 *Julianna Dantas Alencar Reis – Mat. 2323726
 *Mario Sergio Cordeiro Lima – Mat. 2327073
 *Matheus Ferreira de Queiroz Alves – Mat. 2323824 
 */

import java.io.*;

public class IndiceRemissivo {

    public static void main(String[] args) {
        try {
            // Criação da tabela hash
            TabelaHash tabelaHash = new TabelaHash();

            BufferedReader readerTexto = new BufferedReader(new FileReader("C:\\TRABALHO_ED\\texto.txt"));
            String linhaTexto;
            int numeroLinha = 1;

            while ((linhaTexto = readerTexto.readLine()) != null) {
                String[] palavras = linhaTexto.split("\\W+");
                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        tabelaHash.adicionarPalavra(palavra, numeroLinha);
                    }
                }
                numeroLinha++;
            }
            readerTexto.close();

            BufferedReader readerPalavrasChave = new BufferedReader(new FileReader("C:\\TRABALHO_ED\\palavras-chave.txt"));
            String palavraChave;
            BufferedWriter writerIndice = new BufferedWriter(new FileWriter("indice-remissivo.txt"));

            while ((palavraChave = readerPalavrasChave.readLine()) != null) {
                ListaPalavras lista = tabelaHash.getLista(palavraChave.charAt(0));
                if (lista != null) {
                    for (Palavra palavra : lista.getPalavras()) {
                        if (palavra.getTexto().equalsIgnoreCase(palavraChave)) {
                            String ocorrencias = palavra.getOcorrencias().toString();
                            String indiceLinha = palavraChave + ": " + ocorrencias;
                            writerIndice.write(indiceLinha);
                            writerIndice.newLine();
                            System.out.println(indiceLinha);
                        }
                    }
                }
            }
            readerPalavrasChave.close();
            writerIndice.close();

            System.out.println("Índice remissivo gerado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
