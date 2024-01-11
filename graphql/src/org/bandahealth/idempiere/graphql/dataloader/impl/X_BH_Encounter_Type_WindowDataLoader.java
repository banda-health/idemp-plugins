package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;

/**
 * Data Loader for BH_Encounter_Type_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Encounter_Type_WindowDataLoader extends PODataLoader<MBHEncounterTypeWindow> {
	public static String BH_Encounter_Type_Window_BY_ID_DATA_LOADER = "BH_Encounter_Type_WindowByIdDataLoader";
	public static String BH_Encounter_Type_Window_BY_UUID_DATA_LOADER = "BH_Encounter_Type_WindowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHEncounterTypeWindow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Encounter_Type_Window_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Encounter_Type_Window_BY_UUID_DATA_LOADER;
	}
}
