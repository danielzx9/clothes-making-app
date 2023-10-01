package Base_de_datos;

import Atributos.Venta;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BD_Ventas {

    Conexion base= new Conexion();;
    Venta ventas;
    String sql = "";

    public void Registrar(Venta vent) {
       

        ventas = vent;
        sql = "insert into ventas(nombre, cedula, telefono, fechallegada, tipoproducto, tipotela, talla, abono, fechasalida, totalpagar)values('"
                + ventas.getNombre() + "' , '" + ventas.getCedula()
                + "' , '" + ventas.getTelefono() + "' , '" + ventas.getFechaLLegada()
                + "' , '" + ventas.getTipoProducto() + "' , '" + ventas.getTipoTela()
                + "' , '" + ventas.getTalla() + "' , '" + ventas.getAbono()
                + "' , '" + ventas.getFechaSalida() + "' , '" + ventas.getTotalPagar() + "')";
        base.ejecutarSentencia(sql);

    }
    
    public void modificar(Venta vent)
    {
        ventas = vent;
        sql="update ventas set nombre='"+ ventas.getNombre()+"', "
                + "cedula = '"+ventas.getCedula()
                +"' , telefono= '"+ventas.getTelefono()+"' , fechallegada= '"+ventas.getFechaLLegada()+
                "' , tipoproducto= '"+ventas.getTipoProducto()+"' , tipotela= '"+ventas.getTipoTela()+
                "' , talla= '"+ventas.getTalla()+"' , abono= '"+ventas.getAbono()+
                "' , fechasalida= '"+ventas.getFechaSalida()+"' , totalpagar= '"+ventas.getTotalPagar()+
                "' where id = " + 
                ventas.getId();  
        base.ejecutarSentencia(sql);
    }
    public void eliminar(Venta vent)
    {
        ventas = vent;
        sql="delete from ventas where cedula = " +
                ventas.getCedula();  
        base.ejecutarSentencia(sql);
    }
    
    public Venta consultarVenta( Venta vent)
    {
        try {
            ventas = vent;
            sql="select * from ventas where cedula = '" +
                    ventas.getCedula()+"'";
            ResultSet consulta= base.consultar(sql);
            
            if (consulta.next()) {
                ventas.setId(consulta.getString("id"));
                ventas.setNombre(consulta.getString("nombre"));
                ventas.setCedula(consulta.getString("cedula"));
                ventas.setTelefono(consulta.getString("telefono"));
                ventas.setFechaLLegada(consulta.getString("fechallegada"));
                ventas.setTipoProducto(consulta.getString("tipoproducto"));
                ventas.setTipoTela(consulta.getString("tipotela"));
                ventas.setTalla(consulta.getString("talla"));
                ventas.setAbono(consulta.getString("abono"));
                ventas.setFechaSalida(consulta.getString("fechasalida"));
                ventas.setTotalPagar(consulta.getString("totalpagar"));
                
            }else{
                ventas.setId("");
                ventas.setNombre("");
                ventas.setCedula("");
                ventas.setTelefono("");
                ventas.setFechaLLegada("");
                ventas.setTipoProducto("");
                ventas.setTipoTela("");
                ventas.setTalla("");
                ventas.setAbono("");
                ventas.setFechaSalida("");
                ventas.setTotalPagar("");
                JOptionPane.showMessageDialog(null, "No esta registrado");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SELECT CON PROBLEMAS");
        }
        return ventas;
    }
}
