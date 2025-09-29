-- Add the new column
ALTER TABLE C_Payment
	ADD COLUMN BH_Original_C_Invoice_ID NUMERIC DEFAULT NULL;
ALTER TABLE C_Payment
	ADD CONSTRAINT cinvoiceoriginal_cpayment FOREIGN KEY (BH_Original_C_Invoice_ID) REFERENCES c_invoice (c_invoice_id) DEFERRABLE INITIALLY DEFERRED;

-- Add the new element for the new original invoice column to the payment table
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id) + 1
		 FROM
			 ad_element
	 ), 0, 0, 'Y', '2025-09-25 09:50:40.259000', 100, '2025-09-25 09:50:40.259000', 100, 'BH_Original_C_Invoice_ID', 'U',
	 'Original Invoice ID', 'Original Invoice ID', NULL, NULL, NULL, NULL, NULL, NULL,
	 '7c1b243d-de8b-4fd4-b0b6-4deb3dbd40af', NULL);

-- Now add the new column
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-09-25 09:52:43.072000', '2025-09-25 10:09:15.016000', 100, 100, 'Original Invoice ID', NULL,
	 NULL, 0, 'U', 'BH_Original_C_Invoice_ID', 335, 18, 336, 220, 22, NULL, 'N', 'N', 'N', 'Y',
	 '@C_Order_ID@!0 | @C_Charge_ID@!0', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT MAX(ad_element_id) + 1 FROM ad_element WHERE ad_element_uu = '7c1b243d-de8b-4fd4-b0b6-4deb3dbd40af'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f6653906-ed4d-40ba-82c1-ca12e9df4914', 'Y', 0, 'N', 'N', NULL,
	 'cinvoiceoriginal_cpayment', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Assign access for users for the supplier payment window
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	ad_window_id,
	ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	CASE
		WHEN ad_role_uu IN ('c54253cf-c86b-4aaa-b472-ed8880635c62', '097feff0-3aa6-41fe-bf76-936b03859846',
		                    '17ccea57-1131-4d51-83ca-1824182e4493') THEN 'N'
		ELSE 'Y' END,
	uuid_generate_v4(),
	CASE
		WHEN ad_role_uu IN ('c54253cf-c86b-4aaa-b472-ed8880635c62', '097feff0-3aa6-41fe-bf76-936b03859846',
		                    '17ccea57-1131-4d51-83ca-1824182e4493') THEN 'N'
		ELSE 'Y' END
FROM
	ad_role r
		JOIN ad_window
			ON ad_window_uu = 'be24b4d5-987f-4aa5-ae14-38375b0d6bf2'
WHERE
	r.ad_role_uu IN ('93365778-a2d9-433b-b962-87fb150db4fa', 'ee008abc-2c16-4230-b48c-b1f5577ea270',
	                 '09eb7fc8-9cc5-44b0-9d14-15258a066038', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a',
	                 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e', '461b31c5-cae2-449d-8a0c-7385b12f4685',
	                 'c54253cf-c86b-4aaa-b472-ed8880635c62', 'ec17fee0-a53a-4dbb-b946-423ce14880eb',
	                 '097feff0-3aa6-41fe-bf76-936b03859846', '17ccea57-1131-4d51-83ca-1824182e4493');

