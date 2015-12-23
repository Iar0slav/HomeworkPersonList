package person;

import localization.LocalizationRu;

import java.util.Calendar;

public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private int birthYear;
    private int age;

    public Person(String firstName, String middleName, String lastName, int birthYear){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.age = getAge(Calendar.getInstance().get(Calendar.YEAR));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // Ф.И.О.
    public String getFullName(){
        String fullName =   this.lastName + " " +
                            this.firstName + " " +
                            this.middleName;
        return fullName;
    }

    // возраст
    private int getAge(int currentYear){
        return currentYear - birthYear;
    }

    // полное инфо
    public String getInfo(){
        String info =   LocalizationRu.FIO +
                        getFullName() +
                        LocalizationRu.FULLAGE +
                        getAge(Calendar.getInstance().get(Calendar.YEAR));
        return info;
    }
}
