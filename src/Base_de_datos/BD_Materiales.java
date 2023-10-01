package Base_de_datos;

import Atributos.Material;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BD_Materiales {

    Conexion base=new Conexion();
    Material materiales;
    String sql = "";

    public void Registrar(Material mat) {
        
      
        materiales = mat;
        sql = "insert into materiales(tipomaterial, fechallegada, precio, metrostela)values('"
                + materiales.getTipoMaterial() + "' , '" + materiales.getFechaEntrega() + "' , '" + materiales.getPrecio()
                + "' , '" + materiales.getMetrosTela() + "')";
        base.ejecutarSentencia(sql);

    }
    
     public void modificar(Material mat)
    {
        materiales = mat;
        sql="update materiales set tipomaterial='"+ materiales.getTipoMaterial()+
                
                "' , fechallegada= '"+materiales.getFechaEntrega()+"' , precio= '"+materiales.getPrecio()+
                "' , metrostela= '"+materiales.getMetrosTela()+
                "' where id = " + 
                materiales.getId();  
        base.ejecutarSentencia(sql);
    }
    public void eliminar(Material mat)
    {
        materiales = mat;
        sql="delete from materiales where tipomaterial = '" +
                materiales.getTipoMaterial()+"'";  
        base.ejecutarSentencia(sql);
    }
    
    public Material consultarMaterial( Material mat)
    {
        try {
            materiales = mat;
            sql="select * from materiales where tipomaterial = '" +
                    materiales.getTipoMaterial()+"'";
            ResultSet consulta= base.consultar(sql);
            
            
            if (consulta.next()) {
                materiales.setId(consulta.getString("id"));
                
                materiales.setTipoMaterial(consulta.getString("tipomaterial"));
                materiales.setFechaEntrega(consulta.getString("fechallegada"));
                materiales.setPrecio(consulta.getString("precio"));
                materiales.setMetrosTela(consulta.getString("metrostela"));
            }else{
                materiales.setId("");
                materiales.setTipoMaterial("");
                materiales.setFechaEntrega("");
                materiales.setPrecio("");
                materiales.setMetrosTela("");
                JOptionPane.showMessageDialog(null, "El material no existe");
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SELECT CON PROBLEMAS");
        }
        return materiales;
    }
    
}
