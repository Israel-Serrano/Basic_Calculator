package controller;

import view.PrincipalFrame;

public class Main {

	public static void main(String[] args) {
		PrincipalFrame frame = new PrincipalFrame();
		EventsController control = new EventsController(frame);
		frame.controller(control);

	}

}
