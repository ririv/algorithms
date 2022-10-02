// mod activities_selection;

// use std::io::{stdin, stdout};

// mod two_sum;
// mod input_util;
mod  leetcode;

use leetcode::solution::Solution;


fn main() {

    p10();
}

fn p10(){
    let ans  = Solution::is_match(String::from("aab"),String::from("c*a*b"));
    println!("{}",ans);
}
