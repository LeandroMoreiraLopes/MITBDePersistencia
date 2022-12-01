package br.edu.infnet.pedidos.model.entity;

public class Entrega {

	private Long codigo;
	private String entregador;
	private String codigoConfirmacao;
	private String status;
	
	public Entrega() {
	}
	
	public Entrega(String entregador, String codigoConfirmacao) {
		super();
		this.entregador = entregador;
		this.codigoConfirmacao = codigoConfirmacao;
		status = "Iniciada";
	}
	
	public Entrega(Long codigo, String entregador, String codigoConfirmacao, String status) {
		super();
		this.codigo = codigo;
		this.entregador = entregador;
		this.codigoConfirmacao = codigoConfirmacao;
		this.status = status;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}

	public String getCodigoConfirmacao() {
		return codigoConfirmacao;
	}

	public void setCodigoConfirmacao(String codigoConfirmacao) {
		this.codigoConfirmacao = codigoConfirmacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Entrega [codigo=" + codigo + ", entregador=" + entregador
				+ ", codigoConfirmacao=" + codigoConfirmacao + ", status=" + status + "]";
	}	
}
