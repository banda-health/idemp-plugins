package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_BidComment;

/**
 * Data Loader for B_BidComment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_B_BidCommentDataLoader extends PODataLoader<X_B_BidComment> {
	public static String DATALOADER_B_BidComment_BY_ID = "B_BidCommentByIdDataLoader";
	public static String DATALOADER_B_BidComment_BY_UUID = "B_BidCommentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_BidComment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_B_BidComment_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_B_BidComment_BY_UUID;
	}
}
