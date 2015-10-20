package rest.data.models.daos.memory;

import rest.data.models.daos.DaoFactory;
import rest.data.models.daos.ThemeDao;
import rest.data.models.daos.VoteDao;

public class DaoFactoryMemory extends DaoFactory {

	private ThemeDao themeDao;

	private VoteDao voteDao;

	public DaoFactoryMemory() {
	}

	@Override
	public ThemeDao getThemeDao() {
		if (themeDao == null) {
			themeDao = new ThemeMemoryDao();
		}
		return themeDao;
	}

	@Override
	public VoteDao getVoteDao() {
		if (voteDao == null) {
			voteDao = new VoteMemoryDao();
		}
		return voteDao;
	}

}
