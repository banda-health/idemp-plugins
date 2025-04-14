package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResourceUnAvailable;

/**
 * Data Loader for S_ResourceUnAvailable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_S_ResourceUnAvailableDataLoader extends PODataLoader<MResourceUnAvailable> {
	public static String DATALOADER_S_ResourceUnAvailable_BY_ID = "S_ResourceUnAvailableByIdDataLoader";
	public static String DATALOADER_S_ResourceUnAvailable_BY_UUID = "S_ResourceUnAvailableByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResourceUnAvailable.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_S_ResourceUnAvailable_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_S_ResourceUnAvailable_BY_UUID;
	}
}
