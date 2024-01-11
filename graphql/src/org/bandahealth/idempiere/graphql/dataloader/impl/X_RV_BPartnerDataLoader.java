package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBPartnerInfo;

/**
 * Data Loader for RV_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_RV_BPartnerDataLoader extends PODataLoader<MBPartnerInfo> {
	public static String RV_BPartner_BY_ID_DATA_LOADER = "RV_BPartnerByIdDataLoader";
	public static String RV_BPartner_BY_UUID_DATA_LOADER = "RV_BPartnerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPartnerInfo.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return RV_BPartner_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return RV_BPartner_BY_UUID_DATA_LOADER;
	}
}
