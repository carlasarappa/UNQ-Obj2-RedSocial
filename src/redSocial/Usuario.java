package redSocial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Usuario {

	private String nombre;
	private Muro muro;
	private List<Usuario> amigos;
	
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
	
	public void agregarAmigos(Usuario amigo){
		amigos.add(amigo);
	}
	
	public int cantidadAmigos(){
		return this.amigos.size();
	}
	
	public List<Usuario> listaDeAmigos(){
		return this.amigos;
	}
	
	public void notificar(Mensaje msj){
		for (Usuario amigo : this.amigos) {
			amigo.getMuro().agregarMensaje(msj);
		}
	}
	
	public void publicarMensaje(Usuario destinatario, String mensaje){
		Mensaje msj= new Mensaje (destinatario, mensaje);
		destinatario.getMuro().agregarMensaje(msj);
		this.notificar(msj);
	}
	
	
	}

