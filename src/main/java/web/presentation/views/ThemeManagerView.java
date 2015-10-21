package web.presentation.views;

import web.presentation.models.Model;

public class ThemeManagerView implements View {

	@Override
	public void show(Model model) {
		System.out.print("Theme Manager Page\n\tTemas: [");
		System.out.println(model.get("log"));
	}
}
