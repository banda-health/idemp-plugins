package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMovementLine;

/**
 * Data Loader for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementLineDataLoader extends PODataLoader<MMovementLine> {
	public static String DATALOADER_M_MovementLine_BY_ID = "M_MovementLineByIdDataLoader";
	public static String DATALOADER_M_MovementLine_BY_UUID = "M_MovementLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMovementLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_MovementLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_MovementLine_BY_UUID;
	}
}
