package examenEntornos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCCuenta {
	private static BufferedReader dato;

	public static void main(String[] args) {
		dato = new BufferedReader(new InputStreamReader(
				System.in));
		CCuenta marioNavarroMadrid;

		int opcion = 0;
		marioNavarroMadrid = new CCuenta("Rigoberta Piedra", "0000-6523-85-678912345",
				2500, 0);
		do {
			try {
				mostrarMenu();
				opcion = recogerOpcion(dato);
				switch (opcion) {
				case 1:
					ingresar(dato, marioNavarroMadrid);
					break;
				case 2:
					retirar(dato, marioNavarroMadrid);
					break;
				case 3:
					System.out.println("Aaaaaaaaaadios");
				}
			} catch (IOException ex) {
				Logger.getLogger(TestCCuenta.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		} while (opcion != 3);
		System.out.println("Saldo actual: " + marioNavarroMadrid.estado());
	}

	private static void retirar(BufferedReader dato, CCuenta cuenta1) throws IOException {
		System.out.println("Indica cantidad a retirar: ");
		float retirar = recogerOpcion(dato);
		try {
			cuenta1.retirar(retirar);
		} catch (Exception e) {
			System.out.print("Fallo al retirar");
		}
	}

	private static void ingresar(BufferedReader dato, CCuenta cuenta1) throws IOException {
		System.out.println("Indica cantidad a ingresar: ");
		float ingresar = recogerOpcion(dato);
		try {
			System.out.println("Ingreso en cuenta");
			cuenta1.ingresando(ingresar);
		} catch (Exception e) {
			System.out.print("Fallo al ingresar");
		}
	}

	private static int recogerOpcion(BufferedReader dato) throws IOException {
		int opcion;
		opcion = Integer.parseInt(dato.readLine());
		return opcion;
	}

	private static void mostrarMenu() {
		System.out.println("MENU DE OPERACIONES");
		System.out.println("-------------------");
		System.out.println("1 - Ingresar");
		System.out.println("2 - Retirar");
		System.out.println("3 - Salir");
	}
}
