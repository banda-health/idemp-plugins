package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectType;
import org.compiere.model.Query;
import org.compiere.model.X_C_Phase;
import org.compiere.util.Env;

/**
 * Generated Model for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PhaseInput extends X_C_Phase implements I_C_PhaseInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_ProjectTypeInput C_ProjectType;
	 private I_M_ProductInput M_Product;

	/**
	 * Standard constructor
	 */
	public X_C_PhaseInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
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
	public void setC_ProjectType(I_C_ProjectTypeInput C_ProjectType) {
		this.C_ProjectType = C_ProjectType;
		MProjectType foreignEntity;
		if (get_ID() == 0 &&C_ProjectType != null &&
				(foreignEntity = new Query(getCtx(), MProjectType.Table_Name, MProjectType.COLUMNNAME_C_ProjectType_UU + "=?", get_TrxName())
						.setParameters(C_ProjectType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ProjectType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Type.
	 *
	 * @return Type of the project
	 */
	public I_C_ProjectTypeInput getC_ProjectType() {
		return C_ProjectType;
	}
	/**
	 * Set Project Type.
	 *
	 * @param C_ProjectType_ID Type of the project
	 */

	public void setC_ProjectType_ID(int C_ProjectType_ID) {
		if (get_ID() == 0) {
			super.setC_ProjectType_ID(C_ProjectType_ID);
		}
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
	}
}
