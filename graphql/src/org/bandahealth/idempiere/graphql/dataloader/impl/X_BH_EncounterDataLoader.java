package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounter;

/**
 * Data Loader for BH_Encounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_EncounterDataLoader extends PODataLoader<MBHEncounter> {
	public static String DATALOADER_BH_Encounter_BY_ID = "BH_EncounterByIdDataLoader";
	public static String DATALOADER_BH_Encounter_BY_UUID = "BH_EncounterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHEncounter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Encounter_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Encounter_BY_UUID;
	}
}
