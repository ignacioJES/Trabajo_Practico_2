package ar.edu.unju.fi.ejercicio1.Model;

public class Producto {
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private OrigenFabricacion origenFabricacion;
    private Categoria categoria;

    public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion, Categoria categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.origenFabricacion = origenFabricacion;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public OrigenFabricacion getOrigenFabricacion() {
        return origenFabricacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // Enums
    public enum OrigenFabricacion {
        ARGENTINA,
        CHINA,
        BRASIL,
        URUGUAY
    }

    public enum Categoria {
        TELEFONIA,
        INFORMATICA,
        ELECTROHOGAR,
        HERRAMIENTAS
    }

	public void setPrecioUnitario(double nuevoPrecio) {
		// TODO Auto-generated method stub
		
	}
}