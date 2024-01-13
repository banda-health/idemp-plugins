package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;

/**
 * Data Loader for BH_Payer_Info_Fld_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Payer_Info_Fld_SugDataLoader extends PODataLoader<MBHPayerInfoFldSug> {
	public static String DATALOADER_BH_Payer_Info_Fld_Sug_BY_ID = "BH_Payer_Info_Fld_SugByIdDataLoader";
	public static String DATALOADER_BH_Payer_Info_Fld_Sug_BY_UUID = "BH_Payer_Info_Fld_SugByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayerInfoFldSug.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payer_Info_Fld_Sug_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payer_Info_Fld_Sug_BY_UUID;
	}
}
