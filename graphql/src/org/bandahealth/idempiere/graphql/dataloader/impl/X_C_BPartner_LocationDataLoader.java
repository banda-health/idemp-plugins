package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBPartnerLocation;

/**
 * Data Loader for C_BPartner_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BPartner_LocationDataLoader extends PODataLoader<MBPartnerLocation> {
	public static String DATALOADER_C_BPartner_Location_BY_ID = "C_BPartner_LocationByIdDataLoader";
	public static String DATALOADER_C_BPartner_Location_BY_UUID = "C_BPartner_LocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPartnerLocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BPartner_Location_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BPartner_Location_BY_UUID;
	}
}
