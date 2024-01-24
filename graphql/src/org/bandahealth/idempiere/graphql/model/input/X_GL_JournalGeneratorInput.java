package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MElementValue;
import org.compiere.model.MGLCategory;
import org.compiere.model.MJournalGenerator;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for GL_JournalGenerator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalGeneratorInput extends MJournalGenerator implements I_GL_JournalGeneratorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mC_ElementValueAdjustCR;
	private ForeignEntityInput mC_ElementValueAdjustDR;
	private ForeignEntityInput mGL_Category;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_GL_JournalGeneratorInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MJournalGenerator(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			super.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
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
	 * Set Account Adjust CR.
	 *
	 * @param C_ElementValueAdjustCR Account Adjust CR
	 */
	@JsonProperty("C_ElementValueAdjustCR")
	public void setC_ElementValueAdjustCRInput(ForeignEntityInput C_ElementValueAdjustCR) {
		this.mC_ElementValueAdjustCR = C_ElementValueAdjustCR;
		MElementValue foreignEntity;
		if (C_ElementValueAdjustCR != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(C_ElementValueAdjustCR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ElementValueAdjustCR_ID(foreignEntity.get_ID());
		} else {
			super.setC_ElementValueAdjustCR_ID(0);
		}
	}

	/**
	 * Get Account Adjust CR.
	 *
	 * @return Account Adjust CR
	 */
	@JsonProperty("C_ElementValueAdjustCR")
	public ForeignEntityInput C_ElementValueAdjustCR() {
		return mC_ElementValueAdjustCR;
	}

	/**
	 * Set Account Adjust DR.
	 *
	 * @param C_ElementValueAdjustDR Account Adjust DR
	 */
	@JsonProperty("C_ElementValueAdjustDR")
	public void setC_ElementValueAdjustDRInput(ForeignEntityInput C_ElementValueAdjustDR) {
		this.mC_ElementValueAdjustDR = C_ElementValueAdjustDR;
		MElementValue foreignEntity;
		if (C_ElementValueAdjustDR != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(C_ElementValueAdjustDR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ElementValueAdjustDR_ID(foreignEntity.get_ID());
		} else {
			super.setC_ElementValueAdjustDR_ID(0);
		}
	}

	/**
	 * Get Account Adjust DR.
	 *
	 * @return Account Adjust DR
	 */
	@JsonProperty("C_ElementValueAdjustDR")
	public ForeignEntityInput C_ElementValueAdjustDR() {
		return mC_ElementValueAdjustDR;
	}

	/**
	 * Set GL Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	@JsonProperty("GL_Category")
	public void setGL_CategoryInput(ForeignEntityInput GL_Category) {
		this.mGL_Category = GL_Category;
		MGLCategory foreignEntity;
		if (GL_Category != null &&
				(foreignEntity = new Query(getCtx(), "GL_Category", "GL_Category_UU=?", get_TrxName())
						.setParameters(GL_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_Category_ID(foreignEntity.get_ID());
		} else {
			super.setGL_Category_ID(0);
		}
	}

	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	@JsonProperty("GL_Category")
	public ForeignEntityInput GL_Category() {
		return mGL_Category;
	}
	/**
	 * Set GL Journal Generator.
	 *
	 * @param GL_JournalGenerator_ID GL Journal Generator
	 */

	public void setGL_JournalGenerator_ID(int GL_JournalGenerator_ID) {
		if (get_ID() == 0) {
			super.setGL_JournalGenerator_ID(GL_JournalGenerator_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setGL_JournalGenerator_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getGL_JournalGenerator_UU();
	}

	/**
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(I_AD_Ref_ListInput PostingType) {
		this.mPostingType = PostingType;
		MRefList_BH foreignEntity;
		if (PostingType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPostingType(foreignEntity.getValue());
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public I_AD_Ref_ListInput PostingType() {
		return mPostingType;
	}
}
