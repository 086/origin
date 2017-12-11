#include <stdio.h>

int main() {
	unsigned n = 14;
l:
	double a0 = 1, a1 = 1, a2;
	double mul_a = a0 * a1;
	unsigned pow = 2;
	for(unsigned i = 2; i <= n; ++i) {
		a2 = a0 + a1 / pow;
		mul_a *= a2;
		printf("a%u = %f\n", i, a2);
		a0 = a1;
		a1 = a2;
		pow *= 2;
	}
	printf("mul_a(%u) = %f\n", n, mul_a);

	scanf("%u", &n);
	goto l;
}