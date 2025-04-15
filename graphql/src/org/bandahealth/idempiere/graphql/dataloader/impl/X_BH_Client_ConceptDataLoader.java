package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHClientConcept;

/**
 * Data Loader for BH_Client_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Client_ConceptDataLoader extends PODataLoader<MBHClientConcept> {
	public static String DATALOADER_BH_Client_Concept_BY_ID = "BH_Client_ConceptByIdDataLoader";
	public static String DATALOADER_BH_Client_Concept_BY_UUID = "BH_Client_ConceptByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHClientConcept.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Client_Concept_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Client_Concept_BY_UUID;
	}
}
