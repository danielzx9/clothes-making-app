package Atributos;

public class Usuario {

    private String Nombre;
    private String Contraseña;
    private String ConfirmarContraseña;
    private String Email;
    private String Telefono;
    private String Tipo;
    private String Id;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getConfirmarContraseña() {
        return ConfirmarContraseña;
    }

    public void setConfirmarContraseña(String ConfirmarContraseña) {
        this.ConfirmarContraseña = ConfirmarContraseña;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
}
