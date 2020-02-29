// lrl.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#define LIST_INIT_SIZE 10

typedef struct
{
	int* elem; //指向已分配的一片连绩存储空间
	int length; //线性表中已添加的数据元素的个数
	int listsize; //线性表中最多能存储的数据元素个数
}SqList;

SqList Li;

int CreatList(SqList& L)
{//创建一个线性表
	L.elem = (int*)malloc(LIST_INIT_SIZE * sizeof(int));
	if (!L.elem)
		return 0;
	L.length = 0;
	L.listsize = LIST_INIT_SIZE;
	return 1;
}

int DestoryList(SqList& L)//销毀一个线性表
{//销毁线性表
	free(L.elem);
	L.elem = NULL;
	L.length = 0;
	L.listsize = 0;
	return 1;
}

int ClearList(SqList& L)
{//清空线性表，保留存储空间
	L.length = 0;
	return printf("\n线性表成功变成空表！\n");
}

int ListEmpty(SqList L)
{//判断一个线性表是否为空
	if (L.length == 0)
		return printf("该链表为空表\n");
	else
		return printf("该链表不为空表\n");
}

int GetElem(SqList L, int i, int& e)
{//获取线性表中第i个元素赋值给e
	if (i<1 || i>L.length)
		return 0;
	e = L.elem[i - 1];
	return 1;
}

int GetLocateElem(SqList L, int e)
{//获取指定e元素在线性表上的位置
	int i;
	for (i = 0; i < L.length; i++)
		if (L.elem[i] == e)
			return printf("该元素在链表的第%d位。\n", i + 1);
	return printf("该链表没有这个元素！\n");
}

int GetPriorElem(SqList L, int cur_e, int& pre_e)
{//获取cur_e元素的前一个元素并赋值给pre_e
	int i;
	for (i = 0; i < L.length; i++)
		if (L.elem[i] == cur_e)
			break;
	if (i == 0 || i == L.length)
		return 0;
	pre_e = L.elem[i - 1];
	return 1;
}

int GetNextElem(SqList L, int cur_e, int& next_e)
{//获取cur_e元素的后一个元素并赋值给next_e
	int i;
	for (i = 0; i < L.length; i++)
		if (L.elem[i] == cur_e)
			break;
	if (i == L.length - 1 || i == L.length)
		return 0;
	next_e = L.elem[i + 1];
	return 1;
}

int ListInsert(SqList& L, int i, int e, int t)
{//在第i个元素之前插入一个元素e
	int j;
	if (i<1 || i>L.length + 1)
		return 0;
	for (j = L.length; j >= i; j--)
		L.elem[j] = L.elem[j - 1];
	L.elem[i - 1] = e;
	if (t)L.length++;
	return 1;
}

int ListDelete(SqList& L, int i,int l)
{//删除第i个元素并把第i个元素赋值给e
	int j, e;
	if (i<1 || i>L.length)
		return  printf("求你别乱搞，你的链表没这个位置。\n"); 
	e = L.elem[i - 1];
	for (j = i; j < L.length; j++)
		L.elem[j - 1] = L.elem[j];
	L.length--;
	if(l)return printf("已经删除第%d个元素%d。\n", i, e);
}

int ListTraverse(SqList L)
{//遍历线性表
	int i;
	for (i = 0; i < L.length; i++)
		printf("%d  ", L.elem[i]);
	printf("\n");
	return 1;
}

int GetListLength(SqList L)
{
	return L.length;
}

int main()
{
	int i, j, s, elem, flag = 1;
	//初始化链表
	printf("请问你要创建一个多长的链表？\n");
	scanf("%d", &s);
	if (CreatList(Li) == 1)printf("链表创建成功！\n");
	printf("\n");

	for (i = 0; i < s; i++)
	{//插入元素数据
		int e;
		Li.length = s;
		printf("请输入你要添加的第%d个元素：", i + 1);
		scanf("%d", &e);
		ListInsert(Li, i + 1, e, 0);
	}
	printf("\n");

	printf("你的线性表中的各个元素为：\n");
	ListTraverse(Li);//遍历线性表并打印元素数据
	printf("\n");

	for (; flag;)
	{
		int e;
		printf("请输入以下数字实现你想要做的事情：\n(0):退出程序\n(1):删除指定位置元素\n(2):销毁链表\n(3):将链表变成空表\n(4):求出数组长度\n(5):在指定一个位置插入一个数据\n(6):判断链表是否为空\n(7):求出一个元素的位置\n(8):将指定位置数据进行修改\n");
		printf("\n");
		scanf("%d", &e);
		switch (e)
		{
		case 0:flag = 0; printf("\n程序已经退出！\n\n"); break;
		case 1:
		{
			printf("请问你要删除第几个元素：");
			scanf("%d", &j);
			elem = ListDelete(Li, j, 1);//删除链表中指定位置元素
			printf("操作后链表数据为：\n");
			ListTraverse(Li);
			printf("\n");
		}; break;
		case 2:
		{
			DestoryList(Li);//销毁链表
			printf("该链表已被销毁！\n");
			printf("\n");
		}; break;
		case 3:
		{
			ClearList(Li);//将该链表设置为空表
			printf("\n");
		}; break;
		case 4:
		{
			printf("该链表的长度为：%d\n", GetListLength(Li));
			printf("\n");
		}; break;
		case 5:
		{
			printf("请输入你要插入的位置：");
			scanf("%d", &s);
			printf("请输入你要插入的数据：");
			scanf("%d", &elem);
			if (ListInsert(Li, s, elem, 1))
			{
				ListTraverse(Li);//遍历线性表并打印元素数据
			}
			else printf("该链表没有这个位置！\n");
			printf("\n");
		}; break;
		case 6:
		{
			ListEmpty(Li);//判断链表是否为空
			printf("\n");
		}break;
		case 7:
		{
			printf("请问你要获取的元素是：");
			scanf("%d", &elem);
			GetLocateElem(Li, elem); //获取指定元素的位置
			printf("\n");
		}break;
		case 8:
		{
			//将链表中的指定数据修改
			printf("请问你要修改的位置：");
			scanf("%d", &s);
			printf("请问你要将这个元素修改为：");
			scanf("%d", &elem);
			if (s > Li.length)
			{
				printf("\n该链表没有这个位置！\n\n");
			}
			else
			{
				ListDelete(Li, s, 0);
				if (s <= Li.length || s >= 1)
				{
					ListInsert(Li, s, elem, 1);
				}
				printf("你的线性表中的各个元素为：\n");
				ListTraverse(Li);
				printf("\n");
			}
		}break;
		default:printf("请正确输入数字！\n");
			printf("\n");
			break;
		}
	}
	return 0;
}