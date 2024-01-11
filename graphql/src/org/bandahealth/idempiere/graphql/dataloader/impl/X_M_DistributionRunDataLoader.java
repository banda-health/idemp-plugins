package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionRun;

/**
 * Data Loader for M_DistributionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DistributionRunDataLoader extends PODataLoader<MDistributionRun> {
	public static String M_DistributionRun_BY_ID_DATA_LOADER = "M_DistributionRunByIdDataLoader";
	public static String M_DistributionRun_BY_UUID_DATA_LOADER = "M_DistributionRunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_DistributionRun_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_DistributionRun_BY_UUID_DATA_LOADER;
	}
}
