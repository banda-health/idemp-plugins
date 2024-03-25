package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_BPartner;

/**
 * Data Loader for I_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_BPartnerDataLoader extends PODataLoader<X_I_BPartner> {
	public static String DATALOADER_I_BPartner_BY_ID = "I_BPartnerByIdDataLoader";
	public static String DATALOADER_I_BPartner_BY_UUID = "I_BPartnerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_BPartner.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_BPartner_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_BPartner_BY_UUID;
	}
}
