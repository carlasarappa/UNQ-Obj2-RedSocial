package redSocial;

public class Notificacion {
	
	private Usuario usuarioPosteador;
	private String previewContenido;
	
	public Notificacion(Usuario usuarioPosteador, String previewContenido){
		this.usuarioPosteador = usuarioPosteador;
		this.previewContenido = previewContenido;
	}
	
	public String getPreviewContenido(){
		return this.previewContenido;
	}

	public Usuario getUsuarioPosteador(){
		return this.usuarioPosteador;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Notificacion 
				&& ((Notificacion)obj).getUsuarioPosteador().equals(usuarioPosteador)
				&& ((Notificacion)obj).getPreviewContenido().equals(previewContenido);
	}

	

}
