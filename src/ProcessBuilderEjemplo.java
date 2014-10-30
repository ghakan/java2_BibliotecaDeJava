
	import java.util.*;
	import java.io.*;
	import java.lang.ProcessBuilder.Redirect;

	public class ProcessBuilderEjemplo {
		public static void main(String[] args) throws IOException {

		char opcion;
		String comando ="date";
		
		//Utilizamos Scanner y lo guardamos en la variable sc
		Scanner sc = new Scanner(System.in);
		
		//Imprimimos en pantalla el texto
		System.out.println("\nEscribe un comando. Ejemplo: pwd(p), ls(l), whoami(w) o Salir(S)");
		
		//pedimos al usuario introducir lo solicitado y lo guardamos en la variable seleccion
		opcion = sc.next().charAt(0);

		//si la variable cumple la condicion comienza el bucle
		while (opcion !=('s'))
		{

			if (opcion == ('p') || opcion == ('l') || opcion == ('w')){
				if(opcion == ('p') ){
					comando="pwd";
				}
				else if(opcion == ('l')){

					comando="ls";
				}
				else if(opcion == ('w')){

					comando="whoami";
				}

				//Utilizamos el constructor ProcessBuilder al que le introducimos el comando y el lo guardamos en una variable
				ProcessBuilder processBuilder = new ProcessBuilder(comando);

				
				File dirOut = new File("/home/zubiri/ProyectosJava/resultado.txt");
				File dirErr = new File("/home/zubiri/ProyectosJava/errores.txt");

				processBuilder.redirectOutput(dirOut);
				processBuilder.redirectError(dirErr);

				processBuilder.start();

				FileReader fr = new FileReader("/home/zubiri/ProyectosJava/resultado.txt");

	            //String s; 
	           /* while((s = fr.readLine()) != null) 
	            { 
	                System.out.println(s);
	            }
	            fr.close();*/
				char [] mostrar = new char[100];
	            fr.read(mostrar);
	            System.out.println(mostrar);
	            fr.close();     
        	}
			//Si cumplio la condicion de C o R vuelve a preguntar que operacion quiere realizar
			System.out.println("\n\nVuelve a escribir un comando. Ejemplo: pwd(p), ls(l), whoami(w) o Salir(S) \n");
			
			opcion = sc.next().charAt(0);
		}
		
		//Cuando termina el bucle imprime en pantalla el texto.
		System.out.println("\nHas seleccionado salir.\n");
	}
}

