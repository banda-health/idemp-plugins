package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttachment;

/**
 * Data Loader for AD_Attachment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AttachmentDataLoader extends PODataLoader<MAttachment> {
	public static String AD_Attachment_BY_ID_DATA_LOADER = "AD_AttachmentByIdDataLoader";
	public static String AD_Attachment_BY_UUID_DATA_LOADER = "AD_AttachmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttachment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Attachment_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Attachment_BY_UUID_DATA_LOADER;
	}
}
