package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ImportTemplateAccess;

/**
 * Data Loader for AD_ImportTemplateAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ImportTemplateAccessDataLoader extends PODataLoader<X_AD_ImportTemplateAccess> {
	public static String DATALOADER_AD_ImportTemplateAccess_BY_ID = "AD_ImportTemplateAccessByIdDataLoader";
	public static String DATALOADER_AD_ImportTemplateAccess_BY_UUID = "AD_ImportTemplateAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ImportTemplateAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ImportTemplateAccess_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ImportTemplateAccess_BY_UUID;
	}
}
