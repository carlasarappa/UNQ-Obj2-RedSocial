package redSocial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RedSocialTest {
	
	Usuario carla;
	
	@Before
	public void setup(){
		carla = new Usuario("Carla");
	}
	
	@Test
	public void testUnUsuarioTieneNombre() {
		assertTrue("Carla".equals(carla.getNombre()));
	}
	
	@Test
	public void testUnUsuarioNuevoTieneUnMuroVacio() {
		assertTrue(carla.getMuro().isEmpty());
	}
	
	@Test
	public void testUnUsuarioNuevoNoTieneAmigos(){
		assertTrue(carla.cantidadAmigos()==0);
	}
	
	@Test
	public void testUnUsuarioPuedePublicarMensajesEnSuMuro(){
		carla.publicarMensaje(carla, "Holi");
		assertTrue("Holi".equals(carla.getMuro().ultimoMensaje().getContenido()));
	}
	
	@Test
	public void testUnUsuarioPuedePublicarMensajesEnElMuroDeOtroUsuario(){
		Usuario arielito = new Usuario ("Arielito");
		carla.publicarMensaje(arielito, "Hola :D");
		assertTrue("Hola :D".equals(arielito.getMuro().ultimoMensaje().getContenido()));
	}
	
	@Test
	public void testUnUsuarioPuedeBorrarUnMensajeDeSuPropioMuro(){
		carla.publicarMensaje(carla, "test en mi muro");
		carla.eliminarMensaje(carla.getMuro().ultimoMensaje());
		assertTrue(carla.getMuro().cantidadMensajes()==0);
	}
	
	@Test
	public void testUnUsuarioPuedeTenerNotificaciones(){
		Usuario ari = new Usuario("Ari");
		Notificacion nueva = new Notificacion(ari, "holis sarasita larala");
		carla.recibirNotificacion(nueva);
		assertEquals(nueva, carla.ultimaNotificacion());
	}
	
	@Test
	public void testUnUsuarioPublicaAlgoEnSuMuroYSusAmigosDebenSerNotificados(){
		Usuario ari = new Usuario("Ari");
		carla.agregarAmigo(ari);
		carla.publicarMensaje(carla, "test en mi muro");
		Notificacion nuevaNotificacion = new Notificacion(carla, "test en mi muro");
		assertEquals(nuevaNotificacion, ari.ultimaNotificacion());
	}
}
