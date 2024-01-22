package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;

/**
 * Data Loader for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Payer_Info_Fld_ValDataLoader extends PODataLoader<MBHPayerInfoFldVal> {
	public static String DATALOADER_BH_Payer_Info_Fld_Val_BY_ID = "BH_Payer_Info_Fld_ValByIdDataLoader";
	public static String DATALOADER_BH_Payer_Info_Fld_Val_BY_UUID = "BH_Payer_Info_Fld_ValByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayerInfoFldVal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payer_Info_Fld_Val_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payer_Info_Fld_Val_BY_UUID;
	}
}
