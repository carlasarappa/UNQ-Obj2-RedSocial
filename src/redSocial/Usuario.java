package redSocial;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private Muro muro;
	private List<Usuario> amigos;
	private List<Notificacion> notificaciones;
	
	public Usuario(String nombre){
		this.nombre = nombre;
		this.muro = new Muro();
		this.amigos = new ArrayList<Usuario>();
		this.notificaciones = new ArrayList<Notificacion>();
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
	
	public void agregarAmigo(Usuario amigo){
		amigos.add(amigo);
	}
	
	public void publicarMensaje(Usuario destinatario, String mensaje){
		destinatario.getMuro().agregarMensaje(new Mensaje(this, mensaje));
		for(Usuario amigo : amigos){
			amigo.recibirNotificacion(new Notificacion(this, mensaje));
		}
	}
	
	public void eliminarMensaje(Mensaje mensaje){
		getMuro().borrarMensaje(mensaje);		
	}
	
	public int cantidadNotificaciones(){
		return this.notificaciones.size();
	}
	
	public void recibirNotificacion(Notificacion nuevaNotificacion){
		notificaciones.add(nuevaNotificacion);
	}
	
	public Notificacion ultimaNotificacion(){
		return this.notificaciones.get(0);
	}
}
