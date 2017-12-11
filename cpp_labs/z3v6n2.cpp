#include <stdio.h>

int main() {
	float E;
l:
	scanf("%f", &E);

	float an, sum_a = -E;
	unsigned n = 1, fac = 1;
	an = E;
	while(an >= E) {
		sum_a += an;
		an = (10 * n) / (float)fac;
		printf("a(%u) = %f\n", n, an);
		++n;
		fac *= n;
	}

	printf("sum_a(%u) = %f\n", n - 2, sum_a);
	goto l;
}