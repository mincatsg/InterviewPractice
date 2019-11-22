// 一. 加一
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//你可以假设除了整数 0 之外，这个整数不会以零开头。

int* plusOne(int* digits, int digitsSize, int* returnSize){
	*returnSize = digitsSize;
	//从后遍历数组，加1模仿进位.
	for (int i = digitsSize - 1; i >= 0; i--){
		++digits[i];
		if (digits[i] % 10 == 0){
			digits[i] = 0;
		}
		else{
			return digits;
		}
	}
	  //加到第一个还继续进位，则就成1后面数组长度个0.
	int *num = (int*)malloc(sizeof(int)* (digitsSize + 1));
	num[0] = 1;
	for (int i = 0; i < digitsSize; i++){
		num[i + 1] = 0;
	}
	*returnSize = digitsSize + 1;
	return num;
}

//二. 爬台阶
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//注意：给定 n 是一个正整数。

int climbStairs(int n){
	if (n == 1 || n == 2){
		return n;
	}
	else{
		int num = 2;
		int num1 = 1;
		int sum;
		for (int i = 3; i <= n; i++){
			sum = num1 + num;
			num1 = num;
			num = sum;
		}
		return sum;
	}
}

//三.x的平方根
//
//实现 int sqrt(int x) 函数。
//
//计算并返回 x 的平方根，其中 x 是非负整数。
//
//由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。


int mySqrt(int x){
	if (x == 0){
		return 0;
	}
	int left = 1;
	int right = x / 2;
	long mid;
	long squa;
	while (left < right){
		mid = (left + right + 1) >> 1;
		squa = mid * mid;
		if (squa > x){
			right = mid - 1;
		}
		else{
			left = mid;
		}
	}
	return left;
}
