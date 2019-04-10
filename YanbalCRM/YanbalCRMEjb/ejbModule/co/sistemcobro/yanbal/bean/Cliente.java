package co.sistemcobro.yanbal.bean;

import java.util.ArrayList;

public class Cliente {
	
	private int idCliente;
	private int idCargue;
	private String cedulaCliente;
	private String codigoCliente;
	private String nombreCliente;
	private String primerApellidoCliente;
	private String segundoApellidoCliente;
	private String directoraCodigo;
	private String direccionCliente;
	private String barrioDireccionCliente;
	private String ciudadDireccionCliente;
	private String departamentoDireccionCliente;
	private String celularCliente;
	private String telefonoCliente;
	private String nombreCoordinador;
	private String idCall;
	private String email;
	private String despachoDireccion;
	
	private ArrayList<Obligacion> obligaciones; 
	private ArrayList<Obligacion> compromisos; 
	
	
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDirectoraCodigo() {
		return directoraCodigo;
	}
	public void setDirectoraCodigo(String directoraCodigo) {
		this.directoraCodigo = directoraCodigo;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public String getBarrioDireccionCliente() {
		return barrioDireccionCliente;
	}
	public void setBarrioDireccionCliente(String barrioDireccionCliente) {
		this.barrioDireccionCliente = barrioDireccionCliente;
	}
	public String getCiudadDireccionCliente() {
		return ciudadDireccionCliente;
	}
	public void setCiudadDireccionCliente(String ciudadDireccionCliente) {
		this.ciudadDireccionCliente = ciudadDireccionCliente;
	}
	public String getCelularCliente() {
		return celularCliente;
	}
	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	public String getNombreCoordinador() {
		return nombreCoordinador;
	}
	public void setNombreCoordinador(String nombreCoordinador) {
		this.nombreCoordinador = nombreCoordinador;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getPrimerApellidoCliente() {
		return primerApellidoCliente;
	}
	public void setPrimerApellidoCliente(String primerApellidoCliente) {
		this.primerApellidoCliente = primerApellidoCliente;
	}
	public String getSegundoApellidoCliente() {
		return segundoApellidoCliente;
	}
	public void setSegundoApellidoCliente(String segundoApellidoCliente) {
		this.segundoApellidoCliente = segundoApellidoCliente;
	}
	public int getIdCargue() {
		return idCargue;
	}
	public void setIdCargue(int idCargue) {
		this.idCargue = idCargue;
	}
	public String getDepartamentoDireccionCliente() {
		return departamentoDireccionCliente;
	}
	public void setDepartamentoDireccionCliente(String departamentoDireccionCliente) {
		this.departamentoDireccionCliente = departamentoDireccionCliente;
	}
	public String getIdCall() {
		return idCall;
	}
	public void setIdCall(String idCall) {
		this.idCall = idCall;
	}
	public ArrayList<Obligacion> getObligaciones() {
		return obligaciones;
	}
	public void setObligaciones(ArrayList<Obligacion> obligaciones) {
		this.obligaciones = obligaciones;
	}
	public ArrayList<Obligacion> getCompromisos() {
		return compromisos;
	}
	public void setCompromisos(ArrayList<Obligacion> compromisos) {
		this.compromisos = compromisos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDespachoDireccion() {
		return despachoDireccion;
	}
	public void setDespachoDireccion(String despachoDireccion) {
		this.despachoDireccion = despachoDireccion;
	}
	
	
	
	
	
	
	
	
	
	
	}
