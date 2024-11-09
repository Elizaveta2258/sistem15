import java.io.*;

public class Main {
    public static void main(String[] args) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        try (BufferedReader reader = new BufferedReader(new FileReader("Text.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(" ");
                if (array.length < 2) continue; // Проверка на наличие хотя бы двух элементов

                int first = Integer.parseInt(array[0]);
                int second = Integer.parseInt(array[1]);

                // Находим максимальное значение
                max += Math.max(first, second);

                // Находим минимальную разницу, если она не кратна 3
                int difference = Math.abs(first - second);
                if (difference % 3 != 0) {
                    min = Math.min(min, difference);
                }
            }

            // Выводим результат в зависимости от условия
            if (max % 3 != 0) {
                System.out.println(max);
            } else if (min == Integer.MAX_VALUE) {
                // Если min не изменялось, значит не было разницы, не кратной 3
                System.out.println(max); // Или можно обработать это как-то иначе
            } else {
                System.out.println(max - min);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования числа: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Произошла ошибка: " + ex.getMessage());
        }
    }
}
