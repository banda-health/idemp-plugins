package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Offer;

/**
 * Data Loader for B_Offer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_OfferDataLoader extends PODataLoader<X_B_Offer> {
	public static String DATALOADER_B_Offer_BY_ID = "B_OfferByIdDataLoader";
	public static String DATALOADER_B_Offer_BY_UUID = "B_OfferByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Offer.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_B_Offer_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_B_Offer_BY_UUID;
	}
}
