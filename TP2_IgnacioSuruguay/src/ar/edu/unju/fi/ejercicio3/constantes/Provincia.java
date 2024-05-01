package ar.edu.unju.fi.ejercicio3.constantes;


public enum Provincia {
    JUJUY(779212, 53219, 1.5),
    SALTA(1333365, 155488, 8.6),
    TUCUMAN(1687305, 22524, 74.9),
    CATAMARCA(367828, 102602, 3.6),
    LA_RIOJA(331847, 89680, 3.7),
    SANTIAGO_DEL_ESTERO(874006, 136351, 6.4);

    private int cantidadPoblacion;
    private int superficie;
    private double densidadPoblacional;

    private Provincia(int cantidadPoblacion, int superficie, double densidadPoblacional) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
        this.densidadPoblacional = densidadPoblacional;
    }

    public int getCantidadPoblacion() {
        return cantidadPoblacion;
    }

    public void setCantidadPoblacion(int cantidadPoblacion) {
        this.cantidadPoblacion = cantidadPoblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double getDensidadPoblacional() {
        return densidadPoblacional;
    }

    public void setDensidadPoblacional(double densidadPoblacional) {
        this.densidadPoblacional = densidadPoblacional;
    }

    public double calcularDensidadPoblacional() {
        return cantidadPoblacion / (double)superficie;
    }
}
