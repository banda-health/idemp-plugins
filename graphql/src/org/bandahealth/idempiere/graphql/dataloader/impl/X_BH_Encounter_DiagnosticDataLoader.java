package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;

/**
 * Data Loader for BH_Encounter_Diagnostic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Encounter_DiagnosticDataLoader extends PODataLoader<MBHEncounterDiagnostic> {
	public static String DATALOADER_BH_Encounter_Diagnostic_BY_ID = "BH_Encounter_DiagnosticByIdDataLoader";
	public static String DATALOADER_BH_Encounter_Diagnostic_BY_UUID = "BH_Encounter_DiagnosticByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHEncounterDiagnostic.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Encounter_Diagnostic_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Encounter_Diagnostic_BY_UUID;
	}
}
