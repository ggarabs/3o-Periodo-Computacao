# Lab 1 - Exercicio 04

# Anderson Correa Nicodemo 	- 3221536-6
# Felipe do Nascimento Fonseca 	- 4221536-6
# Gustavo Garabetti Munhoz	- 4221195-6
# Giovanni Alves Lavia 		- 4221836-5

.data
	msgRecebeSenha: .asciiz "Digite a senha: "
	msgAcerto: .asciiz "Acesso concedido!\n"
	msgErro: .asciiz "Acesso negado!"
	msgTent: .asciiz "Você tem mais "
	Tent: .asciiz " tentativas\n\n"
	msgBloqueio: .asciiz "Tentativas Finalizadas.\nAcesso Bloqueado.\n"
	lineFeed: .asciiz "\n"
	senhaCorreta: .word 12345 # Senha pré-definida
	
.text
	# Carregar a senha correta para o registrador s1
	lw $s1, senhaCorreta
	
	# Definir o conteúdo do registrador t2 como 3, que é o número de tentativas possíveis
	move $t2, $zero
	addu $t2, $t2, 3

	RecebeSenha:
	
	li $v0, 4
	la $a0, msgRecebeSenha
	syscall
	
	li $v0, 5
	syscall
	
	# Mover a senha lida para o registrador t0
	move $t0, $v0

	# Operação de verificação da compatibilidade da senha
	xor $t1, $t0, $s1
	
	# Se as senhas não coincidem, pule para o segmento Errou
	bne $t1, 0, Errou

	Acertou: 
		li $v0, 4
		la $a0, msgAcerto
		syscall
		
		# Após exibir a mensagem de acerto, pule para o segmento Sair
		j Sair
		
	Errou:
		li $v0, 4
		la $a0, msgErro
		syscall
		
		# Após exibir a mensagem de erro, decremente o conteúdo de t2.
		subu $t2, $t2, 1
		
		# Se o número de tentativas for nulo, pule para o segmento de bloqueio
		beqz $t2, Bloqueio
				
		li $v0, 4
		la $a0, msgTent
		syscall
		
		li $v0, 1
		move $a0, $t2
		syscall
		
		li $v0, 4
		la $a0, Tent
		syscall
		
		# Se nenhuma das condições for válida, então leia outra senha
		j RecebeSenha
		
	Bloqueio:
		li $v0, 4
		la $a0, msgBloqueio
		syscall
		
	Sair:
		li $v0, 10
		syscall