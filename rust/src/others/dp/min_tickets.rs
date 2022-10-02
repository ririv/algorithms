//leetcode 983
use std::cmp::min;
use std::collections::HashSet;


const  dayset:[usize;6] = [1,4,6,7,8,20];
const  COSTS:[usize;3] = [2,7,15];

pub fn run(){
    let mut memo:[usize;366] = [0;366];
    let res = dp(1, memo);
    println!("{}",res);

    fn dp(i:usize, mut memo: [usize;366], ) ->usize {
        if i > 365 {
            return 0;
        }

        if dayset.contains(&i){
            memo[i] = min(dp(i+1, memo,)+COSTS[0],dp(i+3, memo,)+COSTS[1]);
            memo[i] = min(memo[i],dp(i+7, memo,)+COSTS[2]);
            return memo[i];
        }
        else {
            memo[i] = dp(i+1,memo,);
        }
        memo[i]
    }
}

