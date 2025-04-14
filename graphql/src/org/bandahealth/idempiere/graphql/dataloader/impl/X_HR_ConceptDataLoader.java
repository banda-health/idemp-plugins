package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Concept;

/**
 * Data Loader for HR_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_ConceptDataLoader extends PODataLoader<X_HR_Concept> {
	public static String DATALOADER_HR_Concept_BY_ID = "HR_ConceptByIdDataLoader";
	public static String DATALOADER_HR_Concept_BY_UUID = "HR_ConceptByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Concept.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Concept_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Concept_BY_UUID;
	}
}
