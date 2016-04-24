package redSocial;

import java.util.ArrayList;
import java.util.Collection;

public class Usuario {

	private String nombre;
	private Muro muro;
	private Collection<Usuario> amigos;
	
	public Usuario(String nombre){
		this.nombre = nombre;
		this.muro = new Muro();
		this.amigos = new ArrayList<Usuario>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Muro getMuro(){
		return this.muro;		
	}
	
	public int cantidadAmigos(){
		return this.amigos.size();
	}
	
	public void publicarMensaje(Usuario destinatario, String mensaje){
		destinatario.getMuro().agregarMensaje(new Mensaje(this, mensaje));
		
	}
	
}
