package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVisit;

/**
 * Data Loader for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_VisitDataLoader extends PODataLoader<MBHVisit> {
	public static String DATALOADER_BH_Visit_BY_ID = "BH_VisitByIdDataLoader";
	public static String DATALOADER_BH_Visit_BY_UUID = "BH_VisitByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHVisit.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Visit_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Visit_BY_UUID;
	}
}
