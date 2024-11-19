package entityRepository;

public class Teacher {
    private int dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String direccion;

    public Teacher(int dni, String nombre, String apellido, String fechaNacimiento, String direccion){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Teacher [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido +
                ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + "]";
    }
}