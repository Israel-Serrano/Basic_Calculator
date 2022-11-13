package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.PrincipalFrame;

public class EventsController implements ActionListener{

		private PrincipalFrame frame;
		private double x1, x2; 

		public EventsController(PrincipalFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				if(e.getSource() == frame.getAddition()) {
					initVarText();
					frame.getFinalResult().setText(String.valueOf(x1+x2));
					resetAndFocus();
				}
				
				else if(e.getSource() == frame.getMinus()) {
					initVarText();
					frame.getFinalResult().setText(String.valueOf(x1-x2));
					resetAndFocus();
				}
				
				else if(e.getSource() == frame.getMultiplication()) {
					initVarText();
					frame.getFinalResult().setText(String.valueOf(x1*x2));
					resetAndFocus();
				}
				
				else if(e.getSource() == frame.getDivision()) {
					initVarText();
					if(x2 != 0) {						
						frame.getFinalResult().setText(String.valueOf(x1/x2));
						resetAndFocus();
					}
					else {
						JOptionPane.showMessageDialog(frame, "No se puede dividir por 0", "¡ERROR!", 2);
						resetAndFocus();
					}
					//ESTA LA QUEREMOS DEJAR PARA QUE VEA QUE FUNCIONA CON EL INT.
					/* Funcionalidad con Integer, arrojando excepción y recogiendola.
					try {
					
						int x1 = Integer.parseInt(frame.getTextOne().getText());
						int x2 = Integer.parseInt(frame.getTextTwo().getText());	
								
						frame.getFinalResult().setText(String.valueOf(x1/x2));
							
					}catch (ArithmeticException ex) {
						
						ex.printStackTrace();
						JOptionPane.showMessageDialog(frame, "No se puede dividir por 0, imbécil", "¡ERROR!", 2);
							
					}
					
					resetAndFocus();
					*/	
				}
				
				else if(e.getSource() == frame.getR2()) {
					JOptionPane.showMessageDialog(frame, "Función prohibida,\n"
								+ " estas seguro de querer entrar?","¡ADVERTENCIA!", 2);
					JOptionPane.showMessageDialog(frame, "Pues va a ser que no","¡ERROR!",0);
				}
				
				//SE HA CAMBIANDO LA FORMA DE RECOGER LA INFORMACIÓN A TRAVÉS DE JOPTIONPANE Y SE HA REALIZADO LA RAÍZ EN ESA VENTANA.
				else if(e.getSource()== frame.getR3()) {
					
					String pass = JOptionPane.showInputDialog("Digite la contraseña");
					if(pass.equals("Raquel")) {
						String r3Response = JOptionPane.showInputDialog("Inserte un número para calcular su raíz cúbica");
						double x3 = Double.parseDouble(r3Response);
						frame.getFinalResult().setText(String.valueOf(Math.cbrt(x3)));
						
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
			x1 = Double.parseDouble(frame.getTextOne().getText());
			x2 = Double.parseDouble(frame.getTextTwo().getText());
		}
			
}


