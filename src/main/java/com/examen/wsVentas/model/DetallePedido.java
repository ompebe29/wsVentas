package com.examen.wsVentas.model;

import java.util.List;

public class DetallePedido {
	 
	private Pedido pedido;
	private List<Articulo> art;
	private int cantidad;
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public List<Articulo> getArt() {
		return art;
	}
	public void setArt(List<Articulo> art) {
		this.art = art;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