DROP FUNCTION IF EXISTS bh_get_vendor_payment_trail(_ad_client_id numeric);
CREATE OR REPLACE FUNCTION bh_get_vendor_payment_trail(_ad_client_id numeric)
	RETURNS table
	        (
		        ad_client_id               numeric,
		        c_invoice_id               numeric,
		        c_bpartner_id              numeric,
		        c_payment_id               numeric,
		        date                       timestamp,
		        created                    timestamp,
		        updated                    timestamp,
		        ordering_date              timestamp,
		        createdby                  numeric,
		        c_order_id                 numeric,
		        charged                    numeric,
		        paid                       numeric,
		        open_balance               numeric,
		        base_reversal_c_invoice_id numeric,
		        base_reversal_c_payment_id numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	ad_client_id,
	c_invoice_id,
	c_bpartner_id,
	c_payment_id,
	DATE,
	created,
	updated,
	ordering_date,
	createdby,
	c_order_id,
	charged,
	paid,
			SUM(net) FILTER ( WHERE docstatus NOT IN ('DR', 'IP') )
		OVER ( PARTITION BY c_bpartner_id ORDER BY CASE
			                                           WHEN docstatus IN ('DR', 'IP')
				                                           THEN '-infinity'::TIMESTAMP
			                                           ELSE ordering_date END ROWS UNBOUNDED PRECEDING) AS open_balance,
	base_reversal_c_invoice_id,
	base_reversal_c_payment_id
FROM
	(
		-- Receive products
		SELECT
			o.ad_client_id,
			i.c_invoice_id,
			o.c_bpartner_id,
			NULL::NUMERIC                                                           AS c_payment_id,
			-- Add time so the starting balance can be first
			o.dateordered::DATE + '1 microsecond'::INTERVAL                         AS date,
			i.created,
			i.updated,
			CASE
				WHEN i.docstatus IN ('CO', 'CL') THEN i.updated
				ELSE i.created END                                                    AS ordering_date,
			i.createdby,
			o.c_order_id,
			i.grandtotal                                                            AS charged,
			COALESCE(SUM(p.payamt), 0)                                              AS paid,
			i.docstatus,
			i.grandtotal - COALESCE(SUM(p.payamt), 0)                               AS net,
			CASE WHEN i.docstatus = 'RE' THEN i.c_invoice_id ELSE NULL::NUMERIC END AS base_reversal_c_invoice_id,
			NULL::NUMERIC                                                           AS base_reversal_c_payment_id
		FROM
			c_order o
				JOIN c_invoice i
					ON i.c_order_id = o.c_order_id AND (i.reversal_id IS NULL OR i.reversal_id > i.c_invoice_id)
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id
		WHERE
			o.ad_client_id = _ad_client_id
			AND o.issotrx = 'N'
			AND o.bh_visit_id IS NULL
		GROUP BY
			o.ad_client_id, i.c_invoice_id, o.c_bpartner_id, o.dateordered::DATE + '1 microsecond'::INTERVAL, i.created,
			i.updated, i.createdby, o.c_order_id, i.grandtotal, i.docstatus
		UNION ALL
		-- Receive products reversions
		SELECT
			o.ad_client_id,
			i_r.c_invoice_id,
			o.c_bpartner_id,
			NULL,
			-- Add time so the starting balance can be first
			o.dateordered::DATE + '1 microsecond'::INTERVAL AS DATE,
			i_r.created,
			i_r.updated,
			i_r.created,
			i_r.createdby,
			o.c_order_id,
			i_r.grandtotal                                  AS charged,
			COALESCE(SUM(p_r.payamt), 0)                    AS paid,
			i_r.docstatus,
			i_r.grandtotal - COALESCE(SUM(p_r.payamt), 0)   AS net,
			i.c_invoice_id,
			NULL
		FROM
			c_order o
				JOIN c_invoice i
					ON i.c_order_id = o.c_order_id AND i.reversal_id > i.c_invoice_id
				JOIN c_invoice i_r
					ON i.reversal_id = i_r.c_invoice_id
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id
				LEFT JOIN c_payment p_r
					ON p.reversal_id = p_r.c_payment_id AND p.reversal_id > p.c_payment_id
		WHERE
			o.ad_client_id = _ad_client_id
			AND i.docstatus = 'RE'
			AND o.issotrx = 'N'
			AND o.bh_visit_id IS NULL
		GROUP BY
			o.ad_client_id, i_r.c_invoice_id, o.c_bpartner_id, o.dateordered, i_r.created, i_r.updated, i_r.createdby,
			o.c_order_id, i_r.grandtotal, i_r.docstatus, i.c_invoice_id
		UNION ALL
		-- Expenses
		SELECT
			i.ad_client_id,
			i.c_invoice_id,
			i.c_bpartner_id,
			NULL,
			-- Add time so the starting balance can be first
			i.dateinvoiced::DATE + '1 microsecond'::INTERVAL,
			i.created,
			i.updated,
			CASE
				WHEN i.docstatus IN ('CO', 'CL') THEN i.updated
				ELSE i.created END                      AS ordering_date,
			i.createdby,
			NULL,
			i.grandtotal,
			COALESCE(SUM(p.payamt), 0),
			i.docstatus,
			i.grandtotal - COALESCE(SUM(p.payamt), 0) AS net,
			CASE WHEN i.docstatus = 'RE' THEN i.c_invoice_id END,
			NULL
		FROM
			c_invoice i
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id
		WHERE
			i.ad_client_id = _ad_client_id
			AND (i.reversal_id IS NULL OR i.reversal_id > i.c_invoice_id)
			AND i.issotrx = 'N'
			AND i.bh_visit_id IS NULL
			AND i.c_order_id IS NULL
		GROUP BY
			i.ad_client_id, i.c_invoice_id, i.c_bpartner_id, i.dateinvoiced, i.created, i.updated, i.createdby, i.grandtotal,
			i.docstatus
		UNION ALL
		-- Expense reversals
		SELECT
			i_r.ad_client_id,
			i_r.c_invoice_id,
			i_r.c_bpartner_id,
			NULL,
			-- Add time so the starting balance can be first
			i_r.dateinvoiced::DATE + '1 microsecond'::INTERVAL,
			i_r.created,
			i_r.updated,
			i_r.created,
			i_r.createdby,
			NULL,
			i_r.grandtotal,
			COALESCE(SUM(p_r.payamt), 0),
			i_r.docstatus,
			i_r.grandtotal - COALESCE(SUM(p_r.payamt), 0) AS net,
			i.c_invoice_id,
			NULL
		FROM
			c_invoice i
				JOIN c_invoice i_r
					ON i.reversal_id = i_r.c_invoice_id AND i.reversal_id > i.c_invoice_id
				LEFT JOIN c_payment p
					ON i.c_invoice_id = p.bh_original_c_invoice_id
				LEFT JOIN c_payment p_r
					ON p.reversal_id = p_r.c_payment_id AND p.reversal_id > p.c_payment_id
		WHERE
			i.ad_client_id = _ad_client_id
			AND i.reversal_id IS NOT NULL
			AND i.reversal_id < i.c_invoice_id
			AND i.issotrx = 'N'
			AND i.bh_visit_id IS NULL
			AND i.c_order_id IS NULL
		GROUP BY
			i_r.ad_client_id, i_r.c_invoice_id, i_r.c_bpartner_id, i_r.dateinvoiced, i_r.created, i_r.updated, i_r.createdby,
			i_r.grandtotal, i_r.docstatus, i_r.grandtotal, i.c_invoice_id
		UNION ALL
		-- Outstanding Open Balances
		SELECT
			ad_client_id,
			NULL,
			c_bpartner_id,
			c_payment_id,
			-- Add time so the starting balance can be first
			datetrx::DATE + '1 microsecond'::INTERVAL,
			created,
			updated,
			CASE
				WHEN docstatus IN ('CO', 'CL') THEN updated
				ELSE created END,
			createdby,
			NULL,
			0,
			payamt,
			docstatus,
			payamt * -1,
			NULL,
			CASE WHEN docstatus = 'RE' THEN c_payment_id ELSE NULL END
		FROM
			c_payment
		WHERE
			ad_client_id = _ad_client_id
			AND (reversal_id IS NULL OR reversal_id > c_payment_id)
			AND isreceipt = 'N'
			AND c_invoice_id IS NULL
			AND bh_visit_id IS NULL
			AND bh_original_c_invoice_id IS NULL
		UNION ALL
		-- Outstanding Open Balance payment reversals
		SELECT
			p_r.ad_client_id,
			NULL,
			p_r.c_bpartner_id,
			p_r.c_payment_id,
			-- Add time so the starting balance can be first
			p_r.datetrx::DATE + '1 microsecond'::INTERVAL,
			p_r.created,
			p_r.updated,
			p_r.created,
			p_r.createdby,
			NULL,
			0,
			p_r.payamt,
			p_r.docstatus,
			p_r.payamt * -1,
			NULL,
			p.c_payment_id
		FROM
			c_payment p
				JOIN c_payment p_r
					ON p_r.c_payment_id = p.reversal_id AND p.reversal_id > p.c_payment_id
		WHERE
			p.ad_client_id = _ad_client_id
			AND p.isreceipt = 'N'
			AND p.c_invoice_id IS NULL
			AND p.bh_visit_id IS NULL
			AND p.bh_original_c_invoice_id IS NULL
		UNION ALL
		-- Get a starting balance
		SELECT
			_ad_client_id,
			NULL,
			bp.c_bpartner_id,
			NULL,
			MIN(LEAST(bp.created, o.dateordered, i.dateinvoiced, p.datetrx)),
			MIN(LEAST(bp.created, o.dateordered, i.dateinvoiced, p.datetrx)),
			MIN(LEAST(bp.created, o.dateordered, i.dateinvoiced, p.datetrx)),
			MIN(LEAST(bp.created, o.dateordered, i.dateinvoiced, p.datetrx)),
			bp.createdby,
			NULL,
			0,
			0,
			NULL,
			0,
			NULL,
			NULL
		FROM
			c_bpartner bp
				LEFT JOIN c_order o
					ON o.c_bpartner_id = bp.c_bpartner_id AND o.issotrx = 'N' AND
					   o.bh_visit_id IS NULL
				LEFT JOIN c_invoice i
					ON bp.c_bpartner_id = i.c_bpartner_id AND i.issotrx = 'N' AND
					   i.bh_visit_id IS NULL
				LEFT JOIN c_payment p
					ON bp.c_bpartner_id = p.c_bpartner_id AND p.isreceipt = 'N' AND
					   p.bh_visit_id IS NULL
		WHERE
			bp.ad_client_id = _ad_client_id
		GROUP BY bp.c_bpartner_id, bp.createdby
	) b
$$;

SELECT
	register_migration_script('202509291177_GO-984.sql')
FROM
	dual;
