package org.bandahealth.idempiere.rest.service.db;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Tab;
import org.compiere.model.MField;
import org.compiere.model.MTab;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TabDBService extends BaseDBService<Tab, MTab> {

	@Autowired
	private FieldDBService fieldDBService;

	@Override
	public Tab saveEntity(Tab entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Tab createInstanceWithDefaultFields(MTab instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Tab createInstanceWithAllFields(MTab instance) {
		return new Tab(instance);
	}

	@Override
	protected Tab createInstanceWithSearchFields(MTab instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MTab getModelInstance() {
		return new MTab(Env.getCtx(), 0, null);
	}

	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}

	@Override
	public List<Tab> transformData(List<MTab> dbModels) {
		Set<Integer> fieldsId = dbModels.stream().map(MTab::getAD_Tab_ID).collect(Collectors.toSet());

		// get fields
		Map<Integer, List<MField>> fieldsByTab = fieldDBService.getGroupsByIds(MField::getAD_Tab_ID,
				MField.COLUMNNAME_AD_Column_ID, fieldsId);

		return dbModels.stream().map(tab -> {
			Tab result = new Tab(tab);

			if (fieldsByTab.containsKey(tab.getAD_Tab_ID())) {
				result.setFields(fieldDBService.transformData(fieldsByTab.get(tab.getAD_Tab_ID())));
			}

			return result;
		}).collect(Collectors.toList());
	}
}
