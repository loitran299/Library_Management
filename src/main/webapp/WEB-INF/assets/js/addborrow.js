let selected = {};
function init() {
    let results = localStorage.getItem("booksSelected");
    if (results) {
        selected = JSON.parse(results);
        renderBooksInBorrow(selected);
    }

    initEvents();
}

init();

function initEvents() {
    $('#backToBorrowBook').click(() =>{
        localStorage.removeItem("booksSelected");
    })

    $('#btnAddBorrow').click(() =>{
        addBorrow();
    })
}

function renderBooksInBorrow(books) {
    $("#tbody3").empty();
    books.map((item) => {
        let tr = $(`<tr></tr>`)
        tr.append(`<td>${item.code}</td>`);
        tr.append(`<td>${item.title.name}</td>`);
        tr.append(`<td>${item.status}</td>`);
        tr.append(`<td>${item.title.category.name}</td>`);
        tr.append(`<td>${item.title.author.name}</td>`);
        tr.append(`<td><a href="">Chi tiết</a></td>`);
        $("#tbody3").append(tr);
    })
}

async function addBorrow() {
    let url = "http://localhost:8080/api/call-card";
    let data = selected.map((item) => {
        return item.id;
    });
    let returnedDate = $("#payDate").val();
    let body = {
        'ids' : data,
        'returnedDate' : returnedDate
    }
    let response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    console.log(response)
    if (response.status == 200) {
        alert(response.message);
        window.location.href = "http://localhost:8080/borrow-books";
    }else {
        alert(response.message);
    }
}