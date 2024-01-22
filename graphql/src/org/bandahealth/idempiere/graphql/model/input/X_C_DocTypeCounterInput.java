package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDocTypeCounter;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_DocTypeCounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DocTypeCounterInput extends MDocTypeCounter implements I_C_DocTypeCounterInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mCounter_C_DocType;
	private I_AD_Ref_ListInput mDocAction;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_DocTypeCounterInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MDocTypeCounter(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}
	/**
	 * Set Counter Document.
	 *
	 * @param C_DocTypeCounter_ID Counter Document Relationship
	 */

	public void setC_DocTypeCounter_ID(int C_DocTypeCounter_ID) {
		if (get_ID() == 0) {
			super.setC_DocTypeCounter_ID(C_DocTypeCounter_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_DocTypeCounter_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_DocTypeCounter_UU();
	}

	/**
	 * Set Counter Document Type.
	 *
	 * @param Counter_C_DocType Generated Counter Document Type (To)
	 */
	@JsonProperty("Counter_C_DocType")
	public void setCounter_C_DocTypeInput(ForeignEntityInput Counter_C_DocType) {
		this.mCounter_C_DocType = Counter_C_DocType;
		MDocType_BH foreignEntity;
		if (Counter_C_DocType != null &&
				(foreignEntity = new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
						.setParameters(Counter_C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCounter_C_DocType_ID(foreignEntity.get_ID());
		} else {
			super.setCounter_C_DocType_ID(0);
		}
	}

	/**
	 * Get Counter Document Type.
	 *
	 * @return Generated Counter Document Type (To)
	 */
	@JsonProperty("Counter_C_DocType")
	public ForeignEntityInput Counter_C_DocType() {
		return mCounter_C_DocType;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		MRefList_BH foreignEntity;
		if (DocAction != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocAction(foreignEntity.getValue());
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public I_AD_Ref_ListInput DocAction() {
		return mDocAction;
	}
}
