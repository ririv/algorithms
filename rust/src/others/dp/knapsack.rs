use std::cmp::max;

const N: usize = 100;
const INF: i32 = 999999999;

pub fn run() { // 0/1
    let n: usize = 5;
    let v_max: usize = 10;
    let mut dp: [[i32; N]; N] = [[-INF; N]; N]; //恰好装满，初值设为负无穷
    // let mut dp: [[i32; N]; N] = [[-0; N]; N]; //普通0/1
    let items = [(0, 0), (5, 6), (5, 7), (2, 8), (8, 1), (5, 9)];

    for i in 0..=n {
        //注意左闭右开
        for j in 0..=v_max {
            // dp[0][j] = 0;
            dp[i][0] = 0;
        }
    }

    for i in 1..=n {
        for j in 1..=v_max {
            if items[i].0 > j {
                //装不下
                dp[i][j] = dp[i - 1][j];
            } else {
                //装得下
                dp[i][j] = max(dp[i - 1][j - items[i].0] + items[i].1, dp[i - 1][j]);
            }
        }
    }

    dp.map(|x| {
        x.map(|y| print!("{:>3} ", if y < 0 { "-∞".to_string() } else { y.to_string() }));
        println!();
    });

    println!("{:?}", dp[n][v_max]);
    // println!("{:?}", dp);
}

//完全背包问题
pub fn run2() {
    let n: usize = 2;
    let v_max: usize = 94;
    let mut dp: [[i32; N]; N] = [[0; N]; N]; //恰好装满
    // let mut dp: [[i32; N]; N] = [[-0; N]; N]; //普通0/1
    let items = [(0, 0), (21, 55), (88, 64)];

    for i in 0..=n {
        //注意左闭右开
        for j in 0..=v_max {
            // dp[0][j] = 0;
            dp[i][0] = 0;
        }
    }

    for i in 1..=n {
        for j in 1..=v_max {
            let mut k: usize = 0;

            //diff!
            while (k * items[i].0) < j {
                if items[i].0 > j {
                    //装不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //装得下
                    dp[i][j] = max(dp[i - 1][j - k * items[i].0] + (k * items[i].1) as i32, dp[i - 1][j]);
                }
                k += 1;
            }
        }
    }
    dp.map(|x| {
        x.map(|y| print!("{:>3} ", if y < 0 { "-∞".to_string() } else { y.to_string() }));
        println!();
    });

    println!("{:?}", dp[n][v_max]);
}



fn backtrack(i: usize, j: usize, s: &[[i32; N]; N]) {
    todo!();
}
