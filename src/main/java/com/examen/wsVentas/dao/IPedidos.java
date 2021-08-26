package com.examen.wsVentas.dao;

import java.util.List;

import javax.activation.DataSource;

import com.examen.wsVentas.model.DetallePedido;

public interface IPedidos {
	
	
	public void setData(DataSource data);
	public DetallePedido obtienePedido(int pedido);
	public List<?> obtienePedidos();
	public String insertaPedido(DetallePedido pedido);

}
