package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Substitute;

/**
 * Data Loader for M_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_SubstituteDataLoader extends PODataLoader<X_M_Substitute> {
	public static String DATALOADER_M_Substitute_BY_ID = "M_SubstituteByIdDataLoader";
	public static String DATALOADER_M_Substitute_BY_UUID = "M_SubstituteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Substitute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Substitute_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Substitute_BY_UUID;
	}
}
