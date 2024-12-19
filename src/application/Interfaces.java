package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalServices;

public class Interfaces {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do alugel?");
		System.out.print("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
	
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel) ); 
		
		System.out.print("Entre com o preço por hora: ");
		Double pricePerHour = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		Double pricePerDay = sc.nextDouble();
		
		RentalServices rs = new RentalServices(pricePerDay, pricePerHour, new BrazilTaxServices());
		
		rs.processInvoice(carRental);
		
		System.out.println("FATURA: ");
		System.out.printf("Pagamento basico: " + String.format("%.2f%n", carRental.getInvoices().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f%n",carRental.getInvoices().getTax()));
		System.out.println("Pagamento total: " + String.format("%.2f%n",carRental.getInvoices().getTotalPayment()));
		
		/*BrazilTaxServices taxService = new BrazilTaxServices();
		
		System.out.println(taxService.tax(390.0)); */
		
		sc.close();
	}

}
