package homework6.hydrometeorological_center;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Integer> january = new ArrayList(List.of(0, -1, -1, -2, -5, -6, -7, -8, -9, -10, -5, -5, -2, -7, -3, -1, -8, -9, -8, -8, -18, -20, -23, -24, -25, -9, -8, -7, -6, -5, -1));
        ArrayList<Integer> february = new ArrayList<>(List.of(-8, -10, -12, -13, -15, -16, -12, -7, -8, -10, -10, -9, -8, -8, -8, -9, -10, -9, -5, -6, -8, -7, -8, -9, -6, -5, -3, -1));
        ArrayList<Integer> allTemperature = new ArrayList<>(january);

        //Совмещение показателей температур за 2 месяца
        allTemperature.addAll(february);
        Integer average = countAverageTemperature(allTemperature);
        System.out.println("Средняя температура за 2 месяца = " + average);
    }

    public static Integer countAverageTemperature(ArrayList<Integer> allTemperature) {
        Integer avgTmp = 0;
        for (Integer temperature : allTemperature) {
            avgTmp += temperature;
        }
        avgTmp /= allTemperature.size();
        return avgTmp;
    }


}
