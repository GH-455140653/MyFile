#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <Windows.h>

void Page()
{
	printf("欢迎进入贪吃蛇世界：\n");
	printf("按空格开始游戏，使用方向键控制蛇的方向：\n");
}

int main()
{
	Page();
	system("pause");
	return 0;
}