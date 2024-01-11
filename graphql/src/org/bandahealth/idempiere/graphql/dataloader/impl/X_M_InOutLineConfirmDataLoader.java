package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInOutLineConfirm;

/**
 * Data Loader for M_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutLineConfirmDataLoader extends PODataLoader<MInOutLineConfirm> {
	public static String M_InOutLineConfirm_BY_ID_DATA_LOADER = "M_InOutLineConfirmByIdDataLoader";
	public static String M_InOutLineConfirm_BY_UUID_DATA_LOADER = "M_InOutLineConfirmByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInOutLineConfirm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_InOutLineConfirm_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_InOutLineConfirm_BY_UUID_DATA_LOADER;
	}
}
