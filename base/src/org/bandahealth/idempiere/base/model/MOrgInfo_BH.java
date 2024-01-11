package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MOrgInfo;

public class MOrgInfo_BH extends MOrgInfo {

	private static final long serialVersionUID = 1L;

	/** Load Meta Data */

	/** Column name BH_ExtraInfo */
	public static final String COLUMNNAME_BH_ExtraInfo = "BH_ExtraInfo";

	/** Column name BH_FacilityNumber */
	public static final String COLUMNNAME_BH_FacilityNumber = "BH_FacilityNumber";

	/** Column name BH_Header */
	public static final String COLUMNNAME_BH_Header = "BH_Header";

	/** Column name BH_PaymentInformation */
	public static final String COLUMNNAME_BH_PaymentInformation = "BH_PaymentInformation";
	
	public MOrgInfo_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/** Set Extra Information.
	 @param BH_ExtraInfo
	 Enter additional information for this organization
	 */
	public void setBH_ExtraInfo (String BH_ExtraInfo)
	{
		set_Value (COLUMNNAME_BH_ExtraInfo, BH_ExtraInfo);
	}

	/** Get Extra Information.
	 @return Enter additional information for this organization
	 */
	public String getBH_ExtraInfo ()
	{
		return (String)get_Value(COLUMNNAME_BH_ExtraInfo);
	}

	/** Set Facility Number.
	 @param BH_FacilityNumber
	 Facility Number (MFL No.)
	 */
	public void setBH_FacilityNumber (String BH_FacilityNumber)
	{
		set_Value (COLUMNNAME_BH_FacilityNumber, BH_FacilityNumber);
	}

	/** Get Facility Number.
	 @return Facility Number (MFL No.)
	 */
	public String getBH_FacilityNumber ()
	{
		return (String)get_Value(COLUMNNAME_BH_FacilityNumber);
	}

	/** Set Header.
	 @param BH_Header
	 Header information e.g address, phone number etc.
	 */
	public void setBH_Header (String BH_Header)
	{
		set_Value (COLUMNNAME_BH_Header, BH_Header);
	}

	/** Get Header.
	 @return Header information e.g address, phone number etc.
	 */
	public String getBH_Header ()
	{
		return (String)get_Value(COLUMNNAME_BH_Header);
	}

	/** Set Payment Information.
	 @param BH_PaymentInformation
	 Payment Information
	 */
	public void setBH_PaymentInformation (String BH_PaymentInformation)
	{
		set_Value (COLUMNNAME_BH_PaymentInformation, BH_PaymentInformation);
	}

	/** Get Payment Information.
	 @return Payment Information
	 */
	public String getBH_PaymentInformation ()
	{
		return (String)get_Value(COLUMNNAME_BH_PaymentInformation);
	}
}
