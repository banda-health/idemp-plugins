package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHAllergyReaction extends X_BH_Allergy_Reaction {
	public MBHAllergyReaction(Properties ctx, int BH_Allergy_Reaction_ID, String trxName) {
		super(ctx, BH_Allergy_Reaction_ID, trxName);
	}

	public MBHAllergyReaction(Properties ctx, int BH_Allergy_Reaction_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Allergy_Reaction_ID, trxName, virtualColumns);
	}

	public MBHAllergyReaction(Properties ctx, String BH_Allergy_Reaction_UU, String trxName) {
		super(ctx, BH_Allergy_Reaction_UU, trxName);
	}

	public MBHAllergyReaction(Properties ctx, String BH_Allergy_Reaction_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Allergy_Reaction_UU, trxName, virtualColumns);
	}

	public MBHAllergyReaction(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
