package com.examen.wsVentas.storedProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.examen.wsVentas.mapper.TicketMapper;

public class SpObtienePedido extends StoredProcedure {
	
	public static final String RESULTSET1 = "ResulSet1";
	
	public SpObtienePedido(JdbcTemplate jdbc) {
		super(jdbc,"BDCOMPRA.SQVENTAS.SPOBTIENEPEDIDOPORID");
		declareParameter(new SqlParameter("FIVENTAID",Types.INTEGER));
		declareParameter(new SqlReturnResultSet(RESULTSET1, new TicketMapper()));
		compile();
	}
	
	public Map<String, Object> execute(int pedido){
		
		Map<String, Object> inputs = new HashMap<String, Object>();
		inputs.put("@PACPEDIDO", pedido);
		return super.execute(inputs);
		
	}
	
	

}
