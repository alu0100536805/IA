
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


public class jardin extends JPanel {
	
	int TAMCELDA;
	int CELDASFILA;
	int CELDASCOL;
	
	int numeromaximodecortacesped = 0;
    int posinicialI = -3;
    int posinicialJ = -3;
	
	int[] cespedcorto={0, 200, 0};
	int[] cespedlargo={0, 100, 0};
	int[] obstaculo={100, 50, 0};
	int[] cortacesped={0,0,200};
	
	
	
	private Celda[][] vectorjardin;
	private Celda[][] estadosiguientejardin; // este vector tendra al iniciar las caracteristicas de
											 // vector jardin pero se usara para calcular el estado
											 // siguiente del mapa
	
	RadioButtons opcion;
	

	
	//public void setvectorjardin(Celda[][] array, int fila, int columna,int x){ //Coloca el valor del tipo de casilla
		
		//array[fila][columna].setcelda(x);
	//}
	
	public Celda[][] getvectorjardin(){// get array estado actual
		return vectorjardin;
	}
	
	public void setvectorjardin(int filas, int columnas){// set estado actual
		this.vectorjardin = new Celda[filas][columnas];
	}
	
	public void colocarenlacelda(int fila, int columna, int valor){// set array estado actual
		getvectorjardin()[fila][columna].setcelda(valor);
	}

	public Celda[][] getestadosiguientejardin(){// get array la posicion siguiente
		return vectorjardin;
	}
	
	public void setestadosiguientejardin(int filas, int columnas){// set array posicion siguiente
		this.vectorjardin = new Celda[filas][columnas];
	}
	
