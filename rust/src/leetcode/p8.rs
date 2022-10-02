
use crate::leetcode::solution::Solution;

//本解法只使用i32类型而不使用i64类型
impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        let v = s.trim_start().chars().collect::<Vec<_>>();
        let mut res:i32 = 0;
        let mut neg_flag = false;

        let mut iter = v.iter();

        if v.len()>0 && (v[0] == '-'|| v[0] == '+') {
            if v[0] == '-' {
                neg_flag = true;
                }
            iter.next();
        }

        for (i, c) in iter.enumerate() {

            if !c.is_digit(10){
                break
            } else{
                res = match res.checked_mul(10) { //先乘10判断溢出
                    None => {
                        if neg_flag {
                            i32::MIN
                        } else {
                            i32::MAX
                        }
                    }
                    Some(res) => {
                        match res.checked_add(c.to_digit(10).unwrap() as i32) { //再对+判断溢出
                            None => {
                                if neg_flag {
                                    i32::MIN
                                } else {
                                    i32::MAX
                                }

                            }
                            Some(res) => {res}
                        }
                    }
                }
            }
        }

        if neg_flag {
            res.checked_mul(-1).unwrap_or(i32::MIN) //请注意虽然这里不检查leetcode也能通过，但是这里应该还是要再检查一次的
        }
        else {
            res
        }

    }
}