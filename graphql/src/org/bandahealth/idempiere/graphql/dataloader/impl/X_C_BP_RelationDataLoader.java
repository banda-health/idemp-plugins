package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BP_Relation;

/**
 * Data Loader for C_BP_Relation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_RelationDataLoader extends PODataLoader<X_C_BP_Relation> {
	public static String C_BP_Relation_BY_ID_DATA_LOADER = "C_BP_RelationByIdDataLoader";
	public static String C_BP_Relation_BY_UUID_DATA_LOADER = "C_BP_RelationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BP_Relation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BP_Relation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BP_Relation_BY_UUID_DATA_LOADER;
	}
}
