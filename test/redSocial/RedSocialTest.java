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
		assertTrue(carla.cantidadAmigos().equals(0));
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
	public void testUnUsuarioDeseaVerLaCantidadDeAmigos(){
		assertEquals(carla.cantidadAmigos(),0);
	}
	
	
}
