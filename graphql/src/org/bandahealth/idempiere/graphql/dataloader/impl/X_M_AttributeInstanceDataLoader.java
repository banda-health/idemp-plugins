package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttributeInstance;

/**
 * Data Loader for M_AttributeInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeInstanceDataLoader extends PODataLoader<MAttributeInstance> {
	public static String M_AttributeInstance_BY_ID_DATA_LOADER = "M_AttributeInstanceByIdDataLoader";
	public static String M_AttributeInstance_BY_UUID_DATA_LOADER = "M_AttributeInstanceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeInstance.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_AttributeInstance_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_AttributeInstance_BY_UUID_DATA_LOADER;
	}
}
