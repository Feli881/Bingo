import java.util.Arrays; 
public class Bingo {

	public static void main(String[] args) {
		int [][] carton=new int[3][5];
		
		rellenarNumerosCarton(carton);
		ordenarColumnasCrton(carton);
		marcarHuecosCarton(carton);
		mostrarCarton(carton);
	}

	private static void rellenarNumerosCarton(int[][]carton) {
		int iNumeroAleatorio;
		boolean repetido;
		
		for(int j=0; j<carton[0].length; j++)
		{
			for(int i=0; i<carton.length; i++)
			{
				do {
					repetido=false; 
					switch(j) {
						case 0:
							iNumeroAleatorio=generaNumeroAleatorio(1,9);
							break; 
						case 8: 
							iNumeroAleatorio=generaNumeroAleatorio(80,90);
							break; 
						default: 
							iNumeroAleatorio=generaNumeroAleatorio(10*j, (10*j)+9);
							break; 
					}
					if (i==1 && carton[0][1]==iNumeroAleatorio) {
						repetido=true; 
					}
				}while(repetido);
				carton[i][j]=iNumeroAleatorio; 
			}
		}
		
	}

	private static void ordenarColumnasCrton(int[][] carton) {
	    int[] numeros = new int[3];
        for (int j = 0; j < carton[0].length; j++) {

         
            for (int i = 0; i < carton.length; i++) {
                numeros[i] = carton[i][j];
            }

            Arrays.sort(numeros);

            for (int i = 0; i < numeros.length; i++) {
                carton[i][j] = numeros[i];
            }

        }
		
	}

	private static void marcarHuecosCarton(int[][] carton) {
		 int[] distribucion = {1, 1, 1, 1, 1, 1, 1, 1, 1};

	        int posicionAleatoria;
	    
	        for (int i = 0; i < 3; i++) {
	            do {
	                posicionAleatoria = generaNumeroAleatorio(0, distribucion.length - 1);
	            } while (distribucion[posicionAleatoria] == 2);
	            
	            distribucion[posicionAleatoria] = 2;
	        }

	        
	        int numHuecos[] = new int[3];
	        boolean huecoDisponible[] = new boolean[3];
	        int menor, filaAleatoria, posOcupadas;
	        boolean iguales;

	        for (int j = 0; j < carton[0].length; j++) {

	            
	            Arrays.fill(huecoDisponible, true);

	            
	            iguales = true;
	            for (int i = 0; i < numHuecos.length - 1 && iguales; i++) {
	                if (numHuecos[i] != numHuecos[i + 1]) {
	                    iguales = false;
	                }
	            }

	   
	            if (!iguales) {

	                
	                menor = numHuecos[0];
	                for (int i = 1; i < numHuecos.length; i++) {
	                    if (numHuecos[i] < menor) {
	                        menor = numHuecos[i];
	                    }
	                }

	          
	                for (int i = 0; i < huecoDisponible.length; i++) {
	                    if (numHuecos[i] != menor) {
	                        huecoDisponible[i] = false;
	                    }
	                }

	            }

	           
	            do {
	               
	                filaAleatoria = generaNumeroAleatorio(0, carton.length - 1);
	               
	            } while (!huecoDisponible[filaAleatoria] || carton[filaAleatoria][j] == -1);

	           
	            carton[filaAleatoria][j] = -1;

	            numHuecos[filaAleatoria]++;

	  
	            if (distribucion[j] == 2) {
	              
	                posOcupadas = 0;
	                for (int i = 0; i < carton.length; i++) {
	                    if (carton[i][j] == -1) {
	                        posOcupadas++;
	                    }
	                }

	                if (posOcupadas < distribucion[j]) {
	                    j--;
	                }
	            }
	        }
		
	}

	private static void mostrarCarton(int[][] carton) {
		
		  for (int i = 0; i < carton.length; i++) {
	            for (int j = 0; j < carton[i].length; j++) {

	            
	                if (carton[i][j] == -1) {
	                    
	                    if (j == 0) {
	                        System.out.print("* ");
	                    } else {
	                        System.out.print("** ");
	                    }

	                } else {
	          
	                    System.out.print(carton[i][j] + " ");
	                }
	            }
	            System.out.println("");
	        }
	    }

	    public static int generaNumeroAleatorio(int minimo, int maximo) {
	        return (int) (Math.random() * (maximo - minimo + 1) + (minimo));
	    
	}

}
