package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_DemandDetail;

/**
 * Data Loader for M_DemandDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_DemandDetailDataLoader extends PODataLoader<X_M_DemandDetail> {
	public static String DATALOADER_M_DemandDetail_BY_ID = "M_DemandDetailByIdDataLoader";
	public static String DATALOADER_M_DemandDetail_BY_UUID = "M_DemandDetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_DemandDetail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_DemandDetail_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_DemandDetail_BY_UUID;
	}
}
