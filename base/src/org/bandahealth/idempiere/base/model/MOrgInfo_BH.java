package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MOrgInfo;

public class MOrgInfo_BH extends MOrgInfo {

	private static final long serialVersionUID = 1L;
	
	public static final String COLUMNNAME_BH_HEADER = "BH_Header";
	
	public static final String COLUMNNAME_BH_FACILITY_NUMBER = "BH_FacilityNumber";
	
	public static final String COLUMNNAME_BH_PAYMENT_INFORMATION = "BH_PaymentInformation";
	
	public static final String LOGO_STORAGEPROVIDER_UU = "8b887c9c-d8ca-4b9c-a548-267b1e9c7c5c";
	
	public MOrgInfo_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public String getBH_Header() {
		return (String) get_Value(COLUMNNAME_BH_HEADER);
	}

	public void setBH_Header(String BH_Header) {
		set_Value(COLUMNNAME_BH_HEADER, BH_Header);
	}
	
	public String getBH_FacilityNumber() {
		return (String) get_Value(COLUMNNAME_BH_FACILITY_NUMBER);
	}

	public void setBH_FacilityNumber(String BH_FacilityNumber) {
		set_Value(COLUMNNAME_BH_FACILITY_NUMBER, BH_FacilityNumber);
	}
	
	public String getBH_PaymentInformation() {
		return (String) get_Value(COLUMNNAME_BH_PAYMENT_INFORMATION);
	}

	public void setBH_PaymentInformation(String BH_PaymentInformation) {
		set_Value(COLUMNNAME_BH_PAYMENT_INFORMATION, BH_PaymentInformation);
	}
}
