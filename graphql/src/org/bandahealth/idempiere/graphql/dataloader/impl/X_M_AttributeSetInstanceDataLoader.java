package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;

/**
 * Data Loader for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetInstanceDataLoader extends PODataLoader<MAttributeSetInstance_BH> {
	public static String M_AttributeSetInstance_BY_ID_DATA_LOADER = "M_AttributeSetInstanceByIdDataLoader";
	public static String M_AttributeSetInstance_BY_UUID_DATA_LOADER = "M_AttributeSetInstanceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeSetInstance_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_AttributeSetInstance_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_AttributeSetInstance_BY_UUID_DATA_LOADER;
	}
}
