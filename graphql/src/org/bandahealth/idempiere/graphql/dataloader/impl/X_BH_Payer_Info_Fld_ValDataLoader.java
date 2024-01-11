package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;

/**
 * Data Loader for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Payer_Info_Fld_ValDataLoader extends PODataLoader<MBHPayerInfoFldVal> {
	public static String BH_Payer_Info_Fld_Val_BY_ID_DATA_LOADER = "BH_Payer_Info_Fld_ValByIdDataLoader";
	public static String BH_Payer_Info_Fld_Val_BY_UUID_DATA_LOADER = "BH_Payer_Info_Fld_ValByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayerInfoFldVal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Payer_Info_Fld_Val_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Payer_Info_Fld_Val_BY_UUID_DATA_LOADER;
	}
}
