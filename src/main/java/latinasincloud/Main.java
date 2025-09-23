package latinasincloud;

import java.util.ArrayList;
import java.util.Scanner;

/* SISTEMA DE GESTION DE PRODUCTOS
Crear una aplicación de consola en Java que permita gestionar una lista de productos (nombre, precio, stock)
con un metodo vender() para reducir el stock al realizar una venta.

REQUISITOS
 * Clase producto con:
 - Atributos: id(int), nombre(string), precio(int), stock(int).
 - Metodo vender(int cantidad): Reduce el stock y muestra un mensaje.

 *Menú interactivo (Usando scanner) para:
 - Añadir productos.
 - Listar todos los productos.
 - Vender productos (actualizando el stock).
 - Salir del programa.

 *Validaciones:
 - No vender si no hay suficiente stock.
 - Precio y stock no pueden ser negativos. */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private  static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {


        int option;

        do {
            System.out.println("*** MENU ***");
            System.out.println("1. Añadir producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Vender productos por ID");
            System.out.println("4. Editar producto por ID");
            System.out.println("5. Eliminar producto del listado");
            System.out.println("6. Salir");
            System.out.println("> Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    listsProducts();
                    break;

                case 3:
                    sellProduct();
                    break;

                case 4:
                    //editProduct();
                    break;

                case 5:
                    //deleteProduct();
                    break;

                case 6:
                    System.out.println("¡Gracias, vuelve pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (option != 6);

    }

    private static void addProduct(){
        System.out.println("Ingresa el nombre del producto:");
        String name = scanner.nextLine();
        System.out.println("Ingresa precio:");
        int value = scanner.nextInt();
        System.out.println("Ingresa stock:");
        int stock = scanner.nextInt();

        if (value >= 0 && stock >= 0) {
            Producto nuevo = new Producto(name,value, stock);
            productos.add(nuevo);
            System.out.println("Producto añadido con ID: " + nuevo.getId());
        } else {
            System.out.println("Productos y stock deben ser mayores a 0.\nProducto no añadido");
        }
    }

    private static void listsProducts() {
        if (productos.isEmpty()){
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("\nLista de productos:");
            productos.forEach(producto -> {
                producto.mostrar();
            });
        }
    }

    private static void sellProduct() {
        System.out.println("Ingrese el ID del producto a vender:");
        int id = scanner.nextInt();

        Producto producto = productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
