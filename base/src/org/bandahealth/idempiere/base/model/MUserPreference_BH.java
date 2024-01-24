package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MUserPreference;

public class MUserPreference_BH extends MUserPreference {
    /** Column name MigrationScriptComment */
    public static final String COLUMNNAME_MigrationScriptComment = "MigrationScriptComment";

	public MUserPreference_BH(Properties ctx, int AD_UserPreference_ID, String trxName) {
		super(ctx, AD_UserPreference_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MUserPreference_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/** Set Migration Script Comment.
	@param MigrationScriptComment Migration Script Comment	  */
	public void setMigrationScriptComment (String MigrationScriptComment)
	{
		set_Value (COLUMNNAME_MigrationScriptComment, MigrationScriptComment);
	}
	
	/** Get Migration Script Comment.
		@return Migration Script Comment	  */
	public String getMigrationScriptComment () 
	{
		return (String)get_Value(COLUMNNAME_MigrationScriptComment);
	}
}
