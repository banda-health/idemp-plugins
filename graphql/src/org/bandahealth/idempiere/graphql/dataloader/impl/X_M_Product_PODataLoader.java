package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MProductPO_BH;

/**
 * Data Loader for M_Product_PO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_Product_PODataLoader extends PODataLoader<MProductPO_BH> {
	public static String DATALOADER_M_Product_PO_BY_ID = "M_Product_POByIdDataLoader";
	public static String DATALOADER_M_Product_PO_BY_UUID = "M_Product_POByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductPO_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Product_PO_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Product_PO_BY_UUID;
	}
}
