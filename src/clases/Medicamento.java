package clases;

/**
 *
 * @author Usuario
 */
public class Medicamento {
    public int id;
    public String nombre, especificaciones, regisSani;
    public double precio;
    public int cantidad;
    public String numRM;

    public Medicamento(String numFac,String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.numRM = numFac;
    }
    
    

    public Medicamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Medicamento(String nombre) {
        this.nombre = nombre;
    }

    
    public Medicamento(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setNumRM(String numRM) {
        this.numRM = numRM;
    }
    
    
    

    public Medicamento(int id, String nombre, String especificaciones, String regisSani, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.especificaciones = especificaciones;
        this.regisSani = regisSani;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
     public String toString() {
        return this.nombre; // Esto asegura que el JComboBox muestre solo el nombre
    }
}
