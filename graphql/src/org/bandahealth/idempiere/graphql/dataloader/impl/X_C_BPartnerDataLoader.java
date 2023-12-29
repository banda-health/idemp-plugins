package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBPartner_BH;

/**
 * Data Loader for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BPartnerDataLoader extends PODataLoader<MBPartner_BH> {
	public static String C_BPartner_BY_ID_DATA_LOADER = "C_BPartnerByIdDataLoader";
	public static String C_BPartner_BY_UUID_DATA_LOADER = "C_BPartnerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPartner_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BPartner_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BPartner_BY_UUID_DATA_LOADER;
	}
}
