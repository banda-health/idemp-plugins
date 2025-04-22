package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHConceptMapping;

/**
 * Data Loader for BH_Concept_Mapping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Concept_MappingDataLoader extends PODataLoader<MBHConceptMapping> {
	public static String DATALOADER_BH_Concept_Mapping_BY_ID = "BH_Concept_MappingByIdDataLoader";
	public static String DATALOADER_BH_Concept_Mapping_BY_UUID = "BH_Concept_MappingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHConceptMapping.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Concept_Mapping_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Concept_Mapping_BY_UUID;
	}
}
