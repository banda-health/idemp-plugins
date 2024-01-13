package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_AllClients_V;

/**
 * Data Loader for AD_AllClients_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AllClients_VDataLoader extends PODataLoader<X_AD_AllClients_V> {
	public static String DATALOADER_AD_AllClients_V_BY_ID = "AD_AllClients_VByIdDataLoader";
	public static String DATALOADER_AD_AllClients_V_BY_UUID = "AD_AllClients_VByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_AllClients_V.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_AllClients_V_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_AllClients_V_BY_UUID;
	}
}
