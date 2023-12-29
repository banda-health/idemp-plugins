package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MSequence_BH;

/**
 * Data Loader for AD_Sequence - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SequenceDataLoader extends PODataLoader<MSequence_BH> {
	public static String AD_Sequence_BY_ID_DATA_LOADER = "AD_SequenceByIdDataLoader";
	public static String AD_Sequence_BY_UUID_DATA_LOADER = "AD_SequenceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSequence_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Sequence_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Sequence_BY_UUID_DATA_LOADER;
	}
}
