package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MImportTemplate;
import org.compiere.model.X_AD_ImportTemplateAccess;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

public class ImportBusinessPartnersProcessTest extends ChuBoePopulateFactoryVO {
	private static int BUSINESS_PARTNER_WINDOW_ID = 123;
	private static int BUSINESS_PARTNER_TAB_ID = 220;
	private static String BUSINESS_PARTNER_IMPORT_HEADER = "Name,C_BP_Group_ID[Value],IsCustomer,IsProspect,bh_gender,BH_Birthday,BH_Local_PatientID,BH_Phone,C_BPartner_Location>Name,C_BPartner_Location>C_Location>Address1,C_BPartner_Location>C_Location>C_Country_ID[Name]";
	private static String BUSINESS_PARTNER_IMPORT_CSV_FILENAME = "./data/import/BandaBusinessPartnerImportTest.csv";
	
	@IPopulateAnnotation.CanRun
	public void businessPartnerIsImportedProperly() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		// Check if an import template already exists with the required elements
		List<MImportTemplate> importTemplateList = new Query(valueObject.getContext(), MImportTemplate.Table_Name,
				MImportTemplate.COLUMNNAME_AD_Client_ID + " IN (0,?) AND " +
				MImportTemplate.COLUMNNAME_AD_Window_ID + "=? AND " + 
				MImportTemplate.COLUMNNAME_AD_Tab_ID + "=? AND " +
				MImportTemplate.COLUMNNAME_CSVHeader + "=?", get_TrxName())
			.setParameters(
				valueObject.getClient().getAD_Client_ID(),
				BUSINESS_PARTNER_WINDOW_ID,
				BUSINESS_PARTNER_TAB_ID,
				BUSINESS_PARTNER_IMPORT_HEADER)
			.setOnlyActiveRecords(true).list();
		
		int importTemplateId;
		MImportTemplate newImportTemplate = null;
		
		if (importTemplateList.isEmpty()) {
			// If no suitable template existed, create one
			newImportTemplate = new MImportTemplate(valueObject.getContext(), 0, valueObject.getTransactionName());
			newImportTemplate.setName(getScenarioName());
			newImportTemplate.setAD_Window_ID(BUSINESS_PARTNER_WINDOW_ID);
			newImportTemplate.setAD_Tab_ID(BUSINESS_PARTNER_TAB_ID);
			newImportTemplate.setCSVHeader(BUSINESS_PARTNER_IMPORT_HEADER);
			newImportTemplate.saveEx();
			importTemplateId = newImportTemplate.getAD_ImportTemplate_ID();
		} else {
			// If there were suitable templates, get the ID of the first one
			importTemplateId = importTemplateList.get(0).getAD_ImportTemplate_ID();
		}
		
		// Check if there is an import template access record set up that is suitable for the current role
		List<X_AD_ImportTemplateAccess> templateAccessList = new Query(valueObject.getContext(), X_AD_ImportTemplateAccess.Table_Name,
				X_AD_ImportTemplateAccess.COLUMNNAME_AD_Client_ID + "=? AND " +
				X_AD_ImportTemplateAccess.COLUMNNAME_AD_ImportTemplate_ID + "=? AND " +
				X_AD_ImportTemplateAccess.COLUMNNAME_AD_Role_ID + "=? AND " +
				X_AD_ImportTemplateAccess.COLUMNNAME_IsAllowInsert + "=?", get_TrxName())
			.setParameters(
				valueObject.getClient().getAD_Client_ID(),
				importTemplateId,
				Env.getAD_Role_ID(Env.getCtx()),
				"Y")
			.setOnlyActiveRecords(true).list();
		
		X_AD_ImportTemplateAccess newTemplateAccess = null;
		
		if (templateAccessList.isEmpty()) {
			// Create the necessary access
			newTemplateAccess = new X_AD_ImportTemplateAccess(valueObject.getContext(), 0, valueObject.getTransactionName());
			newTemplateAccess.setAD_ImportTemplate_ID(importTemplateId);
			newTemplateAccess.setAD_Role_ID(Env.getAD_Role_ID(Env.getCtx()));
			newTemplateAccess.setIsAllowInsert(true);
			newTemplateAccess.saveEx();
		}
		
		commitEx();
		
		// Count the number of business partners before the import
		int numberOfBusinessPartnersBeforeImport =
				new Query(valueObject.getContext(), MBPartner_BH.Table_Name, null, valueObject.getTransactionName()).count();
		
		valueObject.setStepName("Run CSV Import");
		valueObject.setProcessUuid("95ee94ea-d050-4f20-b4f3-1b6776df6d62");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(List.of(
				new ProcessInfoParameter("AD_ImportTemplate_ID", importTemplateId, null, null, null),
				new ProcessInfoParameter("FileName", BUSINESS_PARTNER_IMPORT_CSV_FILENAME, null, null, null),
				new ProcessInfoParameter("ImportMode", "I", null, null, null)
		));

		ChuBoeCreateEntity.runProcess(valueObject);
		assertThat("Process ran successfully", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));
		commitEx();

		// Count the number of business partners after the import
		int numberOfBusinessPartnersAfterImport =
				new Query(valueObject.getContext(), MBPartner_BH.Table_Name, null, valueObject.getTransactionName()).count();
		assertEquals(numberOfBusinessPartnersBeforeImport + 1, numberOfBusinessPartnersAfterImport, 
				"Business Partner was imported");

		// Remove import template and/or access if it was newly created
		if (newTemplateAccess != null) {
			newTemplateAccess.deleteEx(true);
		}
		if (newImportTemplate != null) {
			newImportTemplate.deleteEx(true);
		}
		commitEx();
    }
}
