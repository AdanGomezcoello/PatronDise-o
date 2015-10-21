package rest.data.models.daos;

import rest.business.models.entities.Theme;
import java.util.List;

public interface ThemeDao extends GenericDao<Theme, Integer> {
	public Theme findByName(String themeName);

	public List<String> findAllNames();

}
