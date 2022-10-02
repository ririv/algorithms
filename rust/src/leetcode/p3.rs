use std::collections::HashMap;
use crate::Solution;


impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut m: HashMap<char, usize> = HashMap::new();
        let mut current_len = 0;
        let mut max_len = 0;
        let mut j = 0;

        for i in  0..s.len() {
            while j<s.len() {

                if m.contains_key(&(s.as_bytes()[j] as char)) {
                    break
                }
                m.insert(s.as_bytes()[j] as char, j);

                current_len += 1;
                j += 1;
            }
            max_len = max_len.max(current_len);
            current_len = 0;
            j = i;
            m.clear();
        }

        max_len
    }

}