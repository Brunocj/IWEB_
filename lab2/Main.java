import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        ArrayList<Cliente> ListaClientes = new ArrayList<>();
        ArrayList<Bebida> ListaBebida = new ArrayList<>();
        Cliente cliente1 = null;
        while(cont){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("|                   Menu                     |");
            System.out.println("| 1<- Registrar nuevo cliente                |");
            System.out.println("| 2<- Buscar detalle del cliente por DNI     |");
            System.out.println("| 3<- Añadir bebida del cliente              |");
            System.out.println("| 4<- Añadir nueva bebida                    |");
            System.out.println("| 5<- Salir                                  |");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.print("Ingrese la opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1:{
                    cliente1 = new Cliente();
                    System.out.print("Registrar nuevo cliente");
                    System.out.print("\nIngrese el nombre del cliente: ");
                    String Nombre = scanner.nextLine();
                    while(true){
                        if(Nombre != null){
                            cliente1.setNombre(Nombre);
                            break;
                        }
                        else{
                            System.out.println("Tiene que colocar un nombre");
                        }
                    }
                    while(true){
                        System.out.print("Ingrese el dni del cliente: ");
                        int DNIngresado = scanner.nextInt();
                        if(String.valueOf(DNIngresado).length() == 8 && DNIngresado != 00000000){
                            cliente1.setDNI(DNIngresado);
                            break;
                        }
                        else{
                            System.out.print("Datos ingresados incorrectos");
                        }
                    }
                    while(true){
                        System.out.print("Ingrese la edad del cliente(tiene que ser mayor de edad): ");
                        int edad = scanner.nextInt();
                        if(edad>17){
                            cliente1.setEdad(edad);
                            break;
                        }
                        else{
                            System.out.print("Datos incorrectos");
                        }
                    }
                    while(true){
                        System.out.print("Ingrese la cantidad de vacunas de " + cliente1.getNombre() + ": ");
                        int cantVacunas = scanner.nextInt();
                        if(cantVacunas > 2){
                            cliente1.setCantidadVacunas(cantVacunas);
                            break;
                        }
                        else{
                            System.out.println("Cantidad de vacunas insuficientes para poder aceder al local");
                        }
                    }
                    System.out.print("Cliente registrado satisfactoriemente, su odigo es " + cliente1.getDNI() + "\n");
                    cliente1.setConsumo(40.0);
                    ListaClientes.add(cliente1);
                    break;
                }
                case 2:{
                    System.out.println("Buscar detalle del cliente con DNI");
                    System.out.print("Ingrese el DNI del liente que quiere buscar: ");
                    int DNIngresado = scanner.nextInt();
                    if(String.valueOf(DNIngresado).length() != 8){
                        System.out.print("Datos ingresados incorrectos\n");
                    }
                    else{
                        int encontrado = 0;
                        for(Cliente cli: ListaClientes)
                            if(cli.getDNI() == DNIngresado){
                                System.out.println("Se encontró el cliente, sus datos son los siguientes");
                                System.out.println("Nombre: " + cli.getNombre());
                                System.out.println("DNI: " + cli.getDNI());
                                System.out.println("Edad: " + cli.getEdad());
                                System.out.println("Consumo: " + cli.getConsumo());
                                System.out.println("Cantidad de vacunas: " + cli.getCantidadVacunas());
                                encontrado = 1;
                            }
                        if(encontrado == 0){
                            System.out.println("El cliente no se encuentra registrado");    
                        }
                    }
                    break;   
                }
                case 3:{
                    System.out.println("Añadir bebida a cliente");
                    System.out.print("Indique el codigo(DNI) del clinte que desea comprar la bebida: ");
                    int DNIngresado = scanner.nextInt();
                    if(String.valueOf(DNIngresado).length() != 8){
                        System.out.print("Datos incorrectos\n");
                    }
                    else{
                        int encontrado = 0;
                        for(Cliente cli : ListaClientes){
                            if(cli.getDNI() == DNIngresado){
                                encontrado = 1;
                                int i = 1;
                                System.out.println("Se encuentran disponibles las siguientes bebidas:");
                                for(Bebida b : ListaBebida){
                                    if(b.getCantidad() > 0){
                                        System.out.println(i + ") " + b.getNombre() + " : S/ " + b.getPrecio());
                                        i++;
                                    }
                                }
                                System.out.print("Ingrese el numero de bebida a agregar: ");
                                Bebida bebidaIngresada = ListaBebida.get(scanner.nextInt() -1);
                                bebidaIngresada.setCantidad(bebidaIngresada.getCantidad()-1);
                                cli.setConsumo(cli.getConsumo() + bebidaIngresada.getPrecio());
                                break;
                            }
                        }
                        if(encontrado == 0){
                            System.out.println("El DNI no se encuentra registrado");
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("Añadir nueva bebida");
                    Bebida Bebida = new Bebida();
                    System.out.print("Ingrese el nombre de la bebida: ");
                    Bebida.setNombre(scanner.nextLine());
                    System.out.print("Ingrese el precio de " + Bebida.getNombre() + ": ");
                    Bebida.setPrecio(scanner.nextDouble());
                    System.out.print("Ingrese el stock: ");
                    Bebida.setCantidad(scanner.nextInt());
                    System.out.println("Se agrego la bebida correctamente");
                    ListaBebida.add(Bebida);
                    //Crear lista de bebidas
                    break;
                }
                case 5:{
                    System.out.println("Process finished with exit code 0");
                    cont = false;
                    break;
                }
                default:{
                    System.out.println("Ingrese una opción válida");
                }
            }
        }
        scanner.close();
    }
}
