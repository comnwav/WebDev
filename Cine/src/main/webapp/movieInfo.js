let key = "6446bae76aaffa9af6d4c00b2299f016";

let srcPara = new URL(location.href).searchParams;
let name = srcPara.get('title');
let movieId = srcPara.get('movieId');
let sessionId = 'testId';

let f1 = document.querySelector('.f1');
let f2 = document.querySelector('.f2');
let f3 = document.querySelector('.f3');
let f4 = document.querySelector('.f4');
let f5 = document.querySelector('.f5');
let f6 = document.querySelector('.f6');

let current_page = 1;

function infoPage() {
    fetchMovie();
    // fetchVideo();
    makePage()
    fetchComment();
    makeNav(current_page);
    showComment(current_page);
}

function fetchMovie() {
    let url = `https://api.themoviedb.org/3/search/movie?api_key=${key}&query=${name}&language=ko-KR`;
    let base_url = "https://image.tmdb.org/t/p/w500";

    fetch(url)
        .then(res => res.json())
        .then(res => {
            // query 결과확인
            let movie = res.results[0];

            // result 에서 가져올 항목
            let poster = base_url + movie.poster_path;
            let overview = movie.overview;
            let title = movie.original_title;
            let relDate = movie.release_date;

            // f1-1 poster
            let imgTag = document.createElement('img');
            imgTag.setAttribute('width', '300');
            imgTag.src = poster;

            f1.firstElementChild.appendChild(imgTag);

            // f1-2 reserve button
            let rsTag = document.createElement('a');
            rsTag.innerHTML = '예매하기';
            rsTag.href = `${title}어디론가갑니다`
            f1.lastElementChild.appendChild(rsTag);

            // f2 info
            let titleTag = document.querySelector('.title');
            titleTag.innerHTML = title;
            f2.appendChild(titleTag);

            let infoTag = document.querySelector('.info');
            infoTag.innerHTML = `개봉일 ${relDate}`;
            f2.appendChild(infoTag)

            // f3 overview
            let ovTag = document.querySelector('.f3');
            ovTag.firstElementChild.innerHTML = overview;
        })
        .catch(error => console.log(error));
};

function fetchVideo() {
    let url = `https://api.themoviedb.org/3/movie/${movieId}/videos?api_key=${key}&language=en-EN`;
    let youtube = document.querySelector('.youtube');

    fetch(url)
        .then(res => res.json())
        .then(res => {
            let ary = res.results;
            console.log(ary);

            ary.forEach(element => {
                let vid = document.createElement('iframe');
                let key = element.key;
                vid.src = `https://www.youtube.com/embed/${key}?autoplay=0`;
                youtube.appendChild(vid);
            });
        })
}

function makePage() {
    let url = `commnetPage.do`;

    fetch(url, {
            method: 'post',
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: `movieId=${movieId}`
        })
        .then(res => res.json())
        .then(res => {
            function totNumPages() {
                return Math.ceil(res.count / 5);
            }
            let page = document.getElementById('page');
            page.innerHTML = "";
            for (let i = 1; i <= totNumPages(); i++) {
                let a = document.createElement('a');
                a.innerHTML = ` ${i} `;
                a.href = '#';
                a.addEventListener('click', e => {
                    showComment(i);
                })
                page.appendChild(a);
            }
        })
}

function makeNav(current_page) {
    let url = `commnetPage.do`;

    fetch(url, {
            method: 'post',
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: `movieId=${movieId}`
        })
        .then(res => res.json())
        .then(res => {
            function totNumPages() {
                return Math.ceil(res.count / 5);
            }

            let btn_prev = document.getElementById("btn_prev");
            btn_prev.addEventListener('click', prevPage);
            let btn_next = document.getElementById("btn_next");
            btn_next.addEventListener('click', nextPage);

            function prevPage() {
                if (current_page > 1) {
                    current_page--;
                    change(current_page);
                }
            }

            function nextPage() {
                if (current_page < totNumPages()) {
                    current_page++;
                    change(current_page);
                }
            }

            function change(page) {
                if (page < 1) page = 1;
                if (page > totNumPages()) page = totNumPages();
                showComment(page);
            }
        })
}

function showComment(page) {
    let url = `commnetList.do`;

    let tr = document.getElementById('cmtTable');
    tr.innerHTML = "";

    fetch(url, {
            method: 'post',
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: `movieId=${movieId}&page=${page}`
        })
        .then(res => res.json())
        .then(res => {
            res.forEach(element => {
                let table = document.querySelector('#cmtTable');
                let tr = document.createElement('tr');

                let id = document.createElement('td');
                id.innerHTML = element.id;
                id.setAttribute("width", "100");
                tr.appendChild(id);

                let cmt = document.createElement('td');
                cmt.innerHTML = element.cmt;
                cmt.setAttribute("width", "300");
                tr.appendChild(cmt);

                let stars = document.createElement('td');
                stars.innerHTML = `&#11088;${element.stars}`;
                stars.setAttribute("width", "10");
                stars.setAttribute("align", "center")
                tr.appendChild(stars);

                let date = document.createElement('td');
                date.innerHTML = element.date;
                date.setAttribute("width", "100");
                date.setAttribute("align", "center")
                tr.appendChild(date);

                let del = document.createElement('td');
                del.addEventListener('click', e => {
                    if (sessionId == element.id) {
                        delComment(element.code);
                    } else {
                        alert("본인이 작성한 게시물만 삭제할 수 있습니다.");
                    }
                })
                del.setAttribute("width", "10");
                del.setAttribute("align", "center")
                del.innerHTML = '&#10060;';
                tr.appendChild(del);

                table.appendChild(tr);
            })
        })
}

function delComment(val) {
    let url = `commentDel.do`;
    fetch(url, {
            method: 'post',
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: `code=${val}`
        })
        .then(res => {
            showComment(current_page);
            makePage()
        })
}

function fetchComment() {
    let url = `commentAdd.do`;

    let bt = document.querySelector('.bt');
    bt.addEventListener('click', e => {
        let comment = document.getElementById('area').value;
        let stars = document.querySelectorAll('.star-rating>input');
        let val;

        stars.forEach(element => {
            if (element.checked == true) {
                val = element.value;
            }
        })

        fetch(url, {
                method: 'post',
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body: `comment=${comment}&stars=${val}&movieId=${movieId}`
            })
            .then(res => {
                document.getElementById('area').value = "";
                stars.forEach(element => {
                    element.checked = false;
                })
                showComment(current_page);
                makePage()
            })
    })
}

window.addEventListener('onLoad', infoPage());