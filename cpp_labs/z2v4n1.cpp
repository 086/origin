#include <stdio.h>

int main() {
	float f, x;
l:
	scanf("%f", &x);

	if (x < 0)
		f = -1 * x;
	else if (0 <= x && x < 1)
			f = 1 * x;
		else if (1 <= x && x < 2)
				f = 1;
			else if (2 <= x)
					f = -2 * x + 5;

	printf("f(%.1f) = %.1f\n", x, f);
	goto l;
}