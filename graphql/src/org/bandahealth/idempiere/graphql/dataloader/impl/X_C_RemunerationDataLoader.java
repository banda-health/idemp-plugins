package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Remuneration;

/**
 * Data Loader for C_Remuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RemunerationDataLoader extends PODataLoader<X_C_Remuneration> {
	public static String DATALOADER_C_Remuneration_BY_ID = "C_RemunerationByIdDataLoader";
	public static String DATALOADER_C_Remuneration_BY_UUID = "C_RemunerationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Remuneration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Remuneration_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Remuneration_BY_UUID;
	}
}
