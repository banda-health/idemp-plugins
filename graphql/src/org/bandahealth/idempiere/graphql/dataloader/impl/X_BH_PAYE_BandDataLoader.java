package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPAYEBand;

/**
 * Data Loader for BH_PAYE_Band - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_PAYE_BandDataLoader extends PODataLoader<MBHPAYEBand> {
	public static String DATALOADER_BH_PAYE_Band_BY_ID = "BH_PAYE_BandByIdDataLoader";
	public static String DATALOADER_BH_PAYE_Band_BY_UUID = "BH_PAYE_BandByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPAYEBand.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_PAYE_Band_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_PAYE_Band_BY_UUID;
	}
}
