// post.js

// 리스트
document.addEventListener('DOMContentLoaded', init);

function init() {
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', '../studentList.json');
	xhtp.send();
	xhtp.onload = function() {
		let data = JSON.parse(xhtp.responseText);

		let tbodyList = document.getElementById('list')

		data.forEach(elem => {
			let newTr = makeTr(elem);
			tbodyList.appendChild(newTr)
		})
	} // end of onload

	let modBtn = document.querySelector('input[type="button"]');
	
	modBtn.addEventListener('click', function() {
		let no = document.querySelector('input[name="sno"]').value;
		let name = document.querySelector('input[name="sname"]').value;
		let eng = document.querySelector('input[name="eScore"]').value;
		let kor = document.querySelector('input[name="kScore"]').value;
		
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', `modStudentServlet?a=${no}&b=${name}&c=${eng}&d=${kor}`);
		xhtp.send();
		xhtp.onload = function() {
			
			let result = JSON.parse(xhtp.responseText);
			
			console.log(result);

			if (result.retCode == 'Success') {
				// 결과값으로 받은 값을 => 새로운 tr
				
				let obj = {
					studentNo: result.studNo,
					studentName: result.studName,
					engScore: result.engScore,
					koreScore: result.korScore
				}
				let newTr = makeTr(obj);
				let oldTr = document.getElementById(result.studNo);
				document.getElementById('list').replaceChild(newTr, oldTr); // replaceChild(바꿀놈, 바뀔놈)
			} else {
				alert('변경 중 오류.')
			}
		}
		
	})
} // end of init

// 변경처리
function modStudent() {

}

// 한건추가
function addStudent(e) {
	e.preventDefault(); // submit -> 차단
	console.log(e);

	let no = document.querySelector('input[name="sno"]').value;
	let name = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="eScore"]').value;
	let kor = document.querySelector('input[name="kScore"]').value;

	let xhtp = new XMLHttpRequest(); // 비동기 방식으로 서버의 파일요청.
	xhtp.open('get', `addStudentServlet?sno=${no}&sname=${name}&eScore=${eng}&kScore=${kor}`);
	xhtp.send();
	xhtp.onload = function() {
		console.log(xhtp.responseText); // {"retCode":"Success"}

		let result = JSON.parse(xhtp.responseText); // {retCode:"Success"}

		if (result.retCode == 'Success') {
			// 리스트 새로운 값 추가

			console.log(result);

			successCallBack2(result);

		} else if (result.retCode == 'Fail') {
			// 처리중 에러가 발생
			failCallBack();
		}

	} // end of function()
} // end of addStudent(e)

function makeTr(stu) {

	let tr = document.createElement('tr');
	tr.setAttribute('id', stu.studentNo);

	for (let field in stu) {
		let td = document.createElement('td');
		td.innerHTML = stu[field];
		tr.appendChild(td);
	}

	// 삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';

	// 이벤트 등록
	btn.addEventListener('click', function() {
		// 삭제 (id 파악 => ajax 호출)
		// this => 이벤트 대상 element = btn
		let id = this.parentElement.firstChild.innerHTML;

		console.log(id);



		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'DelStudentServlet?delId=' + id);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			console.log(result);
			if (result.retCode == 'Ok') {
				document.getElementById(id).remove();
				alert(result.retVal + '번이 삭제되었습니다.');
				console.log(result);
			} else {

			}
		}
	})

	//
	td.appendChild(btn);
	tr.appendChild(btn);
	return tr;
}

function successCallBack() {

	// 사용자 입력값을 id='list' 하위 추가.
	let no = document.querySelector('input[name="sno"]').value;
	let name = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="eScore"]').value;
	let kor = document.querySelector('input[name="kScore"]').value;

	let obj = [no, name, eng, kor];

	document.getElementById('list').appendChild(makeTr(obj));

}

function successCallBack2(retObj) {

	console.log(retObj);

	let obj = {
		studentNo: retObj.studNo,
		studName: retObj.studName,
		engScore: retObj.engScore,
		korScore: retObj.korScore
	}

	document.getElementById('list').appendChild(makeTr(obj));

}

function failCallBack() {
	alert('처리 중 에러가 발생.');
}