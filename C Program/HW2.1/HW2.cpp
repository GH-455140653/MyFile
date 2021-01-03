#include "stdio.h"
#include "stdlib.h"

typedef struct BiTNode { // ���ṹ
	int  data;
	struct BiTNode* lchild, * rchild; // ���Һ���ָ��
} BiTNode, * BiTree;

int CreateBiTree(BiTree& T) {
	char ch;
	scanf("%c", &ch);
	if (ch == ' ') T = NULL;
	else {
		T = (BiTNode*)malloc(sizeof(BiTNode));
		T->data = ch;              // ���ɸ����
		CreateBiTree(T->lchild);   // ����������
		CreateBiTree(T->rchild);   // ����������
	}
	return 1;
} // CreateBiTree

int levernum, lnode, rnode;

void PreOrder(BiTree T, int lnode, int rnode)
{ // ������������� 
	if ((lnode == 3 || rnode == 3) && T )levernum++;
	if (T) {
		printf("%c", T->data); // ���ʽ��
		PreOrder(T->lchild, lnode + 1, rnode+1); // ����������
		PreOrder(T->rchild, lnode+1, rnode + 1);// ����������
	}
}

int main()
{
	BiTree T;
	CreateBiTree(T);
	PreOrder(T, 1, 1);
	printf("\n%d\n", levernum);
	return 0;
}

/*
#include "stdio.h"
#include "stdlib.h"

typedef struct BiTNode { // ���ṹ
	int  data;
	struct BiTNode* lchild, * rchild; // ���Һ���ָ��
} BiTNode, * BiTree;

int CreateBiTree(BiTree& T) {
	char ch;
	scanf_s("%c", &ch);
	if (ch == ' ') T = NULL;
	else {
		T = (BiTNode*)malloc(sizeof(BiTNode));
		T->data = ch;              // ���ɸ����
		CreateBiTree(T->lchild);   // ����������
		CreateBiTree(T->rchild);   // ����������
	}
	return 1;
} // CreateBiTree

int levernum, node;

void PreOrder(BiTree T, int node)
{ // ������������� 
	if (node==3 && T )levernum++;
	if (T) {
		printf("%c", T->data); // ���ʽ��
		PreOrder(T->lchild, node+1); // ����������
		PreOrder(T->rchild, node+1);// ����������
	}
}

int main()
{
	BiTree T;
	CreateBiTree(T);
	PreOrder(T, 1);
	printf("\n%d\n", levernum);
}
*/