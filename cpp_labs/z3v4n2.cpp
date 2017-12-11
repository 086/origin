#include <stdio.h>

int main() {
	float E;
l:
	scanf("%f", &E);

	float an, sum_a = -E;
	unsigned n = 1, pow = 2;
	an = E;
	while(an >= E) {
		sum_a += an;
		an = (2 * n - 1) / (float)pow;
		printf("a(%u) = %f\n", n, an);
		++n;
		pow *= 2;
	}

	printf("sum_a(%u) = %f\n", n - 2, sum_a);
	goto l;
}