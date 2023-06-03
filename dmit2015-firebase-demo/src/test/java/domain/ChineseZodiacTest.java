package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ChineseZodiacTest {
    @ParameterizedTest (name = "birthYear ={0}, animal ={1} ")
@CsvSource({
        "1900, Rat",
        "1958, Dog",
        "2023, Rabbit",
        "1980,Horse",
        "2010, Dragon"
})
    void calculateAnimal(int birthYear, String expectedAnimal) {
        String actualAnimal = ChineseZodiac.animal(birthYear);
      //  assertEquals(expectedAnimal,actualAnimal);
       
    }
}