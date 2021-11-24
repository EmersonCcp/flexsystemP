/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;

/**
 *
 * @author Sammer
 */
public interface IDAO_Gastos {
    
    
    public ArrayList listarGastos(String condicionG);
    public void insertarGastos(Object objG);
    public void modificarGastos(Object objG);
    public void eliminarGastos(Object objG);
    public void filtrarGastos(Object objG);
    
    
    
    
}
