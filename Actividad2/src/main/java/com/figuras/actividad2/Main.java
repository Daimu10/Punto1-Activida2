
package com.figuras.actividad2;


import com.figuras.actividad2.Controller.Controller;
import Model.Competencia;
import View.View;

public class Main {
	public static void main(String[] args) {
		// Inicializar MVC
		Competencia competencia = new Competencia("Mundial Pista - Cali");
		Controller controller = new Controller(competencia);
		View view = new View();
		// Delegar interacción con el usuario a la vista
		view.iniciarMenu(controller);
	}
}
