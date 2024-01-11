package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ReplicationDocument;

/**
 * Data Loader for AD_ReplicationDocument - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReplicationDocumentDataLoader extends PODataLoader<X_AD_ReplicationDocument> {
	public static String AD_ReplicationDocument_BY_ID_DATA_LOADER = "AD_ReplicationDocumentByIdDataLoader";
	public static String AD_ReplicationDocument_BY_UUID_DATA_LOADER = "AD_ReplicationDocumentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ReplicationDocument.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ReplicationDocument_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ReplicationDocument_BY_UUID_DATA_LOADER;
	}
}
