package primeirob;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CriarCSV {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o nome da primeira coluna: ");
        String coluna1 = scanner.nextLine();
        System.out.print("Digite o nome da segunda coluna: ");
        String coluna2 = scanner.nextLine();
        System.out.print("Digite o nome da terceira coluna: ");
        String coluna3 = scanner.nextLine();


        System.out.print("Quantas linhas de dados você deseja inserir? ");
        int numeroLinhas = scanner.nextInt();
        scanner.nextLine();


        try (FileWriter writer = new FileWriter("dados.csv")) {

            writer.write(coluna1 + "," + coluna2 + "," + coluna3 + "\n");


            for (int i = 0; i < numeroLinhas; i++) {
                System.out.println("Digite os dados para a linha " + (i + 1) + ":");
                System.out.print(coluna1 + ": ");
                String dado1 = scanner.nextLine();
                System.out.print(coluna2 + ": ");
                String dado2 = scanner.nextLine();
                System.out.print(coluna3 + ": ");
                String dado3 = scanner.nextLine();


                writer.write(dado1 + "," + dado2 + "," + dado3 + "\n");
            }

            System.out.println("Arquivo CSV criado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }

        scanner.close();
    }
}
