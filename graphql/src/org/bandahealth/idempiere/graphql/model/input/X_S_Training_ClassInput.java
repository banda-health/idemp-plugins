package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_S_Training;
import org.compiere.model.X_S_Training_Class;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for S_Training_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_Training_ClassInput extends X_S_Training_Class implements I_S_Training_ClassInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mS_Training;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The S_Training_Class_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_S_Training_ClassInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (get_ID() != 0) {
			return;
		}
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + M_Product.getUU());
			}
		} else {
			this.setM_Product_ID(0);
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
	@JsonProperty("S_Training_Class_ID")
	public void setS_Training_Class_IDFromJson(int S_Training_Class_ID) {
		if (get_ID() == 0) {
			super.setS_Training_Class_ID(S_Training_Class_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setS_Training_Class_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (S_Training != null) {
			// Since an entity was passed, make sure it's in the DB
			X_S_Training foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "S_Training", "S_Training_UU=?", get_TrxName())
							.setParameters(S_Training.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setS_Training_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_Training with UU " + S_Training.getUU());
			}
		} else {
			this.setS_Training_ID(0);
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
