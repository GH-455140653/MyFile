#include "stdio.h"
#include "stdlib.h"
#include "string.h"
void strmcpy(char* s, char *t, int m)
{
	char num[20]="";
	puts(t);
	printf("m=%d\n", m);
	//s = t;
	//puts(s);
	//int k = strlen(s);
	if (m <= strlen(t))
	{
		/*
		for (int i = 0; i < m ; i++)
		{
			num[i] = t[i];
			num[i + 1] = '\0';
		}
		puts(num);
		s = strtok(s,num);
		while (s != NULL) 
		{
			printf("%s\n", s);
			s = strtok(NULL, num);
		}*/
		for (int i = m; t[i] != '\0'; i++)
		{
			num[i-m] = t[i];
			num[i + 1] = '\0';
		}
		s = num;
		printf("%s",s);
	}
	else printf("mλ�ù���");
}
int main()
{
	char t[] = "liwangzhangjinxiao";
	char s[] = "";
	char* b = t;//ָ��t������׵�ַָ��a
	char* a = s;//ָ��s������׵�ַָ��b
	int m ;//��ȡ��ʼλ��
	//printf("�������ַ���t��");
	//scanf("%s",t);
	printf("��������Ҫ��ȡ�Ĳ��ֵĿ�ʼλ�ã�");
	scanf("%d",&m);
	strmcpy(a, b, m);
	return 0;
}