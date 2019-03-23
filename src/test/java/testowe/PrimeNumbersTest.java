package testowe;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {2,3,5,7,13,29,33})
    void numberShouldBePrime(int number) {
        assertTrue(PrimeNumbers.isPrime(number));
    }
        @ParameterizedTest
        @ValueSource(ints = {2,3,5,7,13,29,33})
        void numberShouldNotBePrime(int number){
            assertFalse(PrimeNumbers.isPrime(number));

        }
            @ParameterizedTest
            @ValueSource(ints = {-10, 2,3,5,7,13,29,33})
            void cornerCaseShouldNotBePrime(int number) {
                assertTrue(PrimeNumbers.isPrime(number));

            }
    }






