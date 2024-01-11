package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPOSTerminal;

/**
 * Data Loader for U_POSTerminal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_POSTerminalDataLoader extends PODataLoader<MPOSTerminal> {
	public static String U_POSTerminal_BY_ID_DATA_LOADER = "U_POSTerminalByIdDataLoader";
	public static String U_POSTerminal_BY_UUID_DATA_LOADER = "U_POSTerminalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPOSTerminal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return U_POSTerminal_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return U_POSTerminal_BY_UUID_DATA_LOADER;
	}
}
