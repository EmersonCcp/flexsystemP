/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sammer
 */
public class FiltroGastos {
    private Integer ga_idFiltro;
    private String ga_fecha_inicio;
    private String ga_fecha_final;
    private double ga_precio_total_final; 

    public FiltroGastos() {
    }

    public FiltroGastos(Integer ga_idFiltro) {
        this.ga_idFiltro = ga_idFiltro;
    }

    public FiltroGastos(Integer ga_idFiltro, String ga_fecha_inicio, String ga_fecha_final, double ga_precio_total_final) {
        this.ga_idFiltro = ga_idFiltro;
        this.ga_fecha_inicio = ga_fecha_inicio;
        this.ga_fecha_final = ga_fecha_final;
        this.ga_precio_total_final = ga_precio_total_final;
    }

    public Integer getGa_idFiltro() {
        return ga_idFiltro;
    }

    public void setGa_idFiltro(Integer ga_idFiltro) {
        this.ga_idFiltro = ga_idFiltro;
    }

    public String getGa_fecha_inicio() {
        return ga_fecha_inicio;
    }

    public void setGa_fecha_inicio(String ga_fecha_inicio) {
        this.ga_fecha_inicio = ga_fecha_inicio;
    }

    public String getGa_fecha_final() {
        return ga_fecha_final;
    }

    public void setGa_fecha_final(String ga_fecha_final) {
        this.ga_fecha_final = ga_fecha_final;
    }

    public double getGa_precio_total_final() {
        return ga_precio_total_final;
    }

    public void setGa_precio_total_final(double ga_precio_total_final) {
        this.ga_precio_total_final = ga_precio_total_final;
    }
    
    
    
    
    
}
