package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAlertProcessor;

/**
 * Data Loader for AD_AlertProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AlertProcessorDataLoader extends PODataLoader<MAlertProcessor> {
	public static String DATALOADER_AD_AlertProcessor_BY_ID = "AD_AlertProcessorByIdDataLoader";
	public static String DATALOADER_AD_AlertProcessor_BY_UUID = "AD_AlertProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAlertProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_AlertProcessor_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_AlertProcessor_BY_UUID;
	}
}
