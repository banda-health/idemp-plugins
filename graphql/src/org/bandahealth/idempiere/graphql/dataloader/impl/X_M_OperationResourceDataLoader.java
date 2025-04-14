package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_OperationResource;

/**
 * Data Loader for M_OperationResource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_OperationResourceDataLoader extends PODataLoader<X_M_OperationResource> {
	public static String DATALOADER_M_OperationResource_BY_ID = "M_OperationResourceByIdDataLoader";
	public static String DATALOADER_M_OperationResource_BY_UUID = "M_OperationResourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_OperationResource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_OperationResource_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_OperationResource_BY_UUID;
	}
}
