document
    .querySelector(
        "form#form-post"
    ).addEventListener(
        "click",
        () => {
            document
                .querySelector(
                    "input#input-title"
                ).placeholder = "글 제목";
            document
                .querySelector(
                    "form#form-post"
                ).classList
                .add(
                    "visible"
                );
        }
    );