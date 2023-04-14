package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MTabNavBtn extends X_BH_TabNavBtn {

	/**
	 * Button Action AD_Reference_UU=6f31d9f4-6230-4cc8-9f05-7179142dc21a
	 */
	public static final String BUTTONACTION_AD_Reference_UU = "6f31d9f4-6230-4cc8-9f05-7179142dc21a";
	/**
	 * Copy = C
	 */
	public static final String BUTTONACTION_Copy = "C";
	/**
	 * Delete = D
	 */
	public static final String BUTTONACTION_Delete = "D";
	/**
	 * Navigation = G
	 */
	public static final String BUTTONACTION_Navigation = "G";
	/**
	 * New = N
	 */
	public static final String BUTTONACTION_New = "N";
	/**
	 * Process = P
	 */
	public static final String BUTTONACTION_Process = "P";
	/**
	 * Save = S
	 */
	public static final String BUTTONACTION_Save = "S";
	/**
	 * Cancel = U
	 */
	public static final String BUTTONACTION_Cancel = "U";
	/**
	 * Button Location AD_Reference_UU=4cb0c1b4-9dbc-421e-9749-e48b1fa41e0c
	 */
	public static final String BUTTONLOCATION_AD_Reference_UU = "4cb0c1b4-9dbc-421e-9749-e48b1fa41e0c";
	/**
	 * Full = F
	 */
	public static final String BUTTONLOCATION_Full = "F";
	/**
	 * Left = L
	 */
	public static final String BUTTONLOCATION_Left = "L";
	/**
	 * Middle = M
	 */
	public static final String BUTTONLOCATION_Middle = "M";
	/**
	 * Right = R
	 */
	public static final String BUTTONLOCATION_Right = "R";

	public MTabNavBtn(Properties ctx, int BH_HomeScreen_Button_ID, String trxName) {
		super(ctx, BH_HomeScreen_Button_ID, trxName);
	}

	public MTabNavBtn(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
