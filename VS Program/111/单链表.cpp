
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
		printf("请输入第%d个数据：", i);
		scanf("%d", &p->data);
		p->next = L->next;
		L->next = p;
	}
	return L;
}

int main(int argc, char* argv[])
{
	int n;
	printf("请问你要输入几个数据？\n");
	scanf("%d", &n);
	Li = CreateList_L(n);
	printf("\n链表中最多有%d个数是位序相邻并且大小是递增的。\n", GetMacLink(Li));
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
//typedef struct node Nd;//定义一个结构体并取名为Nd
//
//Nd* head = NULL;  	//定义一个全局变量，指向Nd这个结构体的空指针head
//Nd* current = NULL; //定义一个全局变量，指向Nd这个结构体的空指针current
//
//void Insert(int key, int data);//因为程序是从主函数才是运行的，你下面定义的Insert函数需要在主函数之前先声明。
//
//void main() {
//	Insert(1, 10);    Insert(2, 20);//函数调用
//	Insert(3, 30);    Insert(4, 40);//函数调用
//
//	//printing
//	current = head;//指针head所指向的结构体的地址赋值给指针ccurrent
//	while (current != NULL) {
//		printf("\n(Key = %d, Data = %d) \n", current->key, current->data);//满足条件是将指针指向的结构体的相应的key与data输出在控制台。
//		current = current->next;//current指向它后面的结构体
//	}
//}
//
////insert link at the first location
//void Insert(int key, int data) {
//	//create a link
//	Nd* link = (struct node*) malloc(sizeof(struct node));//动态分配一个指向结构体的指针取名为link，函数结束即消失。
//
//	link->key = key;//赋值，来源于函数被调用。
//	link->data = data;//赋值，来源于函数被调用。
//
//	//point head to new first node   
//	//下面两部用来串起结构体成为链表。
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






