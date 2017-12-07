#include <stdio.h>

int main() {
	float u, x, y;
l:
	scanf("%f%f", &x, &y);

	if ( x * x + (y - 1) * (y - 1) <= 1
		&& -1 * x * x - y >= -0.5 )
		u = x - y;
	else
		u = x * y - 7;

	printf("u(%.2f, %.2f) = %.2f\n", x, y, u);
	goto l;
}