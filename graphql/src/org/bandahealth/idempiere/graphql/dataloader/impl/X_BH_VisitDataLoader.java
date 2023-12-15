package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVisit;

public class X_BH_VisitDataLoader extends PODataLoader<MBHVisit> {
	public static String BH_Visit_BY_ID_DATA_LOADER = "BH_VisitByIdDataLoader";
	public static String BH_Visit_BY_UUID_DATA_LOADER = "BH_VisitByUuidDataLoader";

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Visit_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Visit_BY_UUID_DATA_LOADER;
	}

	@Override
	protected String getEntityTableName() {
		return MBHVisit.Table_Name;
	}
}
