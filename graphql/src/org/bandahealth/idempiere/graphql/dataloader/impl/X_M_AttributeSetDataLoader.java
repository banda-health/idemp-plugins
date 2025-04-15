package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MAttributeSet_BH;

/**
 * Data Loader for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_AttributeSetDataLoader extends PODataLoader<MAttributeSet_BH> {
	public static String DATALOADER_M_AttributeSet_BY_ID = "M_AttributeSetByIdDataLoader";
	public static String DATALOADER_M_AttributeSet_BY_UUID = "M_AttributeSetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeSet_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_AttributeSet_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_AttributeSet_BY_UUID;
	}
}
