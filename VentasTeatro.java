/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ventasteatro;

/**
 *
 * @author Camilo
 */
public class VentasTeatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                int capacidadSala = 10;
        int maxClientes = 10;
        int maxVentas = 20;

        SistemaTeatro sistema = new SistemaTeatro(capacidadSala, maxClientes, maxVentas);
        sistema.iniciarSistema();
    }
    
}
