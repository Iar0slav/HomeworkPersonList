package operations;

import localization.LocalizationRu;
import person.Person;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class AddPersonToList {

    private List<Person> personList;

    // прием списка с которым работаем
    public void transferPersonList(List<Person> personList) {
        this.personList = personList;
    }

    // меню работы и возврат списка
    //TODO необходим рефакторинг, вынос похожих операций в методы
    public List<Person> transferListBack() {
        boolean circleExit = false;
        do {
            System.out.println(LocalizationRu.ADDMENU);
            Scanner selectMenu = new Scanner(System.in);
            String isSelect = selectMenu.nextLine();
            boolean isInt = CheckForInt.isInteger(isSelect);
            if (isInt) {
                try {
                    int select = Integer.parseInt(isSelect);
                    if (select > 0 && select < 3) {       // 2 пункта меню
                        switch (select) {
                            // старт процедуры добавления пользователя
                            case 1:
                                //Фамилия, обработка ввода
                                boolean lastNameCircle = false;
                                String lastName = null;
                                do {
                                    System.out.println(LocalizationRu.LASTNAME);
                                    Scanner input = new Scanner(System.in);
                                    String isLastName = input.nextLine();
                                    int lastNameLenght = isLastName.length();
                                    // проверка длины строки > 0 и < 15 символов и на регулярку
                                    // регулярка не полная, для теста
                                    if (lastNameLenght > 0 && isLastName.matches("^[А-яа-я]{2,15}$")) {
                                        lastName = isLastName;
                                        lastNameCircle = true;
                                    } else {
                                        System.out.println(LocalizationRu.INCORRECT);
                                    }
                                } while (!lastNameCircle);

                                // Имя, обработка ввода
                                boolean firstNameCircle = false;
                                String firstName = null;
                                do {
                                    System.out.println(LocalizationRu.FIRSTNAME);
                                    Scanner input = new Scanner(System.in);
                                    String isFirstName = input.nextLine();
                                    int firstNameLenght = isFirstName.length();
                                    // проверка длины строки > 0 и < 15 символов и на регулярку
                                    // регулярка не полная, для теста
                                    if (firstNameLenght > 0 && isFirstName.matches("^[А-яа-я]{2,15}$")) {
                                        firstName = isFirstName;
                                        firstNameCircle = true;
                                    } else {
                                        System.out.println(LocalizationRu.INCORRECT);
                                    }
                                } while (!firstNameCircle);

                                // Отчество, обработка ввода
                                boolean middleNameCircle = false;
                                String middleName = null;
                                do {
                                    System.out.println(LocalizationRu.MIDDLENAME);
                                    Scanner input = new Scanner(System.in);
                                    String isMiddleName = input.nextLine();
                                    int middleNameLenght = isMiddleName.length();
                                    // проверка длины строки > 0 и < 15 символов и на регулярку
                                    // регулярка не полная, для теста
                                    if (middleNameLenght > 0 && isMiddleName.matches("^[А-Яа-я]{2,15}$")) {
                                        middleName = isMiddleName;
                                        middleNameCircle = true;
                                    } else {
                                        System.out.println(LocalizationRu.INCORRECT);
                                    }
                                } while (!middleNameCircle);

                                // год рождения
                                // проверка на пределы рабочих годов и пустое поле
                                boolean yearCircle = false;
                                int birthYear = 0;
                                do {
                                    System.out.println(LocalizationRu.BIRTHYEAR +
                                            (Calendar.getInstance().get(Calendar.YEAR) - 75) + " ... " +
                                            (Calendar.getInstance().get(Calendar.YEAR) - 18) + ")");
                                    Scanner input = new Scanner(System.in);
                                    String isYear = input.nextLine();
                                    boolean isYearInt = CheckForInt.isInteger(isYear);
                                    if (isYearInt) {
                                        try {
                                            int selectYear = Integer.parseInt(isYear);
                                            // диапазон между 18 лет и пенсионер 75 - от текущего года
                                            if (selectYear > (Calendar.getInstance().get(Calendar.YEAR) - 75) && selectYear < (Calendar.getInstance().get(Calendar.YEAR) - 18)) {
                                                birthYear = selectYear;
                                                yearCircle = true;
                                            } else {
                                                System.out.println(LocalizationRu.INCORRECT);
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println(LocalizationRu.INCORRECT);
                                        }
                                    } else {
                                        System.out.println(LocalizationRu.INCORRECT);
                                    }
                                } while (!yearCircle);

                                Person testPerson = new Person(firstName, middleName, lastName, birthYear);
                                personList.add(testPerson);
                                System.out.println(LocalizationRu.USERSAVED);

                                break;
                            // выход в предыдущее меню
                            case 2:
                                circleExit = true;
                                break;
                            default:
                                System.out.println("");
                        }
                    } else {
                        System.out.println(LocalizationRu.INCORRECT);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(LocalizationRu.INCORRECT);
                }
            } else {
                System.out.println(LocalizationRu.INCORRECT);
            }
        } while (!circleExit);

        return personList;
    }
}
