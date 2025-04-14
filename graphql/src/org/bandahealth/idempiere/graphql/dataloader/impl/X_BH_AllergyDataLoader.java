package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHAllergy;

/**
 * Data Loader for BH_Allergy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_AllergyDataLoader extends PODataLoader<MBHAllergy> {
	public static String DATALOADER_BH_Allergy_BY_ID = "BH_AllergyByIdDataLoader";
	public static String DATALOADER_BH_Allergy_BY_UUID = "BH_AllergyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHAllergy.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Allergy_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Allergy_BY_UUID;
	}
}
