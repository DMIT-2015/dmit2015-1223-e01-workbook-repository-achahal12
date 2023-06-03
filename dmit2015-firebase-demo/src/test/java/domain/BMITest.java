package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class BMITest {

   @ParameterizedTest(name = "weight ={0},height={1}, expected BMI= {2}")
   @CsvSource({
           "100, 66, 16.1",
           "140, 66, 22.6",
           "175, 66, 28.2",
           "200, 66, 32.3",
           "132, 62, 24.1",
   })
   void bmi(int weight, int height, double  expectedBMI) {
        BMI currentBMI = new BMI( weight,height);
        assertEquals(expectedBMI, currentBMI.bmi());
    }

    @ParameterizedTest(name= "weight ={0}, height = {1},expected category={2}")
    @CsvSource({
            "100, 66, underweight",
            "140, 66, normal",
            "175, 66, overweight",
            "200, 66,obese",
            "170, 66, overweight",

    })
    void bmiCategory(int weight, int height, String expectedCategory) {

        BMI currentBMI = new BMI(weight,height);
        assertEquals(expectedCategory, currentBMI.bmiCategory());
    }

}
