package com.software_testing;

import java.util.Scanner;

public class MediaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos alunos na turma? (Máximo: 10): ");
        int numDiscentes = scanner.nextInt();
        
        if (!validarQuantidadeDiscentes(numDiscentes)){
          throw new IllegalArgumentException("Número de discentes deve estar entre 1 e 10.");
        }

        for (int i = 0; i < numDiscentes; i++) {
            System.out.println("\nAluno " + (i + 1) + ":");
            double[] notas = new double[3];

            for (int j = 0; j < 3; j++) {
                System.out.print("Digite a nota " + (j + 1) + ": ");
                double nota = scanner.nextDouble();
                if(!validarNota(nota)){
                  throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
                }
                notas[j] = nota;
            }

            double media = calcularMedia(notas);
            System.out.printf("Média inicial: %.1f%n", media);

            if (verificaNecessidadeQuartaNota(media)) {
                System.out.print("Digite a quarta nota: ");
                double novaNota = scanner.nextDouble();
                validarNota(novaNota);
                double novaMedia = calcularNovaMedia(notas, novaNota);
                System.out.printf("Nova média: %.1f%n", novaMedia);
            }
        }

        scanner.close();
    }

    public static boolean validarQuantidadeDiscentes(int numDiscentes) {
        return !(numDiscentes <= 0 || numDiscentes > 10);

    }

    public static boolean validarNota(double nota) {
        return !(nota < 0 || nota > 10);

    }

    public static double calcularMedia(double[] notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public static double calcularNovaMedia(double[] notas, double novaNota) {
        double menorNota = notas[0];
        int indiceMenor = 0;

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < menorNota) {
                menorNota = notas[i];
                indiceMenor = i;
            }
        }

        if (novaNota > menorNota) {
            notas[indiceMenor] = novaNota;
        }

        return calcularMedia(notas);
    }

    public static boolean verificaNecessidadeQuartaNota(double media){
          return media < 7;
    }
}
