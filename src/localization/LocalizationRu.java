package localization;


public class LocalizationRu {


    // Person.class
    public static final String FIO          =   "ФИО: ";
    public static final String FULLAGE      =   ". Возраст (полных лет): ";


    // WorkWithPersonList.class
    public static final String USERMENU     =   "===== Пункт меню [ Просмотреть список сотрудников ]=====\n" +
                                                "Выберите действие (ввести цифру и нажать Enter):\n" +
                                                "1. Напечатать весь список сотрудников.\n" +
                                                "2. Напечать полную информацию о сотруднике.\n" +
                                                "3. Очистить список сотрудников.\n" +
                                                "4. Завершить работу с меню [ Просмотреть список сотрудников ] и вернуться в предыдущее меню.";
    public static final String USERLISTTOP  =   "=================[ Список сотрудников ]=================";
    public static final String EMPTYLIST    =   "! Список сотрудников пуст";
    public static final String USERLISTBOT  =   "==============[ Конец списка сотрудников ]==============" + "\n";
    public static final String USERNUMBER   =   "Введите номер сотрудника и нажмите Enter (диапазон ввода ";
    public static final String FULLINFOTOP  =   "=========[ Расширеная информация о сотруднике ]=========";
    public static final String FULLINFOBOT  =   "======[ Конец расширеной информации о сотруднике ]======" + "\n";
    public static final String CLEARLIST    =   "Запущена процедура очистки списка сотрудников.\n" +
                                                "Вы подтверждаете очистку? 1 - Да, 2 - Нет (ввести цифру и нажать Enter)";
    public static final String CLEARCANCELL =   "! Очистка отменена\n";
    public static final String CLEAROK      =   "! Очистка выполнена, список очищен\n";


    // Main.class
    public static final String MAINMENU     =   "===========[ Управление списком сотрудников ]===========\n" +
                                                "Выберите действие (ввести цифру и нажать Enter):\n" +
                                                "1. Добавить сотрудника.\n" +
                                                "2. Просмотреть список сотрудников.\n" +
                                                "3. Завершить работу с модулем сотрудников.";
    public static final String EXIT         =   "======[ Завершение работы со списком сотрудников ]======";


    // AddPersonToList.class
    public static final String ADDMENU      =   "========== Пункт меню [ Добавить сотрудника ]===========\n" +
                                                "Выберите действие (ввести цифру и нажать Enter):\n" +
                                                "1. Запустить процедуру добавления сотрудника.\n" +
                                                "2. Завершить работу с меню [ Добавить сотрудника ] и вернуться в предыдущее меню.";
    public static final String LASTNAME     =   "Введите фамилию и нажмите Enter\n" +
                                                "(поле не должно быть пустым, не больше 15 символов, допускаются буквы А-я)";
    public static final String FIRSTNAME    =   "Введите имя и нажмите Enter\n" +
                                                "(поле не должно быть пустым, не больше 15 символов, допускаются буквы А-я)";
    public static final String MIDDLENAME   =   "Введите отчество и нажмите Enter\n" +
                                                "(поле не должно быть пустым, не больше 15 символов, допускаются буквы А-я)";
    public static final String BIRTHYEAR    =   "Введите год рождения и нажмите Enter (диапазон ввода ";
    public static final String USERSAVED    =   "! Пользователь успешно добавлен";


    // Global
    public static final String INCORRECT    =   "Некорректный ввод" + "\n";

}
