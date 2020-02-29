#define _CRT_SECURE_NO_WARNINGS
#include "stdio.h"
#include "stdlib.h"
#include "string.h"
void strmcpy(char* s, char* t, int m)
{
	if (m <= strlen(t))//判断将要寻找的位置是否超出范围
	{
		for (int i = m; t[i] != '\0'; i++)//将将要截取部分的开始位置开始，把t数组后面的元素依次放入num数组中
		{
			s[i - m] = t[i];
			s[i + 1] = '\0';
		}
		printf("字符串s：%s", s);
	}
	else printf("m位置过大！");
}


int main()
{
		//char t[100];
		//char s[100];
		//int m;//获取开始位置
		//printf("请输入字符串t：");
		//scanf("%s", t);
		//printf("请输入你要截取的部分的开始位置：");
		//scanf("%d", &m);
		//strmcpy(s, t, m);

	char str[10][10], * p[10];
	for (int i = 0; i < 5; i++)
	{
		p[i] = str[i];
		printf("请输入第%d串字符串：",i+1);
		scanf("%s", p[i]);
	}

	for (int i = 0; i < 5; i++)
	{
		//printf("%s",*(str+i));
		puts(p[i]);
	}
	return 0;
}