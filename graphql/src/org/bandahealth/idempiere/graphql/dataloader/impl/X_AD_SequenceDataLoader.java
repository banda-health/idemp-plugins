package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MSequence_BH;

/**
 * Data Loader for AD_Sequence - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_SequenceDataLoader extends PODataLoader<MSequence_BH> {
	public static String DATALOADER_AD_Sequence_BY_ID = "AD_SequenceByIdDataLoader";
	public static String DATALOADER_AD_Sequence_BY_UUID = "AD_SequenceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSequence_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Sequence_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Sequence_BY_UUID;
	}
}
