package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MDiscountSchemaLine;

public class MDiscountSchemaLine_BH extends MDiscountSchemaLine {
    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	public MDiscountSchemaLine_BH(Properties ctx, int M_DiscountSchemaLine_ID, String trxName) {
		super(ctx, M_DiscountSchemaLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MDiscountSchemaLine_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/** Set Description.
	@param Description 
	Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}
	
	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}
}
