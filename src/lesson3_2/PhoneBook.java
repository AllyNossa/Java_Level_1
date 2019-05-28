package lesson3_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        HashMap<String, String> book = new HashMap<>();
        phoneBook.add("890033490", "Иванов",book);
        phoneBook.add("489735893475973", "Иванов", book);
        phoneBook.add("1493274234", "Петров", book);
        //phoneBook.get("Иванов", book);
        phoneBook.add("1234", "Петров", book);
        phoneBook.get("Петров", book);
    }

    void add(String phone, String surname, HashMap<String, String> phoneBook) {
        phoneBook.put(phone, surname);
    }

    void get(String surname, HashMap<String, String> phoneBook) {
        Set<Map.Entry<String, String>> set = phoneBook.entrySet();

        for (Map.Entry<String, String> name : set) {
            if (surname.equals(name.getValue())) {
                System.out.println(name.getValue() + ", номер телефона " + name.getKey());
            }
        }
    }
}
