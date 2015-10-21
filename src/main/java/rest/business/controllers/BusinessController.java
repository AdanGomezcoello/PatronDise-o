package rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import rest.business.models.entities.Theme;
import rest.business.models.entities.Vote;
import rest.business.views.TransferTheme;
import rest.data.models.daos.DaoFactory;
import rest.data.models.daos.ThemeDao;
import rest.data.models.daos.VoteDao;

public class BusinessController {
	public void createTheme(String themeName) {
		ThemeDao tDao = DaoFactory.getFactory().getThemeDao();
		int id = tDao.findAllNames().size();
		tDao.create(new Theme(id, themeName));
	}

	public List<String> getThemes() {
		List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
		List<String> themeNames = new ArrayList<String>();
		for (Theme theme : themes) {
			themeNames.add(theme.getName());
		}
		return themeNames;
	}

	public Theme getTheme(String voteValue) {
		ThemeDao tDao = DaoFactory.getFactory().getThemeDao();
		return tDao.findByName(voteValue);
	}

	public void voteTheme(String themeName, int voteValue) {
		VoteDao vDao = DaoFactory.getFactory().getVoteDao();
		int id = vDao.findAll().size();
		vDao.create(new Vote(id, voteValue, this.getTheme(themeName)));
	}

	public List<TransferTheme> getVotes() {
		List<Vote> votes = DaoFactory.getFactory().getVoteDao().findAll();
		List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
		List<TransferTheme> transferThemes = new ArrayList<TransferTheme>();
		for (Theme theme : themes) {
			transferThemes.add(new TransferTheme(theme.getName(), this.average(votes, theme.getName())));
		}
		return transferThemes;
	}

	private double average(List<Vote> votes, String theme) {
		int total = 0;
		int count = 0;
		for (Vote vote : votes) {
			if (vote.getTheme().getName() == theme) {
				total += vote.getVote();
				count++;
			}
		}
		return (double) total / count;
	}

}

