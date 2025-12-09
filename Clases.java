import java.util.ArrayList;
import java.util.List;

class Recibo {
    private int id;
    private String fechaEmision;
    private String detalles;

    public Recibo(int id, String fechaEmision, String detalles) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.detalles = detalles;
    }
}

class Solicitud {
    private int id;
    private String fecha;
    private String direccion;
    private String estado;
    private double peso;

    private Recibo recibo; // comp 1...1

    public Solicitud(int id, String fecha, String direccion, String estado, double peso) {
        this.id = id;
        this.fecha = fecha;
       	this.direccion = direccion;
        this.estado = estado;
        this.peso = peso;
    }

    public String GetDireccion() {
        return direccion;
    }

    public void asignarRecibo(Recibo r) {
        this.recibo = r;
    }
}

class Conductor {
    private int id;
    private String nombre;
    private String vehiculo;

    private Ruta ruta; // relacion 1..1

    public Conductor(int id, String nombre, String vehiculo) {
        this.id = id;
        this.nombre = nombre;
        this.vehiculo = vehiculo;
    }

    public void asignarRuta(Ruta r) {
        this.ruta = r;
    }

    public Parada SiguienteDireccion() {
        if (ruta == null) return null;
        return ruta.SiguienteParada();
    }
}

class Cooperativa {
    private int id;
    private String nombre;
    private String direccion;

    public Cooperativa(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Ruta CrearRuta(int idRuta, String fecha) {
        return new Ruta(idRuta, fecha);
    }
}

class Vecino {
    private String nombre;
    private String direccion;
    private boolean verificado;

    public Vecino(String nombre, String direccion, boolean verificado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.verificado = verificado;
    }
}

class HistorialReciclaje {
    private double pesoReciclado;
    private int id;
    private String fecha;

    public HistorialReciclaje(int id, double pesoReciclado, String fecha) {
        this.id = id;
        this.pesoReciclado = pesoReciclado;
        this.fecha = fecha;
    }
}

class Parada {
    private int orden;
    private String direccion;
    private boolean visitada;

    public Parada(int orden, String direccion) {
        this.orden = orden;
        this.direccion = direccion;
        this.visitada = false;
    }

    public String GetDireccion() {
        return direccion;
    }

    public void Visitado() {
        visitada = true;
    }
}

class Ruta {
    private int id;
    private String fecha;
    private double distancia;
    private double duracion;

    private List<Parada> paradas = new ArrayList<>();
    private int indice = 0;

    public Ruta(int id, String fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public void CrearParada(int orden, String direccion) {
    paradas.add(new Parada(orden, direccion));
    }

    public void AgregarParada(Parada p) {
        paradas.add(p);
    }

    public Parada SiguienteParada() {
        if (indice < paradas.size()) {
            return paradas.get(indice++);
        }
        return null;
    }
}
