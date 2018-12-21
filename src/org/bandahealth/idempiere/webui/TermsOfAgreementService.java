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

public  class  TermsOfAgreementService{

	private CLogger log = CLogger.getCLogger(TermsOfAgreementService.class);
	private Div contentArea = new Div();

//	private void createTOSPrivacyPolicyPanel() {
//		// heading section
//		Div groupSeparator = new Div();
//		groupSeparator.setClass("bh-button-group-header");
//		groupSeparator.appendChild(new Text("Terms Of Service - Banda Health Solutions"));
//
//		contentArea.appendChild(groupSeparator);
//
//		Div groupContainer = new Div();
//		groupContainer.setClass("bh-button-group-content");
//
//		// content section
//		Div contentSection = new Div();
//		contentSection.appendChild(new Html(getTermsAndConditionsContent()));
//
//		groupContainer.appendChild(contentSection);
//
//		// button section
//		Div buttonsSection = new Div();
//		buttonsSection.setClass("bh-tab-nav-buttons z-div");
//
//		Div acceptButton = new Div();
//		acceptButton.setClass("btn btn-confirm z-div");
//		acceptButton.setStyle("width:120px");
//
//		Div icon = new Div();
//		icon.setClass("fas fa-chevron-right i");
//		acceptButton.appendChild(icon);
//
//		Label label = new Label(" Accept ");
//		label.setStyle("color: white");
//		acceptButton.appendChild(label);
//		acceptButton.setAttribute(UIUtil.TERMS_OF_USE_ATTRIBUTE, true);
//		acceptButton.setAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE, false);
//		acceptButton.setAttribute(UIUtil.REPORT_OR_PROCESS_ATTRIBUTE, false);
//		buttonsSection.appendChild(acceptButton);
//
//		Div rejectButton = new Div();
//		rejectButton.setClass("img-btn z-button");
//		rejectButton.setStyle("width:120px");
//
//		Div cancelIcon = new Div();
//		cancelIcon.setClass("fas fa-ban i");
//		rejectButton.appendChild(cancelIcon);
//
//		Label rejectLabel = new Label(" Reject ");
//		rejectButton.appendChild(rejectLabel);
//		rejectButton.setAttribute(UIUtil.TERMS_OF_USE_ATTRIBUTE, false);
//		rejectButton.setAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE, false);
//		rejectButton.setAttribute(UIUtil.REPORT_OR_PROCESS_ATTRIBUTE, false);
//		buttonsSection.appendChild(rejectButton);
//
//		groupContainer.appendChild(buttonsSection);
//
//		contentArea.appendChild(groupContainer);
//	}

	public String getTermsAndConditionsContent() {
		String termsAndConditions = null;
		InputStream iReader = this.getClass().getClassLoader().getResourceAsStream("resources/TermsAndConditions.txt");

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
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		return termsAndConditions;
	}

	public boolean isAccepted() {
		String whereClause = MUser_BH.COLUMNNAME_AD_User_ID + "=" + Env.getAD_User_ID(Env.getCtx()) + " AND "
				+ MUser_BH.COLUMNNAME_BH_HasAcceptedTermsOfUse + "='Y'";
		return new Query(Env.getCtx(), MUser_BH.Table_Name, whereClause, null).setOnlyActiveRecords(true).match();
	}

	public void acceptTermsOfUse(Component component) {
		MUser_BH user = new MUser_BH(Env.getCtx(), Env.getAD_User_ID(Env.getCtx()), null);
		user.setBH_HasAcceptedTermsOfUse(true);
		user.save();
		
	}
}
