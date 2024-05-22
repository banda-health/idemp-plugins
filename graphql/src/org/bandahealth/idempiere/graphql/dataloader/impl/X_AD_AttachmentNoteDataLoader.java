package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttachmentNote;

/**
 * Data Loader for AD_AttachmentNote - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AttachmentNoteDataLoader extends PODataLoader<MAttachmentNote> {
	public static String DATALOADER_AD_AttachmentNote_BY_ID = "AD_AttachmentNoteByIdDataLoader";
	public static String DATALOADER_AD_AttachmentNote_BY_UUID = "AD_AttachmentNoteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttachmentNote.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_AttachmentNote_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_AttachmentNote_BY_UUID;
	}
}
