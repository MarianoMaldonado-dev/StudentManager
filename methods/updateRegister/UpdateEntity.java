package methods.updateRegister;

import entityRepository.Student;
import entityRepository.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateEntity {

    // Método para actualizar los datos de un alumno de manera independiente
    public void updateStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el DNI del alumno a actualizar: ");
        int dni = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Buscar el alumno en la lista
        Student student = findStudentByDNI(students, dni);

        if (student != null) {
            System.out.println("¿Qué dato desea actualizar?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Fecha de Nacimiento");
            System.out.println("4. Dirección");
            System.out.println("5. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre del alumno: ");
                    String nombre = scanner.nextLine();
                    if (!nombre.isEmpty()) {
                        student.setNombre(nombre); // Actualizar solo si el campo no está vacío
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo apellido del alumno: ");
                    String apellido = scanner.nextLine();
                    if (!apellido.isEmpty()) {
                        student.setApellido(apellido); // Actualizar solo si el campo no está vacío
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la nueva fecha de nacimiento del alumno (Formato esperado: AAAA-MM-DD): ");
                    String fechaNacimiento = scanner.nextLine();
                    if (!fechaNacimiento.isEmpty()) {
                        student.setFechaNacimiento(fechaNacimiento); // Actualizar solo si el campo no está vacío
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la nueva dirección del alumno: ");
                    String direccion = scanner.nextLine();
                    if (!direccion.isEmpty()) {
                        student.setDireccion(direccion); // Actualizar solo si el campo no está vacío
                    }
                    break;
                case 5:
                    return; // Salir sin realizar cambios
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("El registro del alumno fue actualizado exitosamente.");
        } else {
            System.out.println("¡Error! El alumno con DNI " + dni + " no se encuentra registrado.");
        }
    }

    // Método para actualizar los datos de un profesor de manera independiente
    public void updateTeacher(ArrayList<Teacher> teachers) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el DNI del profesor a actualizar: ");
        int dni = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Buscar el profesor en la lista
        Teacher teacher = findTeacherByDNI(teachers, dni);

        if (teacher != null) {//TODO: Agregar la funcion para actualizar fecha de nacimiento y direccion
            System.out.println("¿Qué dato desea actualizar?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre del profesor: ");
                    String nombre = scanner.nextLine();
                    if (!nombre.isEmpty()) {
                        teacher.setNombre(nombre); // Actualizar solo si el campo no está vacío
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo apellido del profesor: ");
                    String apellido = scanner.nextLine();
                    if (!apellido.isEmpty()) {
                        teacher.setApellido(apellido); // Actualizar solo si el campo no está vacío
                    }
                    break;
                case 3:
                    return; // Salir sin realizar cambios
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("El registro del profesor fue actualizado exitosamente.");
        } else {
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
