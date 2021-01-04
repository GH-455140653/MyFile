// practice.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <Windows.h>
#define N 10

void opera(int p[][N],int columns)
{
	for(int i=0;i<columns;i++)
	{
		p[i][i]=1;
		p[i][0]=1;
	}
	for(int i=2;i<columns;i++)
	{
		for(int j=0;j<i;j++)
		{
			p[i][j]=p[i-1][j]+p[i-1][j-1];
		}
	}
}

void printf_angle(int p[][N],int columns)
{
	for(int i=0;i<columns;i++)
	{
		for (int j=0;j<=i;j++)    
		{
			printf("%6d",p[i][j]);
		}
		printf("\n");
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	int arr_01[N][N]={0},columns;
	printf("Please input the number for columns:");
	scanf("%d",&columns);
	opera(arr_01,columns);
	printf("\n杨辉三角如下：\n");
	printf_angle(arr_01,columns);
	return 0;
}

