// src/Main.java
import vehiculos.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("ABC123", "Toyota", 2020, 1000);
        Vehiculo v2 = new Vehiculo("XYZ789", "Ford", 2018, 1500);
        Vehiculo v3 = new Vehiculo("DEF456", "Renault", 2022, 1200);

        v1.mostrarInformacion();
        v2.mostrarInformacion();
        v3.mostrarInformacion();
    }
}
