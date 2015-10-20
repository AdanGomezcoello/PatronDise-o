package web.presentation.frontController;

import web.http.HttpRequest;
import web.http.HttpResponse;

public class FrontController {
	private Dispatcher dispatcher;

	public FrontController() {
		dispatcher = new Dispatcher();
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		dispatcher.doGet(request, response);
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		dispatcher.doPost(request, response);
	}

}
