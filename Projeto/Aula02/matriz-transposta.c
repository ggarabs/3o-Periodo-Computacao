#include <stdio.h>
#include <stdlib.h>

int** trans(int** m, int n){
	int** aux = (int**)calloc(n, sizeof(int*));
	for(int i = 0; i < n; i++) aux[i] = (int*)calloc(n, sizeof(int));

	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			aux[i][j] = m[j][i];
		}
	}

	return aux;
}

int main(){
	int n;
	printf("Digite o valor de n: ");
	scanf("%d", &n);

	int** matriz = (int**)calloc(n, sizeof(int*));

	for(int i = 0; i < n; i++) matriz[i] = (int*)calloc(n, sizeof(int));

	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			scanf("%d", &matriz[i][j]);
		}
	}

	int** matriz_t;
	matriz_t = trans(matriz, n);

	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			printf("%d ", matriz_t[i][j]);
		}
		printf("\n");
	}

	return 0;
}
