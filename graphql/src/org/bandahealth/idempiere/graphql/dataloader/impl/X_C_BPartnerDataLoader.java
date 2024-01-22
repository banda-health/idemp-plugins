package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBPartner_BH;

/**
 * Data Loader for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BPartnerDataLoader extends PODataLoader<MBPartner_BH> {
	public static String DATALOADER_C_BPartner_BY_ID = "C_BPartnerByIdDataLoader";
	public static String DATALOADER_C_BPartner_BY_UUID = "C_BPartnerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPartner_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BPartner_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BPartner_BY_UUID;
	}
}
