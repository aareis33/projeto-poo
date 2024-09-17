package primeirob.listas.CsvGenerator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CsvGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Recebe o número de colunas
        System.out.print("Digite o número de colunas: ");
        int numColumns = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline restante

        // Recebe os títulos das colunas
        String[] columnNames = new String[numColumns];
        for (int i = 0; i < numColumns; i++) {
            System.out.print("Digite o nome da coluna " + (i + 1) + ": ");
            columnNames[i] = scanner.nextLine();
        }

        // Recebe o número de linhas
        System.out.print("Digite o número de linhas: ");
        int numRows = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline restante

        // Recebe os dados das linhas
        String[][] data = new String[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            System.out.println("Digite os dados para a linha " + (i + 1) + ":");
            for (int j = 0; j < numColumns; j++) {
                System.out.print("Coluna " + (j + 1) + ": ");
                data[i][j] = scanner.nextLine();
            }
        }

        // Cria o arquivo CSV
        System.out.print("Digite o nome do arquivo CSV (por exemplo, 'dados.csv'): ");
        String fileName = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Escreve os nomes das colunas
            for (int i = 0; i < numColumns; i++) {
                writer.print(columnNames[i]);
                if (i < numColumns - 1) writer.print(",");
            }
            writer.println();

            // Escreve as linhas de dados
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numColumns; j++) {
                    writer.print(data[i][j]);
                    if (j < numColumns - 1) writer.print(",");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo CSV: " + e.getMessage());
        }

        System.out.println("Arquivo CSV criado com sucesso!");
    }
}

