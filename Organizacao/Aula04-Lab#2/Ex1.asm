.data 
	vetor: .word 2, -5, 12, 7, -3, 99, 8, 54, 21, -45, 67, 61, 55
	tamanho: .word 13 
	colchete: .asciiz  "]\n"
	virgula: .asciiz ", "
	saidaA: .asciiz "O vetor original é: ["
	saidaB: .asciiz "O maior elemento do vetor é: "
	saidaC: .asciiz "\nO menor elemento do vetor é: "
	saidaD: .asciiz "\nA média dos elementos do vetor é: "
	saidaE: .asciiz "\nDigite um número: "
	encontrado: .asciiz "Número encontrado no vetor"
	naoEncontrado: .asciiz "Número não encontrado no vetor"
	
.text
	j main
	
	imprime_original: #  Imprimir o vetor original
	
	move $t9, $ra
	jal carrega # carrega o vetor ($s0) e tamanho ($t0)

	li $v0, 4
	la $a0, saidaA
	syscall
	
	loop:
	
	lw $s1, 0($s0)
			
	li $v0, 1
	move $a0, $s1
	syscall
	
	add $s0, $s0, 4
	add $t1, $t1, 1
	
	beq $t1, $t0, fim_loop
			
	li $v0, 4
	la $a0, virgula
	syscall
		
	j loop
	
	fim_loop:
	
	li $v0, 4
	la $a0, colchete
	syscall
	
	jr $t9
	
	imprime_maior: # Encontrar e imprimir o maior elemento dentro do vetor
	
	move $t9, $ra
	jal carrega # carrega o vetor ($s0) e tamanho ($t0)
	
	lw $t3, 0($s0)
	
	# while( $t1 < tamanho )
	while_01:
	addi $s0, $s0, 4
	lw $t2, 0($s0)
	bge $t3, $t2, final_while01
	
	move $t3, $t2
	
	final_while01:
	addi $t1, $t1, 1
	blt $t1, $t0, while_01
	
	li $v0, 4
	la $a0, saidaB
	syscall
	
	li $v0, 1
	move $a0, $t3
	syscall
	
	jr $t9
	
	
	imprime_menor: # Encontrar e imprimir o menor elemento dentro do vetor
	
	move $t9, $ra
	jal carrega # carrega o vetor ($s0) e tamanho ($t0)
	
	lw $t3, 0($s0)
	
	# while( $t1 < tamanho )
	while_02:
	addi $s0, $s0, 4
	lw $t2, 0($s0)
	ble $t3, $t2, final_while02
	
	move $t3, $t2
	
	final_while02:
	addi $t1, $t1, 1
	blt $t1, $t0, while_02
	
	li $v0, 4
	la $a0, saidaC
	syscall
	
	li $v0, 1
	move $a0, $t3
	syscall
	
	jr $t9
	
	imprime_media: # Calcular e imprimir a média dos elementos do vetor
	
	move $t9, $ra
	jal carrega # carrega o vetor ($s0) e tamanho ($t0)
	
	lw $t3, 0($s0)
	
	# while( $t1 < tamanho )
	while_03:
	addi $s0, $s0, 4
	lw $t2, 0($s0)
	add $t3, $t3, $t2
	
	#final do while
	addi $t1, $t1, 1
	blt $t1, $t0, while_03
	
	li $v0, 4
	la $a0, saidaD
	syscall
	
	mtc1 $t3, $f3 
	cvt.s.w $f3, $f3
	mtc1 $t0, $f0
	cvt.s.w $f0, $f0
		
	li $v0, 2
	div.s $f12, $f3, $f0
	syscall
	
	jr $t9
	
	verifica_elemento: # Verificar se um elemento está presente no vetor
	
	move $t9, $ra
	jal carrega # carrega o vetor ($s0) e tamanho ($t0)
	addi $t0, $t0, 1
	
	lw $t3, 0($s0)
	
	li $v0, 4
	la $a0, saidaE
	syscall
	
	li $v0, 5
	syscall
	
	# while( $t1 < tamanho )
	while_04:
	beq $v0, $t3, Achou
	addi $s0, $s0, 4
	lw $t3, 0($s0)
	
	#final do while
	addi $t1, $t1, 1
	blt $t1, $t0, while_04
	
	li $v0, 4
	la $a0, naoEncontrado
	syscall
	
	jr $t9
	
	Achou:
	
	li $v0, 4
	la $a0, encontrado
	syscall
	
	jr $t9
	
	
	carrega: # carrega as variaveis para evitar que estejam manipuladas ao começo de cada função
	
	la $s0, vetor
	lw $t0, tamanho
	li $t1, 0
	
	jr $ra
	
	main:
	
	jal imprime_original
	jal imprime_maior
	jal imprime_menor
	jal imprime_media
	jal verifica_elemento
	
	li $v0, 10
	syscall 