#include <stdio.h>
#include <stdlib.h>

typedef struct aluno Aluno;

struct aluno{
	char *nome, *matricula;
	float *nota;
};

int main(){
	int n;
	printf("Bem-vindo ao cadastramento de alunos!\n");
	printf("Digite o número de alunos que deseja cadastrar: ");
	scanf("%d", &n);

	Aluno* vetor = (Aluno*)calloc(n, sizeof(Aluno));

	for(int i = 0; i < n; i++){
		char *nome, *matricula;
		nome = (char*)calloc(120, sizeof(char));
		matricula = (char*)calloc(10, sizeof(char));

		printf("ALUNO %d\n", i+1);

		printf("Digite o nome do aluno: ");
		scanf("%s", nome);

		(vetor+i)->nome = nome;

		printf("Digite o número de matrícula: ");
		scanf("%s", matricula);

		(vetor+i)->matricula = matricula;

		float *notas;
		notas = (float*)calloc(2, sizeof(float));

		printf("Digite a nota N1 do aluno: ");
		scanf("%f", notas);

		(vetor+i)->nota = notas;
		(vetor+i)->nota++;

		printf("Digite a nota N2 do aluno: ");
		scanf("%f", notas+1);

		(vetor+i)->nota = notas+1;
		(vetor+i)->nota--;
	}

	for(int i = 0; i < n; i++){
		printf("O aluno %s de matrícula %s tem média igual a: %f\n", (vetor+i)->nome, (vetor+i)->matricula, (*((vetor+i)->nota)+*((vetor+i)->nota+1))/2);
	}

	return 0;
}
