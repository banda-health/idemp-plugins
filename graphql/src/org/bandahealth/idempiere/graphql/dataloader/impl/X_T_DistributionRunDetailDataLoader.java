package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionRunDetail;

/**
 * Data Loader for T_DistributionRunDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_DistributionRunDetailDataLoader extends PODataLoader<MDistributionRunDetail> {
	public static String T_DistributionRunDetail_BY_ID_DATA_LOADER = "T_DistributionRunDetailByIdDataLoader";
	public static String T_DistributionRunDetail_BY_UUID_DATA_LOADER = "T_DistributionRunDetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionRunDetail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_DistributionRunDetail_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_DistributionRunDetail_BY_UUID_DATA_LOADER;
	}
}
