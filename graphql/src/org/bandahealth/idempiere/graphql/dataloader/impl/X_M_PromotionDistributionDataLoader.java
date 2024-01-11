package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionDistribution;

/**
 * Data Loader for M_PromotionDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionDistributionDataLoader extends PODataLoader<X_M_PromotionDistribution> {
	public static String M_PromotionDistribution_BY_ID_DATA_LOADER = "M_PromotionDistributionByIdDataLoader";
	public static String M_PromotionDistribution_BY_UUID_DATA_LOADER = "M_PromotionDistributionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionDistribution.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PromotionDistribution_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PromotionDistribution_BY_UUID_DATA_LOADER;
	}
}
