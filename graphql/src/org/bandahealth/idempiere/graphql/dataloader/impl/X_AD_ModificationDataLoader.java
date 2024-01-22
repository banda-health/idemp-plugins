package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Modification;

/**
 * Data Loader for AD_Modification - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ModificationDataLoader extends PODataLoader<X_AD_Modification> {
	public static String DATALOADER_AD_Modification_BY_ID = "AD_ModificationByIdDataLoader";
	public static String DATALOADER_AD_Modification_BY_UUID = "AD_ModificationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Modification.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Modification_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Modification_BY_UUID;
	}
}
