package com.examen.wsVentas.dao.impl;

import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.examen.wsVentas.dao.IPedidos;
import com.examen.wsVentas.model.DetallePedido;
import com.examen.wsVentas.storedProcedure.SpObtienePedido;
import com.examen.wsVentas.storedProcedure.SpObtienePedidos;

@Repository
public class PedidsoImpl implements IPedidos{
	
	@Autowired
	Environment env;
	
	private JdbcTemplate jdbc;

	@Override
	public DetallePedido obtienePedido(int pedido) {
		// TODO Auto-generated method stub
		SpObtienePedido sp = new SpObtienePedido(jdbc);
		Map<String, Object> out = sp.execute(pedido);
		DetallePedido detalle = (DetallePedido) out.get(SpObtienePedido.RESULTSET1);
		return detalle;
	}

	@Override
	public List<?> obtienePedidos() {
		// TODO Auto-generated method stub
		SpObtienePedidos sp = new SpObtienePedidos(jdbc);
		Map<String, Object> out = sp.execute();
		List<DetallePedido> detalle = (List<DetallePedido>) out.get(SpObtienePedido.RESULTSET1);
		return detalle;
	}

	@Override
	public String insertaPedido(DetallePedido detalle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(@Qualifier("dataSource") DataSource data) {
		// TODO Auto-generated method stub
		this.jdbc = new JdbcTemplate((javax.sql.DataSource) data);
	}

}
