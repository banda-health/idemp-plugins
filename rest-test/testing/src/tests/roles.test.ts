import { roleApi } from '../api';
import { Role } from '../types/org.bandahealth.idempiere.rest';

const roleUuid = { MUST_HAVES: 'baec9412-d994-4313-815c-31332357863a' } as const;

test('role can be created and adjusted', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create role';
	let role = await roleApi.save(valueObject, {
		includedRoles: [],
		isMasterRole: false,
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		isActive: true,
	} as Partial<Role> as Role);
	expect(role).toBeTruthy();
	expect(role.includedRoles).toHaveLength(0);
	expect(role.isMasterRole).toBe(false);

	valueObject.stepName = 'Add included roles';
	const masterRoles = (
		await roleApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ismasterrole: true }))
	).results;
	expect(masterRoles.length > 1).toBeTruthy();
	role = await roleApi.save(valueObject, { ...role, includedRoles: [masterRoles[0], masterRoles[1]] });
	expect(role).toBeTruthy();
	expect(role.includedRoles).toHaveLength(2);

	valueObject.stepName = 'Remove included roles';
	role = await roleApi.save(valueObject, { ...role, includedRoles: [] });
	expect(role).toBeTruthy();
	expect(role.includedRoles).toHaveLength(0);
});

test('properties set correctly', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Get master roles';
	const masterRoles = (
		await roleApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ismasterrole: true }))
	).results;
	expect(masterRoles.every((role) => role.isMasterRole === true)).toBeTruthy();

	valueObject.stepName = 'Create role';
	await roleApi.save(valueObject, {
		includedRoles: [],
		isMasterRole: false,
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		isActive: true,
	} as Partial<Role> as Role);

	valueObject.stepName = 'Get regular roles';
	const regularRoles = (
		await roleApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ismasterrole: false }))
	).results;
	expect(regularRoles.every((role) => role.isMasterRole === false)).toBeTruthy();
});

test('complex role filtering works', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Get role complexly';
	const masterRoles = (
		await roleApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ ismasterrole: true, ad_role_uu: { $neq: roleUuid.MUST_HAVES } }),
		)
	).results;
	expect(masterRoles.length > 2).toBeTruthy();
	const roleUuidsWeWillUse = [masterRoles[0].uuid, masterRoles[1].uuid, roleUuid.MUST_HAVES];
	const complexFilter = {
		$not: [
			{
				'ad_role_included.ad_role::included_role_id.ad_role_uu': {
					$in: masterRoles
						.filter((masterRole) => !roleUuidsWeWillUse.includes(masterRole.uuid))
						.map((masterRole) => masterRole.uuid),
				},
			},
		],
	} as any;
	complexFilter.$and = roleUuidsWeWillUse.map((roleUuid) => ({
		'ad_role_included.ad_role::included_role_id.ad_role_uu': { $eq: roleUuid },
	}));
	const initialRoleQueryResults = (
		await roleApi.get(valueObject, undefined, undefined, undefined, JSON.stringify(complexFilter))
	).results;
	expect(initialRoleQueryResults.every((role) => role.includedRoles.length === roleUuidsWeWillUse.length)).toBeTruthy();

	valueObject.stepName = 'Create role-matching, complex query';
	const role = await roleApi.save(valueObject, {
		includedRoles: roleUuidsWeWillUse.map((roleUuid) => ({ uuid: roleUuid } as Partial<Role> as Role)),
		isMasterRole: false,
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		isActive: true,
	} as Partial<Role> as Role);
	expect(role).toBeTruthy();
	expect(role.includedRoles.length).toBe(roleUuidsWeWillUse.length);

	expect(
		(await roleApi.get(valueObject, undefined, undefined, undefined, JSON.stringify(complexFilter))).results.length,
	).toBe(initialRoleQueryResults.length + 1);

	const secondComplexFilter = {
		$not: [
			{
				'ad_role_included.ad_role::included_role_id': {
					ad_role_uu: {
						$in: masterRoles
							.filter((masterRole) => !roleUuidsWeWillUse.includes(masterRole.uuid))
							.map((masterRole) => masterRole.uuid),
					},
				},
			},
		],
	} as any;
	secondComplexFilter.$and = roleUuidsWeWillUse.map((roleUuid) => ({
		'ad_role_included.ad_role::included_role_id': { ad_role_uu: { $eq: roleUuid } },
	}));
	const secondQueryResults = (
		await roleApi.get(valueObject, undefined, undefined, undefined, JSON.stringify(secondComplexFilter))
	).results;
	expect(secondQueryResults.every((role) => role.includedRoles.length === roleUuidsWeWillUse.length)).toBeTruthy();
	expect(secondQueryResults.length).toBe(initialRoleQueryResults.length + 1);
});
