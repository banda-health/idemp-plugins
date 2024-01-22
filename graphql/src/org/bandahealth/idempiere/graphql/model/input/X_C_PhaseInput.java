package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectType;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PhaseInput extends MProjectTypePhase implements I_C_PhaseInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ProjectType;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_PhaseInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MProjectTypePhase(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Standard Phase.
	 *
	 * @param C_Phase_ID Standard Phase of the Project Type
	 */

	public void setC_Phase_ID(int C_Phase_ID) {
		if (get_ID() == 0) {
			super.setC_Phase_ID(C_Phase_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Phase_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Phase_UU();
	}

	/**
	 * Set Project Type.
	 *
	 * @param C_ProjectType Type of the project
	 */
	@JsonProperty("C_ProjectType")
	public void setC_ProjectTypeInput(ForeignEntityInput C_ProjectType) {
		this.mC_ProjectType = C_ProjectType;
		MProjectType foreignEntity;
		if (get_ID() == 0 && C_ProjectType != null &&
				(foreignEntity = new Query(getCtx(), "C_ProjectType", "C_ProjectType_UU=?", get_TrxName())
						.setParameters(C_ProjectType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Type.
	 *
	 * @return Type of the project
	 */
	@JsonProperty("C_ProjectType")
	public ForeignEntityInput C_ProjectType() {
		return mC_ProjectType;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
}
