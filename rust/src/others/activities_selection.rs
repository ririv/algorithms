struct Activity(i32,i32);

pub fn run(){
    // let a:Vec<Activity> = Vec::new();
    let mut a = [Activity(1,2),Activity()];
    a.sort_by(a,);
}