use std::io;

pub fn input()->Vec<i32> {
    let mut input = String::new();
    io::stdin().read_line(&mut input);
    let list: Vec<i32> = input.split(" ").map(|x|
        x.trim().parse().unwrap()).collect();
    list
}
