package Tasks;
import java.util.*;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

public class Task1 {
    public static void main(String[] args) {
        Map<String, String> db = new HashMap<>();

        System.out.println("Для вывода списка номеров наберите ВЫВОД, для окончания - ОТМЕНА");

        System.out.println("Введите имя абонента");
        Scanner Sk = new Scanner(System.in, "Cp866");
        String subscriber = Sk.nextLine();

        //Scanner Sc = new Scanner(System.in);
        System.out.println("Введите номер телефона: "); 
        String number = Sk.nextLine();
        
        while (subscriber != "ОТМЕНА") {

            if (db.containsKey(subscriber) == true) {
                String keyNumber = db.get(subscriber);
                db.put(subscriber,keyNumber + " " + number);
            }
            else {
                db.put(subscriber,number);
            }

            System.out.println("Введите имя абонента или наберите ВЫВОД или ОТМЕНА");
            subscriber = Sk.nextLine();
            if (subscriber.equals("ВЫВОД")) {
                System.out.println("Список всех абонентов:");
                for (var item : db.entrySet()) {
                    System.out.printf("[%s: %s]\n", item.getKey(), item.getValue());
                    subscriber = "ОТМЕНА";
                }
            } else if (subscriber.equals("ОТМЕНА") == false) {
                System.out.println("Введите номер телефона: "); 
                number = Sk.nextLine();
            }
        }
    }
}