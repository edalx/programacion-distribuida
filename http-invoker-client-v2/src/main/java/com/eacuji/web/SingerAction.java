package com.eacuji.web;

import com.eacuji.dto.Singer;
import com.eacuji.services.SingerService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@ManagedBean(name="singerAction")
@SessionScoped
public class SingerAction {
	private String nombres;
	private String apellidos;
	private List<Singer> singers;

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<Singer> getSingers() {
		return singers;
	}

	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}

	private SingerService servicio;

	@PostConstruct
	public void init() {
		ApplicationContext context = 
				FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		servicio = context.getBean( "singerService", SingerService.class );
		singers = servicio.findAll();
	}
	
	public String listar() {
		singers = servicio.findAll();
		return "";
	}
	
	public String agregar( ) {
		Singer obj = new Singer( );
		obj.setFirstName( nombres );
		obj.setLastName( apellidos );
		obj.setBirthDate( new Date() );
		servicio.save(obj);
		return "";
	}

}
