package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDocumentStatus;

/**
 * Data Loader for PA_DocumentStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_DocumentStatusDataLoader extends PODataLoader<MDocumentStatus> {
	public static String DATALOADER_PA_DocumentStatus_BY_ID = "PA_DocumentStatusByIdDataLoader";
	public static String DATALOADER_PA_DocumentStatus_BY_UUID = "PA_DocumentStatusByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDocumentStatus.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_DocumentStatus_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_DocumentStatus_BY_UUID;
	}
}
