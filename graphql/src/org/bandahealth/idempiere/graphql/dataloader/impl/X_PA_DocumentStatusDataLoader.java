package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDocumentStatus;

/**
 * Data Loader for PA_DocumentStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DocumentStatusDataLoader extends PODataLoader<MDocumentStatus> {
	public static String PA_DocumentStatus_BY_ID_DATA_LOADER = "PA_DocumentStatusByIdDataLoader";
	public static String PA_DocumentStatus_BY_UUID_DATA_LOADER = "PA_DocumentStatusByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDocumentStatus.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_DocumentStatus_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_DocumentStatus_BY_UUID_DATA_LOADER;
	}
}
