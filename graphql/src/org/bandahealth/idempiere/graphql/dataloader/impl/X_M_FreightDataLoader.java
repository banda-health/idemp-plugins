package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFreight;

/**
 * Data Loader for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_FreightDataLoader extends PODataLoader<MFreight> {
	public static String M_Freight_BY_ID_DATA_LOADER = "M_FreightByIdDataLoader";
	public static String M_Freight_BY_UUID_DATA_LOADER = "M_FreightByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFreight.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Freight_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Freight_BY_UUID_DATA_LOADER;
	}
}
