package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLocator;

/**
 * Data Loader for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_LocatorDataLoader extends PODataLoader<MLocator> {
	public static String DATALOADER_M_Locator_BY_ID = "M_LocatorByIdDataLoader";
	public static String DATALOADER_M_Locator_BY_UUID = "M_LocatorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLocator.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Locator_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Locator_BY_UUID;
	}
}
