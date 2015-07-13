import java.util.Scanner;

public class Comprobar_DNI {

	public static void main(String[] args) {
		// Testeo:
		
		String dni = dniCorrecto();
		
		String dni2 = dniCorrecto();
		
		System.out.println(dni + dni2);

	}
	

/*
 * MÉTODO dniCorrecto():
   · Este método no necesita parámetros. Desencadenará una serie de procesos que imprimirá por pantalla los errores del DNI introducido,
     hasta introducir uno correcto, que será el que devolverá el método.

*/
	private static String dniCorrecto() {
		
	 // DELARACIÓN DE VARIABLES
	 // =======================

		String DNI;           // DNI introducido por el usuario.
		int longitud;         // Longitud del DNI.
		String numero;        // Número del DNI almacenado en una cadena.
		char letra;           // Letra del DNI.
		boolean DNIcorrecto;  // Verdadero o falso.
		int modulo23DNI;      // El módulo 23 del número del DNI, que me servirá para saber si la letra introducida es correcta.
		String letrasDNI;     // Cadena donde almacenaré en orden las letras equivalentes de DNI una vez realizado el módulo 23.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		Scanner entrada = new Scanner(System.in);

		System.out.println("DNI con letra:");
		DNI = entrada.nextLine().trim();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		do {
		
		DNIcorrecto = true;  // Presupondré que el DNI que se introducirá es verdadero desde el principio del bucle.
		longitud = DNI.length();
		
		if (longitud<2 || longitud>9) {  // Paso 1: Compruebo que la longitud del DNI completo no es menor de 2 ni supera los 9 caracteres.
			DNIcorrecto = false;
			System.out.println("El DNI debe estar formado al menos por 2 caracteres y menos de 9.");
		}
			
			if (DNIcorrecto) {  // Paso 2: Si la longitud del DNI no es superior a 9 caracteres, procedo con la siguiente comprobación:
				
				numero = DNI.substring(0, longitud-1);  // La cadena 'numero' será el DNI menos el último carácter que presupondré que es una letra correcta.
				
				for (int i=0; i<=longitud-2; i++) { // Compruebo número a número si de verdad lo son:
					
					if (Integer.valueOf(numero.charAt(i))<48  || Integer.valueOf(numero.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
						DNIcorrecto = false;  // Si alguno de estos números comprobados queda fuera de rango especificado, NO es un número, por lo que el DNI es incorrecto.
						System.out.printf("El carácter %s NO es un número\n", numero.charAt(i));
					}
					
				}
				
				if (DNIcorrecto) { // Paso 3: Si he pasado los pasos anteriores, sigo presuponiendo que el DNI es correcto. Sino, me salto esta comprobación.
					letra = DNI.toUpperCase().charAt(longitud-1);  // El caracter 'letra' presupondré que será el último carácter introducido en la cadena (además lo convierto en mayúscula).
					
					if (Integer.valueOf(letra)>=48 && Integer.valueOf(letra)<=57) {  // Compruebo que la letra NO es un número.
						DNIcorrecto = false;
						System.out.println("¡Se te ha olvidado introducir la letra de tu DNI!");
					}
					
					if (DNIcorrecto) {  // Paso 4: Si la letra del DNI es diferente a un número, procedo con la siguiente comprobación.
						
						modulo23DNI = Integer.valueOf(numero)%23; // Módulo 23 del número del DNI, que será un número entre el 0 y el 22:
						letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";    // 23 letras posibles en el DNI, en orden del resultado del módulo23DNI.
						
						if (letra!=letrasDNI.charAt(modulo23DNI)) { // Paso 5: Por último, compruebo que la letra del DNI es correcta.
							DNIcorrecto = false;
							System.out.printf("La letra introducida del DNI es incorrecta. Debería ser la letra '%s'\n", letrasDNI.charAt(modulo23DNI));
						}
						
					} // fin Paso 3.
				}		
			} // fin Paso 2.
			
			if (DNIcorrecto==false) {
				System.out.println("Introduce de nuevo el DNI con letra de manera correcta:");
				DNI = entrada.nextLine().trim(); // Si el DNI no supera alguno de los procesos, lo vuelvo a pedir ¡y a reempezar el bucle de procesos!
			}
			
		} while (DNIcorrecto==false);

		
		entrada.close();
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		return DNI;
		
	}
	
/*
 * FIN MÉTODO dniCorrecto();
 */
}
