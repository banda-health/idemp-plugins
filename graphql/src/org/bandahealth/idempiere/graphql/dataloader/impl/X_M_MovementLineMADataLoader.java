package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMovementLineMA;

/**
 * Data Loader for M_MovementLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MovementLineMADataLoader extends PODataLoader<MMovementLineMA> {
	public static String M_MovementLineMA_BY_ID_DATA_LOADER = "M_MovementLineMAByIdDataLoader";
	public static String M_MovementLineMA_BY_UUID_DATA_LOADER = "M_MovementLineMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMovementLineMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_MovementLineMA_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_MovementLineMA_BY_UUID_DATA_LOADER;
	}
}
