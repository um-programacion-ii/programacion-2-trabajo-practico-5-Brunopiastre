package vehiculos;

import java.time.Year;

public class Vehiculo {
    private String patente;
    private String marca;
    private int anio;
    private double capacidadCargaKg;

    // Constructor
    public Vehiculo(String patente, String marca, int anio, double capacidadCargaKg) {
        if (patente == null || patente.trim().isEmpty())
            throw new IllegalArgumentException("La patente no puede ser nula o vacía.");
        if (anio < 1900 || anio > Year.now().getValue())
            throw new IllegalArgumentException("El año debe estar entre 1900 y el año actual.");
        if (capacidadCargaKg <= 0)
            throw new IllegalArgumentException("La capacidad de carga debe ser positiva.");

        this.patente = patente;
        this.marca = marca;
        this.anio = anio;
        this.capacidadCargaKg = capacidadCargaKg;
    }

    // Getters y Setters
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public double getCapacidadCargaKg() { return capacidadCargaKg; }
    public void setCapacidadCargaKg(double capacidadCargaKg) { this.capacidadCargaKg = capacidadCargaKg; }

    // Método de impresión
    public void mostrarInformacion() {
        System.out.println("Vehículo: " + marca + " | Patente: " + patente + " | Año: " + anio + " | Capacidad: " + capacidadCargaKg + " kg");
    }
}
