#include <stdio.h>
#include <string.h>

int rabinKarp(char text[], char cadena[]){
	int D = 256; 
	int Q = 3; // Segundo numero primo para hash
	int empates = 0; // Numero de empates
	int hCadena = 0; // Hash de cadena
	int hText = 0; // Hash del texto
	int dM = 1;
		
	
	// Realizamos Hash al patron
	for(int i = 1; i< strlen(cadena); i++){
		dM = (dM * D) % Q; // Realizamos Hash al patron
		for(int j = 1; j<=strlen(cadena); j++){
			hCadena = ((hCadena * D) + cadena[j]) % Q;
			hText = ((hText * D) + text[j]) % Q;
		}
		for(int k = 0; k< strlen(text)-strlen(cadena)-1;k++){
			// Busca coincidencia en clave Hash
			if (hCadena == hText){
				// Fuerza Bruta para confirmar empate
				for(int m = 0; m <strlen(cadena) && text[k-1+m] == cadena[m]; m++){			
					
					if(m == strlen(cadena) -1 )
						// confirmo todos los caracteres
						empates++;
				}
			}
			hText = (hText + (Q*D) - text[k]*dM) % Q;
			// Recorre la clave hash el tamanio  de la cadena
			hText = ((hText * D) + text[k + strlen(cadena)]) % Q ;
			
		}
		
	}
	return empates;
}

int main(int argc, char *argv[]) {
	char text[]= "HolaHolaHolaHolaAdiosAdiosAdiosHola Hola Hola Adios Adios";
	char cadena[] ="Hola";
	printf("Empates: %d",rabinKarp(text,cadena));
	return 0;
}

