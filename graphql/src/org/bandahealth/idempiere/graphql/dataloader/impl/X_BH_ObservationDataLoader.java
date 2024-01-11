package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHObservation;

/**
 * Data Loader for BH_Observation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_ObservationDataLoader extends PODataLoader<MBHObservation> {
	public static String BH_Observation_BY_ID_DATA_LOADER = "BH_ObservationByIdDataLoader";
	public static String BH_Observation_BY_UUID_DATA_LOADER = "BH_ObservationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHObservation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Observation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Observation_BY_UUID_DATA_LOADER;
	}
}
