#include <stdio.h>
#include <string.h>

int fuerzaBruta(char text[], char cadena[]){
	int match = 0;
	for (int i = 0; i < strlen(text)-strlen(cadena)+ 1; i++){	
		char aux[strlen(cadena)];
		int k= i;
		int band= 0;
		for ( int j = 0; j < strlen(cadena); j++){
			if(cadena[j] == text[j+k]){
				band++;
			}
		}
		if (band == strlen(cadena)){
			match++;
			i= i + strlen(cadena) -1;
		}
		
	}
	return match;
	

}

int main(int argc, char *argv[]) {
	char text[]= "HolaHolaHola Holatdrgsjftkufhdjghdxdhfdxchgmgncbghdfgfdhfxngdd_aaioñlhuliymk##";
	char cadena[] ="Hola";
	printf("%d",fuerzaBruta(text,cadena));
	
}

