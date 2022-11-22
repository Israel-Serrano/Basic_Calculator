package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
					PlaySound("sounds/coolsaber.wav");
					frame.getFinalResult().setText(String.valueOf(n1+n2));
					resetAndFocus();
				}
				
				else if(e.getSource() == frame.getMinus()) {
					initVarText();
					PlaySound("sounds/coolsaber.wav");
					frame.getFinalResult().setText(String.valueOf(n1-n2));
					resetAndFocus();
				}
				
				else if(e.getSource() == frame.getMultiplication()) {
					initVarText();
					PlaySound("sounds/coolsaber.wav");
					frame.getFinalResult().setText(String.valueOf(n1*n2));
					resetAndFocus();
				}
				
				else if(e.getSource() == frame.getDivision()) {
					initVarText();
					PlaySound("sounds/coolsaber.wav");
					if(n2 != 0) {						
						frame.getFinalResult().setText(String.valueOf(round(n1/n2)));
						resetAndFocus();
					}
					
					else {
						PlaySound("sounds/error.wav");
						JOptionPane.showMessageDialog(frame, "No se puede dividir por 0", "¡ERROR!", 2);
						resetAndFocus();
					}
					
				}
				
				else if(e.getSource() == frame.getR2()) {
					PlaySound("sounds/SlowSabr.wav");
					JOptionPane.showMessageDialog(frame, "Función prohibida,\n"
								+ " estas seguro de querer entrar?","¡ADVERTENCIA!", 2);
					JOptionPane.showMessageDialog(frame, "Pues va a ser que no","¡ERROR!",0);
				}
				
				//recoge la información a través de un JOptionPane y se realiza la raíz cúbica en esa ventana
				else if(e.getSource()== frame.getR3()) {
					PlaySound("sounds/darth_vader.wav");
					int cont = 3;
					do {
												
						String pass = JOptionPane.showInputDialog("Escribe la contraseña");					
						
						if(pass.equals("Vader")) {
							String r3Answer = JOptionPane.showInputDialog("Inserte un número para calcular su raíz cúbica");
							double n3 = Double.parseDouble(r3Answer);
							frame.getFinalResult().setText(String.valueOf(round(Math.cbrt(n3))));
								
						}
							
						else {
							PlaySound("sounds/error.wav");								
							cont--;
							JOptionPane.showMessageDialog(frame, "Contraseña incorrecta \n Te quedan " + cont + " intentos");
							}
						
					}while(cont != 0);
						
						resetAndFocus();					
				}
				
			} catch (NumberFormatException ex) {
				PlaySound("sounds/error.wav");
				JOptionPane.showMessageDialog(frame, "Dato insertado incorrecto. \n\n"
						 + "Recuerda no dejar campos en blanco \n"
						 + " e introducir valores númericos.", "¡ADVERTENCIA!", 2);
			}

		}
		
		//resetea las cajas de texto y pone el foco en la primera
		public void resetAndFocus(){
			frame.getTextOne().setText("");
			frame.getTextTwo().setText("");
			frame.getTextOne().requestFocus();
		}
		
		//coje los valores de las cajas de texto y lo mete en sus variables para trabajar con ellas
		public void initVarText() {
			n1 = Double.parseDouble(frame.getTextOne().getText());
			n2 = Double.parseDouble(frame.getTextTwo().getText());
		}
		
		//función para redondear decimales
		public double round(double num) {
            return Math.round(num * 100.0)/100.0;
        }
		
		//procedimiento para agregar el sonido a los eventos
		public void PlaySound(String soundName){
            try {
             AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
             Clip clip = AudioSystem.getClip();
             clip.open(audioInputStream);
             clip.start();
            } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
              System.out.println("Error al reproducir el sonido.");
            }
          }
			
}


