public class ControlMascota {
    public float ServicioMascota(Mascota mascota, Servicio servicio){
        return (servicio.getCostoBase()) +(servicio.getCostoBase())*(mascota.getTamano())/mascota.getPeso();

    }
}
