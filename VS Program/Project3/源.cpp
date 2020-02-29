// lrl.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

typedef struct LNode
{
	int data;
	struct LNode* next;
}LNode, * LinkList;

LinkList Li;

void CreateList(LinkList& L, int n)
{//逆序插入数据
	int i;
	LinkList p;
	L = (LinkList)malloc(sizeof(LNode));
	L->next = NULL;
	for (i = 0; i < n; i++)
	{
		p = (LinkList)malloc(sizeof(LNode));
		printf("请输入第%d个数据:", n - i);
		scanf("%d", &(p->data));
		p->next = L->next;
		L->next = p;
	}
}

int InitList(LinkList& L)
{//创建头结点
	L = (LinkList)malloc(sizeof(LNode));
	if (!L)exit(-2);
	L->next = NULL;
	return 1;
}

int DestoryList(LinkList& L)
{//销毁链表
	LinkList q;
	while (L)
	{
		q = L->next;
		free(L);
		L = q;
	}
	L = NULL;
	return 1;
}

int ClearList(LinkList L)
{//将链表变为空
	LinkList p, q;
	p = L->next;
	while (p)
	{
		q = p->next;
		free(p);
		p = q;
	}
	L->next = NULL;
	return 1;
}

int LinkEmpty(LinkList L)
{//判断链表是否为空
	if (L->next) return 0;
	else return 1;
}

int ListLength(LinkList L)
{//返回Li中数据元素的个数
	int i = 0;
	LinkList p = L->next;
	while (p)
	{
		i++;
		p = p->next;
	}
	return i;
}

int GetElem(LinkList L, int i, int& e)
{//若第i位置元素存在，则将第i个元素的值付给e并返回1，否者返回0,i为位置
	int j = 1;
	LinkList p = L->next;
	while (p && j < i)//L非空与输入的i值要大于线性最小长度1
	{
		p = p->next;
		j++;
	}
	if (!p || j > i) return 0;//L空或者i小于了线性表最小长度
	e = p->data;
	return 1;
}

int LocateElem(LinkList L, int e)
{//在链表中寻找是否存在e元素，有则返回元素的位置，否则0
	int i = 0;
	LinkList p = L->next;
	while (p)
	{
		i++;
		if (p->data == e) return i;
		p = p->next;
	}
	return 0;
}

int ListInsert(LinkList L, int i, int e)
{//在线性表中第i位置插入元素e
	int j = 0;
	LinkList p = L, s;
	while (p && j < i - 1)//L不空并且插入的位置不小于0
	{
		p = p->next;
		j++;
	}
	if (!p || j > i - 1) return 0;
	s = (LinkList)malloc(sizeof(struct LNode));
	s->data = e;
	s->next = p->next;
	p->next = s;
	return 1;
}

int ListDelete(LinkList L, int i, int& e, int k)
{//删除第i位置元素并将其值返回在e中，成功返回值为1
	int j = 0;
	LinkList p = L, q;
	while (p->next && j < i - 1)
	{
		p = p->next;
		j++;
	}
	if (!p->next || j > i - 1) return 0;
	q = p->next;
	p->next = q->next;
	if (k == 1)e = q->data;
	free(q);
	return 1;
}

int ListTraverse(LinkList L)
{//正序遍历链表
	LinkList p = L->next;
	while (p)
	{
		printf("%d  ", p->data);
		p = p->next;
	}
	printf("\n");
	return 1;
}

int main(int argc, char* argv[])
{
	int k;
	int i, j, s, elem, flag = 1;
	//初始化链表
	printf("请问你要创建一个多长的链表？\n");
	scanf("%d", &s);
	printf("请逆序插入数据！\n");
	CreateList(Li, s);
	ListTraverse(Li);
	//判断空表
	if (LinkEmpty(Li) == 1) printf("该链表为空表！\n");
	else printf("该链表不为空表！\n");
	//线性表长度
	printf("该链表的长度为：%d\n", ListLength(Li));
	//插入
	printf("请输入你要插入元素的位置：");
	scanf("%d", &i);
	printf("请输入你要插入的元素：");
	scanf("%d", &j);
	ListInsert(Li, i, j);
	printf("插入后的数据为：\n");
	ListTraverse(Li);
	//用元素查位置
	printf("请输入你要查找的元素：");
	scanf("%d", &elem);
	printf("%d在线性表中的位置为：%d\n", elem, LocateElem(Li, elem));
	//用位置查元素
	printf("请输入你要查找的元素的位置：");
	scanf("%d", &elem);
	GetElem(Li, elem, s);
	printf("该元素为：%d\n", s);
	//删除元素
	printf("请输入你要删除的元素的位置：");
	scanf("%d", &elem);
	ListDelete(Li, elem, s, 1);
	printf("删除第%d位置的元素为：%d\n", elem, s);
	printf("删除后的线性表为：\n");
	ListTraverse(Li);
	//修改元素
	printf("请问你要修改的元素为：");
	scanf("%d", &i);
	printf("请问你要将%d元素改为：", i);
	scanf("%d", &j);
	s = LocateElem(Li, i);//要修改的元素的位置
	ListDelete(Li, s, k, 0);//删除要修改的元素
	ListInsert(Li, s, j);//插入修改后的元素
	printf("修改过后的线性表为：\n");
	ListTraverse(Li);//打印

	if(DestoryList(Li)==1) printf("该线性表已经销毁！");//销毁线性表
	if(ClearList(Li)==1) printf("该线性表已经是空表了！");//变空表

	printf("\n");
}

