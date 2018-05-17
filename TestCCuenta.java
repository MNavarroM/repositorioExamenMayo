package examenEntornos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCCuenta {
	public static void main(String[] args) {
		BufferedReader dato = new BufferedReader(new InputStreamReader(
				System.in));
		CCuenta cuenta1;

		int opcion = 0;
		cuenta1 = new CCuenta("Rigoberta Piedra", "0000-6523-85-678912345",
				2500, 0);
		do {
			try {
				System.out.println("MENU DE OPERACIONES");
				System.out.println("-------------------");
				System.out.println("1 - Ingresar");
				System.out.println("2 - Retirar");
				System.out.println("3 - Salir");
				opcion = Integer.parseInt(dato.readLine());

				switch (opcion) {
				case 1:
					System.out.println("Indica cantidad a ingresar: ");
					float ingresar = Integer.parseInt(dato.readLine());
					try {
						System.out.println("Ingreso en cuenta");
						cuenta1.ingresar(ingresar);
					} catch (Exception e) {
						System.out.print("Fallo al ingresar");
					}
					break;
				case 2:
					System.out.println("Indica cantidad a retirar: ");
					float retirar = Integer.parseInt(dato.readLine());
					try {
						cuenta1.retirar(retirar);
					} catch (Exception e) {
						System.out.print("Fallo al retirar");
					}
					break;
				case 3:
					System.out.println("Aaaaaaaaaadios");
				}
			} catch (IOException ex) {
				Logger.getLogger(TestCCuenta.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		} while (opcion != 3);
		double saldoActual = cuenta1.estado();
		System.out.println("Saldo actual: " + saldoActual);
	}
}
