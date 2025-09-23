package latinasincloud;

public class Producto {
    private static int contador = 1;

    private int id;
    private String nombre;
    private int precio;
    private int stock;

    public Producto(String nombre, int precio, int stock) {
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public  void vender(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            int total = this.precio * cantidad;
            System.out.println("Venta realiza con éxito. El total es: $");
        }else {
            System.out.println("No hay suficiente stock. Existen " + cantidad + "unidades.");
        }
    }

    public void mostrar() {
        System.out.println(" ID: " + id + " | Producto: " + nombre + " | Precio: $" + precio + " | Stock: " + stock);
    }
}
