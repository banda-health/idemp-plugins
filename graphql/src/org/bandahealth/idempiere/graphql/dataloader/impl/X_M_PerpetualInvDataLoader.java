package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PerpetualInv;

/**
 * Data Loader for M_PerpetualInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_PerpetualInvDataLoader extends PODataLoader<X_M_PerpetualInv> {
	public static String DATALOADER_M_PerpetualInv_BY_ID = "M_PerpetualInvByIdDataLoader";
	public static String DATALOADER_M_PerpetualInv_BY_UUID = "M_PerpetualInvByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PerpetualInv.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PerpetualInv_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PerpetualInv_BY_UUID;
	}
}
