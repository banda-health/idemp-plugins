package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MHierarchy;

/**
 * Data Loader for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_HierarchyDataLoader extends PODataLoader<MHierarchy> {
	public static String PA_Hierarchy_BY_ID_DATA_LOADER = "PA_HierarchyByIdDataLoader";
	public static String PA_Hierarchy_BY_UUID_DATA_LOADER = "PA_HierarchyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MHierarchy.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_Hierarchy_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_Hierarchy_BY_UUID_DATA_LOADER;
	}
}
