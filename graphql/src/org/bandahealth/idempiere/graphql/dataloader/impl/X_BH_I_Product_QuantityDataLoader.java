package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.X_BH_I_Product_Quantity;

/**
 * Data Loader for BH_I_Product_Quantity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_I_Product_QuantityDataLoader extends PODataLoader<X_BH_I_Product_Quantity> {
	public static String BH_I_Product_Quantity_BY_ID_DATA_LOADER = "BH_I_Product_QuantityByIdDataLoader";
	public static String BH_I_Product_Quantity_BY_UUID_DATA_LOADER = "BH_I_Product_QuantityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_BH_I_Product_Quantity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_I_Product_Quantity_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_I_Product_Quantity_BY_UUID_DATA_LOADER;
	}
}
