// findnumber.cpp : �������̨Ӧ�ó������ڵ㡣
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
				i=0;//temp��ˢ�µ�ͬʱҲҪʹ��������ǰ���p[i]���±Ƚ�
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

