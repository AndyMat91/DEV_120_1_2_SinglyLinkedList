package org.example;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.println("1). Создадим объект класса LinkedList<T>, параметризованный типом <String>, добавим значений в начало и конец списка, а также " +
                "\nвыведем все значений на печать(в методе printAll использован перебор всего содержимого списка при помощи оператора «for-each»):");
        list.addInEnd("333");
        list.addInBeginning("Head");
        list.addInEnd("245");
        list.addInEnd("111");
        list.addInEnd("How are you?");
        list.addInEnd("Tail");
        list.printAll();

        System.out.println("2). Проверим перебор содержимого списка от головного узла до узла с заданным значением при помощи оператора\n" +
                "«for-each»; то должно быть перебрано всё содержимое списка.");
        System.out.println("Зададим значение 111:");
        list.listHeadToValue("111").forEach(System.out::println);
        System.out.println();
        System.out.println("Зададим значение 1234567890:");
        list.listHeadToValue("1234567890").forEach(System.out::println);
        System.out.println();

        System.out.println("3). Проверим перебор содержимого списка от узла с заданным значением до конца списка при помощи оператора\n" +
                "«for-each»; если список заданного значения не содержит, то ничего происходить не должно.");
        System.out.println("Зададим значение 245:");
        list.listValueToTail("245").forEach(System.out::println);
        System.out.println();
        System.out.println("Зададим значение 1234567890:");
        list.listValueToTail("1234567890").forEach(System.out::println);
        System.out.println("Ничего не произошло =)");

        System.out.println();
        System.out.println("4). Извлечение значения из начала списка без его удаления из списка:");
        String i = list.extValueFromTheBeginningWithoutDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную");
        System.out.println("Значение осталось в списке:");
        list.printAll();

        System.out.println();
        System.out.println("5). Извлечение значения из начала списка с удалением его из списка:");
        i = list.extValueFromTheBeginningWithDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение удалилось из списка:");
        list.printAll();

        System.out.println();
        System.out.println("6). Извлечение значения c конца списка без его удаления:");
        i = list.extValueFromTheEndWithoutDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение осталось в списке:");
        list.printAll();

        System.out.println();
        System.out.println("7). Извлечение значения с конца списка с удалением его из списка:");
        i = list.extValueFromTheEndWithDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение удалилось из списка:");
        list.printAll();

        System.out.println();
        System.out.println("8). Определим, является ли список пустым, или нет:");
        System.out.println("Список пуст? - " + (list.empty() ? "Да!" : "Нет!"));

        System.out.println();
        System.out.println("9). Определим, содержит ли список заданное значение, или нет:");
        System.out.println("Содержит ли список значенеие 245? - " + (list.searchValue("245") ? "Да!\n" : "Нет!\n") +
                "А значение 777? - " + (list.searchValue("777") ? "Да!" : "Нет!"));

        System.out.println();
        System.out.println("10). Удалим заданное значение из списка, например 245: ");
        list.remove("245");
        list.printAll();
        System.out.println("Удалим несуществующее значение из списка, например 7776: ");
        list.remove("7776");
        System.out.println("Ничего не произошло.");
    }
}