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
		SumBiTreeNode++;//�������ܽ��
		if (T->lchild != NULL || T->rchild != NULL)NotBiTreeLeaveNum++;//��Ҷ�ӽڵ����
		if(T->lchild != NULL && T->rchild != NULL)BiTreeDegree2++;//����Ϊ2�Ľڵ����
		if (T->lchild == NULL && T->rchild == NULL)BiTreeLever++;//Ҷ�ӽڵ����
		if (T && node == BiTreeNodeI)printf("%c ",T->data);//��ӡ��4��Ľڵ�
		//printf("%c�Ĳ��Ϊ��%d\n",T->data,node);//�����������ÿ���ڵ�Ĳ��
		Lever = Lever >= node ? Lever : node;//������������
		myfun(T->lchild,node+1);
		myfun(T->rchild,node+1);
	}
}

void myfun_1(BiTree T, int node)
{
	if (T)
	{
		printf("%c�Ĳ��Ϊ��%d\n", T->data, node);//�����������ÿ���ڵ�Ĳ��
		myfun_1(T->lchild, node + 1);
		myfun_1(T->rchild, node + 1);
	}
}

int main(int argc, char* argv[])
{
	//abc  de g  f   ;
	BiTree T;
	printf("�����뽨�����������ַ����У������ո񣩣�\n");
	CreateBiTree(&T);
	printf("\n����ݹ������������\n");
	PreOrderTraverse(T);
	printf("\n����ݹ������������\n");
	InOrderTraverse(T);
	printf("\n����ݹ������������\n");
	PostOrderTraverse(T);
	printf("\n���������Ĳ�Ľڵ��У�");
	printf("\n");
	myfun(T,1);
	printf("\n�������ķ�Ҷ�ӽڵ�ĸ���Ϊ��%d\n����������Ϊ2�Ľڵ����Ϊ��%d\n�������Ľڵ�����Ϊ��%d\n��������Ҷ�ӽڵ�����Ϊ��%d\n�����������Ϊ��%d\n", NotBiTreeLeaveNum, BiTreeDegree2, SumBiTreeNode, BiTreeLever,Lever);
	printf("\n");
	printf("ÿ���ڵ�Ĳ�����£�\n");
	myfun_1(T,1);
	DestoryBiTree(&T);
}