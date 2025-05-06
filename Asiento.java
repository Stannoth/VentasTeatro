/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventasteatro;

/**
 *
 * @author Camilo
 */
public class Asiento {
        private int asientoId;
        private String ubicacion;
        private boolean disponible;

        //Constructor de la clase asiento, que tendrá su Id, ubicación y disponibilidad
        public Asiento(int asientoId, String ubicacion) {
            this.asientoId = asientoId;
            this.ubicacion = ubicacion;
            this.disponible = true;
        }

        public int getAsientoId() {
            return asientoId;
        }
        public void setAsientoId(int asientoId){
            this.asientoId = asientoId;
        }

        public String getUbicacion(){
            return ubicacion;
        }
        public void setUbicacion(String ubicacion){
            this.ubicacion = ubicacion;
        }

        public boolean isDisponible(){
            return disponible;
        }
        public void setDisponible(boolean disponible){
            this.disponible = disponible;
        }

        //Formato con el metodo String para mostrar el asiento
        @Override
        public String toString(){
            return String.format(
                    "Asiento %d [%s] - %s",
                    asientoId,
                    ubicacion,
                    disponible ? "Disponible" : "No disponible"
            );
        }
    }
