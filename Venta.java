/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventasteatro;

/**
 *
 * @author Camilo
 */
public class Venta {
    private int ventaId;
    private int clienteId;
    private int asientoId;
    private double precioBase;
    private double descuento;
    private double precioFinal;

    //Constructor
    public Venta (int ventaId, int clienteId, int asientoId, double precioBase, double descuento) {
        this.ventaId = ventaId;
        this.clienteId = clienteId;
        this.asientoId = asientoId;
        this.precioBase = precioBase;
        this.descuento = descuento;
        this.precioFinal = precioBase - descuento;
    }

    public int getVentaId(){
        return ventaId;
    }
    public void setVentaId(int ventaId){
        this.ventaId = ventaId;
    }

    public int getClienteId(){
        return  ventaId;
    }
    public void setClienteId(int clienteId){
        this.clienteId = clienteId;
    }

    public int getAsientoId(){
        return asientoId;
    }
    public void setAsientoId(int asientoId){
        this.asientoId = asientoId;
    }

    public double getPrecioBase(){
        return precioBase;
    }
    public void setPrecioBase(double precioBase){
        this.precioBase = precioBase;
    }

    public double getDescuento(){
        return descuento;
    }
    public void setDescuento(double descuento){
        this.descuento = descuento;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    @Override
    public String toString(){
        return String.format(
                "Venta %d - Cliente: %d | Asiento: %d | Base: %.2f | Desc : %.2f | Final : %.2f",
                ventaId, clienteId, asientoId, precioBase, descuento, precioFinal
        );
    }
}