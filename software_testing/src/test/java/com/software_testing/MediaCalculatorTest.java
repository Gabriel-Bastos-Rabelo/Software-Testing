package com.software_testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MediaCalculatorTest {


    @Test
    void testCalcularMedia() {
        double[] notas = {8.0, 7.5, 9.0};
        double media = MediaCalculator.calcularMedia(notas);
        assertEquals(8.2, media, 0.1); 
    }

    @Test
    void testCalcularNovaMediaComNota4Maior() {
        double[] notas = {6.0, 5.5, 7.0};
        double novaNota = 8.0;
        double novaMedia = MediaCalculator.calcularNovaMedia(notas, novaNota);
        assertEquals(7.0, novaMedia, 0.1);
    }

    @Test
    void testCalcularNovaMediaComNota4IgualOuMenor() {
        double[] notas = {6.0, 5.5, 7.0};
        double novaNotaIgual = 5.5;
        double novaNotaMenor = 4.0;

        double mediaComNotaIgual = MediaCalculator.calcularNovaMedia(notas, novaNotaIgual);
        assertEquals(6.16, mediaComNotaIgual, 0.1);

        double mediaComNotaMenor = MediaCalculator.calcularNovaMedia(notas, novaNotaMenor);
        assertEquals(6.16, mediaComNotaMenor, 0.1);
    }

}
