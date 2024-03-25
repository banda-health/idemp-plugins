package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDocumentActionAccess;

/**
 * Data Loader for AD_Document_Action_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Document_Action_AccessDataLoader extends PODataLoader<MDocumentActionAccess> {
	public static String DATALOADER_AD_Document_Action_Access_BY_ID = "AD_Document_Action_AccessByIdDataLoader";
	public static String DATALOADER_AD_Document_Action_Access_BY_UUID = "AD_Document_Action_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDocumentActionAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Document_Action_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Document_Action_Access_BY_UUID;
	}
}
