package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttributeSetExclude;

/**
 * Data Loader for M_AttributeSetExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetExcludeDataLoader extends PODataLoader<MAttributeSetExclude> {
	public static String M_AttributeSetExclude_BY_ID_DATA_LOADER = "M_AttributeSetExcludeByIdDataLoader";
	public static String M_AttributeSetExclude_BY_UUID_DATA_LOADER = "M_AttributeSetExcludeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeSetExclude.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_AttributeSetExclude_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_AttributeSetExclude_BY_UUID_DATA_LOADER;
	}
}
