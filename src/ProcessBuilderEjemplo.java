
import java.util.*;
import java.io.*;
import java.lang.ProcessBuilder.Redirect;

public class ProcessBuilderEjemplo {
	public static void main(String[] args) throws IOException, InterruptedException {

		ProcessBuilder processBuilder = new ProcessBuilder("cat");

		File dirOut = new File("/home/zubiri/ProyectosJava/resultado.txt");
		File dirErr = new File("/home/zubiri/ProyectosJava/errores.txt");


		processBuilder.redirectOutput(dirOut);
		processBuilder.redirectError(dirErr);

		processBuilder.start();

	}
} 