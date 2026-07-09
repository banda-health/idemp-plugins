-- GO-3624 Payroll Management: foundations (6 BH tables + HR_Employee extension + dictionary + statutory seed)

-- Employees live in core HR_Employee (hybrid decision 2026-07-09): identity via C_BPartner,
-- national ID in NationalCode, NSSF number in SSCode, deactivation via EndDate + IsActive.
-- Kenya-specific payroll fields are BH_ columns added here (house pattern: C_BPartner has 12).
ALTER TABLE hr_employee
	ADD COLUMN IF NOT EXISTS BH_KRA_PIN            VARCHAR(20)          DEFAULT NULL,
	ADD COLUMN IF NOT EXISTS BH_SHIF_Number        VARCHAR(20)          DEFAULT NULL,
	ADD COLUMN IF NOT EXISTS BH_BankName           VARCHAR(60)          DEFAULT NULL,
	ADD COLUMN IF NOT EXISTS BH_BankBranch         VARCHAR(60)          DEFAULT NULL,
	ADD COLUMN IF NOT EXISTS BH_BankAccount        VARCHAR(34)          DEFAULT NULL,
	ADD COLUMN IF NOT EXISTS BH_BasicSalary        NUMERIC     NOT NULL DEFAULT 0,
	ADD COLUMN IF NOT EXISTS BH_HouseAllowance     NUMERIC     NOT NULL DEFAULT 0,
	ADD COLUMN IF NOT EXISTS BH_TransportAllowance NUMERIC     NOT NULL DEFAULT 0;
-- One payroll profile per business partner per clinic (BH_Employee had this as a table constraint)
CREATE UNIQUE INDEX IF NOT EXISTS BH_HREmployee_BPartner_idx ON hr_employee (AD_Client_ID, C_BPartner_ID);

-- Clinic payroll preferences (slim — component model 2026-07-09). Rates/deductions live in
-- BH_Payroll_Component; this table only carries per-clinic prefs. Payslip header identity
-- (clinic name, employer KRA PIN, location) comes from AD_Org / AD_OrgInfo.TaxID.
CREATE TABLE BH_Payroll_Settings
(
	AD_Client_ID           NUMERIC(10) NOT NULL,
	AD_Org_ID              NUMERIC(10) NOT NULL,
	BH_Payroll_Settings_ID NUMERIC(10) NOT NULL,
	BH_Payroll_Settings_UU VARCHAR(36)                                         DEFAULT NULL,
	Name                   VARCHAR(60)                                         DEFAULT NULL,
	BH_PayDay              NUMERIC(2)                                          DEFAULT NULL,
	Created                TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	CreatedBy              NUMERIC(10) NOT NULL,
	IsActive               CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	Updated                TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	UpdatedBy              NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Payroll_Settings_Key PRIMARY KEY (BH_Payroll_Settings_ID),
	CONSTRAINT BH_Payroll_Settings_UU_idx UNIQUE (BH_Payroll_Settings_UU),
	CONSTRAINT BH_Payroll_Settings_Client_idx UNIQUE (AD_Client_ID)
);
ALTER TABLE BH_Payroll_Settings
	ADD CONSTRAINT ADClient_BHPayrollSettings FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Settings
	ADD CONSTRAINT ADOrg_BHPayrollSettings FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

-- Payroll components: the general deduction/contribution/relief catalogue. AD_Client_ID=0
-- rows are Banda's seeded statutory defaults + voluntary templates; clinic rows override per
-- Value (code) or add clinic-specific components. Effective-dated per code (latest ValidFrom
-- <= period wins; clinic beats System). A new statutory levy is an INSERT here — never DDL.
-- No CHECK enums on category/method (the model layer validates) — a CHECK would be the same
-- rigidity trap the old filing-type CHECK was. BH_FilingDueDay = day of the following month
-- the remittance is due (drives the compliance banner in the Filings UI).
CREATE TABLE BH_Payroll_Component
(
	AD_Client_ID            NUMERIC(10) NOT NULL,
	AD_Org_ID               NUMERIC(10) NOT NULL,
	BH_Payroll_Component_ID NUMERIC(10) NOT NULL,
	BH_Payroll_Component_UU VARCHAR(36)                                         DEFAULT NULL,
	Value                   VARCHAR(40) NOT NULL,
	Name                    VARCHAR(60) NOT NULL,
	BH_Category             VARCHAR(20) NOT NULL,
	BH_CalcMethod           VARCHAR(20) NOT NULL,
	BH_Rate                 NUMERIC                                             DEFAULT NULL,
	BH_Floor                NUMERIC                                             DEFAULT NULL,
	BH_Cap                  NUMERIC                                             DEFAULT NULL,
	BH_Tier1_Limit          NUMERIC                                             DEFAULT NULL,
	BH_Tier2_Limit          NUMERIC                                             DEFAULT NULL,
	BH_EmployerRate         NUMERIC                                             DEFAULT NULL,
	BH_IsTaxDeductible      CHAR(1)     NOT NULL CHECK (BH_IsTaxDeductible IN ('Y', 'N')) DEFAULT 'N',
	BH_TaxDeductibleCap     NUMERIC                                             DEFAULT NULL,
	BH_IsStatutory          CHAR(1)     NOT NULL CHECK (BH_IsStatutory IN ('Y', 'N')) DEFAULT 'N',
	BH_FilingDueDay         NUMERIC(2)                                          DEFAULT NULL,
	SeqNo                   NUMERIC(10) NOT NULL                                DEFAULT 0,
	ValidFrom               TIMESTAMP   NOT NULL,
	Created                 TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	CreatedBy               NUMERIC(10) NOT NULL,
	IsActive                CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	Updated                 TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	UpdatedBy               NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Payroll_Component_Key PRIMARY KEY (BH_Payroll_Component_ID),
	CONSTRAINT BH_Payroll_Component_UU_idx UNIQUE (BH_Payroll_Component_UU),
	CONSTRAINT BH_Payroll_Component_Code_idx UNIQUE (AD_Client_ID, Value, ValidFrom)
);
ALTER TABLE BH_Payroll_Component
	ADD CONSTRAINT ADClient_BHPayrollComponent FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Component
	ADD CONSTRAINT ADOrg_BHPayrollComponent FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

-- Employee component assignments: per-employee amounts for EMPLOYEE_AMOUNT components
-- (Sacco, voluntary pension, loans). ValidTo ends a deduction (e.g. loan paid off).
CREATE TABLE BH_Employee_Component
(
	AD_Client_ID             NUMERIC(10) NOT NULL,
	AD_Org_ID                NUMERIC(10) NOT NULL,
	BH_Employee_Component_ID NUMERIC(10) NOT NULL,
	BH_Employee_Component_UU VARCHAR(36)                                         DEFAULT NULL,
	HR_Employee_ID           NUMERIC(10) NOT NULL,
	BH_Payroll_Component_ID  NUMERIC(10) NOT NULL,
	BH_Amount                NUMERIC     NOT NULL                                DEFAULT 0,
	ValidFrom                TIMESTAMP   NOT NULL,
	ValidTo                  TIMESTAMP                                           DEFAULT NULL,
	Created                  TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	CreatedBy                NUMERIC(10) NOT NULL,
	IsActive                 CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	Updated                  TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	UpdatedBy                NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Employee_Component_Key PRIMARY KEY (BH_Employee_Component_ID),
	CONSTRAINT BH_Employee_Component_UU_idx UNIQUE (BH_Employee_Component_UU),
	CONSTRAINT BH_Employee_Component_idx UNIQUE (HR_Employee_ID, BH_Payroll_Component_ID, ValidFrom)
);
ALTER TABLE BH_Employee_Component
	ADD CONSTRAINT ADClient_BHEmployeeComponent FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Employee_Component
	ADD CONSTRAINT ADOrg_BHEmployeeComponent FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Employee_Component
	ADD CONSTRAINT HREmployee_BHEmployeeComponent FOREIGN KEY (HR_Employee_ID) REFERENCES hr_employee (hr_employee_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Employee_Component
	ADD CONSTRAINT BHPayrollComponent_BHEmployeeComponent FOREIGN KEY (BH_Payroll_Component_ID) REFERENCES bh_payroll_component (bh_payroll_component_id) DEFERRABLE INITIALLY DEFERRED;

-- PAYE bands: children of the PAYE component row so bands version with their regime.
CREATE TABLE BH_PAYE_Band
(
	AD_Client_ID           NUMERIC(10) NOT NULL,
	AD_Org_ID              NUMERIC(10) NOT NULL,
	BH_PAYE_Band_ID        NUMERIC(10) NOT NULL,
	BH_PAYE_Band_UU        VARCHAR(36)                                         DEFAULT NULL,
	BH_Payroll_Component_ID NUMERIC(10) NOT NULL,
	SeqNo                  NUMERIC(10) NOT NULL                                DEFAULT 0,
	BH_UpperLimit          NUMERIC                                             DEFAULT NULL,
	BH_Rate                NUMERIC     NOT NULL                                DEFAULT 0,
	Created                TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	CreatedBy              NUMERIC(10) NOT NULL,
	IsActive               CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	Updated                TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	UpdatedBy              NUMERIC(10) NOT NULL,
	CONSTRAINT BH_PAYE_Band_Key PRIMARY KEY (BH_PAYE_Band_ID),
	CONSTRAINT BH_PAYE_Band_UU_idx UNIQUE (BH_PAYE_Band_UU)
);
ALTER TABLE BH_PAYE_Band
	ADD CONSTRAINT ADClient_BHPAYEBand FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_PAYE_Band
	ADD CONSTRAINT ADOrg_BHPAYEBand FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_PAYE_Band
	ADD CONSTRAINT BHPayrollComponent_BHPAYEBand FOREIGN KEY (BH_Payroll_Component_ID) REFERENCES bh_payroll_component (bh_payroll_component_id) DEFERRABLE INITIALLY DEFERRED;

-- Payroll run: the document. One per clinic per month; DocStatus drives locking (phase 3).
-- BH_Components_Snapshot = JSON of the resolved component list stamped at lock; NULL while drafted.
CREATE TABLE BH_Payroll_Run
(
	AD_Client_ID           NUMERIC(10) NOT NULL,
	AD_Org_ID              NUMERIC(10) NOT NULL,
	BH_Payroll_Run_ID      NUMERIC(10) NOT NULL,
	BH_Payroll_Run_UU      VARCHAR(36)                                          DEFAULT NULL,
	BH_PayrollMonth        NUMERIC(2)  NOT NULL,
	BH_PayrollYear         NUMERIC(4)  NOT NULL,
	BH_PayDate             TIMESTAMP                                            DEFAULT NULL,
	DocStatus              CHAR(2)     NOT NULL                                 DEFAULT 'DR',
	DocAction              CHAR(2)     NOT NULL                                 DEFAULT 'CO',
	Processed              CHAR(1)     NOT NULL CHECK (Processed IN ('Y', 'N')) DEFAULT 'N',
	Description            VARCHAR(255)                                         DEFAULT NULL,
	BH_Components_Snapshot TEXT                                                 DEFAULT NULL,
	Created                TIMESTAMP   NOT NULL                                 DEFAULT getDate(),
	CreatedBy              NUMERIC(10) NOT NULL,
	IsActive               CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N'))  DEFAULT 'Y',
	Updated                TIMESTAMP   NOT NULL                                 DEFAULT getDate(),
	UpdatedBy              NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Payroll_Run_Key PRIMARY KEY (BH_Payroll_Run_ID),
	CONSTRAINT BH_Payroll_Run_UU_idx UNIQUE (BH_Payroll_Run_UU),
	CONSTRAINT BH_Payroll_Run_Period_idx UNIQUE (AD_Client_ID, BH_PayrollYear, BH_PayrollMonth)
);
ALTER TABLE BH_Payroll_Run
	ADD CONSTRAINT ADClient_BHPayrollRun FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Run
	ADD CONSTRAINT ADOrg_BHPayrollRun FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

-- Run lines: one per employee per run; all figures are real columns (payslip = rendered line).
CREATE TABLE BH_Payroll_Run_Line
(
	AD_Client_ID           NUMERIC(10) NOT NULL,
	AD_Org_ID              NUMERIC(10) NOT NULL,
	BH_Payroll_Run_Line_ID NUMERIC(10) NOT NULL,
	BH_Payroll_Run_Line_UU VARCHAR(36)                                         DEFAULT NULL,
	BH_Payroll_Run_ID      NUMERIC(10) NOT NULL,
	HR_Employee_ID         NUMERIC(10) NOT NULL,
	BH_EmployeeName        VARCHAR(60)                                         DEFAULT NULL,
	BH_KRA_PIN             VARCHAR(20)                                         DEFAULT NULL,
	BH_NSSF_Number         VARCHAR(20)                                         DEFAULT NULL,
	BH_SHIF_Number         VARCHAR(20)                                         DEFAULT NULL,
	BH_PayslipNumber       VARCHAR(20)                                         DEFAULT NULL,
	BH_BasicSalary         NUMERIC     NOT NULL                                DEFAULT 0,
	BH_HouseAllowance      NUMERIC     NOT NULL                                DEFAULT 0,
	BH_TransportAllowance  NUMERIC     NOT NULL                                DEFAULT 0,
	BH_GrossPay            NUMERIC     NOT NULL                                DEFAULT 0,
	BH_TaxablePay          NUMERIC     NOT NULL                                DEFAULT 0,
	BH_PAYE_Amount         NUMERIC     NOT NULL                                DEFAULT 0,
	BH_TotalDeductions     NUMERIC     NOT NULL                                DEFAULT 0,
	BH_NetPay              NUMERIC     NOT NULL                                DEFAULT 0,
	BH_CostToEmployer      NUMERIC     NOT NULL                                DEFAULT 0,
	Created                TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	CreatedBy              NUMERIC(10) NOT NULL,
	IsActive               CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	Updated                TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	UpdatedBy              NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Payroll_Run_Line_Key PRIMARY KEY (BH_Payroll_Run_Line_ID),
	CONSTRAINT BH_Payroll_Run_Line_UU_idx UNIQUE (BH_Payroll_Run_Line_UU),
	CONSTRAINT BH_Payroll_Run_Line_Emp_idx UNIQUE (BH_Payroll_Run_ID, HR_Employee_ID)
);
ALTER TABLE BH_Payroll_Run_Line
	ADD CONSTRAINT ADClient_BHPayrollRunLine FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Run_Line
	ADD CONSTRAINT ADOrg_BHPayrollRunLine FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Run_Line
	ADD CONSTRAINT BHPayrollRun_BHPayrollRunLine FOREIGN KEY (BH_Payroll_Run_ID) REFERENCES bh_payroll_run (bh_payroll_run_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Run_Line
	ADD CONSTRAINT HREmployee_BHPayrollRunLine FOREIGN KEY (HR_Employee_ID) REFERENCES hr_employee (hr_employee_id) DEFERRABLE INITIALLY DEFERRED;

-- Run line items: one per component per line, identity snapshotted at lock so payslips
-- are immune to later component edits. Per-deduction figures live here (not as line columns).
CREATE TABLE BH_Payroll_Run_Line_Item
(
	AD_Client_ID                NUMERIC(10) NOT NULL,
	AD_Org_ID                   NUMERIC(10) NOT NULL,
	BH_Payroll_Run_Line_Item_ID NUMERIC(10) NOT NULL,
	BH_Payroll_Run_Line_Item_UU VARCHAR(36)                                         DEFAULT NULL,
	BH_Payroll_Run_Line_ID      NUMERIC(10) NOT NULL,
	Value                       VARCHAR(40) NOT NULL,
	Name                        VARCHAR(60) NOT NULL,
	BH_Category                 VARCHAR(20) NOT NULL,
	BH_IsTaxDeductible          CHAR(1)     NOT NULL CHECK (BH_IsTaxDeductible IN ('Y', 'N')) DEFAULT 'N',
	BH_EmployeeAmount           NUMERIC     NOT NULL                                DEFAULT 0,
	BH_EmployerAmount           NUMERIC     NOT NULL                                DEFAULT 0,
	SeqNo                       NUMERIC(10) NOT NULL                                DEFAULT 0,
	Created                     TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	CreatedBy                   NUMERIC(10) NOT NULL,
	IsActive                    CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	Updated                     TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	UpdatedBy                   NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Payroll_Run_Line_Item_Key PRIMARY KEY (BH_Payroll_Run_Line_Item_ID),
	CONSTRAINT BH_Payroll_Run_Line_Item_UU_idx UNIQUE (BH_Payroll_Run_Line_Item_UU),
	CONSTRAINT BH_Payroll_Run_Line_Item_idx UNIQUE (BH_Payroll_Run_Line_ID, Value)
);
ALTER TABLE BH_Payroll_Run_Line_Item
	ADD CONSTRAINT ADClient_BHPayrollRunLineItem FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Run_Line_Item
	ADD CONSTRAINT ADOrg_BHPayrollRunLineItem FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Run_Line_Item
	ADD CONSTRAINT BHPayrollRunLine_BHPayrollRunLineItem FOREIGN KEY (BH_Payroll_Run_Line_ID) REFERENCES bh_payroll_run_line (bh_payroll_run_line_id) DEFERRABLE INITIALLY DEFERRED;

-- Filings: one remittance row per statutory component per locked run (PAYE, NSSF, SHIF,
-- Housing Levy, NITA today; any future levy automatically joins). BH_FilingType holds the
-- component code — deliberately NO CHECK enum, so a new levy needs no DDL.
CREATE TABLE BH_Payroll_Filing
(
	AD_Client_ID         NUMERIC(10) NOT NULL,
	AD_Org_ID            NUMERIC(10) NOT NULL,
	BH_Payroll_Filing_ID NUMERIC(10) NOT NULL,
	BH_Payroll_Filing_UU VARCHAR(36)                                            DEFAULT NULL,
	BH_Payroll_Run_ID    NUMERIC(10) NOT NULL,
	BH_FilingType        VARCHAR(40) NOT NULL,
	BH_EmployeeAmount    NUMERIC     NOT NULL                                   DEFAULT 0,
	BH_EmployerAmount    NUMERIC     NOT NULL                                   DEFAULT 0,
	BH_TotalAmount       NUMERIC     NOT NULL                                   DEFAULT 0,
	BH_IsPaid            CHAR(1)     NOT NULL CHECK (BH_IsPaid IN ('Y', 'N'))   DEFAULT 'N',
	BH_PaidDate          TIMESTAMP                                              DEFAULT NULL,
	BH_PaymentReference  VARCHAR(40)                                            DEFAULT NULL,
	Created              TIMESTAMP   NOT NULL                                   DEFAULT getDate(),
	CreatedBy            NUMERIC(10) NOT NULL,
	IsActive             CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N'))    DEFAULT 'Y',
	Updated              TIMESTAMP   NOT NULL                                   DEFAULT getDate(),
	UpdatedBy            NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Payroll_Filing_Key PRIMARY KEY (BH_Payroll_Filing_ID),
	CONSTRAINT BH_Payroll_Filing_UU_idx UNIQUE (BH_Payroll_Filing_UU),
	CONSTRAINT BH_Payroll_Filing_Type_idx UNIQUE (BH_Payroll_Run_ID, BH_FilingType)
);
ALTER TABLE BH_Payroll_Filing
	ADD CONSTRAINT ADClient_BHPayrollFiling FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Filing
	ADD CONSTRAINT ADOrg_BHPayrollFiling FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Filing
	ADD CONSTRAINT BHPayrollRun_BHPayrollFiling FOREIGN KEY (BH_Payroll_Run_ID) REFERENCES bh_payroll_run (bh_payroll_run_id) DEFERRABLE INITIALLY DEFERRED;

-- Audit: insert-only user-facing trail (MBHPayrollAudit enforces no update/delete).
CREATE TABLE BH_Payroll_Audit
(
	AD_Client_ID        NUMERIC(10) NOT NULL,
	AD_Org_ID           NUMERIC(10) NOT NULL,
	BH_Payroll_Audit_ID NUMERIC(10) NOT NULL,
	BH_Payroll_Audit_UU VARCHAR(36)                                         DEFAULT NULL,
	BH_ActionType       VARCHAR(30) NOT NULL,
	BH_Detail           TEXT                                                DEFAULT NULL,
	AD_Role_ID          NUMERIC(10)                                         DEFAULT NULL,
	HR_Employee_ID      NUMERIC(10)                                         DEFAULT NULL,
	BH_Payroll_Run_ID   NUMERIC(10)                                         DEFAULT NULL,
	Created             TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	CreatedBy           NUMERIC(10) NOT NULL,
	IsActive            CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	Updated             TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	UpdatedBy           NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Payroll_Audit_Key PRIMARY KEY (BH_Payroll_Audit_ID),
	CONSTRAINT BH_Payroll_Audit_UU_idx UNIQUE (BH_Payroll_Audit_UU)
);
ALTER TABLE BH_Payroll_Audit
	ADD CONSTRAINT ADClient_BHPayrollAudit FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Audit
	ADD CONSTRAINT ADOrg_BHPayrollAudit FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Audit
	ADD CONSTRAINT HREmployee_BHPayrollAudit FOREIGN KEY (HR_Employee_ID) REFERENCES hr_employee (hr_employee_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payroll_Audit
	ADD CONSTRAINT BHPayrollRun_BHPayrollAudit FOREIGN KEY (BH_Payroll_Run_ID) REFERENCES bh_payroll_run (bh_payroll_run_id) DEFERRABLE INITIALLY DEFERRED;

-- ============================================================================
-- Dictionary registration (Task 3). Patterns: 202605221123_GO-3580.sql.
-- ============================================================================

-- New AD_Element rows (existing core elements are referenced by id, not recreated)
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_KRA_PIN', 'U', 'KRA PIN', 'KRA PIN', NULL, NULL, NULL, NULL, NULL, NULL, '58468c21-00bd-4013-a3b1-a4dd5b8a90ad', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_NSSF_Number', 'U', 'NSSF Number', 'NSSF Number', NULL, NULL, NULL, NULL, NULL, NULL, '51a1510c-6ade-4f32-836b-4d8356f129c9', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_SHIF_Number', 'U', 'SHIF Number', 'SHIF Number', NULL, NULL, NULL, NULL, NULL, NULL, '14a72ef7-e9fc-4c92-85e5-1f902917d97d', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_BankName', 'U', 'Bank Name', 'Bank Name', NULL, NULL, NULL, NULL, NULL, NULL, '39e4ad3c-ce47-4fe5-9ce8-4558fd2bfe68', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_BankBranch', 'U', 'Bank Branch', 'Bank Branch', NULL, NULL, NULL, NULL, NULL, NULL, '6869bf46-1197-4720-8005-cbcb8239f902', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_BankAccount', 'U', 'Bank Account', 'Bank Account', NULL, NULL, NULL, NULL, NULL, NULL, 'bf2c663c-8046-43b2-8fb9-68d88d6e2f24', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_BasicSalary', 'U', 'Basic Salary', 'Basic Salary', NULL, NULL, NULL, NULL, NULL, NULL, '0b8e64cb-2b5d-499d-876a-5deafd5865ff', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_HouseAllowance', 'U', 'House Allowance', 'House Allowance', NULL, NULL, NULL, NULL, NULL, NULL, 'ff548ca4-98ae-45cb-88a2-9d251bdb58ee', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_TransportAllowance', 'U', 'Transport Allowance', 'Transport Allowance', NULL, NULL, NULL, NULL, NULL, NULL, 'b3cd4fe8-74a9-4295-844d-1e9434eb9fc5', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Settings_ID', 'U', 'Payroll Settings', 'Payroll Settings', NULL, NULL, NULL, NULL, NULL, NULL, '24837385-a0b7-49a0-9fa0-6ecc2dcf8901', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Settings_UU', 'U', 'BH_Payroll_Settings_UU', 'BH_Payroll_Settings_UU', NULL, NULL, NULL, NULL, NULL, NULL, '5ad1b032-dc7b-4a67-8b73-02d93eee6db5', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PayDay', 'U', 'Pay Day', 'Pay Day', NULL, NULL, NULL, NULL, NULL, NULL, '449bc557-db68-47d5-bf54-85991c403d22', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Component_ID', 'U', 'Payroll Component', 'Payroll Component', NULL, NULL, NULL, NULL, NULL, NULL, '1288fc9a-08a5-4c6e-aa5f-15a29b53ef27', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Component_UU', 'U', 'BH_Payroll_Component_UU', 'BH_Payroll_Component_UU', NULL, NULL, NULL, NULL, NULL, NULL, '603f5242-89c5-40d7-98e7-0d6a1f7f2a8a', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Category', 'U', 'Category', 'Category', NULL, NULL, NULL, NULL, NULL, NULL, '22e63d45-f895-4c2f-9034-c279bbe478c3', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_CalcMethod', 'U', 'Calculation Method', 'Calculation Method', NULL, NULL, NULL, NULL, NULL, NULL, '08230c0c-530f-4a6f-bc4d-b40f5718362f', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Rate', 'U', 'Rate', 'Rate', NULL, NULL, NULL, NULL, NULL, NULL, 'a4974315-437a-49e0-bbf2-45c7b0ccc81b', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Floor', 'U', 'Floor Amount', 'Floor Amount', NULL, NULL, NULL, NULL, NULL, NULL, '7fb310df-d557-45e4-a3cf-8390e338c6c3', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Cap', 'U', 'Cap Amount', 'Cap Amount', NULL, NULL, NULL, NULL, NULL, NULL, '374be53a-59df-4251-ab9f-2a52f46a4c45', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Tier1_Limit', 'U', 'Tier 1 Limit', 'Tier 1 Limit', NULL, NULL, NULL, NULL, NULL, NULL, '83ba45a7-a144-4f28-aa6e-5edfc5ccc78e', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Tier2_Limit', 'U', 'Tier 2 Limit', 'Tier 2 Limit', NULL, NULL, NULL, NULL, NULL, NULL, '097a7f29-008c-49f1-b95c-6fab75d652fb', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_EmployerRate', 'U', 'Employer Rate', 'Employer Rate', NULL, NULL, NULL, NULL, NULL, NULL, '16c1f79c-863c-4d61-b1d9-baf43dea871d', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_IsTaxDeductible', 'U', 'Tax Deductible', 'Tax Deductible', NULL, NULL, NULL, NULL, NULL, NULL, 'a1cb1f6c-c56d-47f0-b09b-e00851639522', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_TaxDeductibleCap', 'U', 'Tax Deductible Cap', 'Tax Deductible Cap', NULL, NULL, NULL, NULL, NULL, NULL, 'c6f2f6ab-2b41-43c9-84d9-54a15812bb39', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_IsStatutory', 'U', 'Statutory', 'Statutory', NULL, NULL, NULL, NULL, NULL, NULL, 'dc370b2a-9c53-47d9-bf1c-caac0af2769c', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_FilingDueDay', 'U', 'Filing Due Day', 'Filing Due Day', NULL, NULL, NULL, NULL, NULL, NULL, 'dcdef8ab-53bf-4f90-9553-d33faac741cc', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PAYE_Band_ID', 'U', 'PAYE Band', 'PAYE Band', NULL, NULL, NULL, NULL, NULL, NULL, '2113a5f4-b3e5-42f6-bd9f-ef64712d7e9e', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PAYE_Band_UU', 'U', 'BH_PAYE_Band_UU', 'BH_PAYE_Band_UU', NULL, NULL, NULL, NULL, NULL, NULL, 'c09c991e-21cb-472a-9bca-fd73f9538ada', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_UpperLimit', 'U', 'Upper Limit', 'Upper Limit', NULL, NULL, NULL, NULL, NULL, NULL, '65aa26d3-ddee-4810-834f-529a84280744', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Employee_Component_ID', 'U', 'Employee Payroll Component', 'Employee Payroll Component', NULL, NULL, NULL, NULL, NULL, NULL, '88aa40ea-66cd-4e65-8315-22b4ae625514', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Employee_Component_UU', 'U', 'BH_Employee_Component_UU', 'BH_Employee_Component_UU', NULL, NULL, NULL, NULL, NULL, NULL, '9ccf59b1-e393-4633-85e1-c993805bf455', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Amount', 'U', 'Amount', 'Amount', NULL, NULL, NULL, NULL, NULL, NULL, '8d06f980-5107-45ff-92b4-786561deb0a1', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Run_ID', 'U', 'Payroll Run', 'Payroll Run', NULL, NULL, NULL, NULL, NULL, NULL, 'dba77ebb-5202-498e-aeb3-d9ea0bc1e72d', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Run_UU', 'U', 'BH_Payroll_Run_UU', 'BH_Payroll_Run_UU', NULL, NULL, NULL, NULL, NULL, NULL, '6a7836eb-97bb-45aa-a78b-65b3d471fac0', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PayrollMonth', 'U', 'Payroll Month', 'Payroll Month', NULL, NULL, NULL, NULL, NULL, NULL, 'c69da128-20f5-4a6a-9adb-6c4b08f74663', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PayrollYear', 'U', 'Payroll Year', 'Payroll Year', NULL, NULL, NULL, NULL, NULL, NULL, '17f1b02b-90b1-4597-b231-2e768d15c430', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PayDate', 'U', 'Pay Date', 'Pay Date', NULL, NULL, NULL, NULL, NULL, NULL, 'a85a915e-6c92-4a1e-ac6b-c1bb0f2f7b2f', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Components_Snapshot', 'U', 'Components Snapshot', 'Components Snapshot', NULL, NULL, NULL, NULL, NULL, NULL, '7d705982-451c-4d22-9585-7520b3d777e2', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Run_Line_ID', 'U', 'Payroll Run Line', 'Payroll Run Line', NULL, NULL, NULL, NULL, NULL, NULL, '14a251be-3a78-4199-9800-9a5c026e82a8', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Run_Line_UU', 'U', 'BH_Payroll_Run_Line_UU', 'BH_Payroll_Run_Line_UU', NULL, NULL, NULL, NULL, NULL, NULL, 'cb907f84-7d51-4410-b6b4-507043b4d460', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_EmployeeName', 'U', 'Employee Name', 'Employee Name', NULL, NULL, NULL, NULL, NULL, NULL, '521a9339-444a-4bf9-bb99-999e9fcfd652', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PayslipNumber', 'U', 'Payslip Number', 'Payslip Number', NULL, NULL, NULL, NULL, NULL, NULL, 'd56fb768-f57b-444c-bd15-d0b8cecf44fb', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_GrossPay', 'U', 'Gross Pay', 'Gross Pay', NULL, NULL, NULL, NULL, NULL, NULL, '00fc5ce1-fcc4-4a11-889e-b47c7f46c192', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_TaxablePay', 'U', 'Taxable Pay', 'Taxable Pay', NULL, NULL, NULL, NULL, NULL, NULL, '74e50a7c-9dd5-40e6-ae87-b87995fbea37', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PAYE_Amount', 'U', 'PAYE Amount', 'PAYE Amount', NULL, NULL, NULL, NULL, NULL, NULL, '6817cd57-f314-4b78-8fb1-9d8274ca10b8', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_TotalDeductions', 'U', 'Total Deductions', 'Total Deductions', NULL, NULL, NULL, NULL, NULL, NULL, 'c2a8fc4e-80e0-4b98-aee2-9894a51de904', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_NetPay', 'U', 'Net Pay', 'Net Pay', NULL, NULL, NULL, NULL, NULL, NULL, '26ccf8d5-e7c3-448b-85d1-067f8663209f', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_CostToEmployer', 'U', 'Cost To Employer', 'Cost To Employer', NULL, NULL, NULL, NULL, NULL, NULL, '6eb14a1b-c5bc-4bea-aa7b-288994a8b799', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Run_Line_Item_ID', 'U', 'Payroll Run Line Item', 'Payroll Run Line Item', NULL, NULL, NULL, NULL, NULL, NULL, 'fe9c26e4-a436-44b3-bc0c-3401ab60ad32', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Run_Line_Item_UU', 'U', 'BH_Payroll_Run_Line_Item_UU', 'BH_Payroll_Run_Line_Item_UU', NULL, NULL, NULL, NULL, NULL, NULL, '4e84216b-5161-4130-9d6e-dcd002ee6d9d', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_EmployeeAmount', 'U', 'Employee Amount', 'Employee Amount', NULL, NULL, NULL, NULL, NULL, NULL, '9a7163ca-9ab7-4a80-9d25-e34271372d35', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_EmployerAmount', 'U', 'Employer Amount', 'Employer Amount', NULL, NULL, NULL, NULL, NULL, NULL, '80804632-329a-4d4b-a5eb-4de71859933a', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Filing_ID', 'U', 'Payroll Filing', 'Payroll Filing', NULL, NULL, NULL, NULL, NULL, NULL, '4e0ea5d4-7173-4c07-af44-54aa1221b1a8', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Filing_UU', 'U', 'BH_Payroll_Filing_UU', 'BH_Payroll_Filing_UU', NULL, NULL, NULL, NULL, NULL, NULL, '65423962-bf4e-4198-89a5-8a22096e1dd7', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_FilingType', 'U', 'Filing Type', 'Filing Type', NULL, NULL, NULL, NULL, NULL, NULL, 'dd33a669-3325-4e3e-8e58-f45b1c9ae207', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_TotalAmount', 'U', 'Total Amount', 'Total Amount', NULL, NULL, NULL, NULL, NULL, NULL, 'a4bca2e1-a782-4523-9965-702120f317a2', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_IsPaid', 'U', 'Paid', 'Paid', NULL, NULL, NULL, NULL, NULL, NULL, 'b19defc7-0101-483a-bc51-dc4107832f89', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PaidDate', 'U', 'Paid Date', 'Paid Date', NULL, NULL, NULL, NULL, NULL, NULL, '8647f94c-556b-464f-a682-7eb0960490b3', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_PaymentReference', 'U', 'Payment Reference', 'Payment Reference', NULL, NULL, NULL, NULL, NULL, NULL, 'f59ab8ff-9307-40b9-9e81-7fadde756906', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Audit_ID', 'U', 'Payroll Audit', 'Payroll Audit', NULL, NULL, NULL, NULL, NULL, NULL, 'be46331a-3666-4e65-bd31-fa16b7b0dd86', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Payroll_Audit_UU', 'U', 'BH_Payroll_Audit_UU', 'BH_Payroll_Audit_UU', NULL, NULL, NULL, NULL, NULL, NULL, 'cb8ec14f-ff17-43ed-a445-620cfda84378', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_ActionType', 'U', 'Action Type', 'Action Type', NULL, NULL, NULL, NULL, NULL, NULL, 'b7f103ff-d93c-4e88-ade1-40d082d66846', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00',
	 100, 'BH_Detail', 'U', 'Detail', 'Detail', NULL, NULL, NULL, NULL, NULL, NULL, '97baa6bd-6817-4f63-8938-96102bc3d39d', NULL);

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'Payroll Settings', NULL, NULL,
	 'BH_Payroll_Settings', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '1ad0e498-4a19-4234-8bf8-2ea2e8b29841', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'BH_Payroll_Settings',
	 'Table BH_Payroll_Settings', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'a2d67127-5009-4255-b8c3-181992054165', 'N', 'N', NULL);

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'Payroll Component', NULL, NULL,
	 'BH_Payroll_Component', 'N', '7', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'BH_Payroll_Component',
	 'Table BH_Payroll_Component', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '1c875930-fe91-4d61-a835-bbf521a5ea0a', 'N', 'N', NULL);

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'PAYE Band', NULL, NULL,
	 'BH_PAYE_Band', 'N', '7', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'BH_PAYE_Band',
	 'Table BH_PAYE_Band', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '14ede380-51db-424f-b9bb-e662cc17dab1', 'N', 'N', NULL);

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'Employee Payroll Component', NULL, NULL,
	 'BH_Employee_Component', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'BH_Employee_Component',
	 'Table BH_Employee_Component', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'a9eff79e-2011-4abc-b99a-66cb1aeeabb2', 'N', 'N', NULL);

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'Payroll Run', NULL, NULL,
	 'BH_Payroll_Run', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '6d7c76c7-6860-48ea-b0a8-f492d2935457', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'BH_Payroll_Run',
	 'Table BH_Payroll_Run', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '5193f230-f164-4293-b98e-3cab64be97a3', 'N', 'N', NULL);

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'Payroll Run Line', NULL, NULL,
	 'BH_Payroll_Run_Line', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 'ef5c992f-d08a-4afe-8e76-1fb903ae3699', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'BH_Payroll_Run_Line',
	 'Table BH_Payroll_Run_Line', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '1399aa9a-f0b0-46a3-9171-d25c41cf6727', 'N', 'N', NULL);

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'Payroll Run Line Item', NULL, NULL,
	 'BH_Payroll_Run_Line_Item', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '5e75159d-dfc0-4379-a39c-f60d06e05d18', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'BH_Payroll_Run_Line_Item',
	 'Table BH_Payroll_Run_Line_Item', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '6d9e8728-2546-4011-b307-e5b1a5470020', 'N', 'N', NULL);

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'Payroll Filing', NULL, NULL,
	 'BH_Payroll_Filing', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '3e1c3559-2fea-465a-81b1-f47ea2fd435c', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'BH_Payroll_Filing',
	 'Table BH_Payroll_Filing', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '7e589947-d376-4e2c-9530-769c4a5bf8e4', 'N', 'N', NULL);

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'Payroll Audit', NULL, NULL,
	 'BH_Payroll_Audit', 'N', '3', 'U', NULL, NULL, 0, 'N', 'N', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '297e3cbb-f2fb-4496-8161-8d69c275660b', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'BH_Payroll_Audit',
	 'Table BH_Payroll_Audit', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'd908fa82-ca3b-415a-863f-8b46ea4f2425', 'N', 'N', NULL);

-- Columns: BH_Payroll_Settings
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tenant', NULL, NULL, 1,
	 'U', 'AD_Client_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 19, NULL, NULL, 22, '@#AD_Client_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 102,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2c1a5a86-2c69-4aa2-a023-00c0b22fe5a1', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Organization', NULL, NULL, 1,
	 'U', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 19, NULL, NULL, 22, '@#AD_Org_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'fde434be-c950-4d2e-a61f-17e5553eb962', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Settings', NULL, NULL, 1,
	 'U', 'BH_Payroll_Settings_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 13, NULL, NULL, 22, NULL, 'Y', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '24837385-a0b7-49a0-9fa0-6ecc2dcf8901'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '463bf6cd-02dc-434a-b487-2159c351b7eb', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'BH_Payroll_Settings_UU', NULL, NULL, 1,
	 'U', 'BH_Payroll_Settings_UU', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 200231, NULL, NULL, 36, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5ad1b032-dc7b-4a67-8b73-02d93eee6db5'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e8da6689-4720-4011-a17d-832188551e95', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Name', NULL, NULL, 1,
	 'U', 'Name', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 10, NULL, NULL, 60, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 469,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e2b7b90e-b317-4c9c-99fc-be9310b0b25d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Pay Day', NULL, NULL, 1,
	 'U', 'BH_PayDay', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 11, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '449bc557-db68-47d5-bf54-85991c403d22'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '90cdb0cd-1b70-4975-b4ed-f56e7e88acc3', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created', NULL, NULL, 1,
	 'U', 'Created', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cc9569dc-74a3-48fa-9c2e-bb240d0d80b6', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created By', NULL, NULL, 1,
	 'U', 'CreatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '032d0ed2-bd7d-4f1d-8c9d-3e5072aa1640', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Active', NULL, NULL, 1,
	 'U', 'IsActive', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 20, NULL, NULL, 1, 'Y', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8bba51ab-f996-4a7c-b7a1-993ca5c5f30d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated', NULL, NULL, 1,
	 'U', 'Updated', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b01bb0c5-3328-4464-8195-29af9e54d2f4', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated By', NULL, NULL, 1,
	 'U', 'UpdatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '75cf1564-9ef6-4d87-8720-ce24d714998d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Columns: BH_Payroll_Component
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tenant', NULL, NULL, 1,
	 'U', 'AD_Client_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 19, NULL, NULL, 22, '@#AD_Client_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 102,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '950b6e0d-7726-44d1-bf46-9b5af7a0e0ba', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Organization', NULL, NULL, 1,
	 'U', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 19, NULL, NULL, 22, '@#AD_Org_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b7cc136a-dce1-440b-baa7-ffc16d005a6c', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Component', NULL, NULL, 1,
	 'U', 'BH_Payroll_Component_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 13, NULL, NULL, 22, NULL, 'Y', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1288fc9a-08a5-4c6e-aa5f-15a29b53ef27'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3413de74-f7f6-4b7d-90bb-d97f4cd098bb', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'BH_Payroll_Component_UU', NULL, NULL, 1,
	 'U', 'BH_Payroll_Component_UU', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 200231, NULL, NULL, 36, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '603f5242-89c5-40d7-98e7-0d6a1f7f2a8a'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '36589819-1de3-4914-b362-7dc724a39cb1', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Search Key', NULL, NULL, 1,
	 'U', 'Value', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 10, NULL, NULL, 40, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 620,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5bca64fe-a95a-41c3-bb82-83dc231504d4', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Name', NULL, NULL, 1,
	 'U', 'Name', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 10, NULL, NULL, 60, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 469,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '90738531-3601-4d9c-9008-3012f951da53', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Category', NULL, NULL, 1,
	 'U', 'BH_Category', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 10, NULL, NULL, 20, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '22e63d45-f895-4c2f-9034-c279bbe478c3'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2ef71ba8-a79a-4e92-9716-c4c6724b5d17', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Calculation Method', NULL, NULL, 1,
	 'U', 'BH_CalcMethod', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 10, NULL, NULL, 20, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '08230c0c-530f-4a6f-bc4d-b40f5718362f'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '82c80165-d73e-4f26-a335-e43bde135f57', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Rate', NULL, NULL, 1,
	 'U', 'BH_Rate', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 12, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a4974315-437a-49e0-bbf2-45c7b0ccc81b'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '563eb62c-cbe9-47e3-9063-48eab3ced422', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Floor Amount', NULL, NULL, 1,
	 'U', 'BH_Floor', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 12, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7fb310df-d557-45e4-a3cf-8390e338c6c3'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '807897a3-6690-4257-9eed-c897da373fae', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Cap Amount', NULL, NULL, 1,
	 'U', 'BH_Cap', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 12, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '374be53a-59df-4251-ab9f-2a52f46a4c45'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '86f24026-f513-4d5b-9965-ffbad28f13ac', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tier 1 Limit', NULL, NULL, 1,
	 'U', 'BH_Tier1_Limit', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 12, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '83ba45a7-a144-4f28-aa6e-5edfc5ccc78e'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '885b2dee-6b41-4a6f-a7ab-8970c76e8748', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tier 2 Limit', NULL, NULL, 1,
	 'U', 'BH_Tier2_Limit', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 12, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '097a7f29-008c-49f1-b95c-6fab75d652fb'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4bac408d-c1ab-412a-b810-e7105e2c8f9c', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Employer Rate', NULL, NULL, 1,
	 'U', 'BH_EmployerRate', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 12, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '16c1f79c-863c-4d61-b1d9-baf43dea871d'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'fb6bbb98-090f-4c6f-8cc0-6a120a6b6675', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tax Deductible', NULL, NULL, 1,
	 'U', 'BH_IsTaxDeductible', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 20, NULL, NULL, 1, 'N', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a1cb1f6c-c56d-47f0-b09b-e00851639522'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '637ae8a2-59e0-4881-bf03-85a0b7f1af12', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tax Deductible Cap', NULL, NULL, 1,
	 'U', 'BH_TaxDeductibleCap', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 12, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c6f2f6ab-2b41-43c9-84d9-54a15812bb39'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3be0390a-866f-4905-8d7d-4f436180b8af', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Statutory', NULL, NULL, 1,
	 'U', 'BH_IsStatutory', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 20, NULL, NULL, 1, 'N', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dc370b2a-9c53-47d9-bf1c-caac0af2769c'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '329c5bc1-c3e0-478e-a5e4-b9d4ca7071a6', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Filing Due Day', NULL, NULL, 1,
	 'U', 'BH_FilingDueDay', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 11, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dcdef8ab-53bf-4f90-9553-d33faac741cc'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '324cdbb2-43ff-4a0c-81b2-6d60aae20bb3', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Sequence', NULL, NULL, 1,
	 'U', 'SeqNo', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 11, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 566,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '32aa096f-9511-40f4-bf8e-2937a815dd04', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Valid from', NULL, NULL, 1,
	 'U', 'ValidFrom', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 15, NULL, NULL, 7, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 617,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f72cd7a1-6347-4889-8112-aca57ed34eaf', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created', NULL, NULL, 1,
	 'U', 'Created', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0d8e69aa-6de1-48dc-aaa2-dac0eb255896', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created By', NULL, NULL, 1,
	 'U', 'CreatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '647873c8-4437-4c45-9da0-09ebd1e4e2c6', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Active', NULL, NULL, 1,
	 'U', 'IsActive', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 20, NULL, NULL, 1, 'Y', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e5c23367-ae16-406d-9029-31c351ba8f21', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated', NULL, NULL, 1,
	 'U', 'Updated', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'acadd516-a0ba-4d6e-a565-d3939f56470d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated By', NULL, NULL, 1,
	 'U', 'UpdatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2beaeb76-aaaf-4175-9be9-8abdc81fb9d0'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '09b90dc9-a684-4b01-bc23-3c4302be5560', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Columns: BH_PAYE_Band
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tenant', NULL, NULL, 1,
	 'U', 'AD_Client_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 19, NULL, NULL, 22, '@#AD_Client_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 102,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '928ef9cb-9506-4387-a2c4-63c1e8c929e6', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Organization', NULL, NULL, 1,
	 'U', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 19, NULL, NULL, 22, '@#AD_Org_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c0c4a854-f8c1-431b-8f65-f76793771b70', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'PAYE Band', NULL, NULL, 1,
	 'U', 'BH_PAYE_Band_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 13, NULL, NULL, 22, NULL, 'Y', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '2113a5f4-b3e5-42f6-bd9f-ef64712d7e9e'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a8fb433b-a811-49b3-92ea-5a24c4d0fe17', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'BH_PAYE_Band_UU', NULL, NULL, 1,
	 'U', 'BH_PAYE_Band_UU', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 200231, NULL, NULL, 36, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c09c991e-21cb-472a-9bca-fd73f9538ada'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3fc468f3-6a5f-4a70-8366-c83313ff43b4', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Component', NULL, NULL, 1,
	 'U', 'BH_Payroll_Component_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 19, NULL, NULL, 22, NULL, 'N', 'Y',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1288fc9a-08a5-4c6e-aa5f-15a29b53ef27'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ce0b8940-81ad-4fd9-973e-b508425c2540', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Sequence', NULL, NULL, 1,
	 'U', 'SeqNo', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 11, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 566,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0d035e56-73e0-4ba8-84f9-9bcdfec82539', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Upper Limit', NULL, NULL, 1,
	 'U', 'BH_UpperLimit', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 12, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '65aa26d3-ddee-4810-834f-529a84280744'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '595e68a7-8512-43e8-8b5f-59428005e0fc', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Rate', NULL, NULL, 1,
	 'U', 'BH_Rate', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a4974315-437a-49e0-bbf2-45c7b0ccc81b'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7bd6bd66-31eb-467a-8af1-0bcdeed34e3f', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created', NULL, NULL, 1,
	 'U', 'Created', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '53b89485-bed6-4199-8590-56dc9d4ca080', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created By', NULL, NULL, 1,
	 'U', 'CreatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '44dfa3f0-50d1-4fb3-8ae9-7fe8c1c4d924', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Active', NULL, NULL, 1,
	 'U', 'IsActive', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 20, NULL, NULL, 1, 'Y', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c486d375-8dc7-4507-842a-20b15d656d34', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated', NULL, NULL, 1,
	 'U', 'Updated', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'adbf3121-5cb4-4025-9ae6-6908ce75158e', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated By', NULL, NULL, 1,
	 'U', 'UpdatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'fa3a2f01-feae-448f-9a06-0b9f64e7e2fb'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '841261f4-d51b-4746-9db5-d9791b590092', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Columns: BH_Employee_Component
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tenant', NULL, NULL, 1,
	 'U', 'AD_Client_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 19, NULL, NULL, 22, '@#AD_Client_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 102,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0cdbd5fa-4078-44a1-9e88-168419006434', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Organization', NULL, NULL, 1,
	 'U', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 19, NULL, NULL, 22, '@#AD_Org_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f9648a9c-a552-4642-96cf-5c8ba36d63cf', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Employee Payroll Component', NULL, NULL, 1,
	 'U', 'BH_Employee_Component_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 13, NULL, NULL, 22, NULL, 'Y', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '88aa40ea-66cd-4e65-8315-22b4ae625514'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '91b268ed-908e-429b-8f53-7f17b34a3fb5', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'BH_Employee_Component_UU', NULL, NULL, 1,
	 'U', 'BH_Employee_Component_UU', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 200231, NULL, NULL, 36, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9ccf59b1-e393-4633-85e1-c993805bf455'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9ae8a864-921c-46d7-9279-8a2db7974597', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Employee', NULL, NULL, 1,
	 'U', 'HR_Employee_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 19, NULL, NULL, 22, NULL, 'N', 'Y',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 53391,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e2f99db9-cd7c-43f6-bd8a-a2da6fbcd869', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Component', NULL, NULL, 1,
	 'U', 'BH_Payroll_Component_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 19, NULL, NULL, 22, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1288fc9a-08a5-4c6e-aa5f-15a29b53ef27'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9c9e39e7-f82b-4da5-ac74-a72e6183722a', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Amount', NULL, NULL, 1,
	 'U', 'BH_Amount', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '8d06f980-5107-45ff-92b4-786561deb0a1'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'eba97f36-63c0-4147-b505-eb342ffbc949', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Valid from', NULL, NULL, 1,
	 'U', 'ValidFrom', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 15, NULL, NULL, 7, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 617,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1db212b8-ff84-4716-8815-32eecd6105fc', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Valid to', NULL, NULL, 1,
	 'U', 'ValidTo', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 15, NULL, NULL, 7, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 618,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '009debaa-b2b7-4442-9178-51398afa78f4', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created', NULL, NULL, 1,
	 'U', 'Created', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '465edcf3-ce33-4180-82fb-d852dc42eaff', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created By', NULL, NULL, 1,
	 'U', 'CreatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '038a4dff-9cc8-4471-9fcf-25e1f78007b9', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Active', NULL, NULL, 1,
	 'U', 'IsActive', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 20, NULL, NULL, 1, 'Y', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '14dcbd38-8c5b-4644-b378-5412dc405c98', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated', NULL, NULL, 1,
	 'U', 'Updated', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd32ccec8-ab4f-497f-a57d-2952e362143d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated By', NULL, NULL, 1,
	 'U', 'UpdatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f2b53a13-57a4-4bdf-8d29-dc0b93afd93a'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c39d4a26-9c47-49f7-8690-1d2ea30780e5', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Columns: BH_Payroll_Run
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tenant', NULL, NULL, 1,
	 'U', 'AD_Client_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 19, NULL, NULL, 22, '@#AD_Client_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 102,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6e0f23f0-e45d-4ea0-a1a6-64aaca019878', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Organization', NULL, NULL, 1,
	 'U', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 19, NULL, NULL, 22, '@#AD_Org_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c431c55d-fcdf-4ed4-830d-98a08c779fd7', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Run', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 13, NULL, NULL, 22, NULL, 'Y', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dba77ebb-5202-498e-aeb3-d9ea0bc1e72d'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '131d66d1-a334-45d3-8fdb-7d717086f947', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'BH_Payroll_Run_UU', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_UU', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 200231, NULL, NULL, 36, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '6a7836eb-97bb-45aa-a78b-65b3d471fac0'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '755fb489-dcfe-48bd-a00b-d1a4012576bd', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Month', NULL, NULL, 1,
	 'U', 'BH_PayrollMonth', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 11, NULL, NULL, 22, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c69da128-20f5-4a6a-9adb-6c4b08f74663'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e85e6060-3e66-4e26-bf87-d4ff12c18b2f', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Year', NULL, NULL, 1,
	 'U', 'BH_PayrollYear', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 11, NULL, NULL, 22, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '17f1b02b-90b1-4597-b231-2e768d15c430'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9681f804-5f44-4052-b148-1fb0a2557a21', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Pay Date', NULL, NULL, 1,
	 'U', 'BH_PayDate', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 15, NULL, NULL, 7, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a85a915e-6c92-4a1e-ac6b-c1bb0f2f7b2f'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '632562fa-9a14-4500-95dd-b8ca517c8fc6', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Document Status', NULL, NULL, 1,
	 'U', 'DocStatus', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 17, 131, NULL, 2, 'DR', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 289,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cbc33959-9ebf-4bba-aee1-375fb744adef', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Document Action', NULL, NULL, 1,
	 'U', 'DocAction', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 17, 135, NULL, 2, 'CO', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 287,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8e0750f8-7a3d-4e56-8d8b-235f8625c1b2', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Processed', NULL, NULL, 1,
	 'U', 'Processed', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 20, NULL, NULL, 1, 'N', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 1047,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cb6c2940-5200-46ec-a70f-341ceb598e37', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Description', NULL, NULL, 1,
	 'U', 'Description', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 10, NULL, NULL, 255, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 275,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0a97150e-35fa-44c0-acd4-7c2e728bae8c', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Components Snapshot', NULL, NULL, 1,
	 'U', 'BH_Components_Snapshot', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 14, NULL, NULL, 2000, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d705982-451c-4d22-9585-7520b3d777e2'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '48328ab8-c111-4fbf-87e1-48b94f4fb246', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created', NULL, NULL, 1,
	 'U', 'Created', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '33ee5eb6-4952-45d4-bdbe-47bcee73e910', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created By', NULL, NULL, 1,
	 'U', 'CreatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0671d35d-1d4a-459f-a3d6-05fb7861fc0d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Active', NULL, NULL, 1,
	 'U', 'IsActive', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 20, NULL, NULL, 1, 'Y', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2a8c726e-f213-4b23-95fa-4b0c402f110f', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated', NULL, NULL, 1,
	 'U', 'Updated', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ff3f258a-1f74-48ff-a312-81801d678201', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated By', NULL, NULL, 1,
	 'U', 'UpdatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '6d7c76c7-6860-48ea-b0a8-f492d2935457'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '98c18676-1136-4d1b-9bef-63b25c08cee1', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Columns: BH_Payroll_Run_Line
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tenant', NULL, NULL, 1,
	 'U', 'AD_Client_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 19, NULL, NULL, 22, '@#AD_Client_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 102,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4abd2f18-7d92-493b-a544-72a67cf0cd36', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Organization', NULL, NULL, 1,
	 'U', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 19, NULL, NULL, 22, '@#AD_Org_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5e6a1624-8ab2-4a15-a35a-06892ccd8197', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Run Line', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_Line_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 13, NULL, NULL, 22, NULL, 'Y', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '14a251be-3a78-4199-9800-9a5c026e82a8'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '32c829b2-ff1b-47eb-8607-63b455677a58', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'BH_Payroll_Run_Line_UU', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_Line_UU', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 200231, NULL, NULL, 36, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'cb907f84-7d51-4410-b6b4-507043b4d460'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '318e1239-0ee3-43b1-9395-6153aeec90bc', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Run', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 19, NULL, NULL, 22, NULL, 'N', 'Y',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dba77ebb-5202-498e-aeb3-d9ea0bc1e72d'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5026712d-3840-4e13-8290-27a121027502', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Employee', NULL, NULL, 1,
	 'U', 'HR_Employee_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 19, NULL, NULL, 22, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 53391,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '47213fbf-5808-42e2-b554-3fc933bc6bb9', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Employee Name', NULL, NULL, 1,
	 'U', 'BH_EmployeeName', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 10, NULL, NULL, 60, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '521a9339-444a-4bf9-bb99-999e9fcfd652'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '58912938-005a-4250-9c08-e825e1ba7cbe', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'KRA PIN', NULL, NULL, 1,
	 'U', 'BH_KRA_PIN', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 10, NULL, NULL, 20, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '58468c21-00bd-4013-a3b1-a4dd5b8a90ad'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f28f613f-00fe-44d1-98fb-2431f6758b54', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'NSSF Number', NULL, NULL, 1,
	 'U', 'BH_NSSF_Number', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 10, NULL, NULL, 20, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '51a1510c-6ade-4f32-836b-4d8356f129c9'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cc6a9bb9-3c6d-422e-a34e-1e24b03ae5d3', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'SHIF Number', NULL, NULL, 1,
	 'U', 'BH_SHIF_Number', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 10, NULL, NULL, 20, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '14a72ef7-e9fc-4c92-85e5-1f902917d97d'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9ae86bb3-51a0-4052-b278-2902181d5b18', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payslip Number', NULL, NULL, 1,
	 'U', 'BH_PayslipNumber', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 10, NULL, NULL, 20, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd56fb768-f57b-444c-bd15-d0b8cecf44fb'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5a35e34f-d700-487b-9349-ab9a337c3e7e', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Basic Salary', NULL, NULL, 1,
	 'U', 'BH_BasicSalary', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '0b8e64cb-2b5d-499d-876a-5deafd5865ff'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8d60d1b8-de69-4fe6-8638-3f3725ac8ec5', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'House Allowance', NULL, NULL, 1,
	 'U', 'BH_HouseAllowance', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ff548ca4-98ae-45cb-88a2-9d251bdb58ee'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'bce89709-82ae-42b4-bd03-d9b16f09e141', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Transport Allowance', NULL, NULL, 1,
	 'U', 'BH_TransportAllowance', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b3cd4fe8-74a9-4295-844d-1e9434eb9fc5'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '94c38125-b8ac-4cb9-b8c1-66c436618159', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Gross Pay', NULL, NULL, 1,
	 'U', 'BH_GrossPay', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '00fc5ce1-fcc4-4a11-889e-b47c7f46c192'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a0d5fc92-0b5a-4a4c-941c-0cd5e40f2ae7', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Taxable Pay', NULL, NULL, 1,
	 'U', 'BH_TaxablePay', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '74e50a7c-9dd5-40e6-ae87-b87995fbea37'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'dbdc93b4-3a41-430c-a403-7df2770afafd', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'PAYE Amount', NULL, NULL, 1,
	 'U', 'BH_PAYE_Amount', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '6817cd57-f314-4b78-8fb1-9d8274ca10b8'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0f227917-197d-4dc4-85e7-d43eef38ade2', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Total Deductions', NULL, NULL, 1,
	 'U', 'BH_TotalDeductions', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c2a8fc4e-80e0-4b98-aee2-9894a51de904'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2739d25f-1add-4a8f-9630-82e073859ad5', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Net Pay', NULL, NULL, 1,
	 'U', 'BH_NetPay', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '26ccf8d5-e7c3-448b-85d1-067f8663209f'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5365192b-1920-48ad-831d-79e9921c06fd', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Cost To Employer', NULL, NULL, 1,
	 'U', 'BH_CostToEmployer', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '6eb14a1b-c5bc-4bea-aa7b-288994a8b799'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1495052e-17cf-49f2-9ce9-94950c7608dd', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created', NULL, NULL, 1,
	 'U', 'Created', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4e23fc8e-82f7-4d0e-ac6b-51dca359f419', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created By', NULL, NULL, 1,
	 'U', 'CreatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cdd9e04e-246e-424b-8024-7f54d6a195f0', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Active', NULL, NULL, 1,
	 'U', 'IsActive', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 20, NULL, NULL, 1, 'Y', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '43e9bc42-616f-48ae-a2ad-8a39e70695d2', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated', NULL, NULL, 1,
	 'U', 'Updated', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0c118030-94b1-485b-bb93-750a12a73326', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated By', NULL, NULL, 1,
	 'U', 'UpdatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'ef5c992f-d08a-4afe-8e76-1fb903ae3699'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f8b5c455-0cae-4424-9242-98243fc8c774', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Columns: BH_Payroll_Run_Line_Item
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tenant', NULL, NULL, 1,
	 'U', 'AD_Client_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 19, NULL, NULL, 22, '@#AD_Client_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 102,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '68470668-ed63-4da7-998a-f53f5a003882', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Organization', NULL, NULL, 1,
	 'U', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 19, NULL, NULL, 22, '@#AD_Org_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4484c783-1da3-4503-9386-4d97ebf92c8b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Run Line Item', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_Line_Item_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 13, NULL, NULL, 22, NULL, 'Y', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fe9c26e4-a436-44b3-bc0c-3401ab60ad32'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9a8e1366-0960-46dc-a6cd-2742d7c37d12', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'BH_Payroll_Run_Line_Item_UU', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_Line_Item_UU', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 200231, NULL, NULL, 36, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '4e84216b-5161-4130-9d6e-dcd002ee6d9d'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7c3a4500-9bd8-436a-889b-ac96e0bb353a', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Run Line', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_Line_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 19, NULL, NULL, 22, NULL, 'N', 'Y',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '14a251be-3a78-4199-9800-9a5c026e82a8'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'aecf13b0-660e-42c1-bcff-6405dc0b69ad', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Search Key', NULL, NULL, 1,
	 'U', 'Value', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 10, NULL, NULL, 40, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 620,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5b4b8a5f-bf37-4bd3-be2d-fa92f27733f6', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Name', NULL, NULL, 1,
	 'U', 'Name', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 10, NULL, NULL, 60, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 469,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9ded21af-bca6-4903-8385-e7260aba7c0c', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Category', NULL, NULL, 1,
	 'U', 'BH_Category', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 10, NULL, NULL, 20, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '22e63d45-f895-4c2f-9034-c279bbe478c3'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b38b39f1-2694-4350-8143-6efa62f168a0', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tax Deductible', NULL, NULL, 1,
	 'U', 'BH_IsTaxDeductible', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 20, NULL, NULL, 1, 'N', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a1cb1f6c-c56d-47f0-b09b-e00851639522'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '716fcb74-3510-468c-a392-b7ce2f2a4e34', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Employee Amount', NULL, NULL, 1,
	 'U', 'BH_EmployeeAmount', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9a7163ca-9ab7-4a80-9d25-e34271372d35'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1ba30048-84f7-4035-803d-f76399ba9670', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Employer Amount', NULL, NULL, 1,
	 'U', 'BH_EmployerAmount', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '80804632-329a-4d4b-a5eb-4de71859933a'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '86a3a42e-80c3-4738-a0e4-c468eefb1b0b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Sequence', NULL, NULL, 1,
	 'U', 'SeqNo', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 11, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 566,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '65947ef1-d961-4592-9953-28332b1e04e0', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created', NULL, NULL, 1,
	 'U', 'Created', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '23c8db4d-1dfc-4129-b2c1-bfe9b2c7c652', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created By', NULL, NULL, 1,
	 'U', 'CreatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5764298a-a63d-4766-ad2f-c733c86d8a47', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Active', NULL, NULL, 1,
	 'U', 'IsActive', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 20, NULL, NULL, 1, 'Y', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '14e2a4e9-a228-4a3a-a543-22309ae994ea', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated', NULL, NULL, 1,
	 'U', 'Updated', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0eda4723-8ff1-4eb0-93bf-b3fdb8b1d51c', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated By', NULL, NULL, 1,
	 'U', 'UpdatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '5e75159d-dfc0-4379-a39c-f60d06e05d18'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3af084f1-4f1b-4f8a-b468-db92ac1d9217', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Columns: BH_Payroll_Filing
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tenant', NULL, NULL, 1,
	 'U', 'AD_Client_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 19, NULL, NULL, 22, '@#AD_Client_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 102,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2332a9ac-e169-46ff-a6e0-1b9e991bdfd8', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Organization', NULL, NULL, 1,
	 'U', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 19, NULL, NULL, 22, '@#AD_Org_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd428dda9-7b32-4cf0-b63c-c1182c726e38', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Filing', NULL, NULL, 1,
	 'U', 'BH_Payroll_Filing_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 13, NULL, NULL, 22, NULL, 'Y', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '4e0ea5d4-7173-4c07-af44-54aa1221b1a8'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f932f544-fafd-4d85-b892-db60f446d4b0', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'BH_Payroll_Filing_UU', NULL, NULL, 1,
	 'U', 'BH_Payroll_Filing_UU', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 200231, NULL, NULL, 36, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '65423962-bf4e-4198-89a5-8a22096e1dd7'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '822a7d55-8582-49be-8ac6-f934404443ed', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Run', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 19, NULL, NULL, 22, NULL, 'N', 'Y',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dba77ebb-5202-498e-aeb3-d9ea0bc1e72d'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'aebefc59-c0bc-4a04-8eba-0e7993d57727', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Filing Type', NULL, NULL, 1,
	 'U', 'BH_FilingType', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 10, NULL, NULL, 40, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dd33a669-3325-4e3e-8e58-f45b1c9ae207'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9cd4081d-2b7c-4fe8-855e-9aa49359b4d6', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Employee Amount', NULL, NULL, 1,
	 'U', 'BH_EmployeeAmount', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9a7163ca-9ab7-4a80-9d25-e34271372d35'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '32533c34-5a12-45a7-a777-118cd0407ca5', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Employer Amount', NULL, NULL, 1,
	 'U', 'BH_EmployerAmount', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '80804632-329a-4d4b-a5eb-4de71859933a'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '806d3596-aad6-4c35-bbd6-c8dbd31ffe0b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Total Amount', NULL, NULL, 1,
	 'U', 'BH_TotalAmount', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a4bca2e1-a782-4523-9965-702120f317a2'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'bb405b2d-93c4-4682-a6b9-923b6ef62cd1', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Paid', NULL, NULL, 1,
	 'U', 'BH_IsPaid', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 20, NULL, NULL, 1, 'N', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b19defc7-0101-483a-bc51-dc4107832f89'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f719ca72-6246-48e7-8f30-f0840bc33b62', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Paid Date', NULL, NULL, 1,
	 'U', 'BH_PaidDate', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 15, NULL, NULL, 7, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '8647f94c-556b-464f-a682-7eb0960490b3'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e94527b4-0058-4e04-b7c1-f38852958bfe', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payment Reference', NULL, NULL, 1,
	 'U', 'BH_PaymentReference', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 10, NULL, NULL, 40, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f59ab8ff-9307-40b9-9e81-7fadde756906'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0c4cfc5f-47b3-4a4b-a6ec-dedd22aadc97', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created', NULL, NULL, 1,
	 'U', 'Created', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'dcce7982-179c-4927-9d39-ec76d1b66520', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created By', NULL, NULL, 1,
	 'U', 'CreatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5dd1c58d-46ed-4202-80f2-96c576b6b9b3', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Active', NULL, NULL, 1,
	 'U', 'IsActive', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 20, NULL, NULL, 1, 'Y', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'dff51ab2-acc4-4de6-93c6-77bca7c64498', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated', NULL, NULL, 1,
	 'U', 'Updated', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '147c4ca4-3713-40f6-aa00-e4d49f603442', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated By', NULL, NULL, 1,
	 'U', 'UpdatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '3e1c3559-2fea-465a-81b1-f47ea2fd435c'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'fa0b4262-7f36-4534-8755-e7e3ded8a36e', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Columns: BH_Payroll_Audit
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Tenant', NULL, NULL, 1,
	 'U', 'AD_Client_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 19, NULL, NULL, 22, '@#AD_Client_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 102,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0f8aa21b-18a8-401b-b551-a4b24a8e1364', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Organization', NULL, NULL, 1,
	 'U', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 19, NULL, NULL, 22, '@#AD_Org_ID@', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b6edf8b6-f065-4c9d-bc0d-8814a106fd34', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Audit', NULL, NULL, 1,
	 'U', 'BH_Payroll_Audit_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 13, NULL, NULL, 22, NULL, 'Y', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'be46331a-3666-4e65-bd31-fa16b7b0dd86'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6f846fe9-5576-40d4-a17f-1a430fab6f70', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'BH_Payroll_Audit_UU', NULL, NULL, 1,
	 'U', 'BH_Payroll_Audit_UU', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 200231, NULL, NULL, 36, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'cb8ec14f-ff17-43ed-a445-620cfda84378'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd1f99e73-691e-4e7b-b4fa-4bbcec1800d9', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Action Type', NULL, NULL, 1,
	 'U', 'BH_ActionType', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 10, NULL, NULL, 30, NULL, 'N', 'N',
	 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b7f103ff-d93c-4e88-ade1-40d082d66846'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd8b4e7e2-67a1-48bc-ad5c-24be8f794c6c', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Detail', NULL, NULL, 1,
	 'U', 'BH_Detail', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 14, NULL, NULL, 2000, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '97baa6bd-6817-4f63-8938-96102bc3d39d'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f82d4d18-3a10-45be-8ca5-ee96ecc97a59', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Role', NULL, NULL, 1,
	 'U', 'AD_Role_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 19, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 123,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6858b004-9b9c-478f-a94d-d35a4b0391bd', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Employee', NULL, NULL, 1,
	 'U', 'HR_Employee_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 19, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 53391,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f00b8e81-fda2-44c2-95f8-a25b18315367', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Payroll Run', NULL, NULL, 1,
	 'U', 'BH_Payroll_Run_ID', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 19, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dba77ebb-5202-498e-aeb3-d9ea0bc1e72d'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e735f935-c7d4-4379-86ee-08cfd99b4ab0', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created', NULL, NULL, 1,
	 'U', 'Created', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '77f2fb34-13f7-428e-9f99-ba74dbb89baa', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Created By', NULL, NULL, 1,
	 'U', 'CreatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1887c1b4-eaa5-44f2-8e38-e47b20ab9176', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Active', NULL, NULL, 1,
	 'U', 'IsActive', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 20, NULL, NULL, 1, 'Y', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5d2979bd-840d-439c-bd69-e3e2c8550528', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated', NULL, NULL, 1,
	 'U', 'Updated', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '60db214f-3ad9-4ec2-9380-5c59bb524805', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Updated By', NULL, NULL, 1,
	 'U', 'UpdatedBy', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '297e3cbb-f2fb-4496-8161-8d69c275660b'), 30, 110, NULL, 22, NULL, 'N', 'N',
	 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9c4365a9-c519-4dfe-82f8-b7c0896acaf5', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Columns: the eight BH_ additions on core HR_Employee (EntityType U on a core table)
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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'KRA PIN', NULL, NULL, 1,
	 'U', 'BH_KRA_PIN', (SELECT ad_table_id FROM ad_table WHERE tablename = 'HR_Employee'), 10, NULL, NULL, 20, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '58468c21-00bd-4013-a3b1-a4dd5b8a90ad'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '11565720-08b0-4b50-a0da-7fc5411e9e65', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'SHIF Number', NULL, NULL, 1,
	 'U', 'BH_SHIF_Number', (SELECT ad_table_id FROM ad_table WHERE tablename = 'HR_Employee'), 10, NULL, NULL, 20, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '14a72ef7-e9fc-4c92-85e5-1f902917d97d'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ce85675e-1131-4dba-8a72-7d1338c1139b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Bank Name', NULL, NULL, 1,
	 'U', 'BH_BankName', (SELECT ad_table_id FROM ad_table WHERE tablename = 'HR_Employee'), 10, NULL, NULL, 60, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '39e4ad3c-ce47-4fe5-9ce8-4558fd2bfe68'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'feab552f-e68e-45e5-9060-4132145d9fb0', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Bank Branch', NULL, NULL, 1,
	 'U', 'BH_BankBranch', (SELECT ad_table_id FROM ad_table WHERE tablename = 'HR_Employee'), 10, NULL, NULL, 60, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '6869bf46-1197-4720-8005-cbcb8239f902'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cf4e4de1-c3cc-4acf-8202-ebb74485ea82', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Bank Account', NULL, NULL, 1,
	 'U', 'BH_BankAccount', (SELECT ad_table_id FROM ad_table WHERE tablename = 'HR_Employee'), 10, NULL, NULL, 34, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bf2c663c-8046-43b2-8fb9-68d88d6e2f24'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '96a46318-040a-4a99-b528-aa5b7f0ce29c', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Basic Salary', NULL, NULL, 1,
	 'U', 'BH_BasicSalary', (SELECT ad_table_id FROM ad_table WHERE tablename = 'HR_Employee'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '0b8e64cb-2b5d-499d-876a-5deafd5865ff'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8948c449-b04b-4c91-a902-58725178bb2e', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'House Allowance', NULL, NULL, 1,
	 'U', 'BH_HouseAllowance', (SELECT ad_table_id FROM ad_table WHERE tablename = 'HR_Employee'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ff548ca4-98ae-45cb-88a2-9d251bdb58ee'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd1472edd-8b6c-4e75-bd0d-08127e050139', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-09 16:00:00', '2026-07-09 16:00:00', 100, 100, 'Transport Allowance', NULL, NULL, 1,
	 'U', 'BH_TransportAllowance', (SELECT ad_table_id FROM ad_table WHERE tablename = 'HR_Employee'), 12, NULL, NULL, 22, '0', 'N', 'N',
	 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b3cd4fe8-74a9-4295-844d-1e9434eb9fc5'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '49853c85-5b9a-4d48-88c5-3c4cdfa9837d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Window 'Payroll' (no tabs; cf. 'Pharmacy Sales (OTC)', GO-2039)
INSERT INTO
	ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	           help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight,
	           winwidth, isbetafunctionality, ad_window_uu, titlelogic, predefinedcontextvariables)
VALUES
	((SELECT MAX(ad_window_id) + 1 FROM ad_window), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100, 'Payroll',
	 'Manage payroll: employees, statutory components, runs, payslips and filings', NULL, 'T',
	 'Y', 'U', 'N', NULL, NULL, 'N', 0, 0, 'N', '7c6d8045-50e0-4e60-8e4c-96b17cbf57f1', NULL, NULL);

-- Menu entry under the Banda 'Accounting' summary node (Greenlight Client Menu)
INSERT INTO
	ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description,
	         issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id,
	         ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
	         predefinedcontextvariables)
