#include<stdio.h>
#pragma warning(disable:4996)

int main() {

	int num;
	scanf("%d", &num);

	for (int i = 1; i <= num; i++) {
		for (int j = 0; j < i; j++) {
			printf("*");
		}
		printf("\n");
	}
	
	return 0;
}
