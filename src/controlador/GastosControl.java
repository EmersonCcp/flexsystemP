/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datos.GastosDAO;
import datos.IDAO_Gastos;
import java.util.ArrayList;

/**
 *
 * @author Sammer
 */
public class GastosControl implements IDAO_Gastos {

    @Override
    public ArrayList listarGastos(String condicionG) {
        return new GastosDAO().listarGastos(condicionG);}

    @Override
    public void insertarGastos(Object objG) {
        new GastosDAO().insertarGastos(objG);}

    @Override
    public void modificarGastos(Object objG) {
        new GastosDAO().modificarGastos(objG);}

    @Override
    public void eliminarGastos(Object objG) {
        new GastosDAO().eliminarGastos(objG);}

    @Override
    public void filtrarGastos(Object objG) {
       //  new GastosDAO().FiltrarGastos(objG);
    }

}
