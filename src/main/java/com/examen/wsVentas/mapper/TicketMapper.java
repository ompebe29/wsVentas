package com.examen.wsVentas.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.examen.wsVentas.model.Articulo;
import com.examen.wsVentas.model.DetallePedido;

public class TicketMapper implements RowMapper<Object>{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DetallePedido detalle = new DetallePedido();
		Articulo art = new Articulo();
		
		art.setNombre(rs.getString("FCARTICULO"));
		detalle.setCantidad(rs.getInt("FICANTIDAD"));
		detalle.getPedido().setPedido(rs.getInt("FIVENTAID"));  
		detalle.getPedido().setFecha(rs.getDate("FDFECHAVENTA"));
		
		return detalle;
	}

}
