package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionListLine;

/**
 * Data Loader for M_DistributionListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DistributionListLineDataLoader extends PODataLoader<MDistributionListLine> {
	public static String DATALOADER_M_DistributionListLine_BY_ID = "M_DistributionListLineByIdDataLoader";
	public static String DATALOADER_M_DistributionListLine_BY_UUID = "M_DistributionListLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionListLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_DistributionListLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_DistributionListLine_BY_UUID;
	}
}
