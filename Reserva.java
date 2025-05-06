/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventasteatro;

/**
 *
 * @author Camilo
 */
public class Reserva {
    //Atributos de la clase
    private int reservaId;
    private int clienteId;
    private int asientoId;

    //Constructor
    public Reserva(int reservaId, int clienteId, int asientoId) {
        this.reservaId = reservaId;
        this.clienteId = clienteId;
        this.asientoId = asientoId;
    }

    public int getReservaId() {
        return reservaId;
    }
    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getAsientoId() {
        return asientoId;
    }
    public void setAsientoId(int asientoId) {
        this.asientoId = asientoId;
    }

    @Override
    public String toString(){
        return String.format(
                "Reserva %d - Cliente: %d | Asiento: %d",
                reservaId, clienteId, asientoId
        );
    }
}
