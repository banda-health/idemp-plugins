package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Offer;

/**
 * Data Loader for B_Offer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_OfferDataLoader extends PODataLoader<X_B_Offer> {
	public static String B_Offer_BY_ID_DATA_LOADER = "B_OfferByIdDataLoader";
	public static String B_Offer_BY_UUID_DATA_LOADER = "B_OfferByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Offer.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return B_Offer_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return B_Offer_BY_UUID_DATA_LOADER;
	}
}
