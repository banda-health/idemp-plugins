package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;

/**
 * Data Loader for BH_BP_Specific_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_BP_Specific_Payer_InfoDataLoader extends PODataLoader<MBHBPSpecificPayerInfo> {
	public static String BH_BP_Specific_Payer_Info_BY_ID_DATA_LOADER = "BH_BP_Specific_Payer_InfoByIdDataLoader";
	public static String BH_BP_Specific_Payer_Info_BY_UUID_DATA_LOADER = "BH_BP_Specific_Payer_InfoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHBPSpecificPayerInfo.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_BP_Specific_Payer_Info_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_BP_Specific_Payer_Info_BY_UUID_DATA_LOADER;
	}
}
