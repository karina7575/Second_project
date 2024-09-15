package homework7;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        String filename = "luggage.csv";
        putOnLentAndClaim(filename);
        HashMap<String, Integer> result = weightStatistic(filename);
        System.out.println("легкий - " + result.get("легкий"));
        System.out.println("средний - " + result.get("средний"));
        System.out.println("тяжелый - " + result.get("тяжелый"));
    }

    static void putOnLentAndClaim(String filename) {
        Set<String> luggageBelt = new LinkedHashSet<>();
        int filledCells = 10;
        int flag = 0;
        String[] arrayLuggage = new String[2];
        Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream(filename));

        scanner.nextLine();
        while (scanner.hasNext()) {
            System.out.println("Начинается загрузка на ленту.");
            for (int i = 0; i < filledCells && scanner.hasNext(); i++) {
                arrayLuggage = scanner.nextLine().split(";");
                luggageBelt.add(arrayLuggage[0]);
                flag = i + 1;
            }
            System.out.println("Лента загружена, начинается выдача багажа.");
            for (int i = 0; i < flag; i++) {
                Iterator<String> iterator = luggageBelt.iterator();
                System.out.println(iterator.next() + " - выдан");
                iterator.remove();
            }
            System.out.println("Лента пустая, закончена выдача багажа");
        }
    }

    static HashMap<String, Integer> weightStatistic(String filename) {
        int minWeight = 5;
        int maxWeight = 10;
        int weight;
        String light = "легкий";
        String middle = "средний";
        String heavy = "тяжелый";
        String[] arrayLuggage = new String[2];
        HashMap<String, Integer> weights = new HashMap<>();
        Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream(filename));
        scanner.nextLine();
        while (scanner.hasNext()) {
            arrayLuggage = scanner.nextLine().split(";");
            weight = Integer.parseInt(arrayLuggage[1]);
            if (weight < minWeight) {
                weights.put(light, weights.getOrDefault(light, 0) + weight);
            }
            else if (weight >= minWeight && weight <= maxWeight) {
                weights.put(middle, weights.getOrDefault(middle, 0) + weight);
            }
            else {
                weights.put(heavy, weights.getOrDefault(heavy, 0) + weight);
            }
        }
        return weights;
    }
}
