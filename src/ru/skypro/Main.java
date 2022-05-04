package ru.skypro;

public class Main {

    public static void main(String[] args) {
        // write your code here
        StringListImpl myStrArray = new StringListImpl(5);
        StringListImpl myStrArray1 = new StringListImpl(5);

        myStrArray.add("Мама");
        myStrArray1.add("Мама");

        myStrArray.add("Папа");
        myStrArray1.add("Папа");

        myStrArray.add("Сын");
        myStrArray1.add("Сын");

        myStrArray.add("Сестра");
        myStrArray1.add("Сестра");

        myStrArray.add(0, "Дедушка_1");
        myStrArray1.add(0, "Дедушка_1");

        myStrArray.set(1, "Мама_1");
        myStrArray1.set(1, "Мама_1");

        myStrArray.remove("Сын");
        myStrArray1.remove("Сын");

        String sss = myStrArray.remove(1);
        String sss1 = myStrArray1.remove(1);

        boolean checkElement = myStrArray.contains("Папа");
        System.out.println("checkElement = " + checkElement);

        int intElement = myStrArray.indexOf("Дедушка_1");
        System.out.println("intElement = " + intElement);

        int intElementEnd = myStrArray.lastIndexOf("Мама_2");
        System.out.println("intElement = " + intElementEnd);

        String e = myStrArray.get(2);
        System.out.println("e = " + e);

        System.out.println("myStrArray.toArray() = " + myStrArray.toArray());
        System.out.println("myStrArray1.toArray() = " + myStrArray1.toArray());

        System.out.println("myStrArray.equals(myStrArray1) = " + myStrArray.equals(myStrArray1));

        myStrArray.clear();

        if (myStrArray.isEmpty()) {
            System.out.println("Массив пуст!");
        } else {
            System.out.println("Массив не пуст");
        }



    }
}
