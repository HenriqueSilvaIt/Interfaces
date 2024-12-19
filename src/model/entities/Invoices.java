package model.entities;

public class Invoices {
	private Double basicPayment;
	private Double tax;
	
	
	// Construtores
	public Invoices () {
		
	}
	public Invoices(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}
	
	// Get and set
	
	public Double getBasicPayment() {
		return basicPayment;
	}
	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getTotalPayment() {
		return getTax() - getBasicPayment();
	}
	
	
}
