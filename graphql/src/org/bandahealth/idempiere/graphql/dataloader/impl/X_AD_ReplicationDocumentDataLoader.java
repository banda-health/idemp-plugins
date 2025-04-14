package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ReplicationDocument;

/**
 * Data Loader for AD_ReplicationDocument - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ReplicationDocumentDataLoader extends PODataLoader<X_AD_ReplicationDocument> {
	public static String DATALOADER_AD_ReplicationDocument_BY_ID = "AD_ReplicationDocumentByIdDataLoader";
	public static String DATALOADER_AD_ReplicationDocument_BY_UUID = "AD_ReplicationDocumentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ReplicationDocument.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ReplicationDocument_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ReplicationDocument_BY_UUID;
	}
}
