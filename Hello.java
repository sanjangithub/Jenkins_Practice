import java.util.ArrayList;
import java.util.List;

public class Hello
{
    public static void main(String[] args) {
        System.out.println("My self Sanjan.");
        List<String> names = new ArrayList<>();
        names.add("Sanjan"); names.add("Jaikar"); names.add("Harshini"); names.add("Bharathi");

        names.stream().map(i -> i.equals("Bharathi") ? "Karra" : i + " Chikkala").forEach(System.out::println);
    }
}