package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMovementLineConfirm;

/**
 * Data Loader for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MovementLineConfirmDataLoader extends PODataLoader<MMovementLineConfirm> {
	public static String M_MovementLineConfirm_BY_ID_DATA_LOADER = "M_MovementLineConfirmByIdDataLoader";
	public static String M_MovementLineConfirm_BY_UUID_DATA_LOADER = "M_MovementLineConfirmByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMovementLineConfirm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_MovementLineConfirm_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_MovementLineConfirm_BY_UUID_DATA_LOADER;
	}
}
