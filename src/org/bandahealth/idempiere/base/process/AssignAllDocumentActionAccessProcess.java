package org.bandahealth.idempiere.base.process;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHDefaultDocActionAccess;
import org.bandahealth.idempiere.base.model.MBandaSetup;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MClient;
import org.compiere.model.MDocType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MRole;
import org.compiere.model.MUserRoles;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class AssignAllDocumentActionAccessProcess extends SvrProcess {
	public static final String PARAMETERNAME_AD_REF_LIST_ID = "ad_ref_list_id";

	private int referenceListId;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] parameters = getParameter();
		for (ProcessInfoParameter parameter : parameters) {

			String parameterName = parameter.getParameterName();

			if (parameterName.equalsIgnoreCase(PARAMETERNAME_AD_REF_LIST_ID)) {
				referenceListId = parameter.getParameterAsInt();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}

	}

	@Override
	protected String doIt() throws Exception {
		MRefList userTypeRefList =
				new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_ID + "=?", get_TrxName())
						.setParameters(referenceListId).first();
		String dbUserTypeValue = userTypeRefList.getValue();

		// Get a list of all document types (that aren't the **New** one)
		List<MDocType> documentTypes =
				new Query(getCtx(), MDocType.Table_Name, MDocType.COLUMNNAME_C_DocType_ID + ">0", get_TrxName()).setClient_ID()
						.list();

		// Get a list of the right reference lists
		List<MRefList> documentActions =
				new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Reference_ID + "=?", get_TrxName())
						.setParameters(MReference_BH.DOCUMENT_ACTION_AD_REFERENCE_ID).list();

		// Do a cross join on our lists to get what all doc action access should be
		List<Integer[]> docActionAccess = new ArrayList<>();
		documentTypes.forEach(documentType -> documentActions.forEach(documentAction -> {
			docActionAccess.add(new Integer[]{documentType.getC_DocType_ID(), documentAction.getAD_Ref_List_ID()});
		}));

		// Get the currently assigned access
		List<MBHDefaultDocActionAccess> currentDefaultAccess = new Query(getCtx(), MBHDefaultDocActionAccess.Table_Name,
				MBHDefaultDocActionAccess.COLUMNNAME_DB_UserType + "=?", get_TrxName())
				.setParameters(dbUserTypeValue).list();

		// For each access that isn't already added, add it
		AtomicInteger rowsAdded = new AtomicInteger(0);
		docActionAccess.stream().filter(access -> currentDefaultAccess.stream().noneMatch(
				defaultAccess -> defaultAccess.getC_DocType_ID() == access[0] &&
						defaultAccess.getAD_Ref_List_ID() == access[1])).forEach(accessToAdd -> {
			MBHDefaultDocActionAccess defaultDocActionAccess = new MBHDefaultDocActionAccess(getCtx(), 0, get_TrxName());
			defaultDocActionAccess.setC_DocType_ID(accessToAdd[0]);
			defaultDocActionAccess.setAD_Ref_List_ID(accessToAdd[1]);
			defaultDocActionAccess.setDB_UserType(dbUserTypeValue);

			if (!defaultDocActionAccess.save()) {
				throw new AdempiereException(
						"Unable to add access for docType and docAction: " + accessToAdd[0] + ", " + accessToAdd[1]);
			}
			rowsAdded.incrementAndGet();
		});
		return "Successfully Added " + rowsAdded.get() + " Access Records";
	}
}
