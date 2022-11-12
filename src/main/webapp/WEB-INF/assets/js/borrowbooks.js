
async function init() {
    localStorage.removeItem("booksSelected");
    let url = "http://localhost:8080/api/call-card/user";
    let response = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    response.map((item) => {
        let tr = $(`<tr></tr>`)
        tr.append(`<td>${item.id}</td>`);
        tr.append(`<td>${item.books.length}</td>`);
        tr.append(`<td>${item.borrowedDate}</td>`);
        tr.append(`<td>${item.returnedDate}</td>`);
        tr.append(`<td>${item.status}</td>`);
        let btn = $(`<a href="">Chi tiết</a>`)

        tr.append($(`<td></td>`).append(btn));


        $("#tbd").append(tr);
    })
}
init();