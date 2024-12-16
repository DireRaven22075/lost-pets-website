let copyright = document
                    .querySelector("strong#text-copyright");
copyright
    .classList
    .add("btn");
if (copyright) {
    copyright
        .addEventListener(
            "click",
            () => {
                window
                    .open(
                        "https://www.github.com/DireRaven22075/opensource-project"
                    );
            }
        );
}

