.name "nim27"
.comment "I'm a new champion"

l1:		sti r1, %:live, %1
		fork %:l2
		xor	r0, r0, r0

live:	live %1
		live %1
		live %1
		zjmp %:live

l2:		st r1, 6
		add r2, r3, r2
		sub	r12, r8, r12
		zjmp %:l1
