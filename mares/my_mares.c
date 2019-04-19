

#include <unistd.h>

int	main(void)
{
	while (1)
	{
		fork();
		write(1, "tsok\n", 5);
	}
	return (0);
}
