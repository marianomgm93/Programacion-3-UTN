import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Producto.cargarProductos();
        /**1. Filtrado y Transformación
         ○ Obtener una lista con los nombres y precios de los productos de la categoría
         "Electrónica" cuyo precio sea mayor a 1000, ordenados de mayor a menor
         precio.
         */

        System.out.println("Lista de electronica: "+
                productos.stream()
                        .filter(a->a.getCategoria().equals("Electrónica") && a.getPrecio()>1000)
                        .sorted(Comparator.comparing(Producto::getPrecio))
                        .toList()
        );

        /**2. Reducción de Datos
         ○ Calcular el precio promedio de los productos de la categoría "Hogar", pero
         solo considerando aquellos con stock disponible.
         */
        System.out.println("Promedio precios hogar: "+
                productos.stream()
                        .filter(a->a.getCategoria().equals("Hogar") && a.getStock()>0)
                        .collect(Collectors.averagingDouble(Producto::getPrecio))

        );
        /**
         *3. Producto mas caro
         * ○ Obtener el producto más caro de cada categoría y devolver un mapa con la
         * categoría como clave y el producto más caro como valor.
         */

        System.out.println("Producto mas caro: "+
                productos.stream()
                        .collect(Collectors
                                .toMap((Producto::getCategoria),
                                        (Producto::getPrecio),
                                        (Double::max)))
        );

        /**
         * 4. Uso de Optionals
         * ○ Encontrar el producto de la categoría "Deportes" con stock mayor a 10
         * unidades, obtener su nombre en minúsculas y devolverlo dentro de un
         * Optional. Mostrarlo o si no existe, mostrar “Producto Inexistente”
         */
        System.out.println("Uso de optionals: "+
                productos.stream().filter(p->p.getCategoria().equals("Deportes") && p.getStock()>10)
                        .map(p->p.getNombre().toLowerCase())
                        .findFirst().orElse("Producto Inexistente")

        );
    }
}