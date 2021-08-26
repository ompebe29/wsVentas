package com.examen.wsVentas.storedProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.examen.wsVentas.mapper.TicketMapper;

public class SpObtienePedidos extends StoredProcedure {
	
public static final String RESULTSET1 = "ResulSet1";
	
	public SpObtienePedidos(JdbcTemplate jdbc) {
		super(jdbc,"BDCOMPRA.SQVENTAS.SPOBTIENEPEDIDOS");
		declareParameter(new SqlParameter("",Types.VARCHAR));
		declareParameter(new SqlReturnResultSet(RESULTSET1, new TicketMapper()));
		compile();
	}
	
	public Map<String, Object> execute(){
		
		Map<String, Object> inputs = new HashMap<String, Object>();
		return super.execute(inputs);
		
	}

}
