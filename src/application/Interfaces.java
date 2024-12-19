package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;

public class Interfaces {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do alugel?");
		System.out.println("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
		
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		LocalDateTime finish = LocalDateTime.parse(sc.next(), fmt);
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel) );
		
		sc.close();
	}

}
