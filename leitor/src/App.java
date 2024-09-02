public class App {
    public static void main(String[] args) throws Exception {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(1);
        lista.adiciona(2);
        System.out.println("[" +lista+"]" );
        System.out.println(lista.getTamanho());
        lista.limpa();
        System.out.println(lista);
    }
}
