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
    let booksSelected = JSON.parse(localStorage.getItem("booksSelected"));
    if(booksSelected){
        selected = Array.from(booksSelected);
        renderChooseBook();
    }
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
}

function onClickAddBook(item) {
    if(selected.some((book) => book.code === item.code)) return;
    selected.push(item);
    // localStorage.setItem("booksSelected");
    localStorage.setItem("booksSelected", JSON.stringify(selected));
    renderChooseBook();
}

function onClickRemove(item) {
    const index = selected.indexOf(item);
    if (index > -1) { // only splice array when item is found
        selected.splice(index, 1); // 2nd parameter means remove one item only
    }
    localStorage.setItem("booksSelected", JSON.stringify(selected));
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
        tr.append(`<td><a href="">Chi tiết</a></td>`);
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