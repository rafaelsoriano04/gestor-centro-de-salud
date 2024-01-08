package clases;

/**
 *
 * @author Usuario
 */
public class Medicamento {
    int id;
    String nombre, especificaciones, regisSani;
    double precio;
    int cantidad;

    public Medicamento(int id, String nombre, String especificaciones, String regisSani, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.especificaciones = especificaciones;
        this.regisSani = regisSani;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    
}
