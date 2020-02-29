#include "stdlib.h"
#include "stdio.h"

typedef char TElemType;

typedef struct BiTNode
{
	TElemType data;
	struct BiTNode* lchild, * rchild;
}BiTNode, * BiTree;

int NotBiTreeLeaveNum = 0, BiTreeNodeI = 4, SumBiTreeNode = 0, BiTreeLever =0, Lever ,BiTreeDegree2;

void CreateBiTree(BiTree* T)
{
	TElemType ch;
	scanf("%c", &ch);
	if (ch == ' ')*T = NULL;
	else
	{
		*T = (BiTree)malloc(sizeof(BiTNode));
		if (!*T)exit(-1);
		(*T)->data = ch;
		CreateBiTree(&(*T)->lchild);
		CreateBiTree(&(*T)->rchild);
	}
}

void DestoryBiTree(BiTree* T)
{
	if (*T)
	{
		if ((*T)->lchild)DestoryBiTree(&((*T)->lchild));
		if ((*T)->rchild)DestoryBiTree(&((*T)->rchild));
		free(*T);
		*T = NULL;
	}
}

void PreOrderTraverse(BiTree T)
{
	if (T)
	{
		printf("%c ", T->data);
		PreOrderTraverse(T->lchild);
		PreOrderTraverse(T->rchild);
	}
}

void InOrderTraverse(BiTree T)
{
	if (T)
	{
		InOrderTraverse(T->lchild);
		printf("%c ", T->data);
		InOrderTraverse(T->rchild);
	}
}

void PostOrderTraverse(BiTree T)
{
	if (T)
	{
		PostOrderTraverse(T->lchild);
		PostOrderTraverse(T->rchild);
		printf("%c ", T->data);
	}
}

void myfun(BiTree T,int node)
{
	if (T)
	{
		SumBiTreeNode++;//二叉树总结点
		if (T->lchild != NULL || T->rchild != NULL)NotBiTreeLeaveNum++;//非叶子节点个数
		if(T->lchild != NULL && T->rchild != NULL)BiTreeDegree2++;//度数为2的节点个数
		if (T->lchild == NULL && T->rchild == NULL)BiTreeLever++;//叶子节点个数
		if (T && node == BiTreeNodeI)printf("%c ",T->data);//打印第4层的节点
		//printf("%c的层号为：%d\n",T->data,node);//输出二叉树中每个节点的层号
		Lever = Lever >= node ? Lever : node;//求二叉树的深度
		myfun(T->lchild,node+1);
		myfun(T->rchild,node+1);
	}
}

void myfun_1(BiTree T, int node)
{
	if (T)
	{
		printf("%c的层号为：%d\n", T->data, node);//输出二叉树中每个节点的层号
		myfun_1(T->lchild, node + 1);
		myfun_1(T->rchild, node + 1);
	}
}

int main(int argc, char* argv[])
{
	//abc  de g  f   ;
	BiTree T;
	printf("请输入建立二叉树的字符序列（包括空格）：\n");
	CreateBiTree(&T);
	printf("\n先序递归遍历二叉树：\n");
	PreOrderTraverse(T);
	printf("\n中序递归遍历二叉树：\n");
	InOrderTraverse(T);
	printf("\n后序递归遍历二叉树：\n");
	PostOrderTraverse(T);
	printf("\n二叉树第四层的节点有：");
	printf("\n");
	myfun(T,1);
	printf("\n二叉树的非叶子节点的个数为：%d\n二叉树度数为2的节点个数为：%d\n二叉树的节点总数为：%d\n二叉树的叶子节点总数为：%d\n二叉树的深度为：%d\n", NotBiTreeLeaveNum, BiTreeDegree2, SumBiTreeNode, BiTreeLever,Lever);
	printf("\n");
	printf("每个节点的层号如下：\n");
	myfun_1(T,1);
	DestoryBiTree(&T);
}