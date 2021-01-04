#include <stdio.h>

int main()
{
	int i,j,temp;
	for(i=2;i<=20;i++)
	{
		temp=1;
		for(j=2;j<i;j++)
		{
			if(i%j==0)temp=0;
		}
		if(temp==1)printf("%dÊÇËØÊý¡£\n",i);
	}
}