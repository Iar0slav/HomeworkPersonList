package operations;

import localization.LocalizationRu;
import person.Person;

import java.util.List;
import java.util.Scanner;

public class WorkWithPersonsList {

    private List<Person> personList;
    private int personListSize;

    // прием списка с которым работаем
    public void transferPersonList(List<Person> personList) {
        this.personList = personList;
        this.personListSize = personList.size();
    }

    // печать всего списка пользователей
    private void printPersonList() {
        System.out.println(LocalizationRu.USERLISTTOP);
        if (isEmptyList()) {
            System.out.println(LocalizationRu.EMPTYLIST);
        } else {
            for (int i = 0; i < personListSize; i++) {
                System.out.print((i + 1) + ". ");
                System.out.println(personList.get(i).getFullName());
            }
        }
        System.out.println(LocalizationRu.USERLISTBOT);
    }

    // проверка списка на пустоту
    private boolean isEmptyList() {
        return personListSize == 0;
    }

    // печать расширеной информации о пользователе
    private void printPersonFromList(int position) {
        System.out.println(LocalizationRu.FULLINFOTOP);
        System.out.println(personList.get(position - 1).getInfo());
        System.out.println(LocalizationRu.FULLINFOBOT);
    }

    //TODO реализовать функционал удаления пользователя из списка по порядковому номеру


    //чистка списка с доп подтверждением
    private void clearPersonList(){
        if (isEmptyList()) {
            System.out.println(LocalizationRu.USERLISTTOP);
            System.out.println(LocalizationRu.EMPTYLIST);
            System.out.println(LocalizationRu.USERLISTBOT);
        } else {
            boolean circleCrear = false;
            do {
                System.out.println(LocalizationRu.CLEARLIST);
                Scanner clearList = new Scanner(System.in);
                String isClear = clearList.nextLine();
                boolean isInt = CheckForInt.isInteger(isClear);
                if (isInt) {
                    try {
                        int select = Integer.parseInt(isClear);
                        if (select == 1) {          // очистка Ок
                            circleCrear = true;
                            personList.clear();
                            this.personListSize = personList.size();
                            System.out.println(LocalizationRu.CLEAROK);
                        } else if (select == 2){    // очистка отменена
                            circleCrear = true;
                            System.out.println(LocalizationRu.CLEARCANCELL);
                        } else {
                            System.out.println(LocalizationRu.INCORRECT);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(LocalizationRu.INCORRECT);
                    }
                } else {
                    System.out.println(LocalizationRu.INCORRECT);
                }
            } while (!circleCrear);
        }
    }


    //TODO реализовать функционал сохранения списка в файл


    // меню выбора пользователя по номеру
    private void printCurrentPerson() {
        if (isEmptyList()) {
            System.out.println(LocalizationRu.FULLINFOTOP);
            System.out.println(LocalizationRu.EMPTYLIST);
            System.out.println(LocalizationRu.FULLINFOBOT);
        } else {
            boolean circleExit = false;
            do {
                System.out.println(LocalizationRu.USERNUMBER + "1 ... " + personListSize + ")");
                Scanner selectMenu = new Scanner(System.in);
                String isSelect = selectMenu.nextLine();
                boolean isInt = CheckForInt.isInteger(isSelect);
                if (isInt) {
                    try {
                        int select = Integer.parseInt(isSelect);
                        if (select > 0 && select < (personListSize + 1)) {       // от 1 и до размера списка
                            circleExit = true;
                            printPersonFromList(select);
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
        }
    }

    // меню работы и возврат списка
    public List<Person> transferListBack() {
        boolean circleExit = false;
        do {
            System.out.println(LocalizationRu.USERMENU);
            Scanner selectMenu = new Scanner(System.in);
            String isSelect = selectMenu.nextLine();
            boolean isInt = CheckForInt.isInteger(isSelect);
            if (isInt) {
                try {
                    int select = Integer.parseInt(isSelect);
                    if (select > 0 && select < 5) {       // 3 пункта меню
                        switch (select) {
                            // печать списка пользователей
                            case 1:
                                printPersonList();
                                break;
                            // меню выбора пользователя по номеру и печать расширеной информации
                            case 2:
                                printCurrentPerson();
                                break;
                            // выход в предыдущее меню
                            case 3:
                                clearPersonList();
                                break;
                            case 4:
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
