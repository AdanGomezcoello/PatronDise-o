package Voting;

import es.upm.miw.pd.voting.solution.rest.data.models.daos.DaoFactory;
import es.upm.miw.pd.voting.solution.rest.data.models.daos.memory.DaoFactoryMemory;
import web.http.HttpMethod;
import web.http.HttpRequest;

public class VotingMain {

    public VotingMain() {
    }

    public void voting(){
        HttpRequest request = new HttpRequest("LocalHost", "Voting", HttpMethod.GET);
        System.out.println(request.toString() + "\n");
        
        new Client().send(request);
    }
    
    public void votingVoteTheme(String themeName, int value) {
        HttpRequest request = new HttpRequest("LocalHost", "Voting", HttpMethod.POST);
        request.addQueryParam("action", "voteTheme");
        request.addQueryParam("themeName", themeName);
        request.addQueryParam("value", "" + value);
        System.out.println(request.toString() + "\n");
        
        new Client().send(request);
    }

    public void themeManager(){
        HttpRequest request = new HttpRequest("LocalHost", "ThemeManager", HttpMethod.GET);
        System.out.println(request.toString() + "\n");
        
        new Client().send(request);
    }
    
    public void themeManagerCreateTheme(String themeName){
        HttpRequest request = new HttpRequest("LocalHost", "ThemeManager", HttpMethod.POST);
        request.addQueryParam("action", "createTheme");
        request.addQueryParam("themeName", themeName);
        System.out.println(request.toString() + "\n");
        
        new Client().send(request);
    }
    

    public static void main(String[] args) {
        DaoFactory.setFactory(new DaoFactoryMemory());
        VotingMain main = new VotingMain();
        System.out.println("-------Voting--------------------------------------------------------");
        main.voting();
        System.out.println("-------ThemeManager--------------------------------------------------");
        main.themeManager();
        System.out.println("---");
        main.themeManagerCreateTheme("Tema1");
        System.out.println("---");
        main.themeManagerCreateTheme("Tema2");
        System.out.println("-------Voting--------------------------------------------------------");
        main.votingVoteTheme("Tema1", 4);
        System.out.println("---");
        main.votingVoteTheme("Tema1", 6);
        System.out.println("---");
        main.votingVoteTheme("Tema1", 5);
        System.out.println("---");
        main.votingVoteTheme("Tema2", 5);
    }

}
