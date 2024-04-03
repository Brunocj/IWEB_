import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int bucleMenu = 1;
        Scanner scanner = new Scanner(System.in);
        List<Servicio> listaServicios = new ArrayList<>();
        Mascota mascota1 = new Mascota();
        while(bucleMenu == 1) {
            System.out.println("----------------------------------------");
            System.out.println("1) Registrar mascota");
            System.out.println("2) Registrar Servicios Generales");
            System.out.println("3) Registrar Servicio de Mascota");
            System.out.println("4) Total de mascotas en la veterinaria");
            System.out.println("5) Salir");
            System.out.println("----------------------------------------");
            System.out.print("Ingrese una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Registrar Mascota");
                    System.out.println("----------------------------------------");
                    System.out.println("Ingrese nombre: ");
                    mascota1.setNombre(scanner.nextLine());
                    System.out.println("Ingrese raza: ");
                    mascota1.setRaza(scanner.nextLine());
                    System.out.println("Ingrese edad: ");
                    mascota1.setEdad(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Ingrese genero: ");
                    mascota1.setGenero(scanner.nextLine());
                    System.out.println("Ingrese peso(kg): ");
                    mascota1.setPeso(Float.parseFloat(scanner.nextLine()));
                    System.out.println("Ingrese tamaño: ");
                    mascota1.setTamano(Float.parseFloat(scanner.nextLine()));
                    System.out.println("Ingrese nombre del dueño: ");
                    mascota1.setNombreDueno(scanner.nextLine());
                    System.out.println("Ingrese el correo: ");
                    mascota1.setCorreo(scanner.nextLine());
                    break;
                case 2:
                    Servicio servicio1 = new Servicio();
                    ControlServicio controlServicio = new ControlServicio();
                    System.out.println("Registrar Servicios");
                    controlServicio.registraServicio(servicio1);
                    listaServicios.add(servicio1);
                    break;
                case 3:
                    System.out.println("Registrar Servicio de Mascota");
                    System.out.println("----------------------------------------");
                    boolean contIservicio = true;
                    while(contIservicio) {
                        System.out.println("Ingrese el servicio");
                        String servicioi = scanner.nextLine();
                        List<String> listaServiciosStr = new ArrayList<>();
                        listaServiciosStr.add("Baño");
                        listaServiciosStr.add("Corte uñas");
                        listaServiciosStr.add("Consulta");
                        listaServiciosStr.add("Ecografia");
                        if(listaServiciosStr.contains(servicioi)) {
                            for (Servicio s : listaServicios) {
                                if (s.getTipo().equals(servicioi)) {
                                    ControlMascota controlMascota = new ControlMascota();
                                    float precio = controlMascota.ServicioMascota(mascota1, s);
                                    System.out.println("El servicio " + servicioi + " para " + mascota1.getNombre() + " tendrá un costo de " + String.valueOf(precio));
                                    contIservicio = false;
                                    break;
                                } else {
                                    System.out.println("Servicio no válido, intente nuevamente");
                                }
                            }
                        } else {
                            System.out.println("Servicio no válido, intente nuevamente");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Total de mascotas en la veterinaria: " + String.valueOf(mascota1.getContador()));
                    break;
                case 5:
                    System.out.println("----Cerrando el programa----");
                    bucleMenu = 0;
                    break;
                default:
                    System.out.print("La opción NO es válida, ingrese nuevamente: ");
            }
        }

        scanner.close();
    }
}