package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHConceptDescription;

/**
 * Data Loader for BH_Concept_Description - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Concept_DescriptionDataLoader extends PODataLoader<MBHConceptDescription> {
	public static String DATALOADER_BH_Concept_Description_BY_ID = "BH_Concept_DescriptionByIdDataLoader";
	public static String DATALOADER_BH_Concept_Description_BY_UUID = "BH_Concept_DescriptionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHConceptDescription.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Concept_Description_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Concept_Description_BY_UUID;
	}
}
