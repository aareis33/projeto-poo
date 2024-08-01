package primeirob;

import java.io.IOException;
import java.io.FileWriter;

public class Hello {

    public static void main(String [] args) {
        // Escrever em um arquivo
        try (FileWriter writer = new FileWriter("exemplo_bala.txt")) {
            writer.write("Pega!😎\n");
            writer.write("Bem vindo a leitura e escrita com Java☕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


 }
