/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datos.IDAO_Trabajos;
import datos.MaterialesDAO;
import datos.TrabajosDAO;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class TrabajosControl implements IDAO_Trabajos{

    @Override
    public ArrayList listarTrabajo(String condicionM) {
        return new TrabajosDAO().listarTrabajo(condicionM);
    }

    @Override
    public void insertarTrabajo(Object objTrabajo) {
        new TrabajosDAO().insertarTrabajo(objTrabajo);
    }

    @Override
    public void modificarTrabajo(Object objTrabajo) {
        new TrabajosDAO().modificarTrabajo(objTrabajo);
    }

    @Override
    public void eliminarTrabajo(Object objTrabajo) {
        new TrabajosDAO().eliminarTrabajo(objTrabajo);
    }

    @Override
    public ArrayList listarTrabajoDetalle(String condicionM) {
        return new TrabajosDAO().listarTrabajoDetalle(condicionM);
    }
    
    
}
