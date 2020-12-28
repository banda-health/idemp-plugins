package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.acct.Doc;
import org.compiere.model.MAttachment;
import org.compiere.util.CLogger;
import org.compiere.util.KeyNamePair;
import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.Properties;

public abstract class POMixIn {
	@JsonIgnore abstract Properties getCtx();
	@JsonIgnore abstract String get_TableName();
	@JsonIgnore abstract String[] get_KeyColumns();
	@JsonIgnore abstract int get_Table_ID();
	@JsonIgnore abstract int get_IDOld();
	@JsonIgnore abstract CLogger get_Logger();
	@JsonIgnore abstract Object get_Value();
	@JsonIgnore abstract int get_ValueAsInt();
	@JsonIgnore abstract boolean get_ValueAsBoolean();
	@JsonIgnore abstract String get_ValueAsString();
	@JsonIgnore abstract Object get_ValueOfColumn();
	@JsonIgnore abstract Object get_ValueOld();
	@JsonIgnore abstract int get_ValueOldAsInt();
	@JsonIgnore abstract Object get_ValueDifference();
	@JsonIgnore abstract int get_ColumnCount();
	@JsonIgnore abstract String get_ColumnName();
	@JsonIgnore abstract String get_ColumnLabel();
	@JsonIgnore abstract String get_ColumnDescription();
	@JsonIgnore abstract int get_ColumnIndex();
	@JsonIgnore abstract String get_DisplayValue();
	@JsonIgnore abstract String get_TrxName();
	@JsonIgnore abstract MAttachment getAttachment();
	@JsonIgnore abstract byte[] getAttachmentData();
	@JsonIgnore abstract byte[] getPdfAttachment();
	@JsonIgnore abstract StringBuffer get_xmlString();
	@JsonIgnore abstract Document get_xmlDocument();
	@JsonIgnore abstract Doc getDoc();
	@JsonIgnore abstract String getUUIDColumnName();
	@JsonIgnore abstract Object get_Attribute();
	@JsonIgnore abstract HashMap<String, Object> get_Attributes();
	@JsonIgnore abstract KeyNamePair getKeyNamePair();
	@JsonIgnore abstract boolean is_new();
	@JsonIgnore abstract boolean is_Changed();
	@JsonIgnore abstract boolean isAttachment();
	@JsonIgnore abstract boolean isReplication();
	@JsonIgnore abstract boolean is_ValueChanged();

	@JsonProperty("id") abstract int get_ID();
}
