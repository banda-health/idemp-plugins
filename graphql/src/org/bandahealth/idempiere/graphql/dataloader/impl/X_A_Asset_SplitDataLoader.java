package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Split;

/**
 * Data Loader for A_Asset_Split - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_SplitDataLoader extends PODataLoader<X_A_Asset_Split> {
	public static String DATALOADER_A_Asset_Split_BY_ID = "A_Asset_SplitByIdDataLoader";
	public static String DATALOADER_A_Asset_Split_BY_UUID = "A_Asset_SplitByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Split.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Split_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Split_BY_UUID;
	}
}
