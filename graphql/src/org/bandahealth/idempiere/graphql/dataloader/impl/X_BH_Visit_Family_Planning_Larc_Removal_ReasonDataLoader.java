package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningLarcRemovalReason;

/**
 * Data Loader for BH_Visit_Family_Planning_Larc_Removal_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_Larc_Removal_ReasonDataLoader extends PODataLoader<MBHVisitFamilyPlanningLarcRemovalReason> {
	public static String DATALOADER_BH_Visit_Family_Planning_Larc_Removal_Reason_BY_ID = "BH_Visit_Family_Planning_Larc_Removal_ReasonByIdDataLoader";
	public static String DATALOADER_BH_Visit_Family_Planning_Larc_Removal_Reason_BY_UUID = "BH_Visit_Family_Planning_Larc_Removal_ReasonByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHVisitFamilyPlanningLarcRemovalReason.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Visit_Family_Planning_Larc_Removal_Reason_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Visit_Family_Planning_Larc_Removal_Reason_BY_UUID;
	}
}
