package entityRepository;

import java.util.ArrayList;

public class Student {
    private int dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String direccion;
    private int nivelCarrera;
    private ArrayList<Subject> asignacionMateria;

    public Student(int dni, String nombre, String apellido, String fechaNacimiento, String direccion, int nivelCarrera){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.nivelCarrera = nivelCarrera;
        this.asignacionMateria = asignarMaterias(nivelCarrera);
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

    public int getNivelCarrera() {
        return nivelCarrera;
    }

    public void setNivelCarrera(int nivelCarrera){
        this.nivelCarrera = nivelCarrera;
    }

    //Método para asignar las materias según el año de cursado del alumno
    public ArrayList<Subject> asignarMaterias(int nivelCarrera) {
        ArrayList<Subject> asignarMateria = new ArrayList<>();

        if (nivelCarrera == 1) {
            asignarMateria.add(Subject.PRACTICAS_PROFESIONALIZANTES_I);
            asignarMateria.add(Subject.CIENCIA_TECNOLOGIA_SOCIEDAD);
            asignarMateria.add(Subject.ALGEBRA);
            asignarMateria.add(Subject.ALGORITMOS_ESTRUCTURAS_DE_DATOS_I);
            asignarMateria.add(Subject.ANALISIS_MATEMATICO_I);
            asignarMateria.add(Subject.ARQUITECTURA_DE_COMPUTADORAS);
            asignarMateria.add(Subject.INGLES_I);
            asignarMateria.add(Subject.SISTEMAS_ORGANIZACIONES);
        } else if (nivelCarrera == 2) {
            asignarMateria.add(Subject.PRACTICAS_PROFESIONALIZANTES_II);
            asignarMateria.add(Subject.ALGORITMOS_ESTRUCTURAS_DE_DATOS_II);
            asignarMateria.add(Subject.INGENIERIA_DE_SOFTWARE_I);
            asignarMateria.add(Subject.ANALISIS_MATEMATICO_II);
            asignarMateria.add(Subject.INGLES_II);
            asignarMateria.add(Subject.BASES_DE_DATOS);
            asignarMateria.add(Subject.ESTADISTICA);
            asignarMateria.add(Subject.SISTEMAS_OPERATIVOS);
        } else if (nivelCarrera == 3) {
            asignarMateria.add(Subject.PRACTICAS_PROFESIONALIZANTES_III);
            asignarMateria.add(Subject.SEMINARIO_DE_ACTUALIZACION);
            asignarMateria.add(Subject.ASPECTOS_LEGALES_DE_LA_PROFESION);
            asignarMateria.add(Subject.REDES_Y_COMUNICACIONES);
            asignarMateria.add(Subject.ALGORITMOS_ESTRUCTURAS_DE_DATOS_III);
            asignarMateria.add(Subject.INGENIERIA_DE_SOFTWARE_II);
            asignarMateria.add(Subject.INGLES_III);
        } else {
            System.out.println("Ha ocurrido un error inesperado. La materia no ha podido ser asignada porque el año de cursado es inválido.");
        }
        return asignarMateria;
    }

    @Override
    public String toString() {
        return "Alumno [dni= " + dni + ", nombre=" + nombre + ", apellido=" + apellido +
                ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", Año que cursa= " + nivelCarrera;
    }
}