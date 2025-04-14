package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;

/**
 * Data Loader for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_AttributeSetInstanceDataLoader extends PODataLoader<MAttributeSetInstance_BH> {
	public static String DATALOADER_M_AttributeSetInstance_BY_ID = "M_AttributeSetInstanceByIdDataLoader";
	public static String DATALOADER_M_AttributeSetInstance_BY_UUID = "M_AttributeSetInstanceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeSetInstance_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_AttributeSetInstance_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_AttributeSetInstance_BY_UUID;
	}
}
