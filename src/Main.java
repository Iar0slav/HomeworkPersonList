import localization.LocalizationRu;
import operations.AddPersonToList;
import operations.CheckForInt;
import operations.WorkWithPersonsList;
import person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        AddPersonToList addPersonToList = new AddPersonToList();
        WorkWithPersonsList workWithPersonsList = new WorkWithPersonsList();

        // цикл главного меню
        boolean circleExit = false;
        do {
            System.out.println(LocalizationRu.MAINMENU);
            Scanner selectMenu = new Scanner(System.in);
            String isSelect = selectMenu.nextLine();
            boolean isInt = CheckForInt.isInteger(isSelect);
            if (isInt) {
                try {
                    int select = Integer.parseInt(isSelect);
                    if (select > 0 && select < 4) {       // 3 пункта меню
                        switch (select) {
                            // добавить сотрудника
                            case 1:
                                addPersonToList.transferPersonList(personList);
                                personList = addPersonToList.transferListBack();
                                break;
                            // просмотреть список сотрудников
                            case 2:
                                workWithPersonsList.transferPersonList(personList);
                                personList = workWithPersonsList.transferListBack();
                                break;
                            // завершение программы
                            case 3:
                                circleExit = true;
                                System.out.println(LocalizationRu.EXIT);
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
    }
}
