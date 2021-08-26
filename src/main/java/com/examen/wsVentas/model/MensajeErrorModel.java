package com.examen.wsVentas.model;

import java.util.Date;

public class MensajeErrorModel {

		private Integer codigo;
		private String mensaje;
		private Date fecha;
		
		public MensajeErrorModel() {
			super();
		}

		public MensajeErrorModel(Integer codigo, String mensaje, Date fecha) {
			super();
			this.codigo = codigo;
			this.mensaje = mensaje;
			this.fecha = fecha;
		}

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}


}
