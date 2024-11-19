import entityRepository.Teacher;
import methods.createRegister.CreateEntity;
import methods.readRegister.ReadEntity;
import methods.updateRegister.UpdateEntity;
import methods.deleteRegister.DeleteEntity;

import java.util.Scanner;

public class StudentManagerApp {
    private static final String optionErr = "La opción no es válida, por favor seleccione otra.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            String uiMenu = """
                        ===============================================
                        |               STUDENT MANAGER               |
                        ===============================================
                        |                                             |
                        | Seleccione una opción mediante su teclado:  |
                        |                                             |
                        | 1. Crear un registro                        |
                        | 2. Leer un registro                         |
                        | 3. Actualizar un registro                   |
                        | 4. Eliminar un registro                     |
                        | 5. Salir del programa                       |
                        |_____________________________________________|
                        """;
            System.out.print(uiMenu);

            // Leer la opción seleccionada
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            // Ejecutar acción según la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("Crear un registro:");
                    crearRegistro(scanner);
                    break;
                case 2:
                    System.out.println("Leer un registro:");
                    leerRegistro(scanner);
                    break;
                case 3:
                    System.out.println("Actualizar un registro:");
                    actualizarRegistro(scanner);
                    break;
                case 4:
                    System.out.println("Eliminar un registro:");
                    eliminarRegistro(scanner);
                    break;
                case 5:
                    System.out.println("Cerrando Sistema... Gracias por utilizar Student Manager.");
                    String author = """
                             ********************************************************************************
                             *                           STUDENT MANAGER v01                                *
                             ********************************************************************************
                             *      Mariano Maldonado                                                       *
                             *      { DEV</>CODE } Informatic Solutions                                     *
                             *      Linkedin: https://www.linkedin.com/in/mariano-maldonado-810847288/      *
                             *      Instagram: https://www.instagram.com/marianomaldonado.dev/              *
                             *      GitHub: https://github.com/MarianoMaldonado-dev                         *
                             *                                                                              *
                             ********************************************************************************
                            """;
                    System.out.println(author);
                    break;
                default:
                    System.out.println(optionErr);
            }

        } while (opcion != 5);

        scanner.close();
    }

    // Menú de opciones para crear un registro
    public static void crearRegistro(Scanner scanner) {
        System.out.print("""
                Seleccione la opción que desea crear:
                1. Alumno
                2. Profesor
                3. Asignar Materia
                """);
        int tipo = scanner.nextInt();
        scanner.nextLine();

        CreateEntity createEntity = new CreateEntity();

        switch (tipo) {
            case 1:
                createEntity.createStudent(); // Llama a cada método para crear un registro
                break;
            case 2:
                createEntity.createTeacher();
                break;
            case 3:
               // createEntity.createSubject(); // Si necesitas implementar este método, lo puedes hacer en la clase CreateEntity
                break;
            default:
                System.out.println(optionErr);
        }
    }

    // Menú de opciones para leer un registro
    public static void leerRegistro(Scanner scanner) {
        System.out.print("""
                Seleccione la opción que desea leer:
                1. Alumno
                2. Profesor
                3. Materia
                """);
        int tipo = scanner.nextInt();
        scanner.nextLine();

        ReadEntity readEntity = new ReadEntity();

        switch (tipo) {
            case 1:
                readEntity.readStudent(); // Llama a cada método para leer los registros
                break;
            case 2:
                readEntity.readTeacher();
                break;
            case 3:
               // readEntity.readSubject(); // Implementa este método en ReadEntity si aún no lo has hecho
                break;
            default:
                System.out.println(optionErr);
        }
    }

    // Menú de opciones para actualizar un registro
    public static void actualizarRegistro(Scanner scanner) {
        System.out.print("""
                Seleccione la opción que desea actualizar:
                1. Alumno
                2. Profesor
                3. Materia
                """);
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea

        UpdateEntity updateEntity = new UpdateEntity();

        switch (tipo) {
            case 1:
                updateEntity.updateStudent(); // El parámetro debe ser un objeto de tipo 'Student'
                break;
            case 2:
                updateEntity.updateTeacher(); // Lo mismo para el caso del profesor
                break;
            case 3:
               // updateEntity.updateSubject(); // Implementa este método en UpdateEntity si no está hecho
                break;
            default:
                System.out.println(optionErr);
        }
    }

    // Menú de opciones para eliminar un registro
    public static void eliminarRegistro(Scanner scanner) {
        System.out.print("""
                Seleccione la opción que desea eliminar:
                1. Alumno
                2. Profesor
                3. Materia
                4. Eliminar todos los registros
                """);
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea

        DeleteEntity deleteEntity = new DeleteEntity();

        switch (tipo) {
            case 1:
                deleteEntity.deleteStudent(); // Este método elimina un alumno
                break;
            case 2:
                deleteEntity.deleteTeacher(); // Este método elimina un profesor
                break;
            case 3:
               // deleteEntity.deleteSubject(); // Este método elimina una materia
                break;
            case 4:
                deleteEntity.deleteAll(); // Este método elimina todos los registros
                break;
            default:
                System.out.println(optionErr);
        }
    }
}