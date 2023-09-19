.data
Notas_Alunos:		.space 40	#Memoria alocada para notas (vetor de 10 elementos x 4 bytes de cada nota)
Contador_Aprovados:	.word 0	#Contador de alunos aprovados
Contador_Reprovados:	.word 0	#Contador de alunos repovados
Contador_Zeros:	.word 0	#Contador de alunos zerados
#Mensagens de sistema:
Msg_Solicitar:	.asciiz "Digite a nota do aluno: "
Msg_Notas:	.asciiz "\nNotas dos alunos: "
Msg_Aprovados:	.asciiz "\nA quantidade de alunos aprovados: "
Msg_Reprovados:	.asciiz "\nA quantidade de alunos reprovados: "
Msg_Zerados:	.asciiz "\nA quantidade de alunos com nota igual a zero: "
Simbolo_Chave1:	.asciiz "Vetor de notas: ["
Simbolo_Chave2:	.asciiz "]"
Virgula:	.asciiz ", "

.text
Main:
    #Inicializa o programa
    li $t0, 0             #Registrador para guardar o índice vetor de notas que inicia em 0
    li $t1, 10            #Quantidade de alunos
    la $t2, Notas_Alunos  #Endereço do vetor de notas
    li $t3, 6             #Variavel de quem foi aprovado (maior que 6) para comparação

Solicitar_Notas_Dos_Alunos:
    #Solicita a nota do usuário
    li $v0, 4
    la $a0, Msg_Solicitar  #Carrega a mensagem de inserir nota
    syscall
    
    li $v0, 5              #ler um inteiro (nota)
    syscall
    
    #Guarda a nota no vetor de notas
    sw $v0, 0($t2)
    
    #Verifica se a nota é zero se for vai para o bloco de zeros
    beqz $v0, Notas_Zeradas
    
    #Verifica se a nota é maior ou igual a 6 (está aprovado)
    bge $v0, $t3, Notas_Aprovadas
    
    #Se não, é reprovado
    j Notas_Reprovadas
 
#Label de alunos aprovados   
Notas_Aprovadas:
    lw $t4, Contador_Aprovados    #Carrega o contador e alunos aprovados
    addi $t4, $t4, 1       	   #Incrementa a contagem se o aluno foi aprovado
    sw $t4, Contador_Aprovados    #Guarda a nova contagem
    j Proximo_Aluno

#Label de alunos zerados
Notas_Zeradas:
    lw $t4, Contador_Zeros     #Carrega o contador de alunos com nota zero
    addi $t4, $t4, 1           #Incrementa a contagem se ele tirou 0
    sw $t4, Contador_Zeros     #Guarda a nova contagem
    
    #Se ele tirou 0 está reprovado também:
    lw $t4, Contador_Reprovados   #Carrega o contador de alunos reprovados
    addi $t4, $t4, 1              #Incrementa a contagem se ele foi reprovado
    sw $t4, Contador_Reprovados   #Guarda a nova contagem
    j Proximo_Aluno

#Label de alunos reprovados
Notas_Reprovadas:
    lw $t4, Contador_Reprovados   #Carrega o contador de alunos reprovados
    addi $t4, $t4, 1              #Incrementa a contagem se ele foi reprovado
    sw $t4, Contador_Reprovados   #Guarda a nova contagem

#Label para passar para o proximo aluno do vetor
Proximo_Aluno:
    addi $t0, $t0, 1       #Incrementa o índice no vetor de notas
    addi $t2, $t2, 4       #Vai para a próxima posição do vetor de notas adicionando 4 bytes de memoria
    addi $t1, $t1, -1      #Decrementa o contador de alunos
    
    bnez $t1, Solicitar_Notas_Dos_Alunos  #Loop para solicitar a nota dos alunos

    #Imprime o vetor de notas
    li $v0, 4          
    la $a0, Simbolo_Chave1  #Carrega e imprime a mensagem "vetor de notas: ["
    syscall
    
    la $t2, Notas_Alunos    #Carrega o endereço de memoria do vetor de notas em $t2
    li $t1, 10              #Quantidade total de alunos

#Imprime as notas do vetor    
Imprimir_Notas:
    lw $a0, 0($t2)          #Carrega a nota do vetor em $a0
    li $v0, 1               #Imprime um inteiro
    syscall
    
    addi $t2, $t2, 4        #Avança para a próxima nota/elemento no vetor
    addi $t1, $t1, -1       #Decrementa no contador de alunos
    
    bnez $t1, Imprimir_Virgula #Verifica se é a última nota se não continua
    
    #Imprime o vetor de notas
    li $v0, 4               #Código ara imprimir string
    la $a0, Simbolo_Chave2  #Carrega a mensagem em $a0
    syscall
    
    j Imprimir_Aprovados    #Volta para imprimir os aprovados

#Imprime a virgula para separar os elementos do vetor
Imprimir_Virgula:
    li $v0, 4               
    la $a0, Virgula         #Carrega e imprime a virgula
    syscall
    
    j Imprimir_Notas

#Imprime a quantidade de alunos aprovados    
Imprimir_Aprovados:
    li $v0, 4             
    la $a0, Msg_Aprovados  #Imprime uma mensagem de alunos aprovados
    syscall
    
    lw $a0, Contador_Aprovados     #Carrega a quantidade de alunos aprovados em $a0
    li $v0, 1               	    #Imprime o inteiro
    syscall
    
    #Imprime a quantidade de alunos reprovados
    li $v0, 4               
    la $a0, Msg_Reprovados  #Carrega a mensagem de alunos reprovados
    syscall
    
    lw $a0, Contador_Reprovados    #Carrega a quantidade de alunos reprovados em $a0
    li $v0, 1                      #Imprime o inteiro
    syscall
    
    #Imprime a quantidade de alunos com nota zero
    li $v0, 4               
    la $a0, Msg_Zerados     #Carrega a mensagem de alunos com 0
    syscall
    
    lw $a0, Contador_Zeros  #Carrega a quantidade de alunos com nota zero em $a0
    li $v0, 1               #Imprime o inteiro
    syscall
    
    #Finaliza o programa
    li $v0, 10
    syscall