VALUES
	((SELECT MAX(ad_menu_id) + 1 FROM ad_menu), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 'Payroll', 100, NULL, 'N', 'Y',
	 'N', 'W', (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '7c6d8045-50e0-4e60-8e4c-96b17cbf57f1'),
	 NULL, NULL, NULL, NULL, NULL, 'U', 'Y', 'd84b9ce3-a009-4df4-a335-c94d316b33f3', NULL, NULL, NULL);

INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'd84b9ce3-a009-4df4-a335-c94d316b33f3'), 0, 0, 'Y', '2026-07-09 16:00:00', 100, '2026-07-09 16:00:00', 100,
	 (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eba1cdd4-5475-4529-beed-0e63d9a88357'), 99,
	 '746afcc6-600b-49b8-bfa6-bcec9c1b7078');

-- Window access: Clinic Admin + Accounting master roles ONLY (standard role matrix; house
-- pattern GO-3305/GO-3561 — grants are made against the master role UUs, idempotently).
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu)
SELECT
	w.ad_window_id, r.ad_role_id, 0, 0, 'Y', NOW(), 100, NOW(), 100, 'Y', uuid_generate_v4()
FROM
	ad_window w
		JOIN ad_role r ON r.ad_role_uu IN (
			'461b31c5-cae2-449d-8a0c-7385b12f4685', -- Clinic Admin (sheet) = 'Clinical Admin' (DB)
			'93365778-a2d9-433b-b962-87fb150db4fa' -- Accounting
		)
