package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHProductIncluded;

/**
 * Data Loader for BH_Product_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Product_IncludedDataLoader extends PODataLoader<MBHProductIncluded> {
	public static String DATALOADER_BH_Product_Included_BY_ID = "BH_Product_IncludedByIdDataLoader";
	public static String DATALOADER_BH_Product_Included_BY_UUID = "BH_Product_IncludedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHProductIncluded.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Product_Included_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Product_Included_BY_UUID;
	}
}
