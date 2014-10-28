
	import java.util.*;
	import java.io.*;
	import java.lang.ProcessBuilder.Redirect;

	public class ProcessBuilderEjemplo {
		public static void main(String[] args) throws IOException, InterruptedException {

		String seleccion;
		
		//Utilizamos Scanner y lo guardamos en la variable sc
		Scanner sc = new Scanner(System.in);
		
		//Imprimimos en pantalla el texto
		System.out.println("\nEscribe un comando. Ejemplo: (pwd), (ls), (whoami) o (Salir)");
		
		//pedimos al usuario introducir lo solicitado y lo guardamos en la variable seleccion
		seleccion = sc.next();

		//si la variable cumple la condicion comienza el bucle
		while (seleccion !=("salir") && seleccion !=("SALIR"))
		{

			//si la variable cumple con alguna de estas condiciones
				if(seleccion == ("salir") || seleccion == ("SALIR") )
				{
					//este commando termina el bucle
					break;
				}

			ProcessBuilder processBuilder = new ProcessBuilder(seleccion);

			File dirOut = new File("/home/zubiri/ProyectosJava/resultado.txt");
			File dirErr = new File("/home/zubiri/ProyectosJava/errores.txt");

			processBuilder.redirectOutput(dirOut);
			processBuilder.redirectError(dirErr);

			processBuilder.start();

			FileReader fr = new FileReader("/home/zubiri/ProyectosJava/resultado.txt");

			char [] mostrar = new char[100];
            fr.read(mostrar);
            System.out.println(mostrar);
            fr.close();

			//Si cumplio la condicion de C o R vuelve a preguntar que operacion quiere realizar
			System.out.println("\n\nVuelve a escribir un comando. Ejemplo: (pwd), (ls), (whoami) o (Salir) \n");
			
			seleccion = sc.next();
		}

		//Cuando termina el bucle imprime en pantalla el texto.
		System.out.println("\nHas seleccionado salir.\n");
	}
}

