package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.balanceException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);

		System.out.print("Enter amount for withdraw: ");
		double withdraw = sc.nextDouble();

		try {
			acc.withdraw(withdraw);

			System.out.println("New balance: " + acc.getBalance());
		}
		catch (balanceException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}

		sc.close();

	}

}
