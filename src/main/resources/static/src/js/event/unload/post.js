let isDirty = false;

let form = document
            .querySelector(
                "form#post-create"
            );


form.addEventListener(
    "change",
    () => {
        isDirty = true;
    }
);

window.addEventListener(
    "beforeunload",
    (event) => {
        if (isDirty) {
            event.preventDefault();
            event.returnValue = "";
            return "";
        }
    }
)