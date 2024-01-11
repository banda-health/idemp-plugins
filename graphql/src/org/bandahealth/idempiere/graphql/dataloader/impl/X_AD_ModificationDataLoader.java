package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Modification;

/**
 * Data Loader for AD_Modification - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ModificationDataLoader extends PODataLoader<X_AD_Modification> {
	public static String AD_Modification_BY_ID_DATA_LOADER = "AD_ModificationByIdDataLoader";
	public static String AD_Modification_BY_UUID_DATA_LOADER = "AD_ModificationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Modification.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Modification_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Modification_BY_UUID_DATA_LOADER;
	}
}