WHERE
	w.ad_window_uu = '7c6d8045-50e0-4e60-8e4c-96b17cbf57f1'
	AND NOT EXISTS (
		SELECT 1 FROM ad_window_access x WHERE x.ad_window_id = w.ad_window_id AND x.ad_role_id = r.ad_role_id
	);

SELECT update_sequences();

-- ============================================================================
-- GraphQL template registration + statutory component catalogue (Task 4)
-- ============================================================================

-- Register the nine BH_ payroll tables for GraphQL generation (idempotent; HR_Employee's
-- GraphQL stack is already generated and wired — phase 2 hand-adds its new BH_ fields).
UPDATE bh_graphqlgeneratortemplate
SET
	tablename = REGEXP_REPLACE(
		tablename,
		'''BH_Feature_Flag_Rule''',
		'''BH_Feature_Flag_Rule'',''BH_Payroll_Settings'',''BH_Payroll_Component'',''BH_PAYE_Band'',''BH_Employee_Component'',''BH_Payroll_Run'',''BH_Payroll_Run_Line'',''BH_Payroll_Run_Line_Item'',''BH_Payroll_Filing'',''BH_Payroll_Audit''',
		'i'
	)
WHERE
	bh_graphqlgeneratortemplate_uu = '0b9c9d6a-6e59-4ba4-995a-6762c9effe03'
	AND tablename NOT ILIKE '%BH_Payroll_Run%';

