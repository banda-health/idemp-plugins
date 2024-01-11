package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_DemandDetail;

/**
 * Data Loader for M_DemandDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DemandDetailDataLoader extends PODataLoader<X_M_DemandDetail> {
	public static String M_DemandDetail_BY_ID_DATA_LOADER = "M_DemandDetailByIdDataLoader";
	public static String M_DemandDetail_BY_UUID_DATA_LOADER = "M_DemandDetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_DemandDetail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_DemandDetail_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_DemandDetail_BY_UUID_DATA_LOADER;
	}
}
