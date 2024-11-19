package methods.readRegister;

import entityRepository.Student;
import entityRepository.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadEntity {

    // Método para leer los datos de un alumno por DNI
    public void readStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el DNI del alumno para buscar: ");
        int dni = scanner.nextInt();

        // Buscar el estudiante en la lista
        Student student = findStudentByDNI(students, dni);

        if (student != null) {
            // Mostrar información del estudiante
            System.out.println("Datos del alumno encontrado:");
            System.out.println("DNI: " + student.getDni());
            System.out.println("Nombre: " + student.getNombre() + " " + student.getApellido());
            System.out.println("Fecha de Nacimiento: " + student.getFechaNacimiento());
            System.out.println("Dirección: " + student.getDireccion());
            System.out.println("Año de cursado: " + student.getNivelCarrera());
            System.out.println("Materias asignadas:");
            if (!student.asignarMaterias(student.getNivelCarrera()).isEmpty()) {
                student.asignarMaterias(student.getNivelCarrera())
                        .forEach(materia -> System.out.println("- " + materia));
            } else {
                System.out.println("No tiene materias asignadas.");
            }
        } else {
            // Manejo de caso si no se encuentra
            System.out.println("¡Error! El alumno con DNI " + dni + " no se encuentra registrado.");
        }
    }

    // Método para leer los datos de un profesor por DNI
    public void readTeacher(ArrayList<Teacher> teachers) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el DNI del profesor para buscar: ");
        int dni = scanner.nextInt();

        // Buscar el profesor en la lista
        Teacher teacher = findTeacherByDNI(teachers, dni);

        if (teacher != null) {
            // Mostrar información del profesor
            System.out.println("Datos del profesor encontrado:");
            System.out.println("DNI: " + teacher.getDni());
            System.out.println("Nombre: " + teacher.getNombre() + " " + teacher.getApellido());
            System.out.println("Fecha de Nacimiento: " + teacher.getFechaNacimiento());
            System.out.println("Dirección: " + teacher.getDireccion());
            System.out.println("Materias que enseña:");
            // Se pueden añadir métodos futuros para asignar materias al profesor.
            System.out.println("No se implementaron materias específicas para profesores.");
        } else {
            // Manejo de caso si no se encuentra
            System.out.println("¡Error! El profesor con DNI " + dni + " no se encuentra registrado.");
        }
    }

    // Método para buscar un alumno por DNI en la lista
    private Student findStudentByDNI(ArrayList<Student> students, int dni) {
        for (Student student : students) {
            if (student.getDni() == dni) {
                return student;
            }
        }
        return null;
    }

    // Método para buscar un profesor por DNI en la lista
    private Teacher findTeacherByDNI(ArrayList<Teacher> teachers, int dni) {
        for (Teacher teacher : teachers) {
            if (teacher.getDni() == dni) {
                return teacher;
            }
        }
        return null;
    }
}
