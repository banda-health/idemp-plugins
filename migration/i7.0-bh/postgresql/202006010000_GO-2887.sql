/**********************************************************************************************************************
	There are a few problems this script tries to fix for upgrading our iDempiere 7.1 to 11:
    1.  iDempiere's function to alter columns in 7.1 didn't account for views. So, we'll update it to match what's in
        version 11.
    2.  We had previously inserted a new menu in the iDempiere system range, which leads to problems. So move it out.
    3.  iDempiere tries to delete duplicate indexes. However, for some unknown reason, constraints are leveraging
        these indexes instead of the duplicates (that we want to keep). So, force the constraints to use the correct
        indexes, then re-add the duplicates (so they can be removed successfully).
    4.  One script changes the value length of ad_sysconfig.value to be shorter than a value stored in there, so
        truncate it.
**********************************************************************************************************************/

-- This is the current state of this function as of iDempiere 11 and is needed for an upgrade script to get to 8.2,
-- so not sure where we went wrong. Anyways, updating this.
CREATE OR REPLACE FUNCTION altercolumn(tablename name, columnname name, datatype name, nullclause character varying,
                                       defaultclause character varying) RETURNS void
	LANGUAGE plpgsql
AS
$$
DECLARE
	command       text;
	viewtext      text[];
	viewname      name[];
	dropviews     name[];
	perms         text[];
	privs         text;
	i             int;
	j             int;
	v             record;
	sqltype       text;
	sqltype_short text;
	typename      name;
	namespace     text;
BEGIN
	namespace := 'adempiere';
	IF datatype IS NOT NULL THEN
		SELECT
			pg_type.typname,
			FORMAT_TYPE(pg_type.oid, pg_attribute.atttypmod)
		INTO typename, sqltype
		FROM
			pg_class,
			pg_attribute,
			pg_type,
			pg_namespace
		WHERE
			relname = LOWER(tablename)
			AND relkind IN ('r', 'p')
			AND pg_class.oid = pg_attribute.attrelid
			AND attname = LOWER(columnname)
			AND atttypid = pg_type.oid
			AND pg_class.relnamespace = pg_namespace.oid
			AND pg_namespace.nspname = namespace;
		sqltype_short := sqltype;
		IF typename = 'numeric' THEN
			sqltype_short := REPLACE(sqltype, ',0', '');
		ELSIF STRPOS(sqltype, 'character varying') = 1 THEN
			sqltype_short := REPLACE(sqltype, 'character varying', 'varchar');
		ELSIF sqltype = 'timestamp without time zone' THEN
			sqltype_short := 'timestamp';
		END IF;
		IF LOWER(datatype) <> sqltype AND LOWER(datatype) <> sqltype_short THEN
			i := 0;
			FOR v IN
				WITH RECURSIVE depv(relname, viewoid, depth) AS (
					SELECT DISTINCT
						a.relname,
						a.oid,
						1
					FROM
						pg_class a,
						pg_depend b,
						pg_depend c,
						pg_class d,
						pg_attribute e,
						pg_namespace
					WHERE
						a.oid = b.refobjid
						AND b.objid = c.objid
						AND b.refobjid <> c.refobjid
						AND c.refobjid = d.oid
						AND d.relname = LOWER(tablename)
						AND d.relkind IN ('r', 'p')
						AND d.oid = e.attrelid
						AND e.attname = LOWER(columnname)
						AND c.refobjsubid = e.attnum
						AND a.relkind = 'v'
						AND a.relnamespace = pg_namespace.oid
						AND pg_namespace.nspname = namespace
					UNION ALL
					SELECT DISTINCT
						dependee.relname,
						dependee.oid,
						depv.depth + 1
					FROM
						pg_depend
							JOIN pg_rewrite
							ON pg_depend.objid = pg_rewrite.oid
							JOIN pg_class AS dependee
							ON pg_rewrite.ev_class = dependee.oid
							JOIN pg_class AS dependent
							ON pg_depend.refobjid = dependent.oid
							JOIN pg_attribute
							ON pg_depend.refobjid = pg_attribute.attrelid AND pg_depend.refobjsubid = pg_attribute.attnum AND
							   pg_attribute.attnum > 0
							JOIN depv
							ON dependent.relname = depv.relname
				)
				SELECT
					relname,
					viewoid,
					MAX(depth)
				FROM
					depv
				GROUP BY relname, viewoid
				ORDER BY 3 DESC
				LOOP
					RAISE NOTICE 'view -> % %', v.relname, v.viewoid;
					i := i + 1;
					viewtext[i] := PG_GET_VIEWDEF(v.viewoid);
					viewname[i] := v.relname;
				END LOOP;
			IF i > 0 THEN
				BEGIN
					FOR j IN 1 .. i
						LOOP
							SELECT
								STRING_AGG('grant ' || privilege_type || ' on ' || viewname[j] || ' to "' || grantee || '"', '; ')
							INTO privs
							FROM
								information_schema.role_table_grants
							WHERE
								table_name = viewname[j];
							perms[j] := privs;
							command := 'drop view ' || viewname[j];
							RAISE NOTICE 'executing -> %', command;
							EXECUTE command;
							dropviews[j] := viewname[j];
						END LOOP;
				EXCEPTION
					WHEN OTHERS THEN
						i := ARRAY_UPPER(dropviews, 1);
						IF i > 0 THEN
							FOR j IN REVERSE i .. 1
								LOOP
									command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
									RAISE NOTICE 'executing -> %', 'create or replace view ' || dropviews[j] || '...';
									EXECUTE command;
								END LOOP;
						END IF;
						RAISE EXCEPTION 'Failed to recreate dependent view. SQLERRM=%', SQLERRM;
				END;
			END IF;
			command :=
				'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' type ' || LOWER(datatype);
			RAISE NOTICE 'executing -> %', command;
			EXECUTE command;
			i := ARRAY_UPPER(dropviews, 1);
			IF i > 0 THEN
				FOR j IN REVERSE i .. 1
					LOOP
						command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
						RAISE NOTICE 'executing -> %', 'create or replace view ' || dropviews[j] || '...';
						EXECUTE command;
						command := perms[j];
						RAISE NOTICE 'executing -> %', command;
						EXECUTE command;
					END LOOP;
			END IF;
		END IF;
	END IF;

	IF defaultclause IS NOT NULL THEN
		IF LOWER(defaultclause) = 'null' THEN
			command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' drop default ';
		ELSE
			IF defaultclause ~ '.*[(].*[)].*' OR LOWER(defaultclause) = 'current_timestamp' THEN
				command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' set default ' ||
				           defaultclause;
			ELSE
				command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' set default ''' ||
				           defaultclause || '''';
			END IF;
		END IF;
		RAISE NOTICE 'executing -> %', command;
		EXECUTE command;
	END IF;

	IF nullclause IS NOT NULL THEN
		IF LOWER(nullclause) = 'not null' THEN
			command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' set not null';
			RAISE NOTICE 'executing -> %', command;
			EXECUTE command;
		ELSIF LOWER(nullclause) = 'null' THEN
			command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' drop not null';
			RAISE NOTICE 'executing -> %', command;
			EXECUTE command;
		END IF;
	END IF;
END;
$$;

-- Change a menu ID we added where the menu ID was in the system range
SELECT
	bh_execute_statement_without_indexes($$
UPDATE ad_menu
SET
	ad_menu_id = (
		SELECT
			MAX(ad_menu_id) + 1
		FROM
			ad_menu
	)
WHERE
	ad_menu_id = 200174;
UPDATE ad_menu_trl
SET
	ad_menu_id = (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '6491bbbc-8bb1-47d5-9019-622f38b51be7'
	)
WHERE
	ad_menu_id = 200174;
UPDATE ad_package_exp_detail
SET
	ad_menu_id = (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '6491bbbc-8bb1-47d5-9019-622f38b51be7'
	)
WHERE
	ad_menu_id = 200174;
$$, 'ad_menu_id');

-- For 202203071656_IDEMPIERE-5220.sql, we need to make sure the foreign keys don't depend on a duplicate constraint
-- Start with ad_fieldgroup_key
ALTER TABLE ad_fieldgroup_trl
	DROP CONSTRAINT IF EXISTS adfieldgroup_trl;
ALTER TABLE ad_userdef_field
	DROP CONSTRAINT IF EXISTS adfieldgroup_aduserdeffield;
ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS adfieldgroup_adprocesspara;
ALTER TABLE ad_userdef_proc_parameter
	DROP CONSTRAINT IF EXISTS adfieldgroup_aduserdefprocpara;
ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS adfieldgroup_adfield;
ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_fieldgroup_id_fkey;
DROP INDEX IF EXISTS ad_fieldgroup_key;

-- Next is c_channel_key
ALTER TABLE c_campaign
	DROP CONSTRAINT IF EXISTS cchannel_ccampaign;
ALTER TABLE c_campaign
	DROP CONSTRAINT IF EXISTS c_campaign_c_channel_id_fkey;
DROP INDEX IF EXISTS c_channel_key;

-- Next is c_invoice_key
ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS cinvoice_cinvoiceline;
ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS reversal_cinvoice;
ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS relatedinvoice_cinvoice;
ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cinvoice_ref;
ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS cinvoice_minout;
ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS cinvoice_cinvoicetax;
ALTER TABLE c_cashline
	DROP CONSTRAINT IF EXISTS cinvoice_ccashline;
ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cinvoice_cpayment;
ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS cinvoice_callocationline;
ALTER TABLE r_request
	DROP CONSTRAINT IF EXISTS rinvoice_rrequest;
ALTER TABLE r_request
	DROP CONSTRAINT IF EXISTS cinvoicerequest_rrequest;
ALTER TABLE c_bankstatementline
	DROP CONSTRAINT IF EXISTS cinvoice_cbankstatementline;
ALTER TABLE r_requestaction
	DROP CONSTRAINT IF EXISTS cinvoice_rrequestaction;
ALTER TABLE c_invoicepayschedule
	DROP CONSTRAINT IF EXISTS cinvoice_cinvoicepaysched;
ALTER TABLE c_recurring
	DROP CONSTRAINT IF EXISTS cinvoice_crecurring;
ALTER TABLE c_payselectionline
	DROP CONSTRAINT IF EXISTS cinvoice_cpayselectline;
ALTER TABLE m_inoutconfirm
	DROP CONSTRAINT IF EXISTS cinvoice_minoutconfirm;
ALTER TABLE a_asset_addition
	DROP CONSTRAINT IF EXISTS cinvoice_aassetaddition;
ALTER TABLE a_asset_disposed
	DROP CONSTRAINT IF EXISTS cinvoice_aassetdisposed;
ALTER TABLE c_dunningrunline
	DROP CONSTRAINT IF EXISTS cinvoice_cdunningrunline;
ALTER TABLE c_invoicebatchline
	DROP CONSTRAINT IF EXISTS cinvoice_cinvoicebatchline;
ALTER TABLE c_paymentallocate
	DROP CONSTRAINT IF EXISTS cinvoice_cpaymentallocate;
ALTER TABLE c_paymenttransaction
	DROP CONSTRAINT IF EXISTS cinvoice_cpaymenttransaction;
ALTER TABLE c_recurring_run
	DROP CONSTRAINT IF EXISTS cinvoice_crecurringrun;
ALTER TABLE c_taxdeclarationline
	DROP CONSTRAINT IF EXISTS cinvoice_ctaxdeclline;
ALTER TABLE dd_order
	DROP CONSTRAINT IF EXISTS cinvoice_ddorder;
ALTER TABLE i_bankstatement
	DROP CONSTRAINT IF EXISTS cinvoice_ibankstatement;
ALTER TABLE i_payment
	DROP CONSTRAINT IF EXISTS cinvoice_ipayment;
ALTER TABLE i_invoice
	DROP CONSTRAINT IF EXISTS cinvoice_iinvoice;
ALTER TABLE m_shippingtransaction
	DROP CONSTRAINT IF EXISTS cinvoice_mshippingtransaction;
ALTER TABLE t_invoicegl
	DROP CONSTRAINT IF EXISTS cinvoice_tinvoicegl;
ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_ref_invoice_id_fkey;
ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_relatedinvoice_id_fkey;
ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_reversal_id_fkey;
ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_invoice_id_fkey;
ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_invoice_id_fkey;
ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_invoice_id_fkey;
ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS c_allocationline_c_invoice_id_fkey;
ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS c_invoicetax_c_invoice_id_fkey;
DROP INDEX IF EXISTS c_invoice_key;

ALTER TABLE ad_fieldgroup_trl
	ADD CONSTRAINT adfieldgroup_trl
		FOREIGN KEY (ad_fieldgroup_id) REFERENCES ad_fieldgroup
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	ADD CONSTRAINT adfieldgroup_adfield
		FOREIGN KEY (ad_fieldgroup_id) REFERENCES ad_fieldgroup
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_campaign
	ADD CONSTRAINT cchannel_ccampaign
		FOREIGN KEY (c_channel_id) REFERENCES c_channel
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	ADD CONSTRAINT cinvoice_cinvoiceline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	ADD CONSTRAINT reversal_cinvoice
		FOREIGN KEY (reversal_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	ADD CONSTRAINT relatedinvoice_cinvoice
		FOREIGN KEY (relatedinvoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	ADD CONSTRAINT cinvoice_ref
		FOREIGN KEY (ref_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	ADD CONSTRAINT cinvoice_minout
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoicetax
	ADD CONSTRAINT cinvoice_cinvoicetax
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cashline
	ADD CONSTRAINT cinvoice_ccashline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	ADD CONSTRAINT cinvoice_cpayment
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationline
	ADD CONSTRAINT cinvoice_callocationline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE r_request
	ADD CONSTRAINT rinvoice_rrequest
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE r_request
	ADD CONSTRAINT cinvoicerequest_rrequest
		FOREIGN KEY (c_invoicerequest_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankstatementline
	ADD CONSTRAINT cinvoice_cbankstatementline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE r_requestaction
	ADD CONSTRAINT cinvoice_rrequestaction
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoicepayschedule
	ADD CONSTRAINT cinvoice_cinvoicepaysched
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_recurring
	ADD CONSTRAINT cinvoice_crecurring
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payselectionline
	ADD CONSTRAINT cinvoice_cpayselectline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutconfirm
	ADD CONSTRAINT cinvoice_minoutconfirm
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE a_asset_addition
	ADD CONSTRAINT cinvoice_aassetaddition
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE a_asset_disposed
	ADD CONSTRAINT cinvoice_aassetdisposed
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_dunningrunline
	ADD CONSTRAINT cinvoice_cdunningrunline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoicebatchline
	ADD CONSTRAINT cinvoice_cinvoicebatchline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_paymentallocate
	ADD CONSTRAINT cinvoice_cpaymentallocate
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_paymenttransaction
	ADD CONSTRAINT cinvoice_cpaymenttransaction
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_recurring_run
	ADD CONSTRAINT cinvoice_crecurringrun
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_taxdeclarationline
	ADD CONSTRAINT cinvoice_ctaxdeclline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE dd_order
	ADD CONSTRAINT cinvoice_ddorder
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_bankstatement
	ADD CONSTRAINT cinvoice_ibankstatement
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_payment
	ADD CONSTRAINT cinvoice_ipayment
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_invoice
	ADD CONSTRAINT cinvoice_iinvoice
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_shippingtransaction
	ADD CONSTRAINT cinvoice_mshippingtransaction
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE t_invoicegl
	ADD CONSTRAINT cinvoice_tinvoicegl
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

-- Now re-add the duplicate index to be deleted in the migration file
CREATE UNIQUE INDEX IF NOT EXISTS ad_fieldgroup_key
	ON ad_fieldgroup (ad_fieldgroup_id);
CREATE UNIQUE INDEX IF NOT EXISTS c_channel_key
	ON c_channel (c_channel_id);
CREATE UNIQUE INDEX IF NOT EXISTS c_invoice_key
	ON c_invoice (c_invoice_id);

-- Next is c_tax_key
ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS ctax_corderline;
ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS ctax_cinvoiceline;
ALTER TABLE c_tax_trl
	DROP CONSTRAINT IF EXISTS ctax_ctaxtrl;
ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS ctax_parent;
ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS ctax_cinvoicetax;
ALTER TABLE c_ordertax
	DROP CONSTRAINT IF EXISTS ctax_cordertax;
ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS ctax_ctaxacct;
ALTER TABLE m_rmaline
	DROP CONSTRAINT IF EXISTS ctax_mrmaline;
ALTER TABLE c_invoicebatchline
	DROP CONSTRAINT IF EXISTS ctax_cinvoicebatchline;
ALTER TABLE c_taxpostal
	DROP CONSTRAINT IF EXISTS ctax_ctaxpostal;
ALTER TABLE c_taxdeclarationline
	DROP CONSTRAINT IF EXISTS ctax_ctaxdeclline;
ALTER TABLE c_taxdefinition
	DROP CONSTRAINT IF EXISTS ctax_ctaxdefinition;
ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS ctax_factacct;
ALTER TABLE i_invoice
	DROP CONSTRAINT IF EXISTS ctax_iinvoice;
ALTER TABLE i_order
	DROP CONSTRAINT IF EXISTS ctax_iorder;
ALTER TABLE m_rmatax
	DROP CONSTRAINT IF EXISTS ctax_mrmatax;
ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_tax_id_fkey;
ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS c_invoicetax_c_tax_id_fkey;
ALTER TABLE c_ordertax
	DROP CONSTRAINT IF EXISTS c_ordertax_c_tax_id_fkey;
ALTER TABLE c_tax_trl
	DROP CONSTRAINT IF EXISTS c_tax_trl_c_tax_id_fkey;
ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS c_tax_acct_c_tax_id_fkey;
ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_parent_tax_id_fkey;
ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_tax_id_fkey;
ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_tax_id_fkey;
DROP INDEX IF EXISTS c_tax_key;

ALTER TABLE c_orderline
	ADD CONSTRAINT ctax_corderline
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	ADD CONSTRAINT ctax_cinvoiceline
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_trl
	ADD CONSTRAINT ctax_ctaxtrl
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	ADD CONSTRAINT ctax_parent
		FOREIGN KEY (parent_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoicetax
	ADD CONSTRAINT ctax_cinvoicetax
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_ordertax
	ADD CONSTRAINT ctax_cordertax
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_acct
	ADD CONSTRAINT ctax_ctaxacct
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_rmaline
	ADD CONSTRAINT ctax_mrmaline
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoicebatchline
	ADD CONSTRAINT ctax_cinvoicebatchline
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_taxpostal
	ADD CONSTRAINT ctax_ctaxpostal
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_taxdeclarationline
	ADD CONSTRAINT ctax_ctaxdeclline
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_taxdefinition
	ADD CONSTRAINT ctax_ctaxdefinition
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	ADD CONSTRAINT ctax_factacct
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_invoice
	ADD CONSTRAINT ctax_iinvoice
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_order
	ADD CONSTRAINT ctax_iorder
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_rmatax
	ADD CONSTRAINT ctax_mrmatax
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

CREATE UNIQUE INDEX IF NOT EXISTS c_tax_key
	ON c_tax (c_tax_id);

-- Next is c_paymentprocessor_key
ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cpaymentprocessor_cpayment;
ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_paymentprocessor_id_fkey;
ALTER TABLE c_bankaccount_processor
	DROP CONSTRAINT IF EXISTS cpaymentprocessor_cbankaccount;
ALTER TABLE c_bp_bankaccount
	DROP CONSTRAINT IF EXISTS cpaymentprocessor_cbpbankaccou;
ALTER TABLE c_paymentbatch
	DROP CONSTRAINT IF EXISTS cpaymtprocessor_cpaymtbatch;
ALTER TABLE c_paymenttransaction
	DROP CONSTRAINT IF EXISTS cpaymentprocessor_cpaymenttran;
DROP INDEX IF EXISTS c_paymentprocessor_key;

ALTER TABLE c_payment
	ADD CONSTRAINT cpaymentprocessor_cpayment
		FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	ADD CONSTRAINT c_payment_c_paymentprocessor_id_fkey
		FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_processor
	ADD CONSTRAINT cpaymentprocessor_cbankaccount
		FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_bankaccount
	ADD CONSTRAINT cpaymentprocessor_cbpbankaccou
		FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_paymentbatch
	ADD CONSTRAINT cpaymtprocessor_cpaymtbatch
		FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_paymenttransaction
	ADD CONSTRAINT cpaymentprocessor_cpaymenttran
		FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor
			DEFERRABLE INITIALLY DEFERRED;

CREATE UNIQUE INDEX IF NOT EXISTS c_paymentprocessor_key
	ON c_paymentprocessor (c_paymentprocessor_id);

-- Next is c_revenuerecognition_key
ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS crevrecognition_mproduct;
ALTER TABLE c_revenuerecog_service
	DROP CONSTRAINT IF EXISTS crevenuerecognition_crevenuere;
ALTER TABLE c_revenuerecognition_plan
	DROP CONSTRAINT IF EXISTS crevenuerecognition_plan;
ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_c_revenuerecognition_id_fkey;
DROP INDEX IF EXISTS c_revenuerecognition_key;

ALTER TABLE m_product
	ADD CONSTRAINT crevrecognition_mproduct
		FOREIGN KEY (c_revenuerecognition_id) REFERENCES c_revenuerecognition
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_revenuerecog_service
	ADD CONSTRAINT crevenuerecognition_crevenuere
		FOREIGN KEY (c_revenuerecognition_id) REFERENCES c_revenuerecognition
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_revenuerecognition_plan
	ADD CONSTRAINT crevenuerecognition_plan
		FOREIGN KEY (c_revenuerecognition_id) REFERENCES c_revenuerecognition
			DEFERRABLE INITIALLY DEFERRED;

CREATE UNIQUE INDEX IF NOT EXISTS c_revenuerecognition_key
	ON c_revenuerecognition (c_revenuerecognition_id);

-- Next is gl_journalline_key
ALTER TABLE i_gljournal
	DROP CONSTRAINT IF EXISTS gljourbelline_igljournal;
ALTER TABLE i_fajournal
	DROP CONSTRAINT IF EXISTS gljournalline_ifajournal;
DROP INDEX IF EXISTS gl_journalline_key;

ALTER TABLE i_gljournal
	ADD CONSTRAINT gljourbelline_igljournal
		FOREIGN KEY (gl_journalline_id) REFERENCES gl_journalline
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_fajournal
	ADD CONSTRAINT gljournalline_ifajournal
		FOREIGN KEY (gl_journalline_id) REFERENCES gl_journalline
			DEFERRABLE INITIALLY DEFERRED;

CREATE UNIQUE INDEX IF NOT EXISTS gl_journalline_key
	ON gl_journalline (gl_journalline_id);

-- Last is m_productionline_key
ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS mproductionline_mtransaction;
ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS mproductionline_mcostdetail;
ALTER TABLE m_productionlinema
	DROP CONSTRAINT IF EXISTS mproductionline_mplinema;
ALTER TABLE m_transactionallocation
	DROP CONSTRAINT IF EXISTS mproductionline_mtrxalloc;
ALTER TABLE m_transactionallocation
	DROP CONSTRAINT IF EXISTS mproductionlineout_mtrxalloc;
ALTER TABLE t_transaction
	DROP CONSTRAINT IF EXISTS mproductionline_ttransaction;
ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_m_productionline_id_fkey;
ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_m_productionline_id_fkey;
DROP INDEX IF EXISTS m_productionline_key;

ALTER TABLE m_transaction
	ADD CONSTRAINT mproductionline_mtransaction
		FOREIGN KEY (m_productionline_id) REFERENCES m_productionline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	ADD CONSTRAINT mproductionline_mcostdetail
		FOREIGN KEY (m_productionline_id) REFERENCES m_productionline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_productionlinema
	ADD CONSTRAINT mproductionline_mplinema
		FOREIGN KEY (m_productionline_id) REFERENCES m_productionline
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transactionallocation
	ADD CONSTRAINT mproductionline_mtrxalloc
		FOREIGN KEY (m_productionline_id) REFERENCES m_productionline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transactionallocation
	ADD CONSTRAINT mproductionlineout_mtrxalloc
		FOREIGN KEY (out_m_productionline_id) REFERENCES m_productionline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE t_transaction
	ADD CONSTRAINT mproductionline_ttransaction
		FOREIGN KEY (m_productionline_id) REFERENCES m_productionline
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

CREATE UNIQUE INDEX IF NOT EXISTS m_productionline_key
	ON m_productionline (m_productionline_id);

-- Fix for 202012181642_IDEMPIERE-1575.sql trying to change the field limit, so remove our excess
UPDATE ad_sysconfig
SET
	value = ''
WHERE
	ad_sysconfig_uu = '552493d0-c725-4dd0-bbb0-52d5e07deb91';

-- Fix 202209131507_IDEMPIERE-3340.sql where it tries to remove a constraint that isn't in PROD for some reason...
ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS aduser_aduserpreference;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT aduser_aduserpreference
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

-- Fix 202306211841_IDEMPIERE-5747.sql where it tries to remove some constraints that aren't in PROD for some reason...
ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS linkorderline_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT linkorderline_corderline
		FOREIGN KEY (link_orderline_id) REFERENCES c_orderline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS linkorder_corder;
ALTER TABLE c_order
	ADD CONSTRAINT linkorder_corder
		FOREIGN KEY (link_order_id) REFERENCES c_order
			DEFERRABLE INITIALLY DEFERRED;

-- We only want to do this if a particular script hasn't been run in the DB
DO
$$
	BEGIN
		IF NOT EXISTS(
			SELECT * FROM ad_migrationscript WHERE name ILIKE '201602161510_IDEMPIERE-2955.sql'
		) THEN
			ALTER TABLE M_AttributeSet
				DROP COLUMN IF EXISTS M_AttributeSet_Type;
		END IF;

		IF NOT EXISTS(
			SELECT * FROM ad_migrationscript WHERE name ILIKE '201602171713_IDEMPIERE-2999.sql'
		) THEN
			ALTER TABLE m_attribute
				DROP COLUMN IF EXISTS ad_reference_id;
			ALTER TABLE m_attribute
				DROP COLUMN IF EXISTS ad_reference_value_id;
			ALTER TABLE m_attribute
				DROP COLUMN IF EXISTS ad_val_rule_id;
		END IF;

		IF NOT EXISTS(
			SELECT * FROM ad_migrationscript WHERE name ILIKE '201809141624_IDEMPIERE-1604.sql'
		) THEN
			ALTER TABLE ad_userdef_tab
				DROP COLUMN IF EXISTS whereclause;
			ALTER TABLE ad_userdef_tab
				DROP COLUMN IF EXISTS orderbyclause;
			ALTER TABLE ad_userdef_tab
				DROP COLUMN IF EXISTS seqno;
			ALTER TABLE ad_userdef_tab
				DROP COLUMN IF EXISTS ad_process_id;
			ALTER TABLE ad_userdef_tab
				DROP COLUMN IF EXISTS displaylogic;
		END IF;

		IF NOT EXISTS(
			SELECT * FROM ad_migrationscript WHERE name ILIKE '201912301730_IDEMPIERE-4066.sql'
		) THEN
			ALTER TABLE pa_reportcolumn
				DROP COLUMN IF EXISTS relativeperiodto;
		END IF;

		IF NOT EXISTS(
			SELECT * FROM ad_migrationscript WHERE name ILIKE '201912301800_IDEMPIERE-4067.sql'
		) THEN
			ALTER TABLE pa_reportline
				DROP COLUMN IF EXISTS overlinestroketype;
			ALTER TABLE pa_reportline
				DROP COLUMN IF EXISTS underlinestroketype;
		END IF;

		IF NOT EXISTS(
			SELECT * FROM ad_migrationscript WHERE name ILIKE '202007211900_IDEMPIERE-4083.sql'
		) THEN
			ALTER TABLE c_payment
				DROP COLUMN IF EXISTS isoverridecurrencyrate;
		END IF;

		IF NOT EXISTS(
			SELECT * FROM ad_migrationscript WHERE name ILIKE '202007212000_IDEMPIERE-4083.sql'
		) THEN
			ALTER TABLE c_invoice
				DROP COLUMN IF EXISTS isoverridecurrencyrate;
			ALTER TABLE c_invoice
				DROP COLUMN IF EXISTS currencyrate;
		END IF;
	END
$$;

SELECT
	register_migration_script('202006010000_GO-2887.sql')
FROM
	dual;
