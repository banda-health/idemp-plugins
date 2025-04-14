package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBPartnerInfo;

/**
 * Data Loader for RV_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_RV_BPartnerDataLoader extends PODataLoader<MBPartnerInfo> {
	public static String DATALOADER_RV_BPartner_BY_ID = "RV_BPartnerByIdDataLoader";
	public static String DATALOADER_RV_BPartner_BY_UUID = "RV_BPartnerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPartnerInfo.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_RV_BPartner_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_RV_BPartner_BY_UUID;
	}
}
