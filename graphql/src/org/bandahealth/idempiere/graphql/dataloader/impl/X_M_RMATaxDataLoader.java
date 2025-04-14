package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRMATax;

/**
 * Data Loader for M_RMATax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_RMATaxDataLoader extends PODataLoader<MRMATax> {
	public static String DATALOADER_M_RMATax_BY_ID = "M_RMATaxByIdDataLoader";
	public static String DATALOADER_M_RMATax_BY_UUID = "M_RMATaxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRMATax.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_RMATax_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_RMATax_BY_UUID;
	}
}
