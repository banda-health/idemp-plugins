package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionList;

/**
 * Data Loader for M_DistributionList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DistributionListDataLoader extends PODataLoader<MDistributionList> {
	public static String M_DistributionList_BY_ID_DATA_LOADER = "M_DistributionListByIdDataLoader";
	public static String M_DistributionList_BY_UUID_DATA_LOADER = "M_DistributionListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionList.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_DistributionList_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_DistributionList_BY_UUID_DATA_LOADER;
	}
}
