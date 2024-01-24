package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMovementLineConfirm;

/**
 * Data Loader for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MovementLineConfirmDataLoader extends PODataLoader<MMovementLineConfirm> {
	public static String DATALOADER_M_MovementLineConfirm_BY_ID = "M_MovementLineConfirmByIdDataLoader";
	public static String DATALOADER_M_MovementLineConfirm_BY_UUID = "M_MovementLineConfirmByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMovementLineConfirm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_MovementLineConfirm_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_MovementLineConfirm_BY_UUID;
	}
}
