package domain;


/**
 * This class is use to calculate a person's body mass index (BMI) and their BMI Category.
 * @author Amandeep Kaur Chahal
 * @version 2023.05.30
 */
public class BMI {


    private int weight;
    private int height;

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    BMI() {
        weight = 0;
        height = 0;
    }

    BMI(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    /**
     * Calculate the body mass index (BMI) using the weight and height of the person.
     * The BMI of a person is calculated using the formula: BMI = 700 * weight / (height * height)
     * where weight is in pounds and height is in inches.
     *
     * @return the body mass index (BMI) value of the person
     */
    public double bmi() {
        double bmi = 703.0 * weight / (height * height);
        return Math.round(bmi * 10.) / 10.0;
    }


    public String bmiCategory() {
        double bmiResults = bmi();
        String message = "";


        if (bmiResults < 18.5) {
            message = "underweight";
        } else if (bmiResults >= 18.5 && bmiResults <= 24.9) {
            message = "normal";
        } else if (bmiResults >= 24.9 && bmiResults <= 29.9) {
            message = "overweight";
        } else {

            message = "obese";
        }
            return message;
        }
    }
