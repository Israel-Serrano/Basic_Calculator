package controller;

import view.CalculatorFrame;

public class Main {

	public static void main(String[] args) {
		CalculatorFrame frame = new CalculatorFrame();
		EventsController control = new EventsController(frame);
		control.PlaySound("sounds/R2D2.wav");
		frame.controller(control);

	}

}
