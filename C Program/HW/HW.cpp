#include "malloc.h"
#include "stdio.h"

//��֪һ������ͷ��������L�Ѿ���������ͷ����⣬������������е����ݾ�Ϊ�����������������������ж��ٸ�����λ�����ڲ��Ҵ�С�ǵ�����(��С���Ҳ��Ϊ�ǵ�����)

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
    printf("\n�����������%d������λ�����ڲ��Ҵ�С�ǵ����ġ�\n", GetMacLink(Li));
}
	
