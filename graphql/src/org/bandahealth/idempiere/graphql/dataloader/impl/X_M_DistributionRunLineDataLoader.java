package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionRunLine;

/**
 * Data Loader for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DistributionRunLineDataLoader extends PODataLoader<MDistributionRunLine> {
	public static String M_DistributionRunLine_BY_ID_DATA_LOADER = "M_DistributionRunLineByIdDataLoader";
	public static String M_DistributionRunLine_BY_UUID_DATA_LOADER = "M_DistributionRunLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionRunLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_DistributionRunLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_DistributionRunLine_BY_UUID_DATA_LOADER;
	}
}