	public void celdaestadosiguientejardin(int fila, int columna, int valor){// set array posicion siguiente
		getvectorjardin()[fila][columna].setcelda(valor);
	}
	
	
	
	
	public jardin(final int filas, final int columnas, int tamano, RadioButtons ops, int modo, int porcentaje){

		opcion = ops;
		CELDASFILA = filas;
		CELDASCOL = columnas;
		TAMCELDA = tamano;
		setvectorjardin(filas,columnas);
	    for (int i = 0; i < CELDASFILA; i++) {
	        for (int j = 0; j < CELDASCOL; j++) {
	        	getvectorjardin()[i][j] = new Celda(0);
	        
	        }
	    }
//-------------------------------------MODO MANUAL--------------------------------------------------------------	    
		if(modo==0){ //solo si es el modo manual implementa el pintar
		addMouseListener(new MouseListener() {
		      
		      @Override
		      public void mouseReleased(MouseEvent arg0) {
		        // TODO Auto-generated method stub
		      }
		      
		      @Override
		      public void mousePressed(MouseEvent arg0) {
		        int fila = (int) arg0.getPoint().getY() / TAMCELDA;
		        int columna =  (int) arg0.getPoint().getX() / TAMCELDA;
		        
		        //System.out.println(opcion.getrblargo().isSelected());
		        if(opcion.getrblargo().isSelected()){
		        	colocarenlacelda(fila, columna, 1);
		        }
		        if(opcion.getrbobstaculo().isSelected()){
		        	colocarenlacelda(fila, columna, 2);
		        }
		        if((opcion.getrbcortacesped().isSelected())&&(numeromaximodecortacesped == 0)){
		        	colocarenlacelda(fila, columna, 3);
		        }
		        if(opcion.getrbcorto().isSelected()){
		        	colocarenlacelda(fila, columna, 0);
		        }
		        if((opcion.getrbcorto().isSelected())&&(fila == posinicialI)&&(columna == posinicialJ)){
		        	numeromaximodecortacesped = 0;
		        	colocarenlacelda(fila, columna, 0);
		        	posinicialI = -3;
		        	posinicialJ = -3;
		        }
		        repaint();
		      }
		      
		      @Override
		      public void mouseExited(MouseEvent arg0) {
		        // TODO Auto-generated method stub
		      }
		      
		      @Override
		      public void mouseEntered(MouseEvent arg0) {
		        // TODO Auto-generated method stub
		      }
		      
		      @Override
		      public void mouseClicked(MouseEvent arg0) {
		      }
		    });
		}
		
//------------------------------------------MODO ALEATORIO------------------------------------------		
		if(modo == 1){
			for(int b = 0; b < porcentaje; b++){// coloca los obstaculos en el mapa
				int col = (int) (Math.random() * CELDASCOL);
				int fil = (int) (Math.random() * CELDASFILA);
				//int relleno = 1 + (int) (Math.random() * (2 -1));
				if(getvectorjardin()[fil][col].getcelda() == 0){
					colocarenlacelda(fil, col, 2);
				}else{
					while(getvectorjardin()[fil][col].getcelda() !=0 ){ //para controlar que no se pongan unos objetos encima de otros
						col = (int) (Math.random() * CELDASCOL);
						fil = (int) (Math.random() * CELDASFILA);
					}//WHILE
					colocarenlacelda(fil, col, 2);
				}//IF
				
			
				repaint();
			}//FOR
			for(int b = 0; b < porcentaje*2; b++){ //coloca el cesped largo en el mapa
				int col = (int) (Math.random() * CELDASCOL);
				int fil = (int) (Math.random() * CELDASFILA);
				int relleno = 1 + (int) (Math.random() * (2 -1));
				if(getvectorjardin()[fil][col].getcelda() == 0){
					colocarenlacelda(fil, col, relleno);
				}else{
					while(getvectorjardin()[fil][col].getcelda() !=0 ){ //para controlar que no se pongan unos objetos encima de otros
						col = (int) (Math.random() * CELDASCOL);
						fil = (int) (Math.random() * CELDASFILA);
					}//WHILE
					colocarenlacelda(fil, col, relleno);
				}//IF
				
			
				repaint();
			}// FOR
			
			int col = (int) (Math.random() * CELDASCOL);
			int fil = (int) (Math.random() * CELDASFILA);
			int relleno = 1 + (int) (Math.random() * (3 -1));// Para colocar el cortacesped
			if(getvectorjardin()[fil][col].getcelda() == 0){
				colocarenlacelda(fil, col, 3);
			}else{
				while(getvectorjardin()[fil][col].getcelda() !=0 ){ //para controlar que no se pongan unos objetos encima de otros
					col = (int) (Math.random() * CELDASCOL);
					fil = (int) (Math.random() * CELDASFILA);
				}//WHILE
				colocarenlacelda(fil, col, 3);
			}//IF
		}// FIN MODO RANDOM
	}// FIN DEL CONSTRUCTOR
//--------------------------------------FUNCION DE PINTADO-----------------------------------	
	  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);

		    g.setColor(new Color(cespedcorto[0],cespedcorto[1],cespedcorto[2]));
		    g.fillRect(0, 0, TAMCELDA * CELDASCOL,TAMCELDA * CELDASFILA);
		    g.setColor(Color.BLACK);
		    for (int i = 0; i < CELDASFILA; i ++) {       
		      for (int j = 0; j < CELDASCOL; j ++) {
		        g.drawRect( j * TAMCELDA, i * TAMCELDA, TAMCELDA, TAMCELDA);// Dibujamos las casillas vacías
		        if(getvectorjardin()[i][j].getcelda() == 1){// si es cesped largo
		        	g.setColor(new Color(cespedlargo[0],cespedlargo[1],cespedlargo[2]));
		        	g.fillRect( j * TAMCELDA + 1, i * TAMCELDA + 1, TAMCELDA - 1, TAMCELDA - 1);
		        	g.setColor(Color.BLACK);
		        }
		        if(getvectorjardin()[i][j].getcelda() == 2){//si es obstaculo
		        	g.setColor(new Color(obstaculo[0],obstaculo[1],obstaculo[2]));
		        	g.fillRect( j * TAMCELDA + 1, i * TAMCELDA + 1, TAMCELDA - 1, TAMCELDA - 1);
		        	g.setColor(Color.BLACK);
		        }
		        if((getvectorjardin()[i][j].getcelda() == 3)&& (numeromaximodecortacesped == 0)){// si es el unico cortacesped
		        	numeromaximodecortacesped = 1;
		        	g.setColor(new Color(cortacesped[0],cortacesped[1],cortacesped[2]));
		        	g.fillRect( j * TAMCELDA + 1, i * TAMCELDA + 1, TAMCELDA - 1, TAMCELDA - 1);
		        	g.setColor(Color.BLACK);
		        	posinicialI = i;
		        	posinicialJ = j;
		        }
		        if(getvectorjardin()[i][j].getcelda() == 0){
		        	g.setColor(new Color(cespedcorto[0],cespedcorto[1],cespedcorto[2]));
		        	g.fillRect( j * TAMCELDA + 1, i * TAMCELDA + 1, TAMCELDA - 1, TAMCELDA - 1);
		        	g.setColor(Color.BLACK);
		        }
		        if(numeromaximodecortacesped == 1){
		        	g.setColor(new Color(cortacesped[0],cortacesped[1],cortacesped[2]));
		        	g.fillRect( posinicialJ * TAMCELDA + 1, posinicialI * TAMCELDA + 1, TAMCELDA - 1, TAMCELDA - 1);
		        	g.setColor(Color.BLACK);
		        }
		      }
		    }
		  }
	
}