-- HR_Employee.HR_Department_ID / HR_Job_ID are mandatory — a constraint inherited from core
-- HR_Employee, not a feature we expose. Every clinic gets a 'Standard' default of each (house
-- convention for placeholder defaults). Idempotent by (client, name); clients created later
-- are handled by the phase-2 employee save.
INSERT INTO hr_department (hr_department_id, hr_department_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, name)
SELECT (SELECT COALESCE(MAX(hr_department_id), 1000000) FROM hr_department) + ROW_NUMBER() OVER (ORDER BY c.ad_client_id),
	uuid_generate_v4(), c.ad_client_id, 0, 'Y', getDate(), 100, getDate(), 100, 'Standard'
FROM ad_client c
WHERE c.ad_client_id > 0 AND c.isactive = 'Y'
	AND NOT EXISTS (SELECT 1 FROM hr_department d WHERE d.ad_client_id = c.ad_client_id AND d.name = 'Standard');

INSERT INTO hr_job (hr_job_id, hr_job_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, name)
SELECT (SELECT COALESCE(MAX(hr_job_id), 1000000) FROM hr_job) + ROW_NUMBER() OVER (ORDER BY c.ad_client_id),
	uuid_generate_v4(), c.ad_client_id, 0, 'Y', getDate(), 100, getDate(), 100, 'Standard'
