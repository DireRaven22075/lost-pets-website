document
    .querySelector(
        //Form Query
        "form#form-login" // <form id="form-login"...>
    ).addEventListener(
        //Event Type
        "submit",
        //Event Handler Function
        (event) => { //Event Object
            //Block Default Event (Form Submit)
            event
                .preventDefault();

            //Define Data Object
            let data = {
                id: document
                    .querySelector(
                        //Input-ID Query
                        "input[name=id]" //<input name="id"...>
                    ).value, //Input-ID Value
                pw: document
                    .querySelector(
                        //Input-Password Query
                        "input[name=pw]" //<input name="pw"...>
                    ).value //Input-Password Value
            };

            //API Request Function
            fetch(
                //API URL
                "api/auth/login",
                //API Request Option (Method, Credentials, Header, Body)
                {
                    method: "POST", //API Method
                    credentials: "include", //API Option (Cookie & Session)
                    headers: {//API Header
                        "Content-Type": "application/json" //Content Type
                    },
                    body: JSON //API Body (Sending Data)
                        .stringify(data) //Casting (Data Object -> JSON String)
                }
            ).then(
                //API Response Handling (Casting Data)
                (res) => {
                    return res
                        .json(); //Casting (Response Object -> JSON Object)
                }
            ).then(
                //API Response Handling (Using Data)
                data => {
                    //If Request is Success
                    if (data["status"] == "success") {
                        //Redirect to the Previous Page
                        alert(data["message"]);
                        window.location.href='/';
                    }
                    //If Request is Failed
                    else {

                        let msg = document
                            .querySelector(
                                //Text Message Query
                                "#text-msg" //<* id="text-msg" ..>
                            );
                        msg
                            .hidden = false;
                        if (data["message"] == "Invalid ID") {

                        }
                        msg
                            .innerHTML = data["message"];
                    }
                }
            ).catch(
                (err) => console.error(err)
            );
        }
    );