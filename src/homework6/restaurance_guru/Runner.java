package homework6.restaurance_guru;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ArrayList<String> monday = new ArrayList<>(List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо"));
        ArrayList<String> tuesday = new ArrayList<>(List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон", "Реберная"));
        ArrayList<String> wednesday = new ArrayList<>(List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим"));
        ArrayList<String> thursday = new ArrayList<>(List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо"));
        ArrayList<String> friday = new ArrayList<>(List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька"));
        int countIntersections = 0;
        for (String rest : monday) {
            countIntersections += tuesday.contains(rest) ? 1 : 0;
            countIntersections += wednesday.contains(rest) ? 1 : 0;
            countIntersections += thursday.contains(rest) ? 1 : 0;
            countIntersections += friday.contains(rest) ? 1 : 0;
            if (countIntersections == 4) {
                System.out.println(rest);
            }
            countIntersections = 0;
        }
    }
}
