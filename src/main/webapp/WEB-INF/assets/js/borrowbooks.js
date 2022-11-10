async function init() {
    let url = "http://localhost:8080/api/call-card/user";
    let response = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    const htmls  = response.map((item) => {
        return `<tr>
                        <td>${item.id}</td>
                        <td>${item.books.length}</td>
                        <td>${item.borrowedDate}</td>
                        <td>${item.returnedDate}</td>
                        <td>${item.status}</td>
                        <td>
                            <a href="">Chi tiết</a>
                        </td>
                    </tr>`
    })
    $("#tbd").innerHTML = htmls.join('');
}
init();