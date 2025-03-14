package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHAllergyReaction;

/**
 * Data Loader for BH_Allergy_Reaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Allergy_ReactionDataLoader extends PODataLoader<MBHAllergyReaction> {
	public static String DATALOADER_BH_Allergy_Reaction_BY_ID = "BH_Allergy_ReactionByIdDataLoader";
	public static String DATALOADER_BH_Allergy_Reaction_BY_UUID = "BH_Allergy_ReactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHAllergyReaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Allergy_Reaction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Allergy_Reaction_BY_UUID;
	}
}
