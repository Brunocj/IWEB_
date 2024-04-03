public class Cliente {
    public String Nombre;
    public int DNI;
    public int Edad;
    public double Consumo;
    public int CantidadVacunas;
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }
    public int getDNI(){
        return DNI;
    }
    public void setDNI(int dni){
        this.DNI = dni;
    }
    public int getEdad(){
        return Edad;
    }
    public void setEdad(int edad){
        this.Edad = edad;
    }
    public double getConsumo(){
        return Consumo;
    }
    public void setConsumo(double consumo){
        this.Consumo = consumo;
    }
    public int getCantidadVacunas(){
        return CantidadVacunas;
    }
    public void setCantidadVacunas(int cantidadvacunas){
        this.CantidadVacunas = cantidadvacunas;
    }
}
