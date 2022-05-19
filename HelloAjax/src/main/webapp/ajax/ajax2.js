let val = 6;

let promise = new promise((resolve, reject) => {
    val -= 1;
    if (val > 0) {
        resolve('success'); // 성공하면 매개값 정의해서 then 으로 보내기
    } else {
        reject('error');
    }
});