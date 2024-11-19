package methods.deleteRegister;

import entityRepository.Subject;
import entityRepository.Student;
import entityRepository.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteEntity {
    private ArrayList<Student> studentList;
    private ArrayList<Teacher> teacherList;

    public DeleteEntity(ArrayList<Student> studentList, ArrayList<Teacher> teacherList) {
        this.studentList = studentList;
        this.teacherList = teacherList;
    }

    // Eliminar un estudiante por DNI
    public void deleteStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No hay registros de estudiantes para eliminar.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del estudiante a eliminar: ");
        int dni = scanner.nextInt();

        Student studentToRemove = null;
        for (Student student : studentList) {
            if (student.getDni() == dni) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            System.out.println("Estudiante con DNI " + dni + " eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún estudiante con el DNI ingresado.");
        }
    }

    // Eliminar un profesor (Teacher) por DNI
    public void deleteTeacher() {
        if (teacherList.isEmpty()) {
            System.out.println("No hay registros de profesores para eliminar.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del profesor a eliminar: ");
        int dni = scanner.nextInt();

        Teacher teacherToRemove = null;
        for (Teacher teacher : teacherList) {
            if (teacher.getDni() == dni) {
                teacherToRemove = teacher;
                break;
            }
        }

        if (teacherToRemove != null) {
            teacherList.remove(teacherToRemove);
            System.out.println("Profesor con DNI " + dni + " eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún profesor con el DNI ingresado.");
        }
    }

    // Eliminar asignación de materia (por DNI de profesor o estudiante)
    public void deleteSubjectAssignment() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Desea eliminar la asignación de un estudiante o un profesor? (E/P): ");
        char choice = scanner.next().toUpperCase().charAt(0);

        if (choice == 'E') {
            if (studentList.isEmpty()) {
                System.out.println("No hay registros de estudiantes para modificar asignaciones.");
                return;
            }
            System.out.print("Ingrese el DNI del estudiante: ");
            int dni = scanner.nextInt();

            for (Student student : studentList) {
                if (student.getDni() == dni) {
                    student.clearSubjects(); // Elimina todas las asignaciones de materias
                    System.out.println("Asignaciones de materias eliminadas para el estudiante con DNI " + dni + ".");
                    return;
                }
            }
            System.out.println("No se encontró ningún estudiante con el DNI ingresado.");
        } else if (choice == 'P') {
            if (teacherList.isEmpty()) {
                System.out.println("No hay registros de profesores para modificar asignaciones.");
                return;
            }
            System.out.print("Ingrese el DNI del profesor: ");
            int dni = scanner.nextInt();

            for (Teacher teacher : teacherList) {
                if (teacher.getDni() == dni) {
                    teacher.clearSubjects(); // Elimina todas las asignaciones de materias
                    System.out.println("Asignaciones de materias eliminadas para el profesor con DNI " + dni + ".");
                    return;
                }
            }
            System.out.println("No se encontró ningún profesor con el DNI ingresado.");
        } else {
            System.out.println("Opción no válida. Por favor ingrese 'E' o 'P'.");
        }
    }

    // Eliminar todos los registros con confirmación
    public void deleteAll() {
        if (studentList.isEmpty() && teacherList.isEmpty()) {
            System.out.println("No hay registros en la base de datos para eliminar.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("¡ATENCIÓN! ESTA ACCIÓN ELIMINARÁ TODOS LOS REGISTROS.\n¿Está seguro de continuar? (SI/NO): ");
        String confirmation = scanner.next().toUpperCase();

        if ("SI".equals(confirmation)) {
            studentList.clear();
            teacherList.clear();
            System.out.println("Todos los registros han sido eliminados exitosamente.");
        } else {
            System.out.println("Eliminación cancelada. Los registros permanecen intactos.");
        }
    }
}