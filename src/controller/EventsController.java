package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.CalculatorFrame;

public class EventsController implements ActionListener{

		private CalculatorFrame frame;
		private double n1, n2; 

		public EventsController(CalculatorFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				if(e.getSource() == frame.getAddition()) {
					initVarText();
					frame.getFinalResult().setText(String.valueOf(n1+n2));
					resetAndFocus();
				}
				
				else if(e.getSource() == frame.getMinus()) {
					initVarText();
					frame.getFinalResult().setText(String.valueOf(n1-n2));
					resetAndFocus();
				}
				
				else if(e.getSource() == frame.getMultiplication()) {
					initVarText();
					frame.getFinalResult().setText(String.valueOf(n1*n2));
					resetAndFocus();
				}
				
				else if(e.getSource() == frame.getDivision()) {
					initVarText();
					if(n2 != 0) {						
						frame.getFinalResult().setText(String.valueOf(n1/n2));
						resetAndFocus();
					}
					
					else {
						JOptionPane.showMessageDialog(frame, "No se puede dividir por 0", "¡ERROR!", 2);
						resetAndFocus();
					}
					
				}
				
				else if(e.getSource() == frame.getR2()) {
					JOptionPane.showMessageDialog(frame, "Función prohibida,\n"
								+ " estas seguro de querer entrar?","¡ADVERTENCIA!", 2);
					JOptionPane.showMessageDialog(frame, "Pues va a ser que no","¡ERROR!",0);
				}
				
				//SE HA CAMBIANDO LA FORMA DE RECOGER LA INFORMACIÓN A TRAVÉS DE JOPTIONPANE Y SE HA REALIZADO LA RAÍZ EN ESA VENTANA.
				else if(e.getSource()== frame.getR3()) {
					
					String pass = JOptionPane.showInputDialog("Escribe la contraseña");
					if(pass.equals("Vader")) {
						String r3Answer = JOptionPane.showInputDialog("Inserte un número para calcular su raíz cúbica");
						double n3 = Double.parseDouble(r3Answer);
						frame.getFinalResult().setText(String.valueOf(Math.cbrt(n3)));
						
					}
					
					else {
						JOptionPane.showMessageDialog(frame, "Contraseña incorrecta");
					}
					
					resetAndFocus();
				}
				
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame, "Dato insertado incorrecto. \n\n"
						 + "Recuerde no dejar campos en blanco \n"
						 + " e introducir valores númericos.", "¡ADVERTENCIA!", 2);
			}

		}
		//SE HAN CREADO ESTOS MÉTODOS PARA REFACTORIZAR.
		public void resetAndFocus(){
			frame.getTextOne().setText("");
			frame.getTextTwo().setText("");
			frame.getTextOne().requestFocus();
		}
		
		public void initVarText() {
			n1 = Double.parseDouble(frame.getTextOne().getText());
			n2 = Double.parseDouble(frame.getTextTwo().getText());
		}
			
}


