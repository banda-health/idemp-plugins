package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBPartnerLocation;

/**
 * Data Loader for C_BPartner_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BPartner_LocationDataLoader extends PODataLoader<MBPartnerLocation> {
	public static String C_BPartner_Location_BY_ID_DATA_LOADER = "C_BPartner_LocationByIdDataLoader";
	public static String C_BPartner_Location_BY_UUID_DATA_LOADER = "C_BPartner_LocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPartnerLocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BPartner_Location_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BPartner_Location_BY_UUID_DATA_LOADER;
	}
}
