package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.report.MReportColumn;
import org.compiere.util.Env;

public class MReportColumn_BH extends MReportColumn {

    /** Column name RelativePeriodTo */
    public static final String COLUMNNAME_RelativePeriodTo = "RelativePeriodTo";

	public MReportColumn_BH(Properties ctx, int PA_ReportColumn_ID, String trxName) {
		super(ctx, PA_ReportColumn_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MReportColumn_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/** Set Relative Period To.
	@param RelativePeriodTo 
	Period offset (0 is current)
	  */
	public void setRelativePeriodTo (BigDecimal RelativePeriodTo)
	{
		set_Value (COLUMNNAME_RelativePeriodTo, RelativePeriodTo);
	}
	
	/** Get Relative Period To.
		@return Period offset (0 is current)
	  */
	public BigDecimal getRelativePeriodTo () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RelativePeriodTo);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}
