package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_BPartner;

/**
 * Data Loader for I_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_BPartnerDataLoader extends PODataLoader<X_I_BPartner> {
	public static String I_BPartner_BY_ID_DATA_LOADER = "I_BPartnerByIdDataLoader";
	public static String I_BPartner_BY_UUID_DATA_LOADER = "I_BPartnerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_BPartner.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_BPartner_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_BPartner_BY_UUID_DATA_LOADER;
	}
}
