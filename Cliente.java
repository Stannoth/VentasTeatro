/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventasteatro;

/**
 *
 * @author Camilo
 */
public class Cliente {
    //Atributos de la clase cliente
    private int clienteId;
    private String nombre;
    private int edad;
    private boolean esEstudiante;
    private boolean esTerceraEdad;

    //Constructor
    public Cliente(int clienteId, String nombre, int edad, boolean esEstudiante, boolean esTerceraEdad) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.edad = edad;
        this.esEstudiante = esEstudiante;
        this.esTerceraEdad = esTerceraEdad;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEsEstudiante() {
        return esEstudiante;
    }

    public void setEsEstudiante(boolean esEstudiante) {
        this.esEstudiante = esEstudiante;
    }

    public boolean isEsTerceraEdad() {
        return esTerceraEdad;
    }

    public void setEsTerceraEdad(boolean esTerceraEdad) {
        this.esTerceraEdad = esTerceraEdad;
    }

    @Override
    public String toString() {
        return String.format(
                "Cliente %d: %s, %d años, Estudiante: %b, 3ra Edad: %b",
                clienteId, nombre, edad, esEstudiante, esTerceraEdad
        );
    }

}

