package homework8.fruits_farm;

@FunctionalInterface
public interface Garden <F extends Fruit> {

    F makeFruit();
}
