package web.presentation.views;

import web.presentation.models.Model;

public class VotingView implements View {
	
	@Override
	public void show(Model model) {
		System.out.print("Voting Page\n\tTemas: [");
		System.out.println(model.get("log"));
	}
}
