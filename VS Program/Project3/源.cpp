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
{//�����������
	int i;
	LinkList p;
	L = (LinkList)malloc(sizeof(LNode));
	L->next = NULL;
	for (i = 0; i < n; i++)
	{
		p = (LinkList)malloc(sizeof(LNode));
		printf("�������%d������:", n - i);
		scanf("%d", &(p->data));
		p->next = L->next;
		L->next = p;
	}
}

int InitList(LinkList& L)
{//����ͷ���
	L = (LinkList)malloc(sizeof(LNode));
	if (!L)exit(-2);
	L->next = NULL;
	return 1;
}

int DestoryList(LinkList& L)
{//��������
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
{//�������Ϊ��
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
{//�ж������Ƿ�Ϊ��
	if (L->next) return 0;
	else return 1;
}

int ListLength(LinkList L)
{//����Li������Ԫ�صĸ���
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
{//����iλ��Ԫ�ش��ڣ��򽫵�i��Ԫ�ص�ֵ����e������1�����߷���0,iΪλ��
	int j = 1;
	LinkList p = L->next;
	while (p && j < i)//L�ǿ��������iֵҪ����������С����1
	{
		p = p->next;
		j++;
	}
	if (!p || j > i) return 0;//L�ջ���iС�������Ա���С����
	e = p->data;
	return 1;
}

int LocateElem(LinkList L, int e)
{//��������Ѱ���Ƿ����eԪ�أ����򷵻�Ԫ�ص�λ�ã�����0
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
{//�����Ա��е�iλ�ò���Ԫ��e
	int j = 0;
	LinkList p = L, s;
	while (p && j < i - 1)//L���ղ��Ҳ����λ�ò�С��0
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
{//ɾ����iλ��Ԫ�ز�����ֵ������e�У��ɹ�����ֵΪ1
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
{//�����������
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
	//��ʼ������
	printf("������Ҫ����һ���೤������\n");
	scanf("%d", &s);
	printf("������������ݣ�\n");
	CreateList(Li, s);
	ListTraverse(Li);
	//�жϿձ�
	if (LinkEmpty(Li) == 1) printf("������Ϊ�ձ�\n");
	else printf("������Ϊ�ձ�\n");
	//���Ա���
	printf("������ĳ���Ϊ��%d\n", ListLength(Li));
	//����
	printf("��������Ҫ����Ԫ�ص�λ�ã�");
	scanf("%d", &i);
	printf("��������Ҫ�����Ԫ�أ�");
	scanf("%d", &j);
	ListInsert(Li, i, j);
	printf("����������Ϊ��\n");
	ListTraverse(Li);
	//��Ԫ�ز�λ��
	printf("��������Ҫ���ҵ�Ԫ�أ�");
	scanf("%d", &elem);
	printf("%d�����Ա��е�λ��Ϊ��%d\n", elem, LocateElem(Li, elem));
	//��λ�ò�Ԫ��
	printf("��������Ҫ���ҵ�Ԫ�ص�λ�ã�");
	scanf("%d", &elem);
	GetElem(Li, elem, s);
	printf("��Ԫ��Ϊ��%d\n", s);
	//ɾ��Ԫ��
	printf("��������Ҫɾ����Ԫ�ص�λ�ã�");
	scanf("%d", &elem);
	ListDelete(Li, elem, s, 1);
	printf("ɾ����%dλ�õ�Ԫ��Ϊ��%d\n", elem, s);
	printf("ɾ��������Ա�Ϊ��\n");
	ListTraverse(Li);
	//�޸�Ԫ��
	printf("������Ҫ�޸ĵ�Ԫ��Ϊ��");
	scanf("%d", &i);
	printf("������Ҫ��%dԪ�ظ�Ϊ��", i);
	scanf("%d", &j);
	s = LocateElem(Li, i);//Ҫ�޸ĵ�Ԫ�ص�λ��
	ListDelete(Li, s, k, 0);//ɾ��Ҫ�޸ĵ�Ԫ��
	ListInsert(Li, s, j);//�����޸ĺ��Ԫ��
	printf("�޸Ĺ�������Ա�Ϊ��\n");
	ListTraverse(Li);//��ӡ

	if(DestoryList(Li)==1) printf("�����Ա��Ѿ����٣�");//�������Ա�
	if(ClearList(Li)==1) printf("�����Ա��Ѿ��ǿձ��ˣ�");//��ձ�

	printf("\n");
}

