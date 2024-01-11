package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ImportTemplateAccess;

/**
 * Data Loader for AD_ImportTemplateAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ImportTemplateAccessDataLoader extends PODataLoader<X_AD_ImportTemplateAccess> {
	public static String AD_ImportTemplateAccess_BY_ID_DATA_LOADER = "AD_ImportTemplateAccessByIdDataLoader";
	public static String AD_ImportTemplateAccess_BY_UUID_DATA_LOADER = "AD_ImportTemplateAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ImportTemplateAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ImportTemplateAccess_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ImportTemplateAccess_BY_UUID_DATA_LOADER;
	}
}
