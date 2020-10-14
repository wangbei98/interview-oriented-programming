# 01背包问题

## 1.暴力递归

```go
func solution(value []int,weight[],C int){
    // 用 [0,...,index] 的物品，计算容积为C的背包的最大值
    var bestValue func(index int,C int)int
    bestValue = func(index int,C int)int{
        if index < 0 || C <= 0{
            // 如果没有物品了，或者背包中没有空间了，则放不下任何物品
            return 0
        }
        // 不选当前index
        res := bestValue(index-1,C)
        // 如果可以选当前index，则选它
        if C >= weight[inde]{   
            res = max(res,value[index] + bastValue(index-1,C-weight[index]))
        }
        return res
    }
    return bestValue(n-1,C)
}

```

## 2. 记忆化搜索

```go
func solution(value []int,weight[],C int){
    // 用 [0,...,index] 的物品，计算容积为C的背包的最大值

    // n行表示 0,...n-1 个元素
    memo := make([][]int,n)
    for i:=0;i<len(memo);i++{
    	// 每行 C+1列，表示重量 1,...,C 
        memo[i] = make([]int,C+1)
    }
    for i:=0;i<len(memo);i++{
        for j:=0;j<C+1;j++{
            memo[i][j] = -1
        }
    }
    var bestValue func(index int,C int)int
    bestValue = func(index int,C int)int{
        if index < 0 || C <= 0{
            // 如果没有物品了，或者背包中没有空间了，则放不下任何物品
            return 0
        }
        if memo[index][C != -1{return memo[index][C]}
        // 不选当前index
        res := bestValue(index-1,C)
        // 如果可以选当前index，则选它
        if C >= weight[inde]{   
            res = max(res,value[index] + bastValue(index-1,C-weight[index]))
        }
        memo[index][C = res
        return memo[index][C]
    }
    return bestValue(n-1,C)
}

```