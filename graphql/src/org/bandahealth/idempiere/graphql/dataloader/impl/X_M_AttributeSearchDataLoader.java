package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_AttributeSearch;

/**
 * Data Loader for M_AttributeSearch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeSearchDataLoader extends PODataLoader<X_M_AttributeSearch> {
	public static String DATALOADER_M_AttributeSearch_BY_ID = "M_AttributeSearchByIdDataLoader";
	public static String DATALOADER_M_AttributeSearch_BY_UUID = "M_AttributeSearchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_AttributeSearch.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_AttributeSearch_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_AttributeSearch_BY_UUID;
	}
}
