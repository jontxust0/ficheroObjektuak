package prueba_getter_setter_objetoleerfichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		File file = new File("datos/coches.txt");
		ArrayList<Coche> cochesnuevos= new ArrayList<Coche>();
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
			
//		}while();
		
		
		
		
		
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
