package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.EncounterTypeWindow;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncounterTypeWindowDBService extends BaseDBService<EncounterTypeWindow, MBHEncounterTypeWindow> {

	@Autowired
	private WindowDBService windowDBService;

	@Override
	public EncounterTypeWindow saveEntity(EncounterTypeWindow entity) {
		MBHEncounterTypeWindow encounterTypeWindowMapping = new Query(Env.getCtx(), MBHEncounterTypeWindow.Table_Name,
				MBHEncounterTypeWindow.COLUMNNAME_BH_Encounter_Type_Window_UU + " =?", null)
						.setParameters(entity.getUuid()).first();
		if (encounterTypeWindowMapping == null) {
			throw new AdempiereException("Encounter type window mapping not found.");
		}

		return createInstanceWithAllFields(encounterTypeWindowMapping);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected EncounterTypeWindow createInstanceWithDefaultFields(MBHEncounterTypeWindow instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected EncounterTypeWindow createInstanceWithAllFields(MBHEncounterTypeWindow instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MBHEncounterTypeWindow getModelInstance() {
		return new MBHEncounterTypeWindow(Env.getCtx(), 0, null);
	}

	@Override
	public List<EncounterTypeWindow> transformData(List<MBHEncounterTypeWindow> dbModels) {
		// get windows
		Map<Integer, MWindow> windowsById = windowDBService
				.getByIds(dbModels.stream().map(MBHEncounterTypeWindow::getAD_Window_ID).collect(Collectors.toSet()));

		List<EncounterTypeWindow> results = dbModels.stream().map(encounterTypeWindowMapping -> {
			EncounterTypeWindow result = new EncounterTypeWindow(encounterTypeWindowMapping);

			if (windowsById.containsKey(encounterTypeWindowMapping.getAD_Window_ID())) {
				result.setWindow(
						windowDBService
								.transformData(Collections
										.singletonList(windowsById.get(encounterTypeWindowMapping.getAD_Window_ID())))
								.get(0));
			}

			return result;
		}).collect(Collectors.toList());

		return results;
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
