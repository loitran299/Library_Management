$("#btnRegister").click(async () => {
    const formData = {
        'username': $("#username").val(),
        'password': $("#password").val(),
        'fullName': $("#fullName").val(),
        'email': $("#email").val(),
        'phoneNumber': $("#phoneNumber").val()
    }
    const url = "http://localhost:8080/api/readers";
    let response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(formData),
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    console.log(response)
    if(response.status == 200) {
        alert(response.message);
        window.location.href = "http://localhost:8080/login"
    }else {
        alert(response.message);
    }
})