// findnumber.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include <stdlib.h>
#include <time.h>

void numNoRepeat(int p[],int num)
{
	int j;
	for(j=0;j<num;j++)
	{
		int temp=rand()%20;
		for(int i=0;i<j;i++)
		{
			while(p[i]==temp)
			{
				temp=rand()%20;
				i=0;//temp被刷新的同时也要使它重新与前面的p[i]重新比较
			}
		}
	p[j]=temp;
	}
}
void arr_printf(int p[],int num)
{
	for(int i=0;i<num;i++)
	{
		printf("%3d",*(p+i));
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	srand(time(NULL));
	int num;
	printf("Please input the number for the length of the array:");
	scanf("%d",&num);
	int arr[15]={0};
	numNoRepeat(arr,num); 
	arr_printf(arr,num);
	printf("\n");
	return 0;
}

