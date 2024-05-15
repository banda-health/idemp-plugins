package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFreight;

/**
 * Data Loader for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_FreightDataLoader extends PODataLoader<MFreight> {
	public static String DATALOADER_M_Freight_BY_ID = "M_FreightByIdDataLoader";
	public static String DATALOADER_M_Freight_BY_UUID = "M_FreightByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFreight.Table_Name;
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
