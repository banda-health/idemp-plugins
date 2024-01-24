package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Freight;

/**
 * Data Loader for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_FreightDataLoader extends PODataLoader<X_M_Freight> {
	public static String DATALOADER_M_Freight_BY_ID = "M_FreightByIdDataLoader";
	public static String DATALOADER_M_Freight_BY_UUID = "M_FreightByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Freight.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Freight_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Freight_BY_UUID;
	}
}
