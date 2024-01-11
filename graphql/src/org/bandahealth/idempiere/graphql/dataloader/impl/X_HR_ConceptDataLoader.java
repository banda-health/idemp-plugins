package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Concept;

/**
 * Data Loader for HR_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ConceptDataLoader extends PODataLoader<X_HR_Concept> {
	public static String HR_Concept_BY_ID_DATA_LOADER = "HR_ConceptByIdDataLoader";
	public static String HR_Concept_BY_UUID_DATA_LOADER = "HR_ConceptByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Concept.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Concept_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Concept_BY_UUID_DATA_LOADER;
	}
}
