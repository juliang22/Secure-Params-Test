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

    button.addEventListener("click", () => {
        console.log(state)
        console.log(state.connectedSystem)
        Appian.Component.invokeClientApi(
            state.connectedSystem, 
            "BackgroundColorClientAPI", 
            { message: "normal payload" },
            ["visible", "hidden"])
    });
});