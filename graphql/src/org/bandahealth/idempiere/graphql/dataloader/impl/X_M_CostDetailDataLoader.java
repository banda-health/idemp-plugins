package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCostDetail;

/**
 * Data Loader for M_CostDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostDetailDataLoader extends PODataLoader<MCostDetail> {
	public static String M_CostDetail_BY_ID_DATA_LOADER = "M_CostDetailByIdDataLoader";
	public static String M_CostDetail_BY_UUID_DATA_LOADER = "M_CostDetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCostDetail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_CostDetail_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_CostDetail_BY_UUID_DATA_LOADER;
	}
}
