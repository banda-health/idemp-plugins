package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;

/**
 * Data Loader for BH_Payer_Info_Fld - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Payer_Info_FldDataLoader extends PODataLoader<MBHPayerInfoFld> {
	public static String DATALOADER_BH_Payer_Info_Fld_BY_ID = "BH_Payer_Info_FldByIdDataLoader";
	public static String DATALOADER_BH_Payer_Info_Fld_BY_UUID = "BH_Payer_Info_FldByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayerInfoFld.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payer_Info_Fld_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payer_Info_Fld_BY_UUID;
	}
}
