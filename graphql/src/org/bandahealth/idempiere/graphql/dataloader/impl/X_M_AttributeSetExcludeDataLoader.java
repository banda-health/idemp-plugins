package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttributeSetExclude;

/**
 * Data Loader for M_AttributeSetExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetExcludeDataLoader extends PODataLoader<MAttributeSetExclude> {
	public static String DATALOADER_M_AttributeSetExclude_BY_ID = "M_AttributeSetExcludeByIdDataLoader";
	public static String DATALOADER_M_AttributeSetExclude_BY_UUID = "M_AttributeSetExcludeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeSetExclude.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_AttributeSetExclude_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_AttributeSetExclude_BY_UUID;
	}
}
