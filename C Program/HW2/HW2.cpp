#include "malloc.h"
#include "stdio.h"
#include "stdlib.h"

//��֪һ������ͷ��������L�Ѿ���������ͷ����⣬������������е����ݾ�Ϊ��������������������н������ݵ����ֵ��

typedef struct LNode
{
	int data;
	struct LNode* next;
} LNode, * LinkList;

LinkList Li;

int GetMaxInt(LinkList L)//maxΪ���ֵ,iΪ���ݸ���
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
		printf("�������%d�����ݣ�",i);
		scanf("%d",&p->data);
		p->next = L->next;
		L->next = p;
	}
	return L;
}

int main(int argc, char* argv[])
{
    int n;
    printf("������Ҫ���뼸�����ݣ�\n");
    scanf("%d",&n);
    Li = CreateList_L(n);
    printf("\n�������н������ݵ����ֵΪ��%d\n", GetMaxInt(Li));
}
	
