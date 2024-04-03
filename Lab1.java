import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
class Lab1{
    public static class Actividad{
        public String Nombre;
        public String Cargo;
        public int Horas;
        public int Diezmo;
    }
    public static class Estudiante{
     public String Nombre;
     public String Apellido;
     public Integer Codpucp;
     public String Email;
     public String Condicion;
     public int Edad;
     public int Sueldo;
     public int AñoEgreso;
     public Actividad NuevaActividad;
     public void actividad(){
        NuevaActividad = new Actividad();
        }
     }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Estudiante estudiante1 = new Estudiante();
        System.out.print("---------Bienvenidos al laboratorio 1------------\nIngrese su nombre: ");
        estudiante1.Nombre = scanner.nextLine();
        System.out.print("Ingrese su apellido: ");
        estudiante1.Apellido = scanner.nextLine();
        System.out.print("Ingrese su codigo PUCP: ");
        estudiante1.Codpucp = scanner.nextInt();
        System.out.print("Ingrese su mail PUCP: ");
        estudiante1.Email = scanner.nextLine();
        System.out.print("Ingrese su condicion (Alumno o Egresado): ");
        estudiante1.Condicion = scanner.nextLine();
        System.out.print("Ingrese su edad: ");
        estudiante1.Edad = scanner.nextInt();
        if (estudiante1.Condicion.equals("Egresado") || estudiante1.Condicion.equals("egresado")){
            System.out.print("Ingrese su sueldo: ");
            estudiante1.Sueldo = scanner.nextInt();
            System.out.print("Ingrese su año de egreso: ");
            estudiante1.AñoEgreso = scanner.nextInt();
        }
        else{
            estudiante1.Sueldo = 0;
        }
        System.out.println("---------Bienvenidos al laboratorio 1------------");
        System.out.print("Ingrese su codigo PUCP: ");
        int cod_ingresado = scanner.nextInt();
        if(cod_ingresado == estudiante1.Codpucp){
            System.out.print("Bienvenido, lord " + estudiante1.Nombre + " " + estudiante1.Apellido);
        }
        else{
            while(true){
                System.out.print("Codigo incorrecto, ingrese su codigo nuevamente: ");
                if(scanner.nextInt() == estudiante1.Codpucp){
                    System.out.print("Bienvenido, lord " + estudiante1.Nombre +" " + estudiante1.Apellido);
                    break;
                }
            }
        }
        estudiante1.actividad();
        System.out.println("\nEscoja una de las siguientes opciones:\nopción ( 1 ).- Regustrar actividad a la cual apoyaré\nopción ( 2 ).- Diagnóstico de apoyo\nopción ( 3 ).-Ver mi resumen\nopción ( 4 ).-Salir del menu");
        System.out.print("->Ingrese una opción: ");
        int opcion = scanner.nextInt();
        sanner.nextLine();
        switch(opcion){
            case 1:
                while (true) {
                    System.out.println("Registre la actividad la cual apoyará: ");
                    estudiante1.NuevaActividad.Nombre = scanner.nextLine();
                    List<String> ListaNombres = Arrays.asList("futsal", "voley", "4xjugo", "glotones", "basquet");
                    if(ListaNombres.contains(estudiante1.NuevaActividad.Nombre)){
                        break;
                    }
                    else{
                        System.out.println("***Ingrese un nombre de actividad correcto***");
                    }
                }
                while (true){
                    System.out.print("Ingrese su cargo (Barras o Jugar): ");
                    List<String> ListaCargos = Arrays.asList("barras", "Barras", "jugar", "Jugar");
                    estudiante1.NuevaActividad.Cargo = scanner.nextLine();
                    if(ListaCargos.contains(estudiante1.NuevaActividad.Cargo)){
                        break;
                    }
                    else{
                        System.out.println("***Ingrese un cargo correcto***");
                    }
                }
                System.out.print("Ingrese sus horas de apoyo a la fibra: ");
                estudiante1.NuevaActividad.Horas = scanner.nextInt();
                System.out.print("Ingrese su diezmo: ");
                estudiante1.NuevaActividad.Horas = scanner.nextInt();
                break;
            case 2:
                List<String> ListaCondiciones = Arrays.asList("Alumno", "alumno");
                if(ListaCondiciones.contains(estudiante1.Condicion)){
                    System.out.print("Usted es un alumno, apoyo con " + estudiante1.NuevaActividad.Diezmo + "soles, gracias por apoyar a la fibra");
                }
                else{
                    int suma_cifras = 0;
                    int codigo = estudiante1.Codpucp;
                    while(codigo > 0){
                        suma_cifras += codigo%10;
                        codigo /= 10;
                    }
                    double factor = estudiante1.Edad + suma_cifras;
                    double DiezmoDeseado = estudiante1.Sueldo * 0.1 + (2024 - estudiante1.AñoEgreso) * factor;
                    double diff = (DiezmoDeseado - estudiante1.NuevaActividad.Diezmo) / DiezmoDeseado * 100;
                    if(diff <= 10.0){
                        String msg = "Es un hincha de nacimiento, se agradece profundamente la donación realizada a la fibra de corazón";
                        System.out.println(msg);
                    }
                    else if (diff > 10.0 && diff <= 30.0){
                        String msg = "Diagnostico de la fibra: Usted Es un Hincha, la fibra está con usted y usted con la fibra";
                        System.out.println(msg);
                    }
                    else if (diff > 30.0 && diff <= 50.0){
                        String msg = "Diagnostico de la fibra: Usted Es un Hincha, la fibra está con usted y usted con la fibra";
                        System.out.println(msg);
                    }
                    else if (diff > 50.0 && diff <= 70.0){
                        String msg = "Diagnostico de la fibra: Usted Necesita encariñarse más con la fibra, sabemos que el proximo año le pondrá más apoyo";
                        System.out.println(msg);System.out.println(msg);
                    }
                    else if (diff > 70.0 && diff <= 99.9){
                        String msg = "Diagnostico de la fibra: Usted Es un pecho frío, pero se agradece la colaboración";
                        System.out.println(msg);
                    }
                    else{
                        String msg = "Diagnostico de la fibra: Usted No tiene comentarios, puesto que no apoyo a la fibra";
                        System.out.println(msg);
                    }
                }
                break;
            case 3:
                System.out.println("Nombre completo: " + estudiante1.Nombre + " " + estudiante1.Apellido);
                System.out.println("Edad: " + estudiante1.Edad);
                System.out.println("Codgo PUCP: " + estudiante1.Codpucp);
                System.out.println("Apoyo a la actividad de: " + estudiante1.NuevaActividad.Nombre + " como parte de " + estudiante1.NuevaActividad.Cargo);
                System.out.println("Ademas apoyo a la fibra con " + estudiante1.NuevaActividad.Horas + " horas semanales");
                break;
            case 4:
                break;
            default:
                System.out.println("No se ingreso una opcion valida");
        }
        scanner.close();
        /*listaEstudiantes.add(estudiante1);
        for(Estudiante estudiante: listaEstudiantes){
            System.out.println("Nombre: " + estudiante.Nombre);
            System.out.println("Apellido: " + estudiante.Apellido);
        }*/

        }
}