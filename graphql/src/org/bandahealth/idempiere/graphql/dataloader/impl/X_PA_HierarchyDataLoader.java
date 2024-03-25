package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MHierarchy;

/**
 * Data Loader for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_HierarchyDataLoader extends PODataLoader<MHierarchy> {
	public static String DATALOADER_PA_Hierarchy_BY_ID = "PA_HierarchyByIdDataLoader";
	public static String DATALOADER_PA_Hierarchy_BY_UUID = "PA_HierarchyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MHierarchy.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_Hierarchy_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_Hierarchy_BY_UUID;
	}
}
