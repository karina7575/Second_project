package homework8;

import homework8.burn_all.Uranium;
import homework8.burn_all.Wood;
import homework8.divination_found_love.Human;
import homework8.fruits_farm.Apple;
import homework8.fruits_farm.Apricot;
import homework8.reviews.Review;
import homework8.ruler.Animal;
import homework8.ruler.Boat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Runner {
    public static void main(String[] args) {

        //Задание №1: Сад
        //Создать два класса, которые являются фруктами (намек на еще один класс): яблоко, абрикос.
        //(Без полей и методов).
        //Создать функциональный интерфейс сад, который умеет выращивать ФРУКТ и всех наследников фрукта.
        //Метод ничего не принимает.
        //Создать с помощью лямбд выражений 2 фермы: яблочная, абрикосовая.
        //Яблочная ферма должна отдавать яблоко(не фрукт!), абрикосовая - абрикос(не фрукт!).

        Supplier<Apple> appleFarm = () -> new Apple();
        Supplier<Apricot> apricotFarm = () -> new Apricot();
        Apple apple = appleFarm.get();
        Apricot apricot = apricotFarm.get();

        //Задание №2: Поиск пары с помощью гадания
        //Создать функциональный интерфейс гадание, который на вход принимает аргумент любого типа,
        //на выход возвращает да/нет.
        //Создать с помощью лямбд выражений:
        //ромашку: принимает имя, возвращает да если в имени четное кол-во букв, нет если нечетное
        //бабку гадалку: принимает Человека(возраст, рост),
        //возвращает да - если (возраст + рост) больше 210, нет - если меньше или равно

        Predicate<String> chamomile = (String name) -> {
            if (name.length() % 2 == 0) {
                return true;
            } else {
                return false;
            }
        };
        Predicate<Human> grandma = (Human human) -> {
            if ((human.getAge() + human.getHeight()) > 210) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println(chamomile.test("Мария"));
        System.out.println(grandma.test(new Human(54, 165)));

        //Задание №3: Гори ясно!
        //Создать функциональный интерфейс сжигание, ничего не возвращает, принимает аргумент
        //любого типа.
        //Создать класс уран (без атрибутов и методов)
        //Создать класс дерево (без атрибутов и методов)
        //Создать с помощью лямбд выражений:
        //атомный реактор: принимает в себя уран, печатает на экран: зеленый свет вокруг!
        //костер: принимает в себя дерево, печатает на экран: желто-красный свет вокруг!

        Consumer<Uranium> nuclearReactor = (Uranium uranium) -> {
            System.out.println("Зеленый свет вокруг!");
        };
        Consumer<Wood> bonfire = (Wood wood) -> {
            System.out.println("Желто-красный свет вокруг!");
        };
        nuclearReactor.accept(new Uranium());
        bonfire.accept(new Wood());

        //Задание №4: универсальная линейка
        //Создать функциональный интерфейс линейка: принимает в себя любой тип, возвращает Integer
        //Создать класс животное (длина тела, длина хвоста)
        //Создать класс лодка(длина)
        //Создать с помощью лямбд выражений:
        //Измеритель лодок: на вход лодка, возвращает длину лодки
        //Измеритель животных: на вход животное, возвращает сумму длин тела и хвоста

        Function<Boat, Integer> boatRuler = (Boat boat) -> boat.getLenght();
        Function<Animal, Integer> animalRuler = (Animal animal) -> animal.getBodyLenght() + animal.getTailLenght();
        System.out.println(boatRuler.apply(new Boat(150)));
        System.out.println(animalRuler.apply(new Animal(100, 65)));

        //Задание №5: сортировка отзывов
        //Создать класс отзыв с полями: id отзыва, текст отзыва, количество лайков,
        // дата + время отзыва (LocalDateTime)  - НЕ ИСПОЛЬЗОВАТЬ COMPARABLE!
        //Создать коллекцию, которая хранит отсортированные отзывы по:
        // 1.лайкам
        // 2.(Если лайки совпадают) дата + время отзыва
        // 3.(Если лайки и дата + время отзыва совпадают) id

        //Уникальность определяется на основе сортировки.
        //Создать comparator через лямбда выражение, для сортировки отзывов:

        //Пример, отсортированный :
        //          (id, текст, кол-во лайков, дата+время)
        //отзыв №1: 1, отличный товар, 200, 25.01.2024 13:37
        //отзыв №2: 2, так себе товар, 100, 25.01.2024 16:37
        //отзыв №4: 4, плохой товар, 100, 25.01.2024 13:37
        //отзыв №3: 3, плохой товар, 100, 25.01.2024 13:37

        Review review1 = new Review(1, "отличный товар", 200);
        Review review2 = new Review(2, "так себе товар", 100);
        Review review3 = new Review(4, "плохой товар", 100);
        Review review4 = new Review(3, "плохой товар", 100);

        ArrayList<Review> reviews = new ArrayList<>(List.of(review1, review2, review3, review4));
        Comparator<Review> reviewComparator = (rev1, rev2) -> {
            if (rev1.getLikes() < rev2.getLikes()) {
                return 1;
            }
            else if (rev1.getLikes() > rev2.getLikes()) {
                return -1;
            }
            else {
                if (rev1.getDateTime() == rev2.getDateTime()) {
                    if (rev1.getId() < rev2.getId()) {
                        return 1;
                    }
                    else if (rev1.getId() > rev2.getId()) {
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
                else {
                    return rev1.getDateTime().compareTo(rev2.getDateTime());
                }
            }
        };
        reviews.sort(reviewComparator);
        System.out.println(reviews);
    }
}
