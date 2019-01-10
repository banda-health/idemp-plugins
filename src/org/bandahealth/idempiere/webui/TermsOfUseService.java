package org.bandahealth.idempiere.webui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.adempiere.webui.component.Label;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Html;
import org.zkoss.zul.Script;

public  class  TermsOfUseService{

	public static String getTermsOfUseContent() {
		String termsAndConditions = null;
		ClassLoader classLoader = TermsOfUseService.class.getClassLoader();
		InputStream iReader = classLoader.getResourceAsStream("resources/TermsAndConditions.txt");

		if (iReader != null) {
			try (BufferedReader bReader = new BufferedReader(new InputStreamReader(iReader))) {
				StringBuilder sBuilder = new StringBuilder();
				String line = bReader.readLine();
				while (line != null) {
					sBuilder.append(line);
					sBuilder.append("<br />");
					line = bReader.readLine();
				}
				termsAndConditions = sBuilder.toString();
			} catch (IOException ex) {
				CLogger.get().log(Level.SEVERE, ex.getMessage());
			}
		}
		return termsAndConditions;
	}

	public static boolean isAccepted() {
		String whereClause = MUser_BH.COLUMNNAME_AD_User_ID + "=" + Env.getAD_User_ID(Env.getCtx()) + " AND "
				+ MUser_BH.COLUMNNAME_BH_HasAcceptedTermsOfUse + "='Y'";
		return new Query(Env.getCtx(), MUser_BH.Table_Name, whereClause, null).setOnlyActiveRecords(true).match();
	}

	public static  void acceptTermsOfUse() {
		MUser_BH user = new MUser_BH(Env.getCtx(), Env.getAD_User_ID(Env.getCtx()), null);
		user.setBH_HasAcceptedTermsOfUse(true);
		user.save();
		
	}
}
