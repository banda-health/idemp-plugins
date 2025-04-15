package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;

/**
 * Data Loader for BH_Payer_Info_Fld_Val_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payer_Info_Fld_Val_SugDataLoader extends PODataLoader<MBHPayerInfoFldValSug> {
	public static String DATALOADER_BH_Payer_Info_Fld_Val_Sug_BY_ID = "BH_Payer_Info_Fld_Val_SugByIdDataLoader";
	public static String DATALOADER_BH_Payer_Info_Fld_Val_Sug_BY_UUID = "BH_Payer_Info_Fld_Val_SugByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayerInfoFldValSug.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payer_Info_Fld_Val_Sug_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payer_Info_Fld_Val_Sug_BY_UUID;
	}
}
