package homework9.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("тон", "тополь", "боль", "рой", "стройка"));
        Character ch = 'о';
        Stream wordStream = words.stream();
        List <Long> intList = words.stream().map(e -> e.chars().filter(t -> t == ch).count()).collect(Collectors.toList());
        Optional<Long> result = intList.stream().reduce((a, b) -> a + b);
        System.out.println(result.get());

        //Задание №2 - Сколько здесь "о" ?
        //1. Создать набор уникальных слов: "тон", "тополь", "боль", "рой", "стройка"
        //2. Создать стрим у набора
        //2.1 Посчитать количество букв "о" в одном слове
        //2.2 Посчитать сумму количества букв "о" во всех словах из набора
        //2.3 Вывести на экран сумму букв "о". Если в словах нет буквы "о", то распечатать ноль.
        //
        //ожидаемый результат:
        //6
    }
}
