import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class VerySimpleCSVGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definindo colunas fixas
        String[] colunas = {"Coluna1", "Coluna2", "Coluna3"};
        int numColunas = colunas.length;
        int numLinhas = 3;  // Número fixo de linhas

        // Cria um array para armazenar os dados
        String[][] dados = new String[numLinhas][numColunas];

        for (int i = 0; i < numLinhas; i++) {
            System.out.println("Insira os dados para a linha " + (i + 1) + ":");
            for (int j = 0; j < numColunas; j++) {
                System.out.print(colunas[j] + ": ");
                dados[i][j] = scanner.nextLine();
            }
        }

        // Criação do arquivo CSV
        String nomeArquivo = "saida.csv";  // Nome fixo do arquivo CSV

        try (FileWriter fileWriter = new FileWriter(nomeArquivo);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // Escreve o cabeçalho
            for (int i = 0; i < numColunas; i++) {
                printWriter.print(colunas[i]);
                if (i < numColunas - 1) {
                    printWriter.print(",");
                }
            }
            printWriter.println();

            // Escreve os dados
            for (int i = 0; i < numLinhas; i++) {
                for (int j = 0; j < numColunas; j++) {
                    printWriter.print(dados[i][j]);
                    if (j < numColunas - 1) {
                        printWriter.print(",");
                    }
                }
                printWriter.println();
            }

            System.out.println("Arquivo CSV '" + nomeArquivo + "' criado com sucesso!");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo CSV: " + e.getMessage());
        }

        scanner.close();
    }
}
