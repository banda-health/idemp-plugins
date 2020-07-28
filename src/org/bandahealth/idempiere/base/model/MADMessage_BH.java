package org.bandahealth.idempiere.base.model;

import org.compiere.model.X_AD_Message;

import java.sql.ResultSet;
import java.util.Properties;

public class MADMessage_BH extends X_AD_Message {

	public static String OLD_PASSWORD_MANDATORY = "OldPasswordMandatory";
	public static String NEW_PASSWORD_MANDATORY = "NewPasswordConfirmMandatory";
	public static String SECURITY_QUESTION_MANDATORY = "SecurityQuestionMandatory";
	public static String ANSWER_MANDATORY = "AnswerMandatory";
	public static String OLD_PASSWORD_DOESNT_MATCH = "OldPasswordNoMatch";
	public static String NEW_PASSWORD_MUST_DIFFER = "NewPasswordMustDiffer";

	// These are copied from ResetPasswordPanel
	public static int NO_OF_SECURITY_QUESTION = 5;
	public static String SECURITY_QUESTION_PREFIX = "SecurityQuestion_";

	public MADMessage_BH(Properties ctx, int AD_Message_ID, String trxName) {
		super(ctx, AD_Message_ID, trxName);
	}

	public MADMessage_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
