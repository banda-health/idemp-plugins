package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.report.MReportLine;

public class MReportLine_BH extends MReportLine {
    /** Column name UnderlineStrokeType */
    public static final String COLUMNNAME_UnderlineStrokeType = "UnderlineStrokeType";

    /** Column name OverlineStrokeType */
    public static final String COLUMNNAME_OverlineStrokeType = "OverlineStrokeType";    

	public MReportLine_BH(Properties ctx, int PA_ReportLine_ID, String trxName) {
		super(ctx, PA_ReportLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MReportLine_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/** OverlineStrokeType AD_Reference_ID=200174 */
	public static final int OVERLINESTROKETYPE_AD_Reference_ID=200174;
	/** Dotted = DT */
	public static final String OVERLINESTROKETYPE_Dotted = "DT";
	/** Dashed = DS */
	public static final String OVERLINESTROKETYPE_Dashed = "DS";
	/** Double Dotted = DDT */
	public static final String OVERLINESTROKETYPE_DoubleDotted = "DDT";
	/** Double Dashed = DDS */
	public static final String OVERLINESTROKETYPE_DoubleDashed = "DDS";
	/** Double Solid = DSD */
	public static final String OVERLINESTROKETYPE_DoubleSolid = "DSD";
	/** Solid = SD */
	public static final String OVERLINESTROKETYPE_Solid = "SD";
	/** Set Overline Stroke Type.
		@param OverlineStrokeType Overline Stroke Type	  */
	public void setOverlineStrokeType (String OverlineStrokeType)
	{

		set_Value (COLUMNNAME_OverlineStrokeType, OverlineStrokeType);
	}

	/** Get Overline Stroke Type.
		@return Overline Stroke Type	  */
	public String getOverlineStrokeType () 
	{
		return (String)get_Value(COLUMNNAME_OverlineStrokeType);
	}
	
	/** UnderlineStrokeType AD_Reference_ID=200174 */
	public static final int UNDERLINESTROKETYPE_AD_Reference_ID=200174;
	/** Dotted = DT */
	public static final String UNDERLINESTROKETYPE_Dotted = "DT";
	/** Dashed = DS */
	public static final String UNDERLINESTROKETYPE_Dashed = "DS";
	/** Double Dotted = DDT */
	public static final String UNDERLINESTROKETYPE_DoubleDotted = "DDT";
	/** Double Dashed = DDS */
	public static final String UNDERLINESTROKETYPE_DoubleDashed = "DDS";
	/** Double Solid = DSD */
	public static final String UNDERLINESTROKETYPE_DoubleSolid = "DSD";
	/** Solid = SD */
	public static final String UNDERLINESTROKETYPE_Solid = "SD";
	/** Set Underline Stroke Type.
		@param UnderlineStrokeType Underline Stroke Type	  */
	public void setUnderlineStrokeType (String UnderlineStrokeType)
	{

		set_Value (COLUMNNAME_UnderlineStrokeType, UnderlineStrokeType);
	}

	/** Get Underline Stroke Type.
		@return Underline Stroke Type	  */
	public String getUnderlineStrokeType () 
	{
		return (String)get_Value(COLUMNNAME_UnderlineStrokeType);
	}	
}
