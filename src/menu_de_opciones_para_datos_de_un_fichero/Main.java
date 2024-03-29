package menu_de_opciones_para_datos_de_un_fichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		File file = new File("datos/coches.txt");
		ArrayList<Coche> cochesnuevos = new ArrayList<Coche>();
		Scanner scan;
		Coche c = null;
		try {
			scan = new Scanner(file);

			String linea;
			String[] partesLinea;

			// rellenar el arrayList con info del fichero
			while (scan.hasNext()) {
				linea = scan.nextLine();
				partesLinea = linea.split(";");

				c = new Coche();
				c.setMatricula(partesLinea[0]);
				c.setPotencia((partesLinea[1]));
				c.setMarca((partesLinea[2]));
				c.setRuedas((Integer.parseInt(partesLinea[3])));

				cochesnuevos.add(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int opcion;

		do {
			System.out.println("");
			System.out.println("-- MENU --");
			System.out.println("1. Anadir coche");
			System.out.println("2. Cambiar matricula");
			System.out.println("3. Trucar el motor de un coche");
			System.out.println("4. Borrar coche de la lista");
			System.out.println("5. Ver los datos de un coche");
			System.out.println("6. Ver la lista de todos los coches que hay");
			System.out.println("7. Terminar consulta");
			System.out.println("");
			System.out.println("Elige una de las opciones del menu de arriba:");
			opcion = new Scanner(System.in).nextInt();
			
				switch (opcion) {
				case 1:
					aniadirCoche(cochesnuevos);
					guardar(cochesnuevos);
					break;

				case 2:
					cambiarMatricula(cochesnuevos, c);
					guardar(cochesnuevos);
					break;

				case 3:
					cambiarMotor(cochesnuevos, c);
					guardar(cochesnuevos);
					break;

				case 4:
					borrarUnCoche(cochesnuevos, c);
					guardar(cochesnuevos);
					break;

				case 5:
					mostrarUnCoche(cochesnuevos, c);
					break;

				case 6:
					listarCoches(cochesnuevos, c);
					break;
				case 7:
					System.out.println("Saliendo..");
					break;
				default:
					System.out.println("OPCION INCORRECTA");
					
					break;
				}
			

		} while (opcion != 7);
		
		System.out.println("FIN");

		// TODO recorrer el array e guardarlo en coches.txt
		

	}

	private static void aniadirCoche(ArrayList<Coche> cochesnuevos) {
		Scanner scan = new Scanner(System.in);
		Coche c = new Coche();

		System.out.println("Introduce la matricula del coche XXXX XXX");
		c.setMatricula(scan.nextLine());

		System.out.println("Introduce la pontencia del motor del coche");
		c.setPotencia(scan.nextLine());

		System.out.println("Introduce la marca y modelo del coche");
		c.setMarca(scan.nextLine());

		System.out.println("Introduce el numero de ruedas");
		c.setRuedas(Integer.parseInt(scan.nextLine()));

		cochesnuevos.add(c);
	}

	public static void cambiarMatricula(ArrayList cochesnuevos, Coche c) {
		Iterator<Coche> i = cochesnuevos.iterator();
		String matricula;
		String matriculaNueva;
		System.out.println("Di la matricula del coche, para cambiar su numero de matricula");
		matricula = new Scanner(System.in).nextLine();
		while (i.hasNext()) {
			c = i.next();
			if (matricula.equals(c.getMatricula())) {
				System.out.println("Cual sera su nuevo numero de matricula?");
				matriculaNueva = new Scanner(System.in).nextLine();
				c.setMatricula(matriculaNueva);
			}
		}

	}

	public static void cambiarMotor(ArrayList cochesnuevos, Coche c) {
		Iterator<Coche> i = cochesnuevos.iterator();
		String matricula;
		String motorNuevo;
		System.out.println("Di la matricula del coche al que quieres cambiar el motor");
		matricula = new Scanner(System.in).nextLine();
		while (i.hasNext()) {
			c = i.next();
			if (matricula.equals(c.getMatricula())) {
				System.out.println("Que potencia le vas a dar?");
				motorNuevo = new Scanner(System.in).nextLine();
				c.setPotencia(motorNuevo);
			}
		}

	}

	public static void borrarUnCoche(ArrayList cochesnuevos, Coche c) {
		Iterator<Coche> i = cochesnuevos.iterator();
		String cocheABorrar;
		System.out.println("Escribe la matricula del coche que quieres eliminar");
		cocheABorrar = new Scanner(System.in).nextLine();

		while (i.hasNext()) {
			c = i.next();
			if (cocheABorrar.equals(c.getMatricula())) {
				cochesnuevos.remove(c);
				System.out.println("Se ha borrado el coche con la matricula " + c.getMatricula());
				break;
			}
		}
		
	}

	public static void mostrarUnCoche(ArrayList cochesnuevos, Coche c) {
		String cocheACambiar;
		System.out.println("Escribe la matricula del coche del cual quieres saber sus caracteristicas");
		cocheACambiar = new Scanner(System.in).nextLine();
		Iterator<Coche> i = cochesnuevos.iterator();
		while (i.hasNext()) {
			c = i.next();
			if (cocheACambiar.equals(c.getMatricula())) {
				System.out.println("Matricula: " + c.getMatricula() + " - Potencia: " + c.getPotencia() + " - Marca: "
						+ c.getMarca() + " - Ruedas: " + c.getRuedas());
			}
		}

	}

	public static void listarCoches(ArrayList cochesnuevos, Coche c) {
		Iterator<Coche> i = cochesnuevos.iterator();

		while (i.hasNext()) {
			c = i.next();
			System.out.println("Matricula: " + c.getMatricula() + " - Potencia: " + c.getPotencia() + " - Marca: "
					+ c.getMarca() + " - Ruedas: " + c.getRuedas());
		}
	}
	
	public static void guardar(ArrayList cochesnuevos) {
		File f = new File("datos/coches.txt");
		try {
			PrintWriter pr = new PrintWriter(f);
			
			Iterator<Coche> i = cochesnuevos.iterator();
			
			Coche c = null;
			
			while(i.hasNext()) {
				c = i.next();
				
				pr.println(c.getMatricula() + ";" + c.getPotencia() + ";" + c.getMarca() + ";" + c.getRuedas());
				
			}
			pr.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
