package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.EncounterTypeWindow;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.model.Window;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EncounterTypeWindowDBService extends BaseDBService<EncounterTypeWindow, MBHEncounterTypeWindow> {

	private final WindowDBService windowDBService = new WindowDBService();
	private final ReferenceListDBService referenceListDBService = new ReferenceListDBService();

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
		Map<Integer, Window> windowsById = windowDBService.transformData(new ArrayList<>(windowDBService.getByIds(
						dbModels.stream().map(MBHEncounterTypeWindow::getAD_Window_ID).collect(Collectors.toSet())).values())).stream()
				.collect(Collectors.toMap(Window::getId, window -> window));

		// get get encounter types
		Map<String, ReferenceList> encounterTypesByValue = referenceListDBService.getTypes(MReference_BH.ENCOUNTER_TYPES,
						dbModels.stream().map(MBHEncounterTypeWindow::getBH_Encounter_Type).collect(Collectors.toSet())).stream()
				.collect(Collectors.toMap(MRefList::getValue, ReferenceList::new));

		return dbModels.stream().map(encounterTypeWindowMapping -> {
			EncounterTypeWindow result = new EncounterTypeWindow(encounterTypeWindowMapping);

			if (windowsById.containsKey(encounterTypeWindowMapping.getAD_Window_ID())) {
				result.setWindow(windowsById.get(encounterTypeWindowMapping.getAD_Window_ID()));
			}
			if (encounterTypesByValue.containsKey(encounterTypeWindowMapping.getBH_Encounter_Type())) {
				result.setEncounterType(encounterTypesByValue.get(encounterTypeWindowMapping.getBH_Encounter_Type()));
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
