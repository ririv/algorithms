use std::{
    io,
    collections::HashMap,
};

// 3 1 6 7 8 9
pub fn run() {
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut input = String::new();
    io::stdin().read_line(&mut input);
    let list: Vec<i32> = input.split(" ").map(|x|
        x.trim().parse().unwrap()).collect();
    println!("{:?}", list);
    let target = 13;
    for (i, item) in list.iter().enumerate() {
        if map.contains_key(&(target - item)) {
            println!("{} {}", target - item,item);
            println!("{} {}", map.get(&(target - item)).unwrap(),i);
        }
        map.insert(*item, i as i32);
    }
}

//leetcode
pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut map: HashMap<i32, i32> = HashMap::new();
    let mut result:Vec<i32> = vec![];
    for (i, item) in nums.iter().enumerate() {
        if map.contains_key(&(target - item)) {
            result.push(*map.get(&(target - item)).unwrap());
            result.push(i as i32);
            return result;
        }
        map.insert(*item, i as i32);
    }
    result
}

