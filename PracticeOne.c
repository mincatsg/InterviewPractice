#include<stdlib.h>
#include<time.h>

//猜数字游戏
void  put(){
	printf("********************************************\n");
	printf(" 1. 开始游戏\n");
	printf(" 2. 游戏结束\n");
	printf("********************************************\n");
}
void game(){
	int count = 0;
	int i = 1;
	srand((unsigned)time(0));
	int random = rand() % 100 + 1;
	while (1){
		printf("请输入一个数字\n");
		scanf("%d", &i);
		if (i > random){
			printf("高了,应该在(1 ~ %d)之间\n", i);
			count++;
		}
		else if (i < random){
			printf("低了,应该在(%d ~ 100)之间\n", i);
			count++;
		}
		else if (i == random){
			printf("猜对了\n");
			count++;
			printf("共猜了%d次\n", count);
			break;
		}
	}
}
int main(){
	put();
	int choice = 1;
	while (1){
		printf("请选择\n");
		scanf("%d", &choice);
		if (choice == 1){
			game();
		}
		else if (choice == 2){
			printf("游戏结束\n");
			break;
		}
		else{
			printf("你的输入有误,请重输 \n");
		}
	}
	system("pause");
	return 0;
}








//密码登录
#include<string.h>

int main(){
	char str1[] = { "123456" };
	char str[] = { "" };
	int i = 3;
	while (i > 0){
		printf("请输入密码:  ");
		scanf("%s", str);
		if (strcmp(str, str1) == 0){
			printf("密码正确\n");
			break;
		}
		else{
			--i;
			printf("请重新输入，你还有%d机会\n", i);
		}

	}
	system("pause");
	return 0;
}