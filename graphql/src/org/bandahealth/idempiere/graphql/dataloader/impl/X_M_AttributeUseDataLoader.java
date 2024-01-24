package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttributeUse;

/**
 * Data Loader for M_AttributeUse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_AttributeUseDataLoader extends PODataLoader<MAttributeUse> {
	public static String DATALOADER_M_AttributeUse_BY_ID = "M_AttributeUseByIdDataLoader";
	public static String DATALOADER_M_AttributeUse_BY_UUID = "M_AttributeUseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeUse.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_AttributeUse_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_AttributeUse_BY_UUID;
	}
}
