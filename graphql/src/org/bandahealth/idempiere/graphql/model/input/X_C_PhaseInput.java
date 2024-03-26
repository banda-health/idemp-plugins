package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectType;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PhaseInput extends MProjectTypePhase implements I_C_PhaseInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ProjectType;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Phase_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PhaseInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Phase_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (C_ProjectType != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectType", "C_ProjectType_UU=?", get_TrxName())
							.setParameters(C_ProjectType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ProjectType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectType with UUID " + C_ProjectType.getUUID());
			}
		} else {
			this.setC_ProjectType_ID(0);
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
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
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
}
