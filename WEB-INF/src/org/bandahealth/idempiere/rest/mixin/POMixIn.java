package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.pdf.Document;
import org.compiere.acct.Doc;
import org.compiere.model.MAttachment;
import org.compiere.util.CLogger;
import org.compiere.util.KeyNamePair;

import java.util.HashMap;
import java.util.Properties;

public interface POMixIn {
	@JsonIgnore Properties getCtx();
	@JsonIgnore String get_TableName();
	@JsonIgnore String[] get_KeyColumns();
	@JsonIgnore int get_Table_ID();
	@JsonIgnore int get_IDOld();
	@JsonIgnore CLogger get_Logger();
	@JsonIgnore Object get_Value();
	@JsonIgnore int get_ValueAsInt();
	@JsonIgnore boolean get_ValueAsBoolean();
	@JsonIgnore String get_ValueAsString();
	@JsonIgnore Object get_ValueOfColumn();
	@JsonIgnore Object get_ValueOld();
	@JsonIgnore int get_ValueOldAsInt();
	@JsonIgnore Object get_ValueDifference();
	@JsonIgnore int get_ColumnCount();
	@JsonIgnore String get_ColumnName();
	@JsonIgnore String get_ColumnLabel();
	@JsonIgnore String get_ColumnDescription();
	@JsonIgnore int get_ColumnIndex();
	@JsonIgnore String get_DisplayValue();
	@JsonIgnore String get_TrxName();
	@JsonIgnore MAttachment getAttachment();
	@JsonIgnore byte[] getAttachmentData();
	@JsonIgnore byte[] getPdfAttachment();
	@JsonIgnore StringBuffer get_xmlString();
	@JsonIgnore Document get_xmlDocument();
	@JsonIgnore Doc getDoc();
	@JsonIgnore String getUUIDColumnName();
	@JsonIgnore Object get_Attribute();
	@JsonIgnore HashMap<String, Object> get_Attributes();
	@JsonIgnore KeyNamePair getKeyNamePair();
	@JsonIgnore boolean is_new();
	@JsonIgnore boolean is_Changed();
	@JsonIgnore boolean isAttachment();
	@JsonIgnore boolean isReplication();
	@JsonIgnore boolean is_ValueChanged();

	@JsonProperty("id") int get_ID();
}
