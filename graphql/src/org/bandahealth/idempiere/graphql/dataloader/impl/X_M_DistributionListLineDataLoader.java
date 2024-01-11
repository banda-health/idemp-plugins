package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionListLine;

/**
 * Data Loader for M_DistributionListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DistributionListLineDataLoader extends PODataLoader<MDistributionListLine> {
	public static String M_DistributionListLine_BY_ID_DATA_LOADER = "M_DistributionListLineByIdDataLoader";
	public static String M_DistributionListLine_BY_UUID_DATA_LOADER = "M_DistributionListLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionListLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_DistributionListLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_DistributionListLine_BY_UUID_DATA_LOADER;
	}
}
