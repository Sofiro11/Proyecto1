package LPTH.usuarios;
// No es necesario importar resenia
import LPTH.modelo.Sistema;
import LPTH.modelo.learningPath;
import LPTH.actividades.Actividad;
import java.util.ArrayList;

public abstract class Usuario {
    private int idUsuario;
    private String nombre;
    private String email;
    private String password;
    private String fechaRegistro;
    private String tipo;
    private ArrayList<Resenia> resenias;
    private ArrayList<learningPath> learningPaths;
    private  boolean loggedOn = false;
    protected Sistema sistemaCentral;

    public Usuario(Sistema sistemaCentral ,int idUsuario, String nombre, String email, String contraseña, String fechaRegistro, String tipo) {
        this.sistemaCentral = sistemaCentral;
    	this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.password = contraseña;
        this.fechaRegistro = fechaRegistro;
        this.tipo = tipo;
        this.resenias = new ArrayList<>();
        this.learningPaths = new ArrayList<>();
        
    }

    public void crearResenia(Actividad actividad, String texto, int rating) {
    	Resenia resenia = new Resenia(texto, rating);
    	actividad.agregarResenia(resenia);
    }
    
    
    public boolean realizarLogIn(String email, String contrasenia) {
    	boolean logStatus = sistemaCentral.autenticarUsuario(email, contrasenia);
    	return logStatus;
    }

    public void Logout() {
    	this.loggedOn = false;
    }
    
    public ArrayList<learningPath> checkLearningPaths() {
		return learningPaths;
    	}

    public void resetPassword(String newPass) {
    	this.password = newPass;
}


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return password;
    }

    public void setContrasenia(String password) {
        this.password = password;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void agregarResenia(Resenia resenia) {
        this.resenias.add(resenia);
    }
    
    public ArrayList<Resenia> getResenias() {
        return resenias;
    }
}