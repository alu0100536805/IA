import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtons extends JPanel {
	
	
	
	private JRadioButton rblargo = new JRadioButton("Cesped largo",true);
	private JRadioButton rbobstaculo = new JRadioButton("Obstaculo",false);
	private JRadioButton rbcortacesped = new JRadioButton("Cortacesped",false);
	private JRadioButton rbcorto = new JRadioButton("Cesped corto",false);
	
	public JRadioButton getrblargo(){
		return rblargo;
	}
	
	public JRadioButton getrbobstaculo(){
		return rbobstaculo;
	}

	public JRadioButton getrbcortacesped(){
		return rbcortacesped;
	}
	
	public JRadioButton getrbcorto(){
		return rbcorto;
	}
	
	
	
	public RadioButtons(){
		JPanel panelradio = new JPanel();
		panelradio.setLayout(new GridLayout(4,1));
		panelradio.add(rblargo);
		panelradio.add(rbobstaculo);
		panelradio.add(rbcortacesped);
		panelradio.add(rbcorto);
		add(panelradio);
		
		ButtonGroup rbopciones = new ButtonGroup();
		rbopciones.add(rblargo);
		rbopciones.add(rbobstaculo);
		rbopciones.add(rbcortacesped);
		rbopciones.add(rbcorto);
			
	}

}