package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionRunDetail;

/**
 * Data Loader for T_DistributionRunDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_DistributionRunDetailDataLoader extends PODataLoader<MDistributionRunDetail> {
	public static String DATALOADER_T_DistributionRunDetail_BY_ID = "T_DistributionRunDetailByIdDataLoader";
	public static String DATALOADER_T_DistributionRunDetail_BY_UUID = "T_DistributionRunDetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionRunDetail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_DistributionRunDetail_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_DistributionRunDetail_BY_UUID;
	}
}
