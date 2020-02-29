// Practice.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

void sort(char s[][10])
{
	for(int i=0;i<4;i++)
	{
		char temp[10];
		if(s[i][0]>s[i+1][0])
		{
			temp[10]=s[i];
			s[i]=s[i+1];
			s[i+1]=temp[10];
		}
	}
}

int main(int argc, _TCHAR* argv[])
{
	/*
	char str[]="program",*p=str;
	printf("%s\n",p);
	*/

	/*
	char str[20],*p;
	p=str;
	scanf("%s",p);//oh,my baby.
	printf("%s\n",p);//oh,my
	*/

	/*
	char str[20],*p;
	p=str;
	gets(p);//oh,my baby.
	puts(p);//oh,my baby.
	*/

	char str[10][10]={0},*p[10];
	for(int i=0;i<5;i++)
	{
		p[i]=str[i];
		printf("请输入第%d个字符串：",i+1);
		gets(p[i]);
	}
	for(int i=0;i<5;i++)
	{
		//puts(p[i]);
		printf("%s ",p[i]);
		printf("\n");
	}

	sort(str);
	 
	return 0;
}
