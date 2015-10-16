package web.presentation.views;

import web.presentation.models.Model;

public class ErrorView implements View {

    @Override
    public void show(Model model) {
        System.out.println("ErrorView \n  error: "+ model.get("error"));
    }

}
