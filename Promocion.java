/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventasteatro;

/**
 *
 * @author Camilo
 */
public class Promocion {
    //Atributos
    private int promoId;
    private String descripcion;
    private double porcentajeDescuento;

    //Constructor de la clase
    public Promocion(int promoId, String descripcion, double porcentajeDescuento) {
        this.promoId = promoId;
        this.descripcion = descripcion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getPromoId(){
        return promoId;
    }
    public void setPromoId(int promoId){
        this.promoId = promoId;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public  String toString(){
        return String.format(
                "Promoción %d: %s (%.0f%%)",
                promoId, descripcion, porcentajeDescuento * 100
        );
    }
}