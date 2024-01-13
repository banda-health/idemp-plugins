package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BP_EDI;

/**
 * Data Loader for C_BP_EDI - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_EDIDataLoader extends PODataLoader<X_C_BP_EDI> {
	public static String DATALOADER_C_BP_EDI_BY_ID = "C_BP_EDIByIdDataLoader";
	public static String DATALOADER_C_BP_EDI_BY_UUID = "C_BP_EDIByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BP_EDI.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BP_EDI_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BP_EDI_BY_UUID;
	}
}
