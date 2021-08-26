package com.examen.wsVentas.controller;

import java.util.Date;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.wsVentas.dao.IPedidos;
import com.examen.wsVentas.model.DetallePedido;
import com.examen.wsVentas.model.MensajeErrorModel;

@RestController
public class PedidosController {
	
	@Autowired
	IPedidos pedidoDao;
	@Autowired
	Environment env;
	@Autowired
	@Qualifier("datsource")
	private DataSource source;
	
	
	@GetMapping("/ObtienePedidos")
	public ResponseEntity<?> getPedidos(){
		try {
			List<DetallePedido> pedido = (List<DetallePedido>) pedidoDao.obtienePedidos();
			if(pedido != null && pedido.isEmpty()) {
				return new ResponseEntity<List<?>>(pedido,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(new MensajeErrorModel(204,"No hay pedidos", new Date()), HttpStatus.OK);
			}
			
		}catch(Exception e) {
			 return new ResponseEntity<>(new MensajeErrorModel(500,"Se presentó una incidencia en la comunicación, favor de intentar más tarde. En caso de persistir comuníquese con soporte técnico", 
					 new Date()),HttpStatus.NOT_ACCEPTABLE);			
		}
	}
	@GetMapping("/ObtienePedido/{pedido}")
	public ResponseEntity<?> getPedido(@PathVariable("pedido") String pedido){
			try {
				DetallePedido detallepedido = (DetallePedido) pedidoDao.obtienePedidos();
				if(pedido != null) {
					return new ResponseEntity<DetallePedido>(detallepedido,HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>(new MensajeErrorModel(204,"No hay pedidos", new Date()), HttpStatus.OK);
				}
				
			}catch(Exception e) {
				 return new ResponseEntity<>(new MensajeErrorModel(500,"Se presentó una incidencia en la comunicación, favor de intentar más tarde. En caso de persistir comuníquese con soporte técnico", 
						 new Date()),HttpStatus.NOT_ACCEPTABLE);			
			}
		
	}
	
	@PostMapping("/IngresaPedido")
	public ResponseEntity<?> ingresaPedido(@RequestBody DetallePedido detalle){
			try {
				String pedido = (String) pedidoDao.insertaPedido(detalle);
				if(pedido != null) {
					return new ResponseEntity<String>(pedido,HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>(new MensajeErrorModel(204,"No hay pedidos", new Date()), HttpStatus.OK);
				}
				
			}catch(Exception e) {
				 return new ResponseEntity<>(new MensajeErrorModel(500,"Se presentó una incidencia en la comunicación, favor de intentar más tarde. En caso de persistir comuníquese con soporte técnico", 
						 new Date()),HttpStatus.NOT_ACCEPTABLE);			
			}		
	}
	
}
