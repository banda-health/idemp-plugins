package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackageExpDetail;

/**
 * Data Loader for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Package_Exp_DetailDataLoader extends PODataLoader<MPackageExpDetail> {
	public static String DATALOADER_AD_Package_Exp_Detail_BY_ID = "AD_Package_Exp_DetailByIdDataLoader";
	public static String DATALOADER_AD_Package_Exp_Detail_BY_UUID = "AD_Package_Exp_DetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackageExpDetail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Package_Exp_Detail_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Package_Exp_Detail_BY_UUID;
	}
}
