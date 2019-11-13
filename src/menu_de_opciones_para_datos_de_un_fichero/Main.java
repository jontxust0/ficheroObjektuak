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
				if(opcion < 1 || opcion > 7) {
					System.out.println("OPCION INVALIDA, prueba de nuevo");
					System.out.println("");
				} else {
					 switch (opcion) {
					 	case 1:
					 		//1 kotxea gehitu
							
						break;
					 	case 2:
					 		//2 martikula aldatu
						break;
					 	case 3:
					 		//3 motorra trukatu
						break;
					 	case 4:
					 		borrarUnCoche(cochesnuevos, c);
						break;
					 	case 5:
					 		mostrarUnCoche(cochesnuevos, c);
						break;
					 	case 6:
					 		listarCoches(cochesnuevos, c);
						break;
					 	default:
						break;
					}
				}
				
			
		} while (opcion != 7);
		System.out.println("FIN");
		
		
		
		// recorrer el array e guardarlo en coches.txt
		
		
		
	}
	public static void anadirUnCoche(ArrayList cochesnuevos, Coche c) {
		
	}
	
	public static void borrarUnCoche(ArrayList cochesnuevos, Coche c){
		Iterator<Coche> i = cochesnuevos.iterator();
		String cocheABorrar;
		System.out.println("Escribe la matricula del coche que quieres eliminar");
		cocheABorrar = new Scanner(System.in).nextLine();
		
		while (i.hasNext()) {
			c = i.next();
			if(cocheABorrar.equals(c.getMatricula())) {
				cochesnuevos.remove(c);
				System.out.println("Se ha borrado el coche con la matricula " + c.getMatricula());
				
				File file = new File("datos/coches.txt");

				i = cochesnuevos.iterator();

				
				try {
					//fitxategi baten idatzi ahal izateko behar diren objectuak
					FileWriter fw;
					fw = new FileWriter(file);
					PrintWriter pw = new PrintWriter(fw);
					
					while (i.hasNext()) {
						c = i.next();
						pw.println(c.getMatricula()+";"+c.getPotencia()+";"+c.getMarca()+";"+c.getRuedas());

					}
					pw.close();
					fw.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
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
				if(cocheACambiar.equals(c.getMatricula())) {
					System.out.println("Matricula: "+ c.getMatricula() + " - Potencia: " + c.getPotencia() 
					+ " - Marca: " + c.getMarca() + " - Ruedas: " + c.getRuedas());
				}	
			}
			
			
		
	}
	public static void listarCoches(ArrayList cochesnuevos, Coche c) {
		Iterator<Coche> i = cochesnuevos.iterator();

		while (i.hasNext()) {
			c = i.next();
			System.out.println("Matricula: "+ c.getMatricula() + " - Potencia: " + c.getPotencia() 
							+ " - Marca: " + c.getMarca() + " - Ruedas: " + c.getRuedas());
		}
	}
}
