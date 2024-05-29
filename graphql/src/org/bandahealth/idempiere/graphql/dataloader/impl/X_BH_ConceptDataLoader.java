package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHConcept;

/**
 * Data Loader for BH_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_ConceptDataLoader extends PODataLoader<MBHConcept> {
	public static String DATALOADER_BH_Concept_BY_ID = "BH_ConceptByIdDataLoader";
	public static String DATALOADER_BH_Concept_BY_UUID = "BH_ConceptByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHConcept.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Concept_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Concept_BY_UUID;
	}
}
