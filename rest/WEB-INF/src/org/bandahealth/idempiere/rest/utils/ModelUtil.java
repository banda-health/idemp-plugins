package org.bandahealth.idempiere.rest.utils;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.util.ProcessUtil;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.bandahealth.idempiere.rest.exceptions.DocumentProcessException;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.compiere.model.MProcess;
import org.compiere.model.PO;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfo;
import org.compiere.util.Env;

import java.util.List;

/**
 * A utility class to work with iDempiere models
 */
public class ModelUtil {
	/**
	 * A simplified method to set a property on an entity if it's present on another entity, typically an input model
	 *
	 * @param propertyValue  The property value to set, if it's not null
	 * @param propertySetter The setter method on the entity, if the property is present
	 * @param <T>            The type of the property
	 */
	public static <T> void setPropertyIfPresent(T propertyValue, VoidFunction<T> propertySetter) {
		if (propertyValue == null) {
			return;
		}
		if (propertyValue instanceof String) {
			if (!StringUtil.isNullOrEmpty(propertyValue.toString())) {
				propertySetter.apply(propertyValue);
			}
		} else if (propertyValue instanceof List<?>) {
			if (!((List<?>) propertyValue).isEmpty()) {
				propertySetter.apply(propertyValue);
			}
		} else {
			propertySetter.apply(propertyValue);
		}
	}

	/**
	 * Since processing a document can either fail or throw an error, capture both paths in a single method. An error
	 * will be thrown if the processing is unsuccessful.
	 *
	 * @param documentProcessId The process to run to process the document through a workflow
	 * @param document          The document to process
	 * @param processAction     Which action to take on the document
	 */
	public static <T extends PO & DocAction> void processDocumentOrError(int documentProcessId, T document,
			String processAction) {
		MProcess documentProcess = MProcess.get(Env.getCtx(), documentProcessId);
		ProcessInfo processInformation =
				new ProcessInfo("Process Document", documentProcess.get_ID(), documentProcess.get_Table_ID(),
						document.get_ID());
		processInformation.setTransactionName(document.get_TrxName());
		try {
			document.set_ValueOfColumn("DocAction", processAction);
			document.saveEx();
			// Check if the new feature is enabled for this client
			if (MSysConfig_BH.getValue(MSysConfig_BH.NEW_FEATURE_ROLLOUT_ALLOW_FOR_CLIENTS)
					.contains(MClient_BH.get(Env.getCtx(), Env.getAD_Client_ID(Env.getCtx())).getAD_Client_UU())) {
				ProcessUtil.startWorkFlow(Env.getCtx(), processInformation, documentProcess.getAD_Workflow_ID());
				if (processInformation.isError()) {
					throw new AdempiereException(processInformation.getSummary());
				}
			} else {
				if (!document.processIt(processAction)) {
					throw new AdempiereException(document.getProcessMsg());
				}
			}
			document.saveEx();
		} catch (AdempiereException exception) {
			document.save();
			throw new DocumentProcessException(exception.getLocalizedMessage());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
