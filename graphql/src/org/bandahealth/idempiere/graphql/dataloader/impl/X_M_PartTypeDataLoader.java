package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PartType;

/**
 * Data Loader for M_PartType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PartTypeDataLoader extends PODataLoader<X_M_PartType> {
	public static String DATALOADER_M_PartType_BY_ID = "M_PartTypeByIdDataLoader";
	public static String DATALOADER_M_PartType_BY_UUID = "M_PartTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PartType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PartType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PartType_BY_UUID;
	}
}
