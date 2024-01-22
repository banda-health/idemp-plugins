package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;

/**
 * Data Loader for BH_BP_General_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_BP_General_Payer_InfoDataLoader extends PODataLoader<MBHBPGeneralPayerInfo> {
	public static String DATALOADER_BH_BP_General_Payer_Info_BY_ID = "BH_BP_General_Payer_InfoByIdDataLoader";
	public static String DATALOADER_BH_BP_General_Payer_Info_BY_UUID = "BH_BP_General_Payer_InfoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHBPGeneralPayerInfo.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_BP_General_Payer_Info_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_BP_General_Payer_Info_BY_UUID;
	}
}
