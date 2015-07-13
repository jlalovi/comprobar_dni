import java.util.Scanner;

public class Comprobar_DNI {

	public static void main(String[] args) {
		// Testeo:
		
		String dni = dniCorrecto();
		
		String dni2 = dniCorrecto();
		
		System.out.println(dni + dni2);

	}
	

/*
 * M�TODO dniCorrecto():
   � Este m�todo no necesita par�metros. Desencadenar� una serie de procesos que imprimir� por pantalla los errores del DNI introducido,
     hasta introducir uno correcto, que ser� el que devolver� el m�todo.

*/
	private static String dniCorrecto() {
		
	 // DELARACI�N DE VARIABLES
	 // =======================

		String DNI;           // DNI introducido por el usuario.
		int longitud;         // Longitud del DNI.
		String numero;        // N�mero del DNI almacenado en una cadena.
		char letra;           // Letra del DNI.
		boolean DNIcorrecto;  // Verdadero o falso.
		int modulo23DNI;      // El m�dulo 23 del n�mero del DNI, que me servir� para saber si la letra introducida es correcta.
		String letrasDNI;     // Cadena donde almacenar� en orden las letras equivalentes de DNI una vez realizado el m�dulo 23.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		Scanner entrada = new Scanner(System.in);

		System.out.println("DNI con letra:");
		DNI = entrada.nextLine().trim();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		do {
		
		DNIcorrecto = true;  // Presupondr� que el DNI que se introducir� es verdadero desde el principio del bucle.
		longitud = DNI.length();
		
		if (longitud<2 || longitud>9) {  // Paso 1: Compruebo que la longitud del DNI completo no es menor de 2 ni supera los 9 caracteres.
			DNIcorrecto = false;
			System.out.println("El DNI debe estar formado al menos por 2 caracteres y menos de 9.");
		}
			
			if (DNIcorrecto) {  // Paso 2: Si la longitud del DNI no es superior a 9 caracteres, procedo con la siguiente comprobaci�n:
				
				numero = DNI.substring(0, longitud-1);  // La cadena 'numero' ser� el DNI menos el �ltimo car�cter que presupondr� que es una letra correcta.
				
				for (int i=0; i<=longitud-2; i++) { // Compruebo n�mero a n�mero si de verdad lo son:
					
					if (Integer.valueOf(numero.charAt(i))<48  || Integer.valueOf(numero.charAt(i))>57) {    // ASCII 48-57 (Los n�meros del 0 al 9)
						DNIcorrecto = false;  // Si alguno de estos n�meros comprobados queda fuera de rango especificado, NO es un n�mero, por lo que el DNI es incorrecto.
						System.out.printf("El car�cter %s NO es un n�mero\n", numero.charAt(i));
					}
					
				}
				
				if (DNIcorrecto) { // Paso 3: Si he pasado los pasos anteriores, sigo presuponiendo que el DNI es correcto. Sino, me salto esta comprobaci�n.
					letra = DNI.toUpperCase().charAt(longitud-1);  // El caracter 'letra' presupondr� que ser� el �ltimo car�cter introducido en la cadena (adem�s lo convierto en may�scula).
					
					if (Integer.valueOf(letra)>=48 && Integer.valueOf(letra)<=57) {  // Compruebo que la letra NO es un n�mero.
						DNIcorrecto = false;
						System.out.println("�Se te ha olvidado introducir la letra de tu DNI!");
					}
					
					if (DNIcorrecto) {  // Paso 4: Si la letra del DNI es diferente a un n�mero, procedo con la siguiente comprobaci�n.
						
						modulo23DNI = Integer.valueOf(numero)%23; // M�dulo 23 del n�mero del DNI, que ser� un n�mero entre el 0 y el 22:
						letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";    // 23 letras posibles en el DNI, en orden del resultado del m�dulo23DNI.
						
						if (letra!=letrasDNI.charAt(modulo23DNI)) { // Paso 5: Por �ltimo, compruebo que la letra del DNI es correcta.
							DNIcorrecto = false;
							System.out.printf("La letra introducida del DNI es incorrecta. Deber�a ser la letra '%s'\n", letrasDNI.charAt(modulo23DNI));
						}
						
					} // fin Paso 3.
				}		
			} // fin Paso 2.
			
			if (DNIcorrecto==false) {
				System.out.println("Introduce de nuevo el DNI con letra de manera correcta:");
				DNI = entrada.nextLine().trim(); // Si el DNI no supera alguno de los procesos, lo vuelvo a pedir �y a reempezar el bucle de procesos!
			}
			
		} while (DNIcorrecto==false);

		
		entrada.close();
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		return DNI;
		
	}
	
/*
 * FIN M�TODO dniCorrecto();
 */
}
