package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCostDetail;

/**
 * Data Loader for M_CostDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_CostDetailDataLoader extends PODataLoader<MCostDetail> {
	public static String DATALOADER_M_CostDetail_BY_ID = "M_CostDetailByIdDataLoader";
	public static String DATALOADER_M_CostDetail_BY_UUID = "M_CostDetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCostDetail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_CostDetail_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_CostDetail_BY_UUID;
	}
}
