package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPOSTerminal;

/**
 * Data Loader for U_POSTerminal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_U_POSTerminalDataLoader extends PODataLoader<MPOSTerminal> {
	public static String DATALOADER_U_POSTerminal_BY_ID = "U_POSTerminalByIdDataLoader";
	public static String DATALOADER_U_POSTerminal_BY_UUID = "U_POSTerminalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPOSTerminal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_U_POSTerminal_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_U_POSTerminal_BY_UUID;
	}
}
