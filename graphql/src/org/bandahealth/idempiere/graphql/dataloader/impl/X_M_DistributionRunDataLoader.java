package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionRun;

/**
 * Data Loader for M_DistributionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DistributionRunDataLoader extends PODataLoader<MDistributionRun> {
	public static String DATALOADER_M_DistributionRun_BY_ID = "M_DistributionRunByIdDataLoader";
	public static String DATALOADER_M_DistributionRun_BY_UUID = "M_DistributionRunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_DistributionRun_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_DistributionRun_BY_UUID;
	}
}
