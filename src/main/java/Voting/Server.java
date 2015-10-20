package Voting;

import web.presentation.frontController.FrontController;
import web.http.HttpMethod;
import web.http.HttpRequest;
import web.http.HttpResponse;
import web.http.HttpStatus;

public class Server {

	public HttpResponse send(HttpRequest request) {
		HttpResponse response = new HttpResponse();
		if (HttpMethod.GET.equals(request.getMethod())) {
			new FrontController().doGet(request, response);
		} else if (HttpMethod.POST.equals(request.getMethod())) {
			new FrontController().doPost(request, response);
		}
		response.setStatus(HttpStatus.OK);
		return response;
	}

}
