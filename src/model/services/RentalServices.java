package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoices;

public class RentalServices {
	private Double pricePerHour;
	private Double pricePerDay;
	
	
	// Composição
	
	private TaxService taxService; // agora a rentalservic vai depender de taxservice que é uma 
	// classe genérica, a brasil tax service é um subtipo de tax service, por isso ocorre um upservice

	
	// Construtores
	
	
	public RentalServices(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	// Get
	
	public void processInvoice(CarRental cr) {
		
		// número de horas em gração, calculo de duração
		double minutes = Duration.between(cr.getStart(), cr.getFinish()).toMinutes();
		double hours = minutes / 60.0; 

		double basicPayment;
		if ( hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours); // Math.ceil arrendonda pra cima
		}
		else {
			basicPayment = pricePerHour * Math.ceil(hours / 24);
		}
		
		double tax = taxService.tax(basicPayment);
		cr.setInvoices(new Invoices(basicPayment, tax));

			
	}

	
}
