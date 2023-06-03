package domain;

/**
 * This class is use to calculate a person's body mass index (ChineseZodiac) and their BMI Category.
 * @author Amandeep Kaur Chahal
 * @version 2023.05.30
 */
public class ChineseZodiac {
    private int birthYear;
    private String animalName ="";

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    public String getAnimalName(){return animalName;}
    public void setAnimalName (String animalName){ this.animalName=animalName;}

    public ChineseZodiac() {

        birthYear = 0;
        animalName="";
    }

public ChineseZodiac(int newBirthYear) {this.birthYear=newBirthYear;}

    public static String animal (int birthYear){
        int Offset= (birthYear-1990) % 12;
        String animalName;
        switch (Offset) {

            case 4:
            {
                animalName="Rat";
                break;
            }
            case 5:
            {
                animalName="Ox";
                break;
            }
            case 6:
            {
                animalName="Tigger";
                break;
            }
            case 7:
            {
                animalName="Rabbit";
                break;
            }
            case 8:
            {
                animalName="Dragon";
                break;
            }
            case 9:
            {
                animalName="Snake";
                break;
            }
            case 10:
            {
                animalName="Horse";
                break;
            }
            case 11:
            {
                animalName="Goat";
                break;
            }
            case 0:
            {
                animalName="Monkey";
                break;
            }
            case 1:
            {
                animalName="Rooster";
                break;
            }
            case 2:
            {
                animalName="Dog";
                break;
            }
            case 3:
            {
                animalName="Pig";
                break;
            }
            default:{
                animalName ="Invalid Input";
                break;
            }
        }

      return animalName;
    }



}
