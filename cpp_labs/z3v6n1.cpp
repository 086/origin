#include <stdio.h>

int main() {
	unsigned n = 123;
l:
	double a1;
	double sum_a = 0;
	for(unsigned i = 1; i <= n; ++i) {
		a1 = 1 / (double)(4 * i*i);
		printf("a%u = %f\n", i, a1);
		sum_a += a1;
	}
	printf("sum_a(%u) = %f\n", n, sum_a);

	scanf("%u", &n);
	goto l;
}