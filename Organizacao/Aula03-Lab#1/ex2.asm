.data
	Idade_minima: .word 18
	Pergunta_idade: .asciiz "Sua Idade: "
    	Pergunta_doenca: .asciiz "Voce tem alguma doenca?\n"
    	Resp1: .asciiz "1. Nao\n"
    	Resp2: .asciiz "2. Sim\n"
    	Nao: .word 1
    	Sim: .word 2
    	Pode_doar: .asciiz "Voce pode doar sangue!"
    	Nao_pode: .asciiz "Voce nao pode doar sangue, pois esta doente"
    	Mensagem_menor: .asciiz "Voce precisa ter 18 anos ou mais para doar sangue"
    	Sua_resp: .asciiz "Sua resposta: "

.text
    	li $v0, 4
    	la $a0, Pergunta_idade
	syscall
    
	li $v0, 5
	syscall
    
	move $s0, $v0
	
	lw $t0, Idade_minima #Passa a variavel de idade minima
	bge $s0, $t0, Maior_de_idade #Se for maior ou igual a 18 continua para bloco maior de idade, se nao vai para o final
	
	li $v0, 4
	la $a0, Mensagem_menor #Apresenta mensagem de menor de idade
	syscall
	
	j Final #Pula para o final

Maior_de_idade: 

	li $v0, 4
	la $a0, Pergunta_doenca
	syscall
    
    	li $v0, 4
	la $a0, Resp1
	syscall
	
	li $v0, 4
	la $a0, Resp2
	syscall
	
	li $v0, 4
	la $a0, Sua_resp
	syscall
	
	li $v0, 5
	syscall

	move $s1, $v0
		
	lw $t0, Nao #Passa a variavel da opcao 1
	lw $t1, Sim #Passa a variavel da opcao 2
	
	beq $t0, $s1, pode_doar
	beq $t1, $s1, nao_pode_doar

pode_doar: 

	li $v0, 4
	la $a0, Pode_doar
	syscall
	
	j Final
    
nao_pode_doar: 

	li $v0, 4
	la $a0, Nao_pode
	syscall
	
	j Final
	
Final: 

	li $v0, 10
	syscall