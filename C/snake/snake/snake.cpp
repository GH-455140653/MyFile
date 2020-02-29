#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

void startGame()//开始游戏
{
	HANDLE hOut=GetStdHandle(STD_OUTPUT_HANDLE);
	//制作游戏窗口
	makeFrame(hOut);
	//初始化蛇
	//产生食物
}


void makeFrame(HANDLE hOut)//绘制游戏窗口
{
	printf("→");
}

int main()
{
	startGame();
	return 0;
}