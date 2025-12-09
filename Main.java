public class Main {
    public static void main(String[] args) {

        Cooperativa coop = new Cooperativa(1, "Biosur", "Av. Central 100");

        Ruta ruta = coop.CrearRuta(50, "2025-12-08");
        ruta.CrearParada(1, "Orompello 324");
        ruta.CrearParada(2, "Obispo Salas 445");

        Conductor conductor = new Conductor(1, "Sigma boy", "Camión negro");
        conductor.asignarRuta(ruta);

        System.out.println(" Ruta asignada al conductor:");

        Parada p;
        while ((p = conductor.SiguienteDireccion()) != null) {
            System.out.println("Próxima parada: " + p.GetDireccion());
            p.Visitado();
            System.out.println("Parada atendida.\n");
        }

        System.out.println("Ruta completada.\n");

        Solicitud s = new Solicitud(200, "2025-12-08", "Calle 10 #22", "Pendiente", 14.5);
        Recibo r = new Recibo(500, "2025-12-09", "Retiro completado");
        s.asignarRecibo(r);

        System.out.println("Solicitud creada y recibo asignado.");
    }
}
