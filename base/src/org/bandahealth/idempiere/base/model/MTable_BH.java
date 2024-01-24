package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MTable;

public class MTable_BH extends MTable {

    /** Column name CreateWindowFromTable */
    public static final String COLUMNNAME_CreateWindowFromTable = "CreateWindowFromTable";

	public MTable_BH(Properties ctx, int AD_Table_ID, String trxName) {
		super(ctx, AD_Table_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTable_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/** Set Create Window From Table.
	@param CreateWindowFromTable Create Window From Table	  */
	public void setCreateWindowFromTable (String CreateWindowFromTable)
	{
		set_Value (COLUMNNAME_CreateWindowFromTable, CreateWindowFromTable);
	}
	
	/** Get Create Window From Table.
		@return Create Window From Table	  */
	public String getCreateWindowFromTable () 
	{
		return (String)get_Value(COLUMNNAME_CreateWindowFromTable);
	}
}
