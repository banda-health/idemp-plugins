package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionLine;

/**
 * Data Loader for M_PromotionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionLineDataLoader extends PODataLoader<X_M_PromotionLine> {
	public static String M_PromotionLine_BY_ID_DATA_LOADER = "M_PromotionLineByIdDataLoader";
	public static String M_PromotionLine_BY_UUID_DATA_LOADER = "M_PromotionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PromotionLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PromotionLine_BY_UUID_DATA_LOADER;
	}
}
