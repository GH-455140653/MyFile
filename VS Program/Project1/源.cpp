// lrl.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#define LIST_INIT_SIZE 10

typedef struct
{
	int* elem; //ָ���ѷ����һƬ�����洢�ռ�
	int length; //���Ա�������ӵ�����Ԫ�صĸ���
	int listsize; //���Ա�������ܴ洢������Ԫ�ظ���
}SqList;

SqList Li;

int CreatList(SqList& L)
{//����һ�����Ա�
	L.elem = (int*)malloc(LIST_INIT_SIZE * sizeof(int));
	if (!L.elem)
		return 0;
	L.length = 0;
	L.listsize = LIST_INIT_SIZE;
	return 1;
}

int DestoryList(SqList& L)//����һ�����Ա�
{//�������Ա�
	free(L.elem);
	L.elem = NULL;
	L.length = 0;
	L.listsize = 0;
	return 1;
}

int ClearList(SqList& L)
{//������Ա������洢�ռ�
	L.length = 0;
	return printf("\n���Ա�ɹ���ɿձ�\n");
}

int ListEmpty(SqList L)
{//�ж�һ�����Ա��Ƿ�Ϊ��
	if (L.length == 0)
		return printf("������Ϊ�ձ�\n");
	else
		return printf("������Ϊ�ձ�\n");
}

int GetElem(SqList L, int i, int& e)
{//��ȡ���Ա��е�i��Ԫ�ظ�ֵ��e
	if (i<1 || i>L.length)
		return 0;
	e = L.elem[i - 1];
	return 1;
}

int GetLocateElem(SqList L, int e)
{//��ȡָ��eԪ�������Ա��ϵ�λ��
	int i;
	for (i = 0; i < L.length; i++)
		if (L.elem[i] == e)
			return printf("��Ԫ��������ĵ�%dλ��\n", i + 1);
	return printf("������û�����Ԫ�أ�\n");
}

int GetPriorElem(SqList L, int cur_e, int& pre_e)
{//��ȡcur_eԪ�ص�ǰһ��Ԫ�ز���ֵ��pre_e
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
{//��ȡcur_eԪ�صĺ�һ��Ԫ�ز���ֵ��next_e
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
{//�ڵ�i��Ԫ��֮ǰ����һ��Ԫ��e
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
{//ɾ����i��Ԫ�ز��ѵ�i��Ԫ�ظ�ֵ��e
	int j, e;
	if (i<1 || i>L.length)
		return  printf("������Ҹ㣬�������û���λ�á�\n"); 
	e = L.elem[i - 1];
	for (j = i; j < L.length; j++)
		L.elem[j - 1] = L.elem[j];
	L.length--;
	if(l)return printf("�Ѿ�ɾ����%d��Ԫ��%d��\n", i, e);
}

int ListTraverse(SqList L)
{//�������Ա�
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
	//��ʼ������
	printf("������Ҫ����һ���೤������\n");
	scanf("%d", &s);
	if (CreatList(Li) == 1)printf("�������ɹ���\n");
	printf("\n");

	for (i = 0; i < s; i++)
	{//����Ԫ������
		int e;
		Li.length = s;
		printf("��������Ҫ��ӵĵ�%d��Ԫ�أ�", i + 1);
		scanf("%d", &e);
		ListInsert(Li, i + 1, e, 0);
	}
	printf("\n");

	printf("������Ա��еĸ���Ԫ��Ϊ��\n");
	ListTraverse(Li);//�������Ա���ӡԪ������
	printf("\n");

	for (; flag;)
	{
		int e;
		printf("��������������ʵ������Ҫ�������飺\n(0):�˳�����\n(1):ɾ��ָ��λ��Ԫ��\n(2):��������\n(3):�������ɿձ�\n(4):������鳤��\n(5):��ָ��һ��λ�ò���һ������\n(6):�ж������Ƿ�Ϊ��\n(7):���һ��Ԫ�ص�λ��\n(8):��ָ��λ�����ݽ����޸�\n");
		printf("\n");
		scanf("%d", &e);
		switch (e)
		{
		case 0:flag = 0; printf("\n�����Ѿ��˳���\n\n"); break;
		case 1:
		{
			printf("������Ҫɾ���ڼ���Ԫ�أ�");
			scanf("%d", &j);
			elem = ListDelete(Li, j, 1);//ɾ��������ָ��λ��Ԫ��
			printf("��������������Ϊ��\n");
			ListTraverse(Li);
			printf("\n");
		}; break;
		case 2:
		{
			DestoryList(Li);//��������
			printf("�������ѱ����٣�\n");
			printf("\n");
		}; break;
		case 3:
		{
			ClearList(Li);//������������Ϊ�ձ�
			printf("\n");
		}; break;
		case 4:
		{
			printf("������ĳ���Ϊ��%d\n", GetListLength(Li));
			printf("\n");
		}; break;
		case 5:
		{
			printf("��������Ҫ�����λ�ã�");
			scanf("%d", &s);
			printf("��������Ҫ��������ݣ�");
			scanf("%d", &elem);
			if (ListInsert(Li, s, elem, 1))
			{
				ListTraverse(Li);//�������Ա���ӡԪ������
			}
			else printf("������û�����λ�ã�\n");
			printf("\n");
		}; break;
		case 6:
		{
			ListEmpty(Li);//�ж������Ƿ�Ϊ��
			printf("\n");
		}break;
		case 7:
		{
			printf("������Ҫ��ȡ��Ԫ���ǣ�");
			scanf("%d", &elem);
			GetLocateElem(Li, elem); //��ȡָ��Ԫ�ص�λ��
			printf("\n");
		}break;
		case 8:
		{
			//�������е�ָ�������޸�
			printf("������Ҫ�޸ĵ�λ�ã�");
			scanf("%d", &s);
			printf("������Ҫ�����Ԫ���޸�Ϊ��");
			scanf("%d", &elem);
			if (s > Li.length)
			{
				printf("\n������û�����λ�ã�\n\n");
			}
			else
			{
				ListDelete(Li, s, 0);
				if (s <= Li.length || s >= 1)
				{
					ListInsert(Li, s, elem, 1);
				}
				printf("������Ա��еĸ���Ԫ��Ϊ��\n");
				ListTraverse(Li);
				printf("\n");
			}
		}break;
		default:printf("����ȷ�������֣�\n");
			printf("\n");
			break;
		}
	}
	return 0;
}