package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionDistribution;

/**
 * Data Loader for M_PromotionDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionDistributionDataLoader extends PODataLoader<X_M_PromotionDistribution> {
	public static String DATALOADER_M_PromotionDistribution_BY_ID = "M_PromotionDistributionByIdDataLoader";
	public static String DATALOADER_M_PromotionDistribution_BY_UUID = "M_PromotionDistributionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionDistribution.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PromotionDistribution_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PromotionDistribution_BY_UUID;
	}
}
