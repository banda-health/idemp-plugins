package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionList;

/**
 * Data Loader for M_DistributionList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_DistributionListDataLoader extends PODataLoader<MDistributionList> {
	public static String DATALOADER_M_DistributionList_BY_ID = "M_DistributionListByIdDataLoader";
	public static String DATALOADER_M_DistributionList_BY_UUID = "M_DistributionListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionList.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_DistributionList_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_DistributionList_BY_UUID;
	}
}
