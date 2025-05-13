package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHConceptExtra;

/**
 * Data Loader for BH_Concept_Extra - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Concept_ExtraDataLoader extends PODataLoader<MBHConceptExtra> {
	public static String DATALOADER_BH_Concept_Extra_BY_ID = "BH_Concept_ExtraByIdDataLoader";
	public static String DATALOADER_BH_Concept_Extra_BY_UUID = "BH_Concept_ExtraByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHConceptExtra.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Concept_Extra_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Concept_Extra_BY_UUID;
	}
}
