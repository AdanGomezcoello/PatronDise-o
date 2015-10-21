package web.presentation.presenters;

import java.util.List;

import rest.business.controllers.BusinessController;
import rest.business.views.TransferTheme;
import web.presentation.models.Model;

public class VotingPresenter {
	public String process(Model model) {
		List<TransferTheme> themes = (new BusinessController()).getVotes();
		String log = "";
		int size = themes.size(), i = 1;
		for (TransferTheme theme : themes) {
			log += theme.toString();
			if (i < size) {
				log += ", ";
				i++;
			}
		}
		log += "]";
		model.put("log", log);
		return "VotingView";
	}

	public String voteTheme(Model model) {
		BusinessController BusinessController = new BusinessController();
		int voteValue = Integer.valueOf((String) model.get("voteValue"));
		String themeName = (String) model.get("themeName");
		BusinessController.voteTheme(themeName, voteValue);
		this.process(model);
		return "VotingView";
	}
}
