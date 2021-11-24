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

public class Gastos {
    
private Integer ga_codigo;
private Integer ga_categoria;
private String ga_fecha;   
private Double ga_monto;
private String ga_descripcion;
private String ga_factura;

    public Gastos() {
    }

    public Gastos(Integer ga_codigo) {
        this.ga_codigo = ga_codigo;
    }

    public Gastos(Integer ga_codigo, Integer ga_categoria, String ga_fecha, Double ga_monto, String ga_descripcion, String ga_factura) {
        this.ga_codigo = ga_codigo;
        this.ga_categoria = ga_categoria;
        this.ga_fecha = ga_fecha;
        this.ga_monto = ga_monto;
        this.ga_descripcion = ga_descripcion;
        this.ga_factura = ga_factura;
    }

    public Integer getGa_codigo() {
        return ga_codigo;
    }

    public void setGa_codigo(Integer ga_codigo) {
        this.ga_codigo = ga_codigo;
    }

    public Integer getGa_categoria() {
        return ga_categoria;
    }

    public void setGa_categoria(Integer ga_categoria) {
        this.ga_categoria = ga_categoria;
    }

    public String getGa_fecha() {
        return ga_fecha;
    }

    public void setGa_fecha(String ga_fecha) {
        this.ga_fecha = ga_fecha;
    }

    public Double getGa_monto() {
        return ga_monto;
    }

    public void setGa_monto(Double ga_monto) {
        this.ga_monto = ga_monto;
    }

    public String getGa_descripcion() {
        return ga_descripcion;
    }

    public void setGa_descripcion(String ga_descripcion) {
        this.ga_descripcion = ga_descripcion;
    }

    public String getGa_factura() {
        return ga_factura;
    }

    public void setGa_factura(String ga_factura) {
        this.ga_factura = ga_factura;
    }

   
    
}
