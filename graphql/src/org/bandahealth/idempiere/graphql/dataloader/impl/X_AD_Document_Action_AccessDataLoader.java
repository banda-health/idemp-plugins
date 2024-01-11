package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Document_Action_Access;

/**
 * Data Loader for AD_Document_Action_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Document_Action_AccessDataLoader extends PODataLoader<X_AD_Document_Action_Access> {
	public static String AD_Document_Action_Access_BY_ID_DATA_LOADER = "AD_Document_Action_AccessByIdDataLoader";
	public static String AD_Document_Action_Access_BY_UUID_DATA_LOADER = "AD_Document_Action_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Document_Action_Access.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Document_Action_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Document_Action_Access_BY_UUID_DATA_LOADER;
	}
}
