import java.io.IOException;

public class Menu {
    private static final String path = "C:\\Users\\maria\\OneDrive\\Área de Trabalho\\PoyatosExUm\\ExercicioUm\\src\\JogosDesordenados.csv";
    private Item[] jogos;

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("[1] Ler arquivo");
            System.out.println("[2] Ordenar por categoria");
            System.out.println("[3] Ordenar por avaliação");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Ler.entradaInt();

            switch (opcao) {
                case 1:
                    lerArquivo();
                    break;
                case 2:
                    ordenarPorCategoria();
                    salvarArquivoOrdenado("JogosOrdenadosporCategoria.csv");
                    break;
                case 3:
                    ordenarPorAvaliacao();
                    salvarArquivoOrdenado("JogosOrdenadosporAvaliacao.csv");
                    break;
                case 4:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);
    }

    private void lerArquivo() {
        try {
            jogos = Arquivo.lerArquivo(path);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }

    private void ordenarPorCategoria() {
        Ordenacao.selectionSort(jogos);
    }

    private void ordenarPorAvaliacao() {
        Ordenacao.bubbleSort(jogos);
    }

    private void salvarArquivoOrdenado(String nomeArquivo) {
        try {
            Arquivo.salvarArquivo(jogos, nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo " + nomeArquivo);
            e.printStackTrace();
        }
    }
}
