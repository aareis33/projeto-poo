package primeirob;

import java.util.Scanner;

public class ConversorSimples {


    public static String converterParaRomano(int num) {
        if (num < 1 || num > 3999) {
            return "Número fora do intervalo suportado (1-3999)";
        }

        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] dezenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] milhares = {"", "M", "MM", "MMM"};

        return milhares[num / 1000] +
                centenas[(num % 1000) / 100] +
                dezenas[(num % 100) / 10] +
                unidades[num % 10];
    }


    public static double converterMoeda(double valor, String moedaOrigem, String moedaDestino) {

        double taxa = 1.0;
        if (moedaOrigem.equals("USD") && moedaDestino.equals("EUR")) taxa = 0.93;
        else if (moedaOrigem.equals("USD") && moedaDestino.equals("JPY")) taxa = 146.24;
        else if (moedaOrigem.equals("USD") && moedaDestino.equals("GBP")) taxa = 0.82;
        else if (moedaOrigem.equals("USD") && moedaDestino.equals("BRL")) taxa = 5.09;
        else if (moedaOrigem.equals("EUR") && moedaDestino.equals("USD")) taxa = 1.08;
        else if (moedaOrigem.equals("EUR") && moedaDestino.equals("JPY")) taxa = 157.46;
        else if (moedaOrigem.equals("EUR") && moedaDestino.equals("GBP")) taxa = 0.88;
        else if (moedaOrigem.equals("EUR") && moedaDestino.equals("BRL")) taxa = 5.48;
        else if (moedaOrigem.equals("JPY") && moedaDestino.equals("USD")) taxa = 0.0068;
        else if (moedaOrigem.equals("JPY") && moedaDestino.equals("EUR")) taxa = 0.0064;
        else if (moedaOrigem.equals("JPY") && moedaDestino.equals("GBP")) taxa = 0.0056;
        else if (moedaOrigem.equals("JPY") && moedaDestino.equals("BRL")) taxa = 0.0348;
        else if (moedaOrigem.equals("GBP") && moedaDestino.equals("USD")) taxa = 1.22;
        else if (moedaOrigem.equals("GBP") && moedaDestino.equals("EUR")) taxa = 1.14;
        else if (moedaOrigem.equals("GBP") && moedaDestino.equals("JPY")) taxa = 179.67;
        else if (moedaOrigem.equals("GBP") && moedaDestino.equals("BRL")) taxa = 6.25;
        else if (moedaOrigem.equals("BRL") && moedaDestino.equals("USD")) taxa = 0.20;
        else if (moedaOrigem.equals("BRL") && moedaDestino.equals("EUR")) taxa = 0.18;
        else if (moedaOrigem.equals("BRL") && moedaDestino.equals("JPY")) taxa = 28.74;
        else if (moedaOrigem.equals("BRL") && moedaDestino.equals("GBP")) taxa = 0.16;
        else {
            return -1;
        }
        return valor * taxa;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite um número inteiro para converter para romano: ");
        int numero = scanner.nextInt();
        String romano = converterParaRomano(numero);
        System.out.println("Número romano: " + romano);


        System.out.print("Digite o valor a ser convertido: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite a moeda de origem (USD, EUR, JPY, GBP, BRL): ");
        String moedaOrigem = scanner.next().toUpperCase();
        System.out.print("Digite a moeda de destino (USD, EUR, JPY, GBP, BRL): ");
        String moedaDestino = scanner.next().toUpperCase();

        double convertido = converterMoeda(valor, moedaOrigem, moedaDestino);
        if (convertido == -1) {
            System.out.println("Conversão não suportada");
        } else {
            System.out.printf("Valor convertido: %.2f %s%n", convertido, moedaDestino);
        }

        scanner.close();
    }
}

