package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MAttributeSet_BH;

/**
 * Data Loader for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetDataLoader extends PODataLoader<MAttributeSet_BH> {
	public static String M_AttributeSet_BY_ID_DATA_LOADER = "M_AttributeSetByIdDataLoader";
	public static String M_AttributeSet_BY_UUID_DATA_LOADER = "M_AttributeSetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeSet_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_AttributeSet_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_AttributeSet_BY_UUID_DATA_LOADER;
	}
}
