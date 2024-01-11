package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRMATax;

/**
 * Data Loader for M_RMATax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RMATaxDataLoader extends PODataLoader<MRMATax> {
	public static String M_RMATax_BY_ID_DATA_LOADER = "M_RMATaxByIdDataLoader";
	public static String M_RMATax_BY_UUID_DATA_LOADER = "M_RMATaxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRMATax.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_RMATax_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_RMATax_BY_UUID_DATA_LOADER;
	}
}
