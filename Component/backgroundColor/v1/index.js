let colors;
let state;

Appian.Component.onNewValue(newValues => {
    colors = newValues.colors;
    let backgroundColor;
    if (!colors || colors.length === 0) {
        backgroundColor = "WHITE";
    } else if (colors.length === 1) {
        backgroundColor = colors[0];
    } else {
        backgroundColor = "PURPLE";
    }
    document.getElementById("container").style.backgroundColor = backgroundColor;
    state = newValues;

})


// 👇 Add button click handler
document.addEventListener("DOMContentLoaded", () => {
    const button = document.getElementById("printButton");

    button.addEventListener("click", async () => {
        console.log(state)
        console.log(state.connectedSystem)
        try {
            await Appian.Component.invokeClientApi(
                state.connectedSystem,
                "BackgroundColorClientAPI",
                {
                    text: state.text,
                    booleanNotSecured: state.booleanNotSecured,
                    decimalNotSecured: state.decimalNotSecured,
                    integerNotSecured: state.integerNotSecured,
                    dictionaryNotSecured: state.dictionaryNotSecured,
                    variantNotSecured: state.variantNotSecured,
                    connectedSystemNotSecured: state.connectedSystemNotSecured,
                },
                [

                    // "luahsdilauhsbegf",
                    "textHidden",
                    "textVisible",
                    "textArrVisible",
                    "textArrHidden",

                    "booleanHidden",
                    "booleanVisible",
                    "booleanArrVisible",
                    "booleanArrHidden",

                    "decimalHidden",
                    "decimalVisible",
                    "decimalArrVisible",
                    "decimalArrHidden",

                    "integerHidden",
                    "integerVisible",
                    "integerArrVisible",
                    "integerArrHidden",

                    "dictionaryHidden",
                    "dictionaryVisible",
                    "dictionaryArrVisible",
                    "dictionaryArrHidden",

                    "variantHidden",
                    "variantVisible",
                    "variantArrVisible",
                    "variantArrHidden",

                    "connectedSystemHidden",
                    "connectedSystemVisible",

                    "typedValueHidden"
                ]
            );

        } catch (error) {
            console.log(error)
        }

    });
});