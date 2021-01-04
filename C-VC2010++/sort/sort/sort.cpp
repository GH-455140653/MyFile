// sort.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include <time.h>
#include <stdlib.h>
#include <string.h>

void selectSort(int p[],int num)
{
	int i,j,temp;
	for(i=0;i<num;i++)
	{
		int max=i;
		for(j=i+1;j<num;j++)
		{
			if(p[max]<p[j])
			{
				max=j;
			}
		}
		temp=p[max];
		p[max]=p[i];
		p[i]=temp;
	}
	printf("\n经过选择排序后的数据如下：\n");
}

void bubbleSort(int p[],int num)
{
	int i,j,k;
	for(i=0;i<num;i++)
	{
		for(j=0;j<num;j++)
		{
			int temp;
			if(p[i]>p[j])
			{
				temp=p[i];
				p[i]=p[j];
				p[j]=temp;
			}
		}
	}
	printf("\n经过冒泡排序后的数据如下：\n");
}

void insertSort(int p[],int num)
{
	int i,j,temp;
	for(i=1;i<num;i++)
	{
		j=i-1;
		temp=p[i];
		while(j>=0 && p[j]<temp)
		{
			p[j+1]=p[j];
			j--;
		}
		p[j+1]=temp;
	}
	printf("\n经过插入排序后的数据如下：\n");
}

void arr_printf(int p[],int num)
{
	for(int i=0;i<num;i++)
	{
		printf("%3d",p[i]);
	}
	printf("\n");
}

int _tmain(int argc, _TCHAR* argv[])
{
	srand(time(NULL));
	int num,arr[100]={0};
	printf("请输入数据个数：");
	scanf("%d",&num);
	printf("随机生成的一组0-100的数字：\n");
	for(int i=0;i<num;i++)
	{
		arr[i]=rand()%101;
		printf("%3d",arr[i]);
	}
	selectSort(arr,num);
	arr_printf(arr,num);
	bubbleSort(arr,num);
	arr_printf(arr,num);
	insertSort(arr,num+1);
	arr_printf(arr,num);
	return 0;
}

