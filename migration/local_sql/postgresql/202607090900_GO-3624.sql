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
