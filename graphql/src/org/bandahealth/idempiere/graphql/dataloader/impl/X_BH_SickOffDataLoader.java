package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHSickOff;

/**
 * Data Loader for BH_SickOff - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_SickOffDataLoader extends PODataLoader<MBHSickOff> {
	public static String DATALOADER_BH_SickOff_BY_ID = "BH_SickOffByIdDataLoader";
	public static String DATALOADER_BH_SickOff_BY_UUID = "BH_SickOffByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHSickOff.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_SickOff_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_SickOff_BY_UUID;
	}
}
