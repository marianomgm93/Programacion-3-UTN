import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<Integer> arrPares=new ArrayList<>();
        Random rand=new Random();
        for (int i = 0; i < 10; i++) {
            arr.add(rand.nextInt(100));
        }
        System.out.println(arr);
        arr.stream()
                .filter(i->i%2==0)
                .forEach(arrPares::add);
        System.out.println(arrPares);
*/
        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Juan");
        nombres.add("María");
        nombres.add("Pedro");
        nombres.add("Lucía");
        System.out.println(nombres);
        nombres.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

}
