/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.FiltroGastos;
import modelo.Gastos;
import modelo.Materiales;

/**
 *
 * @author Sammer
 */
public class GastosDAO implements IDAO_Gastos{
    
    
    Connection con = null;
    ArrayList<Gastos> lista = new ArrayList<>();
    Gastos gastosObj = null;
    FiltroGastos filtroGastos = null;
    PreparedStatement ps ;
    ResultSet rs;
    private String SSQL;
    
    public GastosDAO(){
    con = new Conexion().Conectar();
    }
    

    @Override
    public ArrayList listarGastos(String condicionG) {
        
        try {
            SSQL = "SELECT * FROM gastos " + condicionG;
          //  double ga_suma=0;
            ps = con.prepareStatement(SSQL);
            rs = ps.executeQuery();
            while (rs.next()){
            gastosObj = new Gastos(
                    rs.getInt("ga_codigo"),
                    rs.getInt("ga_categoria"),
                    rs.getString("ga_fecha"),
                    rs.getDouble("ga_monto"),
                    rs.getString("ga_descripcion"),
                    rs.getString("ga_factura"));
            
         //       ga_suma= ga_suma+ rs.getDouble("ga_monto_total");
                    lista.add(gastosObj);            
            }
            
            
            filtroGastos = new FiltroGastos();
      /*   try {   
            SSQL = "Update filtro_gastos SET ga_monto_total_final=? where ga_idFiltro=1";
            ps = con.prepareStatement(SSQL);
            
         //   ps.setDouble(1, ga_suma);
            
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el monto total final");
 }*/
    
    return lista;
    
    } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en listar " + e);
        }
    return null;
    }

    @Override
    public void insertarGastos(Object objG){
    gastosObj = (Gastos) objG;
    SSQL = "INSERT INTO gastos(ga_categoria,ga_fecha,ga_monto,ga_descripcion,ga_factura) VALUES (?,?,?,?,?)" ;
    
       try{
           ps = con.prepareStatement(SSQL); 
           ps.setInt(1, gastosObj.getGa_categoria());
           ps.setString(2, gastosObj.getGa_fecha());
           ps.setDouble(3, gastosObj.getGa_monto());
           ps.setString(4, gastosObj.getGa_descripcion());
           ps.setString(5, gastosObj.getGa_factura());
           ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Ingresado con Exito");
       }catch(SQLException e) {
          JOptionPane.showMessageDialog(null, "Ingresado no con Exito");
    }
    }
    
    @Override
    public void modificarGastos(Object objG) {
        
         gastosObj = (Gastos) objG;
        
        try {
           
            
            SSQL = "UPDATE gastos SET ga_categoria=?,ga_fecha=?,ga_monto=?,ga_descripcion=?,ga_factura, where ga_codigo=?";
            
            ps = con.prepareStatement(SSQL);
            
            ps.setInt(1,gastosObj.getGa_categoria());
            ps.setString(2, gastosObj.getGa_fecha());
            ps.setDouble(3, gastosObj.getGa_monto());
            ps.setString(4, gastosObj.getGa_descripcion());
            ps.setString(5, gastosObj.getGa_factura());
           // ps.setInt(6, gastosObj.getGa_codigo());
            ps.executeUpdate();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Error en modificar " + e);
        }
               
    
    
    }

   @Override
    public void eliminarGastos(Object objG) {
        
        try {
            gastosObj = (Gastos) objG;
            SSQL ="delete from gastos where ga_codigo=?";
            ps = con.prepareStatement(SSQL);
            ps.setInt(1, gastosObj.getGa_codigo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en eliminar " + ex);
        }
        
        
     }

    
    public void filtrarGastos(Object objG) {
         filtroGastos = (FiltroGastos) objG;
   
        try {
           
            
            SSQL = "update filtro_Gastos set ga_fecha_inicio=?, ga_fecha_final=?, where Ga_idFiltro";
            ps = con.prepareStatement(SSQL);
            ps.setString(1, filtroGastos.getGa_fecha_inicio());
            ps.setString(2, filtroGastos.getGa_fecha_final());
            ps.setInt(3, filtroGastos.getGa_idFiltro());
            ps.executeUpdate();
                    
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha en formato XXXX-XX-XX ");
        }
    
    }
    
    
}
