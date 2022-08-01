-- Rename the windows
UPDATE ad_window SET name = 'Visits/Bills' WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77';
UPDATE ad_window SET name = 'Suppliers' WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27';
UPDATE ad_window SET name = 'Products & Prices' WHERE ad_window_uu = 'c63b9972-1b23-4140-8bbb-0ea2b0b81024';
UPDATE ad_window SET name = 'Services & Prices' WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758';
UPDATE ad_window SET name = 'Manage Inventory' WHERE ad_window_uu = '8f744d1c-427a-4b85-ab98-38e50258e86d';
UPDATE ad_window SET name = 'Debt Payments' WHERE ad_window_uu = '4497b5f7-758d-4e82-8e2b-01c4364ce609';

SELECT register_migration_script('202207211325_GO-2400.sql') FROM dual;
