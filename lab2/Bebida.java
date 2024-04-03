public class Bebida {
    public String Nombre;
    public double Precio;
    public int Cantidad;
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }
    public double getPrecio(){
        return Precio;
    }
    public void setPrecio(double precio){
        this.Precio = precio;
    }
    public int getCantidad(){
        return Cantidad;
    }
    public void setCantidad(int cantidad){
        this.Cantidad = cantidad;
    }
}
