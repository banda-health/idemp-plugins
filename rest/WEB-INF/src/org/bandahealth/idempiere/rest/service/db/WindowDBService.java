package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Window;
import org.compiere.model.MTab;
import org.compiere.model.MWindow;
import org.compiere.util.Env;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WindowDBService extends BaseDBService<Window, MWindow> {

	private final TabDBService tabDBService = new TabDBService();

	@Override
	public Window saveEntity(Window entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Window createInstanceWithDefaultFields(MWindow instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Window createInstanceWithAllFields(MWindow instance) {
		return new Window(instance);
	}

	@Override
	protected MWindow getModelInstance() {
		return new MWindow(Env.getCtx(), 0, null);
	}

	@Override
	public List<Window> transformData(List<MWindow> dbModels) {
		Set<Integer> windowIds = dbModels.stream().map(MWindow::getAD_Window_ID).collect(Collectors.toSet());

		// get tabs
		Map<Integer, List<MTab>> tabsByWindow = tabDBService.getGroupsByIds(MTab::getAD_Window_ID,
				MTab.COLUMNNAME_AD_Window_ID, windowIds);

		return dbModels.stream().map(window -> {
			Window result = new Window(window);

			if (tabsByWindow.containsKey(window.getAD_Window_ID())) {
				result.setTabs(tabDBService.transformData(tabsByWindow.get(window.getAD_Window_ID())));
			}

			return result;
		}).collect(Collectors.toList());
	}

	@Override
	protected EntityConfiguration getDefaultEntityConfiguration() {
		return new EntityConfiguration() {
			{
				setShouldUseContextClientId(false);
				setShouldFetchFromSystemClient(true);
			}
		};
	}

}
