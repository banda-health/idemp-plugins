package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttributeUse;

/**
 * Data Loader for M_AttributeUse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeUseDataLoader extends PODataLoader<MAttributeUse> {
	public static String M_AttributeUse_BY_ID_DATA_LOADER = "M_AttributeUseByIdDataLoader";
	public static String M_AttributeUse_BY_UUID_DATA_LOADER = "M_AttributeUseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeUse.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_AttributeUse_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_AttributeUse_BY_UUID_DATA_LOADER;
	}
}
