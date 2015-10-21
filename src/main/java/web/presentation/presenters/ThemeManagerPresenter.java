package web.presentation.presenters;

import java.util.List;

import rest.business.controllers.BusinessController;
import web.presentation.models.Model;

public class ThemeManagerPresenter {
	public String process(Model model) {
		List<String> themes = (new BusinessController()).getThemes();
		String log = "";
		int size = themes.size(), i = 1;
		for (String theme : themes) {
			log += theme;
			if (i < size) {
				log += ", ";
				i++;
			}
		}
		log += "]";
		model.put("log", log);
		return "ThemeManagerView";
	}

	public String createTheme(Model model) {
		BusinessController businessController = new BusinessController();
		String themeName = (String) model.get("themeName");
		businessController.createTheme(themeName);
		this.process(model);
		return "ThemeManagerView";
	}
}
