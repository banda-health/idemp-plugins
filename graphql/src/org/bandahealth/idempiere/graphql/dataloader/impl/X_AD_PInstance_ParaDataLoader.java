package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPInstancePara;

/**
 * Data Loader for AD_PInstance_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PInstance_ParaDataLoader extends PODataLoader<MPInstancePara> {
	public static String DATALOADER_AD_PInstance_Para_BY_ID = "AD_PInstance_ParaByIdDataLoader";
	public static String DATALOADER_AD_PInstance_Para_BY_UUID = "AD_PInstance_ParaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPInstancePara.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PInstance_Para_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PInstance_Para_BY_UUID;
	}
}
