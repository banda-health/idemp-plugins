package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPInstance;

/**
 * Data Loader for AD_PInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PInstanceDataLoader extends PODataLoader<MPInstance> {
	public static String DATALOADER_AD_PInstance_BY_ID = "AD_PInstanceByIdDataLoader";
	public static String DATALOADER_AD_PInstance_BY_UUID = "AD_PInstanceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPInstance.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PInstance_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PInstance_BY_UUID;
	}
}
