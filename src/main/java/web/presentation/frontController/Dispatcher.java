package web.presentation.frontController;

import web.http.HttpRequest;
import web.http.HttpResponse;
import web.presentation.models.Model;
import web.presentation.presenters.ThemeManagerPresenter;
import web.presentation.presenters.VotingPresenter;
import web.presentation.views.ErrorView;
import web.presentation.views.ThemeManagerView;
import web.presentation.views.VotingView;
import web.presentation.views.View;

public class Dispatcher {
	public void doGet(HttpRequest request, HttpResponse response) {
		Model model = new Model();
		String presenter = request.getPath() + "Presenter";
		String nextView = request.getPath() + "View";

		switch (presenter) {
		case "ThemeManagerPresenter":
			ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
			nextView = themeManagerPresenter.process(model);
			break;
		case "VotingPresenter":
			VotingPresenter votingPresenter = new VotingPresenter();
			nextView = votingPresenter.process(model);
			break;
		}
		this.show(nextView, model);
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		Model model = new Model();
		String controller = request.getPath() + "Presenter";
		String action = request.getParams().get("action");
		String nextView = request.getPath() + "View";
		String themeName = request.getParams().get("themeName");
		String voteValue = request.getParams().get("value");
		switch (controller) {
		case "ThemeManagerPresenter":
			ThemeManagerPresenter tmPresenter = new ThemeManagerPresenter();
			model.put("themeName", themeName);
			if ("createTheme".equals(action)) {
				nextView = tmPresenter.createTheme(model);
			} else {
				model.put("error", "Acción no permitida: " + action);
			}
			break;
		case "VotingPresenter":
			VotingPresenter votingPresenter = new VotingPresenter();
			model.put("themeName", themeName);
			model.put("voteValue", voteValue);
			if ("voteTheme".equals(action)) {
				nextView = votingPresenter.voteTheme(model);
			} else {
				model.put("error", "Acción no permitida: " + action);
			}
			break;
		}
		this.show(nextView, model);
	}

	private void show(String nextView, Model model) {
		View view;
		switch (nextView) {
		case "ThemeManagerView":
			view = new ThemeManagerView();
			break;
		case "VotingView":
			view = new VotingView();
			break;
		default:
			view = new ErrorView();
			model.put("error", "Vista no encontrada: " + nextView);
		}
		view.show(model);
	}
}
