package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFormAccess;

/**
 * Data Loader for AD_Form_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Form_AccessDataLoader extends PODataLoader<MFormAccess> {
	public static String DATALOADER_AD_Form_Access_BY_ID = "AD_Form_AccessByIdDataLoader";
	public static String DATALOADER_AD_Form_Access_BY_UUID = "AD_Form_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFormAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Form_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Form_Access_BY_UUID;
	}
}
