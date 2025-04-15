package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHOclOriginatingSource;

/**
 * Data Loader for BH_Ocl_Originating_Source - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Ocl_Originating_SourceDataLoader extends PODataLoader<MBHOclOriginatingSource> {
	public static String DATALOADER_BH_Ocl_Originating_Source_BY_ID = "BH_Ocl_Originating_SourceByIdDataLoader";
	public static String DATALOADER_BH_Ocl_Originating_Source_BY_UUID = "BH_Ocl_Originating_SourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHOclOriginatingSource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Ocl_Originating_Source_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Ocl_Originating_Source_BY_UUID;
	}
}
