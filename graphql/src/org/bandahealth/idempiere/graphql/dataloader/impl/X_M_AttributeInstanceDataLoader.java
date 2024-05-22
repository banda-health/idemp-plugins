package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttributeInstance;

/**
 * Data Loader for M_AttributeInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeInstanceDataLoader extends PODataLoader<MAttributeInstance> {
	public static String DATALOADER_M_AttributeInstance_BY_ID = "M_AttributeInstanceByIdDataLoader";
	public static String DATALOADER_M_AttributeInstance_BY_UUID = "M_AttributeInstanceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeInstance.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_AttributeInstance_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_AttributeInstance_BY_UUID;
	}
}
