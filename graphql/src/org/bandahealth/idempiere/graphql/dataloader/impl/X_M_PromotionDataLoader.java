package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Promotion;

/**
 * Data Loader for M_Promotion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionDataLoader extends PODataLoader<X_M_Promotion> {
	public static String DATALOADER_M_Promotion_BY_ID = "M_PromotionByIdDataLoader";
	public static String DATALOADER_M_Promotion_BY_UUID = "M_PromotionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Promotion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Promotion_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Promotion_BY_UUID;
	}
}
