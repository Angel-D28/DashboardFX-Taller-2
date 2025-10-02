package co.edu.uniquindio.fx10.repositories;

import co.edu.uniquindio.fx10.models.Producto;
import java.util.ArrayList;


public class ProductoRepository {
    private static ProductoRepository instancia;
    private ArrayList<Producto> productos;

    private ProductoRepository() {
        productos = new ArrayList<>();
        cargarDatosEjemplo();
    }


    public static ProductoRepository getInstancia() {
        if (instancia == null) {
            instancia = new ProductoRepository();
        }
        return instancia;
    }


    private void cargarDatosEjemplo() {
        productos.add(new Producto("P001", "Laptop HP", "Laptop HP Victus 15", 1200.00, 10));
        productos.add(new Producto("P002", "Mouse Razer", "Mouse inalámbrico Razer Mamba", 89.99, 25));
        productos.add(new Producto("P003", "Teclado Mecánico Razer", "Teclado Mecánico RGB", 150.00, 15));
    }


    public ArrayList<Producto> getProductos() {

        return productos;
    }


    public void agregarProducto(Producto producto) {

        productos.add(producto);

    }


    public boolean eliminarProducto(Producto producto) {

        return productos.remove(producto);

    }


    public Producto buscarPorCodigo(String codigo) {
        return productos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }


    public int getCantidadProductos() {
        return productos.size();
    }
}

