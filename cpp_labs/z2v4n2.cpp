#include <stdio.h>

int main()
{
	unsigned k, l, m, n;
l:
	scanf("%u%u%u%u", &k, &l, &m, &n);
	
	if ((k - l) % 2 == (m - n) % 2)
		printf("являются полями одного цвета\n");
	else
		printf("не являются полями одного цвета\n");
	goto l;
}