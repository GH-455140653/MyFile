#include "malloc.h"
#include "stdio.h"

//已知一个带有头结点的链表L已经建立，除头结点外，其它各个结点中的数据均为正整数，请计算链表中最多有多少个数是位序相邻并且大小是递增的(大小相等也认为是递增的)

typedef struct LNode
{
	int data;
	struct LNode* next;
} LNode, * LinkList;

LinkList Li;

int GetMacLink(LinkList L)
{
	LinkList p, k;
	int max_F, max = 0;
	p = L->next->next;
	k = L->next;
	while (p != NULL)
	{
		int g = 1;
		while (p != NULL && k->data <= p->data)
		{
			g++;
			p = p->next;
			k = k->next;
		}
		max_F = g;
		max = max > max_F ? max : max_F;
		k = p;
		if(p != NULL) p = p->next;
	}
	return max;
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
    printf("\n链表中最多有%d个数是位序相邻并且大小是递增的。\n", GetMacLink(Li));
}
	
