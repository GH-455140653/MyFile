#include "stdio.h"
#include "stdlib.h"

typedef struct BiTNode { // 结点结构
	int  data;
	struct BiTNode* lchild, * rchild; // 左右孩子指针
} BiTNode, * BiTree;

int CreateBiTree(BiTree& T) {
	char ch;
	scanf("%c", &ch);
	if (ch == ' ') T = NULL;
	else {
		T = (BiTNode*)malloc(sizeof(BiTNode));
		T->data = ch;              // 生成根结点
		CreateBiTree(T->lchild);   // 构造左子树
		CreateBiTree(T->rchild);   // 构造右子树
	}
	return 1;
} // CreateBiTree

int levernum, lnode, rnode;

void PreOrder(BiTree T, int lnode, int rnode)
{ // 先序遍历二叉树 
	if ((lnode == 3 || rnode == 3) && T )levernum++;
	if (T) {
		printf("%c", T->data); // 访问结点
		PreOrder(T->lchild, lnode + 1, rnode+1); // 遍历左子树
		PreOrder(T->rchild, lnode+1, rnode + 1);// 遍历右子树
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

typedef struct BiTNode { // 结点结构
	int  data;
	struct BiTNode* lchild, * rchild; // 左右孩子指针
} BiTNode, * BiTree;

int CreateBiTree(BiTree& T) {
	char ch;
	scanf_s("%c", &ch);
	if (ch == ' ') T = NULL;
	else {
		T = (BiTNode*)malloc(sizeof(BiTNode));
		T->data = ch;              // 生成根结点
		CreateBiTree(T->lchild);   // 构造左子树
		CreateBiTree(T->rchild);   // 构造右子树
	}
	return 1;
} // CreateBiTree

int levernum, node;

void PreOrder(BiTree T, int node)
{ // 先序遍历二叉树 
	if (node==3 && T )levernum++;
	if (T) {
		printf("%c", T->data); // 访问结点
		PreOrder(T->lchild, node+1); // 遍历左子树
		PreOrder(T->rchild, node+1);// 遍历右子树
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