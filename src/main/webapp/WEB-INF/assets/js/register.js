$("#btnRegister").click(async () => {
    debugger
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
    });
    let responses = response.json();
    console.log(responses)
    if(responses.status == 200) {
        alert(responses.message);
        $.location.href = "http://localhost:8080/home-readers"
    }else {
        alert(responses.message);
    }
})