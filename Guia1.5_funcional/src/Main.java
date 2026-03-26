import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Producto> productos = Producto.cargarProductos();
        /**1. Filtrado y Transformación
         ○ Obtener una lista con los nombres y precios de los productos de la categoría
         "Electrónica" cuyo precio sea mayor a 1000, ordenados de mayor a menor
         precio.
         */

        System.out.println("Lista de electronica: " +
                productos.stream()
                        .filter(a -> a.getCategoria().equals("Electrónica") && a.getPrecio() > 1000)
                        .sorted(Comparator.comparing(Producto::getPrecio))
                        .toList()
        );

        /**2. Reducción de Datos
         ○ Calcular el precio promedio de los productos de la categoría "Hogar", pero
         solo considerando aquellos con stock disponible.
         */
        System.out.println("Promedio precios hogar: " +
                productos.stream()
                        .filter(a -> a.getCategoria().equals("Hogar") && a.getStock() > 0)
                        .collect(Collectors.averagingDouble(Producto::getPrecio))

        );
        /**
         *3. Producto mas caro
         * ○ Obtener el producto más caro de cada categoría y devolver un mapa con la
         * categoría como clave y el producto más caro como valor.
         */

        System.out.println("Producto mas caro: " +
                productos.stream()
                        .collect(Collectors
                                .toMap((Producto::getCategoria),
                                        a -> a,//Function.Identify()
                                        (a, b) -> a.getPrecio() > b.getPrecio() ? a : b))
        );

        /**
         * 4. Uso de Optionals
         * ○ Encontrar el producto de la categoría "Deportes" con stock mayor a 10
         * unidades, obtener su nombre en minúsculas y devolverlo dentro de un
         * Optional. Mostrarlo o si no existe, mostrar “Producto Inexistente”
         */
        System.out.println("Uso de optionals: " +
                productos.stream().filter(p -> p.getCategoria().equals("Deportes") && p.getStock() > 10)
                        .map(p -> p.getNombre().toLowerCase())
                        .findFirst().orElse("Producto Inexistente")

        );
        /**
         * 5. Producto Mas Barato
         * ○ Encontrar el producto mas barato calculando el valor total de todas las
         * unidades en stock (Precio * stock). Devolver un Opcional con el producto. En
         * caso de que no exista, lanzar una excepción.
         */
        System.out.println("Producto mas barato: " +
                        productos
                                .stream()
                                .min(Comparator.comparingDouble(a -> a.getStock() * a.getPrecio())).orElseThrow(NoSuchElementException::new)
                //     .reduce((a, b) ->
                //           (a.getPrecio() * a.getStock()) < (b.getPrecio() * b.getStock()) ? a : b).orElseThrow(Exception::new)
        );
        /**
         * 6. Productos en stock ordenados alfabéticamente
         * ○ Obtener una lista con los nombres de los productos que tienen stock,
         * ordenarlos alfabéticamente y excluir los productos con nombres de menos de
         * 5 caracteres.
         */

        System.out.println("Productos en stock: " +
                productos.stream().filter(a -> a.getStock() > 0 && a.getNombre().length() > 5)
                        .sorted(Comparator.comparing(Producto::getNombre))
                        .toList()
        );
        /**
         * 7. Calculo de Stock Total
         * ○ Obtener el total de unidades en stock de todos los productos, pero solo
         * considerando aquellos con precio superior al promedio.
         */
        double promedio = productos.stream().mapToDouble(Producto::getPrecio).average().orElse(0);
        System.out.println("Total en stock: " +
                productos.stream()
                        .filter(a -> a.getPrecio() > promedio)
                        .mapToInt(Producto::getStock)
                        .sum()

        );
        /**
         * 8. Stock por Categoría
         * ○ Calcular cuántas unidades en stock hay por categoría, excluyendo categorías
         * con menos de 3 productos.
         */
        /// TODO REHACER
        /*


        System.out.println("Stock por categoria: " +
                productos.stream()
                        .collect(Collectors.groupingBy(Producto::getCategoria,Collectors.counting()));
        return productos.stream().filter(p->p.)


        );
         */

        /**
         * 9. Aplicar descuento
         * ○ Crear una nueva lista de productos con un 15% de descuento en su precio,
         * pero solo si el producto tiene más de 20 unidades en stock.
         */
        System.out.println("Productos con descuento: " +
                productos.stream()
                        .map(p ->
                                p.getStock() > 20 ?
                                        new Producto(p.getNombre(), p.getPrecio() * 0.85, p.getCategoria(), p.getStock()) : p
                        )
                        .toList()

        );
        System.out.println("Productos sin descuento: " + productos);
        /**
         * 10. Ganancia total inventario
         * ○ Calcular la ganancia total si se vendiera todo el inventario, considerando que
         * el costo de compra de cada producto es un 45% del valor de venta o de un
         * 65% si pertenece a la categoria Electronica.
         */
        System.out.println(
                productos.stream()
                        .mapToDouble(p -> p.getCategoria().equals("Electrónica")
                                ? p.getStock() * p.getPrecio() * 0.35
                                : p.getStock() * p.getPrecio() * 0.55)
                        .sum()
        );
    }
}