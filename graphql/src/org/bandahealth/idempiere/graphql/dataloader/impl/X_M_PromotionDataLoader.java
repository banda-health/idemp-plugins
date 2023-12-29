package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Promotion;

/**
 * Data Loader for M_Promotion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionDataLoader extends PODataLoader<X_M_Promotion> {
	public static String M_Promotion_BY_ID_DATA_LOADER = "M_PromotionByIdDataLoader";
	public static String M_Promotion_BY_UUID_DATA_LOADER = "M_PromotionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Promotion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Promotion_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Promotion_BY_UUID_DATA_LOADER;
	}
}
