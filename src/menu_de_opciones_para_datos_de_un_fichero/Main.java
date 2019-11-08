package menu_de_opciones_para_datos_de_un_fichero;

import java.io.File;
import java.io.FileNotFoundException;
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

		
		//menua eta aukerak
//		do {
			//1 kotxea gehitu
			//2 martikula aldatu
			//3 motorra trukatu
			//4 kotxea ezabatu
			//5 kotxearen datuak ikusi
			//6 kotxeak zerrendatu
			//7 amaitu programa
//		}while();
		
		int opcion;
		
		do {
				System.out.println("");
				System.out.println("-- MENU --");
				System.out.println("1. Añadir coche");
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
					 		
							
						break;
					 	case 2:
						
						break;
					 	case 3:
						
						break;
					 	case 4:
						
						break;
					 	case 5:
						
						break;
					 	case 6:
							 //listarCoches(cochesNuevos);
							 //goiko metodoan sartu tartekoa
					 		Iterator<Coche> i = cochesnuevos.iterator();

							while (i.hasNext()) {
								c = i.next();
								System.out.println("Matricula: "+ c.getMatricula() + " - Marca: " + c.getPotencia() 
												+ " - Pasajeros: " + c.getMarca() + " - Ruedas: " + c.getRuedas());
							}
							 //metodo baten sartu
						break;
					 	default:
						break;
					}
				}
				
			
		} while (opcion != 7);
		System.out.println("FIN");
		
		
		
		// recorrer el array e guardarlo en coches.txt
		file = new File("datos/coches.txt");
 		
		try {
			PrintWriter pw= new PrintWriter(file);
			
			Iterator<Coche> i = cochesnuevos.iterator();
			
			while (i.hasNext()) {
				c = i.next();
				pw.println(c.getMatricula() + ";" + c.getPotencia() 
				+ ";" + c.getMarca() + ";" + c.getRuedas());

			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}