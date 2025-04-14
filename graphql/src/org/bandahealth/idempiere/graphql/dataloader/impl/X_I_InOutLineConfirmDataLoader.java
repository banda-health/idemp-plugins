package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_InOutLineConfirm;

/**
 * Data Loader for I_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_InOutLineConfirmDataLoader extends PODataLoader<X_I_InOutLineConfirm> {
	public static String DATALOADER_I_InOutLineConfirm_BY_ID = "I_InOutLineConfirmByIdDataLoader";
	public static String DATALOADER_I_InOutLineConfirm_BY_UUID = "I_InOutLineConfirmByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_InOutLineConfirm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_InOutLineConfirm_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_InOutLineConfirm_BY_UUID;
	}
}
