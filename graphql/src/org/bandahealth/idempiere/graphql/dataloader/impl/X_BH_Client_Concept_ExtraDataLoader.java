package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;

/**
 * Data Loader for BH_Client_Concept_Extra - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Client_Concept_ExtraDataLoader extends PODataLoader<MBHClientConceptExtra> {
	public static String DATALOADER_BH_Client_Concept_Extra_BY_ID = "BH_Client_Concept_ExtraByIdDataLoader";
	public static String DATALOADER_BH_Client_Concept_Extra_BY_UUID = "BH_Client_Concept_ExtraByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHClientConceptExtra.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Client_Concept_Extra_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Client_Concept_Extra_BY_UUID;
	}
}
