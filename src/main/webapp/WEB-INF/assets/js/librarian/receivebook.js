
async function init() {
    localStorage.removeItem("booksSelected");
    // let info = $("#input-search").val();
    // let url = `http://localhost:8080/api/call-card/find?information=${info}`;
    // let response = await fetch(url, {
    //     method: "GET",
    //     headers: {
    //         "Content-Type": "application/json; charset=UTF-8"
    //     }
    // }).then((responses) => {return responses.json()}).then((results) => {return results});
    getData();
    initEvents();
}
init();

function initEvents() {
    $('#input-search').keyup(function(e){
        if(e.keyCode == 13)
        {
            getData();
        }
    });
}

async function getData() {
    let info = $("#input-search").val();
    let url = `http://localhost:8080/api/call-card/find?information=${info}`;
    let response = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    renderGrid(response);
}

function renderGrid(callCard) {
    $("#tbd").empty();
    callCard.map((item) => {
        let tr = $(`<tr></tr>`)
        tr.append(`<td>${item.id}</td>`);
        tr.append(`<td>${item.books.length}</td>`);
        tr.append(`<td>${item.borrowedDate}</td>`);
        tr.append(`<td>${item.reader.fullName}</td>`);
        tr.append(`<td>${item.returnedDate}</td>`);
        tr.append(`<td>${item.status}</td>`);
        let btn = $(`<a href="http://localhost:8080/borrow-detail?id=${item.id}" class="btn-page">Thay đổi</a>`)
        tr.append($(`<td></td>`).append(btn));
        let btn2 = $(`<a href="http://localhost:8080/call-card-detail?id=${item.id}" class="btn-page">Xác nhận lấy</a>`)
        tr.append($(`<td></td>`).append(btn2));


        $("#tbd").append(tr);
    })
}