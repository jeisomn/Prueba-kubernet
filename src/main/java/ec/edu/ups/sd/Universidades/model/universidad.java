package ec.edu.ups.sd.Universidades.model;

public class universidad {
	
	private int codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "universidad [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
    
    
}