FROM ad_client c
WHERE c.ad_client_id > 0 AND c.isactive = 'Y'
	AND NOT EXISTS (SELECT 1 FROM hr_job j WHERE j.ad_client_id = c.ad_client_id AND j.name = 'Standard');

-- System component catalogue (AD_Client_ID = 0). Codes are stable machine keys (column: Value).
-- A new statutory levy later = one more row here or in a follow-up seed migration — no DDL.
-- Deductibility per TLAA 2024 (verified against a real 2026 payslip): NSSF/SHIF/HLEVY/PENSION
-- reduce taxable income (pension capped at 30,000/month); SACCO and LOAN do not.
-- BH_FilingDueDay = day of the following month the remittance is due (compliance banner).
INSERT INTO bh_payroll_component (ad_client_id, ad_org_id, bh_payroll_component_id, bh_payroll_component_uu,
	value, name, bh_category, bh_calcmethod, bh_rate, bh_floor, bh_cap, bh_tier1_limit, bh_tier2_limit,
	bh_employerrate, bh_istaxdeductible, bh_taxdeductiblecap, bh_isstatutory, bh_filingdueday, seqno, validfrom,
	createdby, updatedby)
SELECT 0, 0, (SELECT COALESCE(MAX(bh_payroll_component_id), 1000000) FROM bh_payroll_component) + c.seq,
	c.uu, c.value, c.name, c.cat, c.method, c.rate, c.flr, c.cap, c.t1, c.t2, c.emprate,
	c.taxded, c.taxdedcap, c.stat, c.dueday, c.seq * 10, c.validfrom::timestamp, 100, 100
