package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionGroupLine;

/**
 * Data Loader for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionGroupLineDataLoader extends PODataLoader<X_M_PromotionGroupLine> {
	public static String DATALOADER_M_PromotionGroupLine_BY_ID = "M_PromotionGroupLineByIdDataLoader";
	public static String DATALOADER_M_PromotionGroupLine_BY_UUID = "M_PromotionGroupLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionGroupLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PromotionGroupLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PromotionGroupLine_BY_UUID;
	}
}
