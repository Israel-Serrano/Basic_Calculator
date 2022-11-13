package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EventsController;

public class CalculatorFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel numberOne, numberTwo, result, finalResult, logo;
	private JButton addition, minus, multiplication, division, r2, r3;
	private JTextField textOne, textTwo;
	private Image img;
		
	//constructor de la ventana de la calculadora
	public CalculatorFrame () {
		setSize(410,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Calculadora");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/calculadora3.png"));
		setJMenuBar(getJMenuBar());
		setLayout(null);
		
		initialiceComponents();
		
		setVisible(true);
	}
	
	// inicializa los componentes de la ventana
	private void initialiceComponents() {
		
		getContentPane().setBackground(Color.BLACK);// seteamos un color de fondo a la ventana
		
		//pone una imagen arriba de los componentes
		img = new ImageIcon("img/star_wars_logo.png").getImage();
		logo = new JLabel(new ImageIcon(img.getScaledInstance(420, 240, Image.SCALE_SMOOTH)));
		logo.setBounds(0, 0, 410, 240);
		add(logo);
		
		//inicializa primero las etiquetas
		numberOne = new JLabel("Número 1 :");
		numberOne.setBounds(50, 250, 120, 30);
		numberOne.setFont(new Font("Dialog", Font.BOLD, 14));
		numberOne.setForeground(Color.RED);
		add(numberOne);
		
		numberTwo = new JLabel("Número 2 :");
		numberTwo.setBounds(200, 250, 120, 30);
		numberTwo.setFont(new Font("Dialog", Font.BOLD, 14));
		numberTwo.setForeground(Color.RED);
		add(numberTwo);
		
		result = new JLabel("Resultado:");
		result.setBounds(100, 520, 120, 30);
		result.setFont(new Font("Dialog", Font.BOLD, 14));
		result.setForeground(Color.RED);
		add(result);
		
		finalResult = new JLabel();
		finalResult.setBounds(190, 520, 120, 30);
		finalResult.setFont(new Font("Dialog", Font.BOLD, 14));
		finalResult.setForeground(Color.RED);
		add(finalResult);
		
		//en segundo lugar inicializa los campos de texto
		textOne = new JTextField();
		textOne.setBounds(130, 250, 60, 30);
		textOne.setFont(new Font("Dialog", Font.BOLD, 14));
		textOne.setForeground(Color.DARK_GRAY);
		textOne.setBackground(Color.ORANGE);
		add(textOne);
				
		textTwo = new JTextField();
		textTwo.setBounds(285, 250, 60, 30);
		textTwo.setFont(new Font("Dialog", Font.BOLD, 14));
		textTwo.setForeground(Color.DARK_GRAY);
		textTwo.setBackground(Color.ORANGE);
		add(textTwo);
		
		//en último lugar inicializa los botones
		addition = new JButton("SUMAR");
		addition.setBounds(60, 320, 130, 50);
		addition.setFont(new Font("Dialog", Font.BOLD, 14));
		addition.setForeground(Color.DARK_GRAY);
		addition.setBackground(Color.RED);
		add(addition);
		
		minus = new JButton("RESTAR");
		minus.setBounds(220, 320, 130, 50);
		minus.setFont(new Font("Dialog", Font.BOLD, 14));
		minus.setForeground(Color.DARK_GRAY);
		minus.setBackground(Color.RED);
		add(minus);
		
		multiplication = new JButton("MULTIPLICAR");
		multiplication.setBounds(60, 380, 130, 50);
		multiplication.setFont(new Font("Dialog", Font.BOLD, 14));
		multiplication.setForeground(Color.DARK_GRAY);
		multiplication.setBackground(Color.RED);
		add(multiplication);
		
		division = new JButton("DIVIDIR");
		division.setBounds(220, 380, 130, 50);
		division.setFont(new Font("Dialog", Font.BOLD, 14));
		division.setForeground(Color.DARK_GRAY);
		division.setBackground(Color.RED);
		add(division);
		
		r2 = new JButton("√2");
		r2.setBounds(60, 440, 130, 50);
		r2.setFont(new Font("Dialog", Font.BOLD, 14));
		r2.setForeground(Color.DARK_GRAY);
		r2.setBackground(Color.RED);
		add(r2);
		
		r3 = new JButton("√3");
		r3.setBounds(220, 440, 130, 50);
		r3.setFont(new Font("Dialog", Font.BOLD, 14));
		r3.setForeground(Color.DARK_GRAY);
		r3.setBackground(Color.RED);
		add(r3);
					
	}
	
	//activa los listeners de los botones
	public void controller(EventsController control) {
		
		addition.addActionListener(control);
		minus.addActionListener(control); 
		multiplication.addActionListener(control); 
		division.addActionListener(control);
		r2.addActionListener(control);
		r3.addActionListener(control);		
	}

	//Generamos getters
	public JLabel getFinalResult() {
		return finalResult;
	}

	public JButton getAddition() {
		return addition;
	}

	public JButton getMinus() {
		return minus;
	}

	public JButton getMultiplication() {
		return multiplication;
	}

	public JButton getDivision() {
		return division;
	}

	public JButton getR2() {
		return r2;
	}

	public JButton getR3() {
		return r3;
	}

	public JTextField getTextOne() {
		return textOne;
	}

	public JTextField getTextTwo() {
		return textTwo;
	}
	

}
