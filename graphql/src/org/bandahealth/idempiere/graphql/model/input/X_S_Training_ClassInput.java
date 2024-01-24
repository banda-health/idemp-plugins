package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_S_Training;
import org.compiere.model.X_S_Training_Class;

import java.sql.ResultSet;

/**
 * Generated Model for S_Training_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_Training_ClassInput extends X_S_Training_Class implements I_S_Training_ClassInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mS_Training;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_S_Training_ClassInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_S_Training_Class(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 && M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
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
	/**
	 * Set Training Class.
	 *
	 * @param S_Training_Class_ID The actual training class instance
	 */

	public void setS_Training_Class_ID(int S_Training_Class_ID) {
		if (get_ID() == 0) {
			super.setS_Training_Class_ID(S_Training_Class_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setS_Training_Class_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getS_Training_Class_UU();
	}

	/**
	 * Set Training.
	 *
	 * @param S_Training Repeated Training
	 */
	@JsonProperty("S_Training")
	public void setS_TrainingInput(ForeignEntityInput S_Training) {
		this.mS_Training = S_Training;
		X_S_Training foreignEntity;
		if (get_ID() == 0 && S_Training != null &&
				(foreignEntity = new Query(getCtx(), "S_Training", "S_Training_UU=?", get_TrxName())
						.setParameters(S_Training.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setS_Training_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Training.
	 *
	 * @return Repeated Training
	 */
	@JsonProperty("S_Training")
	public ForeignEntityInput S_Training() {
		return mS_Training;
	}
}
