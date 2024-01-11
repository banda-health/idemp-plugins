package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPInstance;

/**
 * Data Loader for AD_PInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PInstanceDataLoader extends PODataLoader<MPInstance> {
	public static String AD_PInstance_BY_ID_DATA_LOADER = "AD_PInstanceByIdDataLoader";
	public static String AD_PInstance_BY_UUID_DATA_LOADER = "AD_PInstanceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPInstance.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PInstance_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PInstance_BY_UUID_DATA_LOADER;
	}
}
