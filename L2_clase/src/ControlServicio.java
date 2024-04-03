import java.util.Scanner;

public class ControlServicio {
    Scanner scanner = new Scanner(System.in);
    public void registraServicio(Servicio servicio1){
        System.out.println("----------------------------------------");
        System.out.println("Ingrese el tipo de servicio:");
        servicio1.setTipo(scanner.nextLine());
        System.out.println("Ingrese el tiempo estimado (horas):");
        servicio1.setTiempoEstimado(scanner.nextLine());
        System.out.println("Ingrese el Costo Base (PEN):");
        servicio1.setCostoBase(Float.parseFloat(scanner.nextLine()));
    }
}
