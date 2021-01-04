// tiaoshi.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

int  main()
{
	float w,x,y,z;
	for(w=1;w<=711;w++)\
	{
		for(x=1;x<=711;x++)
		{
			for(y=1;y<=711;y++)
			{
				z=711-w-x-y;
				if((w+x+y+z==711) && (w*x*y*z==711000000))
				{
					printf("w=%f x=%f y=%f z=%f\n",w/100,x/100,y/100,z/100);
				}
			}
		}
	}
}

/*
#include <stdio.h>
#define value 711
#define f 100.0
int main()
{
  int a,b,c;
  for(a=1;a<value;a++)
  for(b=1;b<value;b++)
  for(c=1;c<value;c++)
     if(a/f*b/f*c/f*(value-a-b-c)==value)
		printf("%g,%g,%g,%g\n",a/f,b/f,c/f,(value-a-b-c)/f);
}*/

