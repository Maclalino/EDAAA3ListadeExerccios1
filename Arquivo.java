import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    public static Item[] lerArquivo(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int count = 0;

        while (br.readLine() != null) {
            count++;
        }

        br.close();
        br = new BufferedReader(new FileReader(path));

        Item[] jogos = new Item[count];

        for (int i = 0; i < count; i++) {
            line = br.readLine();
            String[] dados = line.split(",");
            String nomeJogo = dados[0];
            String categoria = dados[1];
            double avaliacao = Double.parseDouble(dados[2]);

            jogos[i] = new Item(nomeJogo, categoria, avaliacao);
        }

        return jogos;
    }

    public static void salvarArquivo(Item[] jogos, String nomeArquivo) throws IOException {
        FileWriter fw = new FileWriter(nomeArquivo);
        for (Item jogo : jogos) {
            fw.write(jogo.toString() + "\n");
        }
        fw.close();
        System.out.println("Arquivo " + nomeArquivo + " salvo com sucesso!");
    }
}
