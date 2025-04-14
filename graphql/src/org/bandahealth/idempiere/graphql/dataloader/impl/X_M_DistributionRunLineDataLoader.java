package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionRunLine;

/**
 * Data Loader for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DistributionRunLineDataLoader extends PODataLoader<MDistributionRunLine> {
	public static String DATALOADER_M_DistributionRunLine_BY_ID = "M_DistributionRunLineByIdDataLoader";
	public static String DATALOADER_M_DistributionRunLine_BY_UUID = "M_DistributionRunLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionRunLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_DistributionRunLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_DistributionRunLine_BY_UUID;
	}
}
