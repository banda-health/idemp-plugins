package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHConceptName;

/**
 * Data Loader for BH_Concept_Name - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Concept_NameDataLoader extends PODataLoader<MBHConceptName> {
	public static String DATALOADER_BH_Concept_Name_BY_ID = "BH_Concept_NameByIdDataLoader";
	public static String DATALOADER_BH_Concept_Name_BY_UUID = "BH_Concept_NameByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHConceptName.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Concept_Name_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Concept_Name_BY_UUID;
	}
}
