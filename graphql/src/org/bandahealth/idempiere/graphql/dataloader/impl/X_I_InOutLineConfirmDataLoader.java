package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_InOutLineConfirm;

/**
 * Data Loader for I_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_InOutLineConfirmDataLoader extends PODataLoader<X_I_InOutLineConfirm> {
	public static String I_InOutLineConfirm_BY_ID_DATA_LOADER = "I_InOutLineConfirmByIdDataLoader";
	public static String I_InOutLineConfirm_BY_UUID_DATA_LOADER = "I_InOutLineConfirmByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_InOutLineConfirm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_InOutLineConfirm_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_InOutLineConfirm_BY_UUID_DATA_LOADER;
	}
}
