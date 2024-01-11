package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAlertProcessor;

/**
 * Data Loader for AD_AlertProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertProcessorDataLoader extends PODataLoader<MAlertProcessor> {
	public static String AD_AlertProcessor_BY_ID_DATA_LOADER = "AD_AlertProcessorByIdDataLoader";
	public static String AD_AlertProcessor_BY_UUID_DATA_LOADER = "AD_AlertProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAlertProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_AlertProcessor_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_AlertProcessor_BY_UUID_DATA_LOADER;
	}
}
