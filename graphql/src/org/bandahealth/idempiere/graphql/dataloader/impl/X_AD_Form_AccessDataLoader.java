package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFormAccess;

/**
 * Data Loader for AD_Form_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Form_AccessDataLoader extends PODataLoader<MFormAccess> {
	public static String AD_Form_Access_BY_ID_DATA_LOADER = "AD_Form_AccessByIdDataLoader";
	public static String AD_Form_Access_BY_UUID_DATA_LOADER = "AD_Form_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFormAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Form_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Form_Access_BY_UUID_DATA_LOADER;
	}
}
