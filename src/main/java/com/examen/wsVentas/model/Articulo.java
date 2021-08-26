package com.examen.wsVentas.model;

public class Articulo {
	
	private String articulo;
	private String nombre;
	private String  desc;
	private int cantidadInv;
	
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getCantidadInv() {
		return cantidadInv;
	}
	public void setCantidadInv(int cantidadInv) {
		this.cantidadInv = cantidadInv;
	}

}
