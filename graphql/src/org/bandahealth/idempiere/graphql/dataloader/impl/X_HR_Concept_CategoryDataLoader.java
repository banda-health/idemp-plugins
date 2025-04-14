package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Concept_Category;

/**
 * Data Loader for HR_Concept_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_Concept_CategoryDataLoader extends PODataLoader<X_HR_Concept_Category> {
	public static String DATALOADER_HR_Concept_Category_BY_ID = "HR_Concept_CategoryByIdDataLoader";
	public static String DATALOADER_HR_Concept_Category_BY_UUID = "HR_Concept_CategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Concept_Category.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Concept_Category_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Concept_Category_BY_UUID;
	}
}
