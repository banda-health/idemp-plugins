package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionGroup;

/**
 * Data Loader for M_PromotionGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionGroupDataLoader extends PODataLoader<X_M_PromotionGroup> {
	public static String DATALOADER_M_PromotionGroup_BY_ID = "M_PromotionGroupByIdDataLoader";
	public static String DATALOADER_M_PromotionGroup_BY_UUID = "M_PromotionGroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionGroup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PromotionGroup_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PromotionGroup_BY_UUID;
	}
}
