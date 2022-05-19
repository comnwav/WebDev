/**
 * ajax.js
 */

// 비동기

let val = 10;

setTimeout(() => {
    val += 5;
    console.log("hello ->" + val);

    setTimeout(() => {
        val += 3;
        console.log("hello2 ->" + val);

        setTimeout(() => {
            val += 4;
            console.log("hello3 ->" + val);
        }, 1000);
    }, 1000);
}, 2000);

// promise 함수 
let success = true;

let promise = new promise((resolve, reject) => {
    if (success) {
        resolve('success');
    } else {
        reject('error');
    }

    console.log("hello World");
});

// then과 catch는 function 을 parameter 로 받는다
// promise 가 정상실행되면 then 실패면catch가 실행
promise.then((result) => {
        console.log(result);
    })
    .then((result) => {
        console.log(result);
    })
    .then((result) => {
        console.log(result);
    })
    .catch((err) => {
        console.log(err);
    });