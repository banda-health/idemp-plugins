package org.bandahealth.idempiere.base.editor.factory;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.adempiere.base.IDisplayTypeFactory;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Reference;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Language;

public class BHDisplayTypeFactory implements IDisplayTypeFactory {

	CLogger log = CLogger.getCLogger(BHDisplayTypeFactory.class);

	public static int PaymentRow = -1;
//			((X_AD_Reference)new Query(Env.getCtx(), X_AD_Reference.Table_Name,
//			"Name='BH Bill Payments'", null).first()).getAD_Reference_ID();

	private static String TabNavButtonReferenceUUID = "fa6aea19-82bc-4a8c-8c52-6f13435ff2a9";
	public static int TabNavButton = ((X_AD_Reference) new Query(Env.getCtx(), X_AD_Reference.Table_Name,
			X_AD_Reference.COLUMNNAME_AD_Reference_UU + "='" + TabNavButtonReferenceUUID + "'",
			null)
			.first()).getAD_Reference_ID();

	@Override
	public boolean isID(int displayType) {
		return false;
	}

	@Override
	public boolean isNumeric(int displayType) {
		return false;
	}

	@Override
	public Integer getDefaultPrecision(int displayType) {
		return null;
	}

	@Override
	public boolean isText(int displayType) {
		if (displayType == PaymentRow) {
			return true;
		}else if (displayType == TabNavButton) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isDate(int displayType) {
		return false;
	}

	@Override
	public boolean isLookup(int displayType) {
		return false;
	}

	@Override
	public boolean isLOB(int displayType) {
		return false;
	}

	@Override
	public DecimalFormat getNumberFormat(int displayType, Language language, String pattern) {
		return null;
	}

	@Override
	public SimpleDateFormat getDateFormat(int displayType, Language language, String pattern) {
		return null;
	}

	@Override
	public Class<?> getClass(int displayType, boolean yesNoAsBoolean) {
		return null;
	}

	@Override
	public String getSQLDataType(int displayType, String columnName, int fieldLength) {
		if (displayType == PaymentRow) {
			return "NVARCHAR2(" + fieldLength + ")";
		} else if (displayType == TabNavButton) {
			return "NVARCHAR2(" + fieldLength + ")";
		}
		return null;
	}

	@Override
	public String getDescription(int displayType) {
		if (displayType == PaymentRow) {
			return "PaymentRow";
		} else if (displayType == TabNavButton) {
			return "TabNavButton";
		}
		return null;
	}
}
