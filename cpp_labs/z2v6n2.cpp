#include <stdio.h>

int main()
{
	unsigned k, l, m, n;
l:
	scanf("%u%u%u%u", &k, &l, &m, &n);
	
	if (  (k - m == 1 || m - k == 1 && l - n == 2 || n - l == 2)
		||(k - m == 2 || m - k == 2 && l - n == 1 || n - l == 1) )
		printf("конь расположенный на k l угрожает полю m n\n");
	else
		printf("конь расположенный на k l не угрожает полю m n\n");
	goto l;
}