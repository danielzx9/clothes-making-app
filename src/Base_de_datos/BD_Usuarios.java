package Base_de_datos;

import Atributos.Usuario;
import Interfaces.IN_Pagina_principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BD_Usuarios {

    Conexion base1;
    Usuario usuario;
    String sql = "";

    public void Registrar(Usuario usu) {
        base1 = new Conexion();
        
        usuario = usu;
        sql = "insert into usuario (Nombre, Contraseña, Confirmarcontraseña, Email, Telefono, Tipo)values('"
                + usuario.getNombre() + "' , '" + usuario.getContraseña()
                + "' , '" + usuario.getConfirmarContraseña() + "' , '" + usuario.getEmail()
                + "' , '" + usuario.getTelefono() + "' , '" + usuario.getTipo() + "')";
        base1.ejecutarSentencia(sql);
    }
    
    public void modificar(Usuario usu)
    {
        usuario = usu;
        sql="update usuario set nombre='"+ usuario.getNombre()+"', "
                + "contraseña = '"+usuario.getContraseña()
                +"' , confirmarcontraseña= '"+usuario.getConfirmarContraseña()+"' , email= '"+usuario.getEmail()+
                "' , telefono= '"+usuario.getTelefono()+"' , tipo= '"+usuario.getTipo()+
                "' where id = " + 
                usuario.getId();  
        base1.ejecutarSentencia(sql);
    }
    public void eliminar(Usuario usu)
    {
        usuario = usu;
        sql="delete from usuario where id = " +
                usuario.getId();  
        base1.ejecutarSentencia(sql);
    }
    
    public Usuario consultarDocente( Usuario usu)
    {
        try {
            usuario = usu;
            sql="select * from usuario where id = " +
                    usuario.getId();
            ResultSet consulta= base1.consultar(sql);
            
            while (consulta.next()) {
                usuario.setNombre(consulta.getString("nombre"));
                usuario.setContraseña(consulta.getString("contraseña"));
                usuario.setConfirmarContraseña(consulta.getString("confirmarcontraseña"));
                usuario.setEmail(consulta.getString("email"));
                usuario.setTelefono(consulta.getString("telefono"));
                usuario.setTipo(consulta.getString("tipo"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SELECT CON PROBLEMAS");
        }
        return usuario;
    }
    
    /*public Usuario IniciarSesion(Usuario usu) {
        try {
            usuario = usu;
            sql = "select * from usuario where Nombre = "
                    + usuario.getNombre()+ "and Contraseña ="+ usuario.getContraseña()+"";
            ResultSet consulta = base1.consultar(sql);

            if(sql!=null){
                while(consulta.next()){
                    
                        JOptionPane.showMessageDialog(null, "USUARIO CORRECTO");
                        IN_Pagina_principal ins=new IN_Pagina_principal();
                        ins.setVisible(true);
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña\nIncorrecto.");
                }
            } catch (SQLException ex) {
            Logger.getLogger(BD_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

 
        return usuario;
    }*/

}
