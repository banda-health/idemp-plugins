package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_MRP;

/**
 * Data Loader for PP_MRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_MRPDataLoader extends PODataLoader<X_PP_MRP> {
	public static String DATALOADER_PP_MRP_BY_ID = "PP_MRPByIdDataLoader";
	public static String DATALOADER_PP_MRP_BY_UUID = "PP_MRPByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_MRP.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_MRP_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_MRP_BY_UUID;
	}
}
