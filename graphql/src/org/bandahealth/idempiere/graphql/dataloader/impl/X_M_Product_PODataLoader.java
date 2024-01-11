package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductPO;

/**
 * Data Loader for M_Product_PO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_PODataLoader extends PODataLoader<MProductPO> {
	public static String M_Product_PO_BY_ID_DATA_LOADER = "M_Product_POByIdDataLoader";
	public static String M_Product_PO_BY_UUID_DATA_LOADER = "M_Product_POByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductPO.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Product_PO_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Product_PO_BY_UUID_DATA_LOADER;
	}
}
