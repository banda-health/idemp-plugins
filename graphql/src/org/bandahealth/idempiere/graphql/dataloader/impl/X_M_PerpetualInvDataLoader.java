package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PerpetualInv;

/**
 * Data Loader for M_PerpetualInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PerpetualInvDataLoader extends PODataLoader<X_M_PerpetualInv> {
	public static String M_PerpetualInv_BY_ID_DATA_LOADER = "M_PerpetualInvByIdDataLoader";
	public static String M_PerpetualInv_BY_UUID_DATA_LOADER = "M_PerpetualInvByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PerpetualInv.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PerpetualInv_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PerpetualInv_BY_UUID_DATA_LOADER;
	}
}
