package Base_de_datos;

import Atributos.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BD_Proveedores {

    Conexion base= new Conexion();;
    Proveedor proveedores;
    String sql = "";

    public void Registrar(Proveedor pro) {
        

        proveedores = pro;
        sql = "insert into proveedores(nombreorg, nombreprov, telefono, producto, precio)values('"
                + proveedores.getNombreOrg() + "' , '" + proveedores.getNombreProv()
                + "' , '" + proveedores.getTelefono() + "' , '" + proveedores.getProducto()
                + "' , '" + proveedores.getPrecio() + "')";
        base.ejecutarSentencia(sql);

    }
    
    public void modificar(Proveedor pro)
    {
        proveedores = pro;
        sql="update proveedores set nombreorg='"+ proveedores.getNombreOrg()+"', "
                + "nombreprov = '"+proveedores.getNombreProv()
                +"' , telefono= '"+proveedores.getTelefono()+"' , producto= '"+proveedores.getProducto()+
                "' , precio= '"+proveedores.getPrecio()+
                "' where id = " + 
                proveedores.getId();  
        base.ejecutarSentencia(sql);
    }
    public void eliminar(Proveedor pro)
    {
        proveedores = pro;
        sql="delete from proveedores where nombreprov = '" +
                proveedores.getNombreProv()+"'";  
        base.ejecutarSentencia(sql);
    }
    
    public Proveedor consultarProveedor( Proveedor pro)
    {
        try {
            proveedores = pro;
            sql="select * from proveedores where nombreprov = '" +
                    proveedores.getNombreProv()+"'";
            ResultSet consulta= base.consultar(sql);
            
            if (consulta.next()) {
                proveedores.setId(consulta.getString("id"));
                proveedores.setNombreOrg(consulta.getString("nombreorg"));
                proveedores.setNombreProv(consulta.getString("nombreprov"));
                proveedores.setTelefono(consulta.getString("telefono"));
                proveedores.setProducto(consulta.getString("producto"));
                proveedores.setPrecio(consulta.getString("precio"));
                
            }else{
                proveedores.setId("");
                proveedores.setNombreOrg("");
                proveedores.setNombreProv("");
                proveedores.setTelefono("");
                proveedores.setProducto("");
                proveedores.setPrecio("");
                JOptionPane.showMessageDialog(null, "El proveedor no existe");
                
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SELECT CON PROBLEMAS");
        }
        return proveedores;
    }
}
