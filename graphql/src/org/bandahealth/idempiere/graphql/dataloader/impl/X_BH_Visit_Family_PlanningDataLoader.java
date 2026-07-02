package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;

/**
 * Data Loader for BH_Visit_Family_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_PlanningDataLoader extends PODataLoader<MBHVisitFamilyPlanning> {
	public static String DATALOADER_BH_Visit_Family_Planning_BY_ID = "BH_Visit_Family_PlanningByIdDataLoader";
	public static String DATALOADER_BH_Visit_Family_Planning_BY_UUID = "BH_Visit_Family_PlanningByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHVisitFamilyPlanning.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Visit_Family_Planning_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Visit_Family_Planning_BY_UUID;
	}
}
