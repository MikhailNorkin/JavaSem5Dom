// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности Имени.

package Tasks;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;

public class Task2 {
    public static String Str (String line){
        String st = "";
        st = line.split(" ")[0];
        return st;
    }

    public class Main {
        public static void main(String[] args) throws IOException {
            Map<String, Integer> db = new HashMap<>();
            File file = new File("Tasks/file.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String NameS = Str(line);
                if (db.containsKey(NameS) == true) {
                    Integer keyNumber = db.get(NameS);
                    db.put(NameS,keyNumber + 1);
                } else {db.put(NameS,1);}    
                line = reader.readLine();
            }
            db.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
        }
    }      
}
