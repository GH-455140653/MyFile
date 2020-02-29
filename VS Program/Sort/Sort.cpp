#include "stdafx.h"
#define MAXSIZE 10
#define N 8
typedef struct
{
	int r[MAXSIZE + 1];
	int length;
}SqList;

SqList L;

void InsertSort(SqList* L)//插入排序
{
	int i, j;
	for (i = 2; i <= (*L).length; ++i)//
	{
		if ((*L).r[i] < (*L).r[i - 1])//假如相邻的两个元素，前面元素比后面元素大
		{
			(*L).r[0] = (*L).r[i];//获取小的元素放入哨兵位置
			for (j = i - 1; ((*L).r[0] < (*L).r[j]); --j)//在前面元素大于后面元素时，两者进行交换
				(*L).r[j + 1] = (*L).r[j];
			(*L).r[j + 1] = (*L).r[0];//最后将哨兵元素放在相应的位置
		}
	}
}

int SelectMinKey(SqList L, int i)//找出整个长度表中最小的元素的下标，记录并返回值
{
	int min;
	int j, k;
	k = i;
	min = L.r[i];
	for (j = i + 1; j <= L.length; j++)
		if (L.r[j] < min) 
		{ 
			k = j; 
			min = L.r[j];
		}
	return k;
}

void SelectSort(SqList* L)
{
	int i, j;
	int t;
	for (i = 1; i < (*L).length; ++i)
	{
		j = SelectMinKey(*L, i);
		if (i != j)//两元素不相等便交换
		{
			t = (*L).r[i];
			(*L).r[i] = (*L).r[j];
			(*L).r[j] = t;
		}
	}
}

void Swap(int& i, int& j)//交换
{
	int temp;
	temp = i;
	i = j;
	j = temp;
}

void BubbleSort(SqList* L, int n)
{
	int i, j, IEI;
	i = n;
	while (i > 1)
	{
		IEI = 1;
		for (j = 1; j < i; j++)
			if ((*L).r[j + 1] < (*L).r[j])//如果后比前大
			{
				Swap((*L).r[j], (*L).r[j + 1]);//前后交换
				IEI = j;//记录最后小元素的交换位置
			}
		i = IEI; //记录最后一个元素的下标，同时起到终止循环的作用。
	}
}

void main()
{
	srand(time(NULL));
	int i;
	for (i = 1; i < N + 1; i++)//链表第一个位置空出来用来作为哨兵位置，所以后面长度不再是N，需要改为N+1。
	{
		L.r[i] = rand() % 101;//随机赋值
		L.length++;//长度赋值
	}//链表初始化

	for (i = 1; i < L.length + 1; i++)
	{
		printf(" %d", L.r[i]);
	}//打印初始化数据

	InsertSort(&L);
	printf("\n进行插叙排序后的链表为：");
	for (i = 1; i < L.length + 1; i++)
	{
		printf(" %d", L.r[i]);
	}

	SelectSort(&L);
	printf("\n进行选择排序后的链表为：");
	for (i = 1; i < L.length + 1; i++)
	{
		printf(" %d", L.r[i]);
	}

	BubbleSort(&L, L.length);
	printf("\n进行冒泡排序后的链表为：");
	for (i = 1; i < L.length + 1; i++)
	{
		printf(" %d", L.r[i]);
	}
}