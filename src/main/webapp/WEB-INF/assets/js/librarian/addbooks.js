var id = $('#idCallCard').val();
var books = []
var selected = []

async function initAddBook() {
    let url = "http://localhost:8080/api/books";
    let response = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    books = response;
    getBooksByCallCardId();
    renderBooks();
    initEvents();
}
initAddBook();

function initEvents() {
    $('#input-search').keyup(function(e){
        if(e.keyCode == 13)
        {
            searchBook();
        }
    });

    $('#backToBorrow').click(() => {
        console.log("backToBorrow")
        renderBooksInBorrow(selected);
    })

    $('#btnSave').click(() => {
        updateCallCard();
    })
}

async function updateCallCard() {
    let url = `http://localhost:8080/api/call-card/${id}`;
    let data = selected.map((item) => {
        return item.id;
    });
    let body = {
        'ids' : data
    }
    let response = await fetch(url, {
        method: "PUT",
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    if (response.status == 200) {
        alert(response.message);
        window.location.href = `http://localhost:8080/borrow-detail?id=${id}`;
    }else {
        alert(response.message);
    }
}

function onClickAddBook(item) {
    if(selected.some((book) => book.code === item.code)) return;
    selected.push(item);
    renderChooseBook();
}

function onClickRemove(item) {
    const index = selected.indexOf(item);
    if (index > -1) { // only splice array when item is found
        selected.splice(index, 1); // 2nd parameter means remove one item only
    }
    renderChooseBook()
}

function renderBooks() {
    $("#tbody1").empty();
    books.map((item) => {
        let tr = $(`<tr></tr>`)
        tr.append(`<td>${item.code}</td>`);
        tr.append(`<td>${item.title.name}</td>`);
        tr.append(`<td>${item.status}</td>`);
        tr.append(`<td>${item.title.category.name}</td>`);
        tr.append(`<td><a href="http://localhost:8080/book-detail?id=${item.id}">Chi tiết</a></td>`);
        let btn = $(`<button class="btn-page">Thêm</button>`)
        btn.click(() => {
            onClickAddBook(item);
        })
        tr.append($(`<td></td>`).append(btn));
        $("#tbody1").append(tr);
    })
}

function  renderChooseBook() {
    $("#tbody2").empty();
    selected.map((item) => {
        let tr = $(`<tr></tr>`)
        tr.append(`<td>${item.code}</td>`);
        tr.append(`<td>${item.title.name}</td>`);
        tr.append(`<td>${item.status}</td>`);
        tr.append(`<td>${item.title.category.name}</td>`);
        let btn = $(`<a class="btn-page bg-red">Xóa</a>`)
        btn.click(() => {
            onClickRemove(item);
        })
        tr.append($(`<td></td>`).append(btn));
        $("#tbody2").append(tr);
    })
}

async function searchBook() {
    let info = $("#input-search").val();
    let url = `http://localhost:8080/api/books/search?information=${info}`;
    let response = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    books = response;
    renderBooks();
}


    async function getBooksByCallCardId() {
        let info = $("#input-search").val();
        let url = `http://localhost:8080/api/books/${id}`;
        let response = await fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            }
        }).then((responses) => {return responses.json()}).then((results) => {return results});
        selected = response;
        renderChooseBook();
    }