
package Base_de_datos;

import Atributos.Usuario;
import Interfaces.IN_Pagina_principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexion {
    private String servidor;
    private String usuario;
    private String password;
    private String url;
    private String basedatos;
    private Connection conexion; //para establecer conexion
    private Statement sentencia; //para las sentencias insert delete update
    private ResultSet consulta;  //pra usar le select

    public Conexion() {
        servidor = "127.0.0.1";
        usuario = "root";
        password = "";
        basedatos= "base_de_datos";
        url = "jdbc:mysql://" + servidor + "/" + basedatos;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("EL DRIVER NO EXISTE");
        } catch (SQLException ex) {
            System.out.println("LA BASE DE DATOS NO EXISTE");
        }
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("NO SE PUDO CERRAR LA CONEXION ");
        }
    }

    public void ejecutarSentencia(String sql) {
        try {
            sentencia = conexion.createStatement();
            if (sentencia.execute(sql));
            {
                JOptionPane.showMessageDialog(null, " OPERACION EXITOSA ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "LA SENTENCIA ESTA PAILAS " + sql);
        }
    }
    
    public ResultSet consultar(String sql)
    {
        try 
        {
           
            sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            return resultado;

        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "LA SENTENCIA ESTA PAILAS " + sql);
        }
        return null;
    }
    public ResultSet IniciarSesion(Usuario usu) {
        String nick, contra;
        nick = usu.getNombre();
        contra = usu.getContraseña();

        //Statement stmt;
        //ResultSet rs;
        try {
            sentencia = conexion.createStatement();
            consulta = sentencia.executeQuery("SELECT * FROM usuario WHERE(nombre='" + nick + "' and contraseña='" + contra + "' ) ");

            if (consulta != null) {
                if (consulta.next()) {

                    JOptionPane.showMessageDialog(null, "Usuario correcto");
                    IN_Pagina_principal ins1 = new IN_Pagina_principal();
                    ins1.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña\nIncorrecto.");
                }
            }
        } catch (SQLException e) {

        }
        return null;

    }


    
}

