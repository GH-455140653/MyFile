#include "malloc.h"
#include "stdio.h"
#include "stdlib.h"

//已知一个带有头结点的链表L已经建立，除头结点外，其它各个结点中的数据均为正整数，请计算链表所有结点的数据的最大值。

typedef struct LNode
{
	int data;
	struct LNode* next;
} LNode, * LinkList;

LinkList Li;

int GetMaxInt(LinkList L)//max为最大值,i为数据个数
{
	LinkList p;
	int k=0;
	p=L->next;
	while(p!=NULL)
	{
		k>=p->data?k=k:k=p->data;
		p=p->next;
	}
	return k;
}

LinkList CreateList_L(int n)
{
	int i;
	LinkList p;
	LinkList L = (LinkList)malloc(sizeof(LNode));
	L->next = NULL;
	for (i = n; i > 0; --i)
	{
		p = (LinkList)malloc(sizeof(LNode));
		printf("请输入第%d个数据：",i);
		scanf("%d",&p->data);
		p->next = L->next;
		L->next = p;
	}
	return L;
}

int main(int argc, char* argv[])
{
    int n;
    printf("请问你要输入几个数据？\n");
    scanf("%d",&n);
    Li = CreateList_L(n);
    printf("\n链表所有结点的数据的最大值为：%d\n", GetMaxInt(Li));
}
	
