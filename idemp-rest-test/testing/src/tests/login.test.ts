test('can login', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	expect(globalThis.__VALUE_OBJECT__.errorMessage).toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.client).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.organization).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.role).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.warehouse).not.toBeFalsy();
});

export {};
