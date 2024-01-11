package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_OperationResource;

/**
 * Data Loader for M_OperationResource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_OperationResourceDataLoader extends PODataLoader<X_M_OperationResource> {
	public static String M_OperationResource_BY_ID_DATA_LOADER = "M_OperationResourceByIdDataLoader";
	public static String M_OperationResource_BY_UUID_DATA_LOADER = "M_OperationResourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_OperationResource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_OperationResource_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_OperationResource_BY_UUID_DATA_LOADER;
	}
}
