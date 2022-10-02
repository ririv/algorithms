//最长非下降子序列LIS
use std::cmp::max;

const N: usize = 9;

pub fn run() {
    let a = [4, 1, 7, 3, 2, 3, 5, 7, 6];
    let mut f: [i32; N] = [1; N];
    for i in 0..9usize {
        for j in 0..9usize {
            if a[i] > a[j] {
                f[i] = max(f[i], f[j] + 1);
            }
        }
    }
    println!("{}", f[N - 1])
}