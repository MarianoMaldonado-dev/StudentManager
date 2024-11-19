package methods.createRegister;

import entityRepository.Student;
import entityRepository.Teacher;
import entityRepository.Subject;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateEntity {

    //Impplementacion del array para Alumno
    public void createStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el DNI del alumno sin espacios ni puntos: ");
        int dni = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la fecha de nacimiento del alumno (Formato esperado: DD-MM-AAAA): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Ingrese la dirección del alumno: ");
        String direccion = scanner.nextLine();

        System.out.print("¿En qué año se encuentra cursando el alumno?: ");
        int nivelCarrera = scanner.nextInt();

        Student student = new Student(dni, nombre, apellido, fechaNacimiento, direccion, nivelCarrera);

        students.add(student);
        System.out.println("El alumno " + student + " fue registrado correctamente.");
    }

    // Impplementacion del array para profesor
    public void createTeacher(ArrayList<Teacher> teachers) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el DNI del profesor sin espacios ni puntos: ");
        int dni = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del profesor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del profesor: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la fecha de nacimiento del profesor (Formato esperado: DD-MM-AAAA): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Ingrese la dirección del profesor: ");
        String direccion = scanner.nextLine();

        Teacher teacher = new Teacher(dni, nombre, apellido, fechaNacimiento, direccion);

        teachers.add(teacher);
        System.out.println("El profesor " + teacher + " fue registrado correctamente.");
    }

    /* Se pasa como parámetro el ArrayList Student a un metodo assignSubject
    para utilizar los Enums y asignar las materias correspondientes por DNI
     */
    public void assignSubject(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el DNI del alumno al que le quiere asignar las materias: ");
        int dni = scanner.nextInt();

        // Buscar al alumno por DNI
        Student student = null;
        for (Student alumno : students) {
            if (alumno.getDni() == dni) {
                student = alumno;
                break;
            }
        }

        if (student == null) {
            System.out.println("¡Error! El alumno con dni " + dni + " no se encuentra o no ha sido registrado. Verifique los datos ingresados.");
            return;
        }

        // Asignación de las materias según el año que cursa el alumno
        student.asignarMaterias(student.getNivelCarrera());
        System.out.println("Las materias han sido asignadas correctamente al alumno " + student);
    }
}