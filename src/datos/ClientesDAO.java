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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Clientes;

/**
 *
 * @author Gabriel
 */
public class ClientesDAO implements IDAO_Clientes {

    Connection con = null;
    ArrayList<Clientes> lista = new ArrayList<>();
    Clientes clientesObj = null;
    PreparedStatement ps;
    ResultSet rs;
    private String SSQL;

    public ClientesDAO() {
        con = new Conexion().Conectar();
    }

    @Override
    public ArrayList listarClientes(String condicion) {
        try {
            SSQL = "Select * from clientes " + condicion;
            ps = con.prepareStatement(SSQL);
            rs = ps.executeQuery();
            while(rs.next()){
                clientesObj= new Clientes(
                rs.getInt("cli_codigo"),
                        rs.getString("cli_nombre"),
                        rs.getString("cli_apellido"),
                        rs.getString("cli_telefono"),
                        rs.getString("cli_direccion"),
                        rs.getString("cli_ruc")
                );
                lista.add(clientesObj);
                
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en listar "+e);
        }
        return null;
    }

    
    public void insertarCliente(Clientes c) {
                try {
            String ssql="INSERT INTO clientes (cli_nombre,cli_ruc,cli_telefono,cli_direccion) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(ssql);
            ps.setString(1, c.getCli_nombre());
            ps.setString(2, c.getCli_apellido());
            ps.setString(3, c.getCli_ruc());
            ps.setString(4, c.getCli_telefono());
            ps.setString(5, c.getCli_direccion());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ingresado con Exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    @Override
    public void modificarCliente(Object objMaterial) {

    }

    @Override
    public void eliminarCliente(Object objMaterial) {

    }

    @Override
    public void listarClientesComboBox(JComboBox cbxClientes) {
        try {
            SSQL="select a.cli_nombre,a.cli_ruc from clientes a order by a.cli_nombre asc";
            ps = con.prepareStatement(SSQL);
            rs = ps.executeQuery();
            cbxClientes.addItem("Seleccione..");
            while(rs.next()){
                cbxClientes.addItem(rs.getString("cli_nombre")+" - "+rs.getString("cli_ruc"));
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en listar combobox "+e);
        }
        
    }

    @Override
    public String Cliente(int i) {
        String a="select a.cli_nombre from clientes a where a.cli_codigo="+i;
        String nombre="";
        try {
            ps=con.prepareStatement(a);
            
            rs=ps.executeQuery();
            while(rs.next()){
                nombre=""+rs.getString("cli_nombre");
            }
            
            
            //JOptionPane.showMessageDialog(null, nombre);
            return nombre;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en filtrar el nombre");
        }
        return a;
    }

    @Override
    public void insertarCliente(Object objMaterial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

}
