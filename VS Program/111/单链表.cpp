
#define _CRT_SECURE_NO_WARNINGS
/*
#include "malloc.h"
#include "stdio.h"
#include "stdlib.h"

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
		if (p != NULL) p = p->next;
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
		printf("�������%d�����ݣ�", i);
		scanf("%d", &p->data);
		p->next = L->next;
		L->next = p;
	}
	return L;
}

int main(int argc, char* argv[])
{
	int n;
	printf("������Ҫ���뼸�����ݣ�\n");
	scanf("%d", &n);
	Li = CreateList_L(n);
	printf("\n�����������%d������λ�����ڲ��Ҵ�С�ǵ����ġ�\n", GetMacLink(Li));
}
*/

//Live Demo
//#include <stdio.h> 
//#include <stdlib.h>
//
//struct node {
//	int data;
//	int key;
//	struct node* next;
//};
//typedef struct node Nd;//����һ���ṹ�岢ȡ��ΪNd
//
//Nd* head = NULL;  	//����һ��ȫ�ֱ�����ָ��Nd����ṹ��Ŀ�ָ��head
//Nd* current = NULL; //����һ��ȫ�ֱ�����ָ��Nd����ṹ��Ŀ�ָ��current
//
//void Insert(int key, int data);//��Ϊ�����Ǵ��������������еģ������涨���Insert������Ҫ��������֮ǰ��������
//
//void main() {
//	Insert(1, 10);    Insert(2, 20);//��������
//	Insert(3, 30);    Insert(4, 40);//��������
//
//	//printing
//	current = head;//ָ��head��ָ��Ľṹ��ĵ�ַ��ֵ��ָ��ccurrent
//	while (current != NULL) {
//		printf("\n(Key = %d, Data = %d) \n", current->key, current->data);//���������ǽ�ָ��ָ��Ľṹ�����Ӧ��key��data����ڿ���̨��
//		current = current->next;//currentָ��������Ľṹ��
//	}
//}
//
////insert link at the first location
//void Insert(int key, int data) {
//	//create a link
//	Nd* link = (struct node*) malloc(sizeof(struct node));//��̬����һ��ָ��ṹ���ָ��ȡ��Ϊlink��������������ʧ��
//
//	link->key = key;//��ֵ����Դ�ں��������á�
//	link->data = data;//��ֵ����Դ�ں��������á�
//
//	//point head to new first node   
//	//����������������ṹ���Ϊ����
//	if (head == NULL) {
//		head = link;
//		current = link;
//	}
//	else {
//		current->next = link;
//		current = link;
//		current->next = NULL;
//	}
//}
//Live Demo

#include <stdio.h> 
#include <stdlib.h>

struct node {
	int data;
	int key;
	struct node* next;
};

typedef struct node Nd;
Nd* head = NULL;
Nd* current = NULL;

//insert link at the first location
void Insert(int key, int data) {
	//create a link
	Nd* link = (Nd*)malloc(sizeof(Nd));

	link->key = key;
	link->data = data;

	//point first to new first node

	if (head == NULL) {
		head = link;
		current = link;
	}
	else {
		current->next = link;
		current = link;
		current->next = NULL;
	}
}

Nd* find_elem(int val) {
	Nd* link = (Nd*)malloc(sizeof(Nd));
	link = head;
	while (link != NULL) {
		if (link->data == val)
			return(link);
		else
			link = link->next;
	}
	return(NULL);
}

void main() {
	Insert(1, 10);
	Insert(2, 20);
	Insert(3, 30);
	Insert(4, 40);

	//printing
	current = head;
	while (current != NULL) {
		printf("\n(Key = %d, Data = %d) \n", current->key, current->data);
		current = current->next;
	}

	//Finding element in the Linked list

	int value;
	printf("\n\nEnter the value you want to find :");
	scanf("%d", &value);

	current = find_elem(value);

	if (current == NULL)
		printf("Sorry. Your value is not in the list.\n");
	else
		printf("Your value in Node %d. \n", current->key);
}






