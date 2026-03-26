import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

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
//2
        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Juan");
        nombres.add("María");
        nombres.add("Pedro");
        nombres.add("Lucía");
        nombres.add("Mariano");
        System.out.println(nombres);
        nombres.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
//3
        arr.stream().sorted().forEach(System.out::println);
//4
        System.out.println("numeros mayores que 7 = "
                + arr.stream()
                .filter(i->i>7)
                .count()
        );
//5
        System.out.println("Primeros 5 numeros:");
        arr.stream().limit(5).forEach(System.out::println);

//6
        System.out.println("Cantidad de letras de cada palabra: "+
            nombres.stream().map(String::length).toList()

        );
//7
        System.out.println(
                nombres.stream()
                        .reduce((a,b)->a+", "+b).orElse("")
        );

//8
        ArrayList<Integer> repetidos= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            repetidos.add(rand.nextInt(10));
        }
        System.out.println("Lista con posibles repetidos: " + repetidos);
        System.out.println("Ahora sin repetidos: " +
        repetidos.stream()
                .distinct()
                .toList()
        );
        //9
        System.out.println("Ahora los 3 mas grandes: " +
        repetidos.stream()
                .sorted((a,b)->-a.compareTo(b))
                .limit(3)
                .toList()
        );
        //10
        System.out.println("Agrupando por cantidad de letras: "+
        nombres.stream()
                .collect(Collectors.groupingBy(a->a.length()))
        );
        //11
        System.out.println("El producto de "+repetidos+" es: "+
                repetidos.stream()
                        .reduce(1,(a,b)->a*b)

                );
        //12
        System.out.println("El nombre mas largo de "+ nombres +" es: "+
                nombres.stream()
                        .reduce("",(a,b)->a.length()>b.length() ? a : b)

                );
        //13
        System.out.println("Convirtiendo "+ repetidos + " a cadena con guiones: "+
                repetidos.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining("-"))
        );

        //14
        System.out.println("Agrupando pares y impares de "+arr+" -> "+
                arr.stream()
                        .collect(Collectors.partitioningBy(a->a%2==0))
                );
        //15
        System.out.println("La suma de los cuadrados de los numeros impares: "+
                arr.stream()
                        .filter(a->a%2!=0)
                        .map(a->Math.pow(a,2))
                        .map(Double::intValue)
                        .reduce(Integer::sum).orElse(0)
        );
    }


}
