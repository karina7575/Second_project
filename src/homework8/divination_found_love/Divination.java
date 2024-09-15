package homework8.divination_found_love;

@FunctionalInterface
public interface Divination <T extends Object> {

    boolean guess (T obj);

}
