package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_MRP;

/**
 * Data Loader for PP_MRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_MRPDataLoader extends PODataLoader<X_PP_MRP> {
	public static String PP_MRP_BY_ID_DATA_LOADER = "PP_MRPByIdDataLoader";
	public static String PP_MRP_BY_UUID_DATA_LOADER = "PP_MRPByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_MRP.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_MRP_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_MRP_BY_UUID_DATA_LOADER;
	}
}