FROM (VALUES
	-- statutory, effective 2024-07-01 (SHIF live; Housing Levy in force; NSSF Year 3)
	(1,  'efc0adcc-3b5c-4890-ae3a-a3bd485f97d2', 'NSSF',            'NSSF',                    'STAT_DED',         'TIERED',           6::numeric,    NULL::numeric, NULL::numeric, 8000::numeric, 72000::numeric, 6::numeric,    'Y', NULL::numeric, 'Y', 9::numeric,    '2024-07-01'),
	(2,  '2a636948-36a9-41df-b60e-6c9433762e96', 'SHIF',            'SHIF',                    'STAT_DED',         'PERCENT_OF_GROSS', 2.75,          300,           NULL,          NULL,          NULL,           NULL,          'Y', NULL,          'Y', 9,             '2024-07-01'),
	(3,  'df088005-19e8-4ce0-b727-8ee04e0b7e52', 'HLEVY',           'Housing Levy',            'STAT_DED',         'PERCENT_OF_GROSS', 1.5,           NULL,          NULL,          NULL,          NULL,           1.5,           'Y', NULL,          'Y', 9,             '2024-07-01'),
	(4,  '4a1486cc-e4bb-4467-80c5-92a44ccb9fb2', 'NITA',            'NITA Levy',               'EMPLOYER_CONTRIB', 'FIXED',            50,            NULL,          NULL,          NULL,          NULL,           NULL,          'N', NULL,          'Y', 9,             '2024-07-01'),
	(5,  'a804f404-80e3-450e-9e89-d1cc510fae78', 'PERSONAL_RELIEF', 'Monthly Personal Relief', 'RELIEF',           'FIXED',            2400,          NULL,          NULL,          NULL,          NULL,           NULL,          'N', NULL,          'N', NULL::numeric, '2024-07-01'),
	(6,  'ee37c7c7-32b6-4cbb-81d3-5df19945d202', 'PAYE',            'PAYE (income tax)',       'STAT_DED',         'BANDS',            NULL,          NULL,          NULL,          NULL,          NULL,           NULL,          'N', NULL,          'Y', 9,             '2024-07-01'),
	-- NSSF Year 4 (official notice, effective 2026-02-01): only the tier limits change
	(7,  '64b35a88-8fac-4918-b773-718f56ad372e', 'NSSF',            'NSSF',                    'STAT_DED',         'TIERED',           6,             NULL,          NULL,          9000,          108000,         6,             'Y', NULL,          'Y', 9,             '2026-02-01'),
	-- voluntary templates (amounts come from BH_Employee_Component assignments)
	(8,  '55a5b024-7b63-4bc8-891c-ac82de4320f1', 'SACCO',           'Sacco',                   'VOL_DED',          'EMPLOYEE_AMOUNT',  NULL,          NULL,          NULL,          NULL,          NULL,           NULL,          'N', NULL,          'N', NULL,          '2024-07-01'),
	(9,  '227a6562-a3bd-4304-9c76-182e73c08ae1', 'PENSION',         'Voluntary Pension',       'VOL_DED',          'EMPLOYEE_AMOUNT',  NULL,          NULL,          NULL,          NULL,          NULL,           NULL,          'Y', 30000,         'N', NULL,          '2024-07-01'),
	(10, '744795cf-6169-4136-af38-f770e08480a6', 'LOAN',            'Loan Repayment',          'VOL_DED',          'EMPLOYEE_AMOUNT',  NULL,          NULL,          NULL,          NULL,          NULL,           NULL,          'N', NULL,          'N', NULL,          '2024-07-01')
) AS c(seq, uu, value, name, cat, method, rate, flr, cap, t1, t2, emprate, taxded, taxdedcap, stat, dueday, validfrom)
WHERE NOT EXISTS (SELECT 1 FROM bh_payroll_component x WHERE x.bh_payroll_component_uu = c.uu);

-- PAYE bands (10/25/30/32.5/35; NULL upper limit = top band), children of the PAYE component
INSERT INTO bh_paye_band (ad_client_id, ad_org_id, bh_paye_band_id, bh_paye_band_uu, bh_payroll_component_id,
	seqno, bh_upperlimit, bh_rate, createdby, updatedby)
SELECT 0, 0, (SELECT COALESCE(MAX(bh_paye_band_id), 1000000) FROM bh_paye_band) + b.seq, b.uu,
	(SELECT bh_payroll_component_id FROM bh_payroll_component WHERE ad_client_id = 0 AND value = 'PAYE'),
	b.seq * 10, b.upperlimit, b.rate, 100, 100
FROM (VALUES
	(1, 'f6367849-98b7-4a8d-8893-7067eac8635b', 24000::numeric,  10::numeric),
	(2, 'a51f2962-d0df-4762-97ff-15fde615a3fe', 32333::numeric,  25::numeric),
	(3, '34451131-d3d3-47c3-babd-04cb7b53ed23', 500000::numeric, 30::numeric),
	(4, 'c032c413-88a7-4180-926f-ea5540c4cace', 800000::numeric, 32.5::numeric),
	(5, '0993361e-c52b-4d86-ad1b-8922fdc27cbe', NULL::numeric,   35::numeric)
) AS b(seq, uu, upperlimit, rate)
WHERE NOT EXISTS (SELECT 1 FROM bh_paye_band WHERE bh_paye_band_uu = b.uu);

SELECT register_migration_script('202607090900_GO-3624.sql') FROM dual;
