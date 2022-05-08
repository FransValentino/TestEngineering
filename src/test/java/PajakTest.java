import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


    public class PajakTest {
        static Pajak pajak;

        @BeforeAll
        static void init(){
            pajak = new Pajak();
        }

        @AfterAll
        static void destroy(){
            pajak = null;
        }

        @ParameterizedTest
        @CsvSource({"0,2500000","10,10000000","22,27500000","40f,45000000","-1,-1000000","-1,9999999999999f"})
        public void EQVTest(double tax, double salary){
            Assertions.assertEquals(tax, pajak.getPajak(salary));
        }

        private static Stream<Arguments> BVA1(){
            return Stream.of(
                    Arguments.of(true, 3999999),
                    Arguments.of(true, 4000000),
                    Arguments.of(false, 4000001)
            );
        }

        @ParameterizedTest
        @MethodSource("BVA1")
        public void BVA1Test(boolean expected, double salary){
            Assertions.assertNotNull(pajak);
            Assertions.assertEquals(expected, pajak.getPajak(salary) == 0);
        }

        private static Stream<Arguments> BVA2(){
            return Stream.of(
                    Arguments.of(true, 14999999),
                    Arguments.of(true, 15000000),
                    Arguments.of(false, 15000001)
            );
        }

        @ParameterizedTest
        @MethodSource("BVA2")
        public void BVA2Test(boolean expected, double salary){
            Assertions.assertNotNull(pajak);
            Assertions.assertEquals(expected, pajak.getPajak(salary) == 10);
        }

        private static Stream<Arguments> BVA3(){
            return Stream.of(
                    Arguments.of(true, 39999999),
                    Arguments.of(true, 40000000),
                    Arguments.of(false, 40000001)
            );
        }

        @ParameterizedTest
        @MethodSource("BVA3")
        public void BVA3Test(boolean expected, double salary){
            Assertions.assertNotNull(pajak);
            Assertions.assertEquals(expected, pajak.getPajak(salary) == 22);
        }
    }


