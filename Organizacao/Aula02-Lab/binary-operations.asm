.data
	msg1: .asciiz "Digite o primeiro número: "
	msg2: .asciiz "Digite o segundo número: "
	msgAnd: .asciiz "Resultado do bitwise AND: "
	msgOr: .asciiz "Resultado do bitwise OR: "
	msgXor: .asciiz "Resultado do bitwise XOR: "
	lineFeed: .asciiz "\n"

.text
	#PRIMEIRA MENSAGEM
	li $v0, 4
	la $a0, msg1
	syscall
	
	li $v0, 5
	syscall

	move $t0, $v0
			
	#SEGUNDA MENSAGEM
	li $v0, 4
	la $a0, msg2
	syscall
	
	li $v0, 5
	syscall
	
	move $t1, $v0
	
	#OPERAÇÃO AND
	and $t2, $t0, $t1
	
	#MENSAGEM DO AND
	li $v0, 4
	la $a0, msgAnd
	syscall
		
	li $v0, 1
	move $a0, $t2
	syscall	
	
	li $v0, 4
	la $a0, lineFeed
	syscall
	
	#OPERAÇÃO OR
	or $t2, $t0, $t1
	
	#MENSAGEM DO OR
	li $v0, 4
	la $a0, msgOr
	syscall
	
	li $v0, 1
	move $a0, $t2
	syscall
	
	li $v0, 4
	la $a0, lineFeed
	syscall
	
	#OPERAÇÃO XOR
	xor $t2, $t0, $t1
	
	#MENSAGEM XOR
	li $v0, 4
	la $a0, msgXor
	syscall
	
	li $v0, 1
	move $a0, $t2
	syscall
	
	li $v0, 4
	la $a0, lineFeed
	syscall

	#FIM DO PROGRAMA
	li $v0, 10
	syscall
	