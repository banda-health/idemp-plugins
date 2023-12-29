package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounter;

/**
 * Data Loader for BH_Encounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_EncounterDataLoader extends PODataLoader<MBHEncounter> {
	public static String BH_Encounter_BY_ID_DATA_LOADER = "BH_EncounterByIdDataLoader";
	public static String BH_Encounter_BY_UUID_DATA_LOADER = "BH_EncounterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHEncounter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Encounter_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Encounter_BY_UUID_DATA_LOADER;
	}
}
