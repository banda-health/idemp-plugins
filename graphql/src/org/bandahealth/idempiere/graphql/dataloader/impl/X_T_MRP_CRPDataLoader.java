package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_T_MRP_CRP;

/**
 * Data Loader for T_MRP_CRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_MRP_CRPDataLoader extends PODataLoader<X_T_MRP_CRP> {
	public static String T_MRP_CRP_BY_ID_DATA_LOADER = "T_MRP_CRPByIdDataLoader";
	public static String T_MRP_CRP_BY_UUID_DATA_LOADER = "T_MRP_CRPByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_MRP_CRP.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_MRP_CRP_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_MRP_CRP_BY_UUID_DATA_LOADER;
	}
}
