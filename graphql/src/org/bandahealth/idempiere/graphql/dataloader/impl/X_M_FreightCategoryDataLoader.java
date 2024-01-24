package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFreightCategory;

/**
 * Data Loader for M_FreightCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_FreightCategoryDataLoader extends PODataLoader<MFreightCategory> {
	public static String DATALOADER_M_FreightCategory_BY_ID = "M_FreightCategoryByIdDataLoader";
	public static String DATALOADER_M_FreightCategory_BY_UUID = "M_FreightCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFreightCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_FreightCategory_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_FreightCategory_BY_UUID;
	}
}
