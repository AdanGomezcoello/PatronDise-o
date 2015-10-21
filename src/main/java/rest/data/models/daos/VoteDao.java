package rest.data.models.daos;

import java.util.List;

import rest.business.models.entities.Theme;
import rest.business.models.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {
	public List<Vote> findByTheme(Theme theme);
}
