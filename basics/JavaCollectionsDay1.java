import java.util.ArrayList;
import java.util.Collection;

public class JavaCollectionsDay1 {
    public static void main(String[] args) {
        Collection<String> foods = new ArrayList<>();
        Collection<String> moreFoods = new ArrayList<>();

        foods.add("Banana");
        foods.add("Apple");
        foods.add("Mango");
        foods.add("papaya");
        foods.add("blackberry");

        moreFoods.add("grapes");
        moreFoods.add("pineapple");
        System.out.println(foods);
        foods.addAll(moreFoods);
        System.out.println(foods);
        if(foods.contains("Mango")) {
            System.out.println("mango exists");
        } else {
            System.out.println("mango dont exist");
        }
        if(foods.containsAll(moreFoods)) {
            System.out.println("all exists");
        } else {
            System.out.println("not exists all");
        }
        foods.remove("Mango");
        System.out.println(foods);
        foods.removeAll(moreFoods);
        moreFoods.retainAll(foods);
        System.out.println(moreFoods);
        System.out.println(foods);
        System.out.println(foods.size());
        if(foods.isEmpty()) {
            System.out.println("foods is empty");
        } else {
            System.out.println("foods is not empty");
        }


    }
}