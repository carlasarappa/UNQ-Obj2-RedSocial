package redSocial;

import java.util.List;
import java.util.ArrayList;

public class Muro {
	
	private List<Mensaje> mensajes;
	
	public Muro(){
		this.mensajes = new ArrayList<Mensaje>();
	}
	
	public void agregarMensaje(Mensaje mensaje){
		this.mensajes.add(mensaje);
	}
	
	public Mensaje ultimoMensaje(){
		return this.mensajes.get(0);
	}
	
	public void borrarMensaje(Mensaje mensaje){
		this.mensajes.remove(mensaje);
	}
	
	public boolean isEmpty(){
		return true;
	}
	
	public int cantidadMensajes(){
		return this.mensajes.size();
	}
	
}
