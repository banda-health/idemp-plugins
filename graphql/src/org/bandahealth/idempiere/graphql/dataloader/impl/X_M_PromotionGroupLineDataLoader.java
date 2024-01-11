package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionGroupLine;

/**
 * Data Loader for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionGroupLineDataLoader extends PODataLoader<X_M_PromotionGroupLine> {
	public static String M_PromotionGroupLine_BY_ID_DATA_LOADER = "M_PromotionGroupLineByIdDataLoader";
	public static String M_PromotionGroupLine_BY_UUID_DATA_LOADER = "M_PromotionGroupLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionGroupLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PromotionGroupLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PromotionGroupLine_BY_UUID_DATA_LOADER;
	}
}
