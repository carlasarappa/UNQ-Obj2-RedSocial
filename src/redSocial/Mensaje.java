package redSocial;

public class Mensaje {

	private Usuario remitente;
	private String contenido;
	
	public Mensaje(Usuario remitente, String contenido){
		this.remitente = remitente;
		this.contenido = contenido;
	}
	
	public String getContenido(){
		return this.contenido;
	}

}
