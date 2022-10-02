use std::io;
use std::io::Read;

const MAX: i32 = 0xfffffff;
const N: usize = 100;

fn matrices_chain(n: usize, p: &mut [i32; N], s: &mut [[i32; N]; N], dp: &mut [[i32; N]; N]) {
    let mut temp = String::new();
    for i in 0..n {
        std::io::stdin().read_to_string(&mut temp).unwrap() as i32;
        p[i] = temp.trim().parse::<i32>().unwrap();
        dp[i][i] = 0; //只有一个矩阵时不能相乘
    }

    for l in 2..n {
        //相乘矩阵的个数
        for i in 1..n {
            let j = i + l - 1;
            if j > n {
                break;
            }
            for k in i..j - 1 {
                //遍历切割位置
                let mut min = dp[i][j];
                let temp = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                if temp < min {
                    dp[i][j] = temp;
                    min = temp;
                    s[i][j] = k as i32;
                }
                //	dp[i][j]=min(dp[i][j],dp[i][k]+dp[k+1][j]+p[i-1]*p[k]*p[j]);
            }
        }
    }
}

fn traceback(i: usize, j: usize, s: &[[i32; N]; N]) {
    if i == j {
        return;
    };
    let k = s[i][j] as usize;
    traceback(i, k, &s);
    traceback(k + 1, j, &s);
    println!("A[{}:{}]*A[{}:{}]", i, k, k + 1, j);
}

pub fn run() {
    let mut p: [i32; N] = [MAX; N];
    let mut s: [[i32; N]; N] = [[MAX; N]; N];
    let mut dp: [[i32; N]; N] = [[0; N]; N]; //S存储切割位置，dp存储最优值

    let mut input = String::new();
    io::stdin().read_line(&mut input);
    let n = input.trim().parse::<usize>().unwrap();

    matrices_chain(n, &mut p, &mut s, &mut dp);
    for i in 1..n {
        for j in 1..n {
            print!("{} ", dp[i][j]);
        }
        println!();
    }

    for i in 1..n {
        for j in 1..n {
            print!("{} ", s[i][j]);
        }
        println!();
    }

    println!("连乘的最少次数是{}次", dp[1][n]);
    traceback(1, n, &s);
}
/*
6
2 7 5 4 2 3 8
5
30 35 15 5 10 20
*/
