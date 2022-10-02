
//TODO 未完成

pub fn run() {
    let mut a = [6, 3, 7, 8, 5, 1, 4, 2, 4, 9, 10];
    let mut low = 0;
    let mut  high = a.len()-1;
    QuickSort(a, low,high);
    // println!("{:?}", a);
}

fn QuickSort(mut a: [usize;11], mut low: usize, mut high: usize) {
    if low >= high {
        return;
    }

    let p = a[low];
    while low < high {
        while low < high && a[low] <= p {
            low += 1;
        }
        a[high] = a[low];
        while low < high && a[high] >= p {
            high -= 1;
        }
        a[low] = a[high];

    }
    println!("{:?}", a);
    a[low] = p;
    println!("{}",low);
    if p>1 {
        QuickSort(a, low, p - 1);
    }
    QuickSort(a, p+1, high);
}