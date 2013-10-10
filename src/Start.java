////////////////////////////////////////////////////
// Miembros del Grupo:                            //
//  - Samuel González Alonso                      //
//  - Rubén Hernandez Rivero                      //
//  - Francisco Mendoza González                  //
//                                                //
//                                                //
////////////////////////////////////////////////////
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Start {
	
	static int columnas = 0;
	static int filas = 0 ;
	static int tamano = 0;
	static int anchopanel = 35;
	static int anchoborde = 9;
	static int anchoradio = 111;
	static int tantoporcientodeobstaculo = 0;
	

	public static void main(String[] args) {
		
		columnas = Integer.parseInt(args[0]);//Introduce el numero de columnas
		filas = Integer.parseInt(args[1]);//Introduce el numero de filas
		tamano = Integer.parseInt(args[2]);//Introduce el tamano de las celdas
		tantoporcientodeobstaculo = Integer.parseInt(args[3]);//Introduce el % de obstaculos que habra
		final int porcentajecalculado = (columnas * filas * tantoporcientodeobstaculo)/100;
		
		
		
		
		// TODO Auto-generated method stub
		final int ancho = (tamano)*columnas+anchoborde+anchoradio;
		final int alto = (tamano)*filas+anchopanel;
		
		JButton modomanual = new JButton("Modo Manual");
		JButton modorandom = new JButton("Modo Aleatorio");

		JPanel panelbotones = new JPanel();
		
		panelbotones.setLayout(new GridLayout(2,1));
		panelbotones.add(modomanual);
		panelbotones.add(modorandom);
		//panelbotones.add(samu30);
				
		final JFrame ventanaopciones = new JFrame();
	    ventanaopciones.add(panelbotones);
	    ventanaopciones.setSize(200,200);
	    ventanaopciones.setTitle("Seleccion de Mapa");
	    ventanaopciones.setLocationRelativeTo(null);
	    ventanaopciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ventanaopciones.setVisible(true);
	    
	    modomanual.addMouseListener(new MouseListener() {
		      
		      @Override
		      public void mouseReleased(MouseEvent arg0) {
		        // TODO Auto-generated method stub
		      }
		      
		      @Override
		      public void mousePressed(MouseEvent arg0) {
		    	RadioButtons opciones = new RadioButtons();
		  		jardin tablero = new jardin(filas,columnas,tamano,opciones,0,0);
		  		
		  		
		  		JFrame ventana = new JFrame();
		  	    ventana.add(tablero);
		  	    ventana.add(opciones, BorderLayout.EAST);
		  	    ventana.setSize(ancho,alto);
		  	    ventana.setTitle("Jardin");
		  	    ventana.setLocationRelativeTo(null);
		  	    ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  	    ventana.setVisible(true);
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
	    
	    modorandom.addMouseListener(new MouseListener() {
		      
		      @Override
		      public void mouseReleased(MouseEvent arg0) {
		        // TODO Auto-generated method stub
		      }
		      
		      @Override
		      public void mousePressed(MouseEvent arg0) {
		    	RadioButtons opciones = new RadioButtons();
		  		jardin tablero = new jardin(filas,columnas,tamano,opciones,1,porcentajecalculado);
		  		
		  		final int anchosinradios = ancho - anchoradio;
		  		
		  		JFrame ventana = new JFrame();
		  	    ventana.add(tablero);
		  	    ventana.setSize(anchosinradios,alto);
		  	    ventana.setTitle("Jardin");
		  	    ventana.setLocationRelativeTo(null);
		  	    ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  	    ventana.setVisible(true);
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
		
//-------------------------- A partir de aqui era el main inicial no borrar por si es necesario mas adelante ------------------------------
		
		/*RadioButtons opciones = new RadioButtons();
		jardin tablero = new jardin(filas,columnas,tamano,opciones);
		
		JFrame ventana = new JFrame();
	    ventana.add(tablero);
	    ventana.add(opciones, BorderLayout.EAST);
	    ventana.setSize(ancho,alto);
	    ventana.setTitle("Jardin");
	    ventana.setLocationRelativeTo(null);
	    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ventana.setVisible(true);*/

	}
	

}
