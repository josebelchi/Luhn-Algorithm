package test.java.tests;

import main.java.algorithm.Luhn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LuhnTest {

    @Test
    void testNumeroValido() {
        Luhn luhn = new Luhn("5406093381901606");
        assertTrue(luhn.luhnAlgorithm(), "El número debería ser válido.");
    }

    @Test
    void testNumeroInvalido() {
        Luhn luhn = new Luhn("79927398710");
        assertFalse(luhn.luhnAlgorithm(), "El número debería ser inválido.");
    }

    @Test
    void testConCerosIniciales() {
        Luhn luhn = new Luhn("0000123456789012");
        assertFalse(luhn.luhnAlgorithm(), "El número con ceros iniciales debería ser inválido.");
    }

    @Test
    void testLongitudIncorrecta() {
        Luhn luhn = new Luhn("12345");
        assertFalse(luhn.luhnAlgorithm(), "El número con longitud incorrecta debería ser inválido.");
    }

    @Test
    void testEntradaInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Luhn("1234abcd5678efgh").luhnAlgorithm());
        assertEquals("Número inválido: contiene caracteres no numéricos.", exception.getMessage(),
                "Se esperaba una excepción por entrada no numérica.");
    }
}
