package com.ccfraser.muirwik.starterapp

import com.ccfraser.muirwik.components.*
import com.ccfraser.muirwik.components.styles.ThemeOptions
import com.ccfraser.muirwik.components.styles.createMuiTheme
import react.*

interface AppState : RState {
    var themeColor: String
}

class App(props: RProps) : RComponent<RProps, AppState>(props) {
    override fun AppState.init() {
        themeColor = "light"
    }

    override fun RBuilder.render() {
        mCssBaseline()

        // Create an object with child objects already created and effectively cast it to ThemeOptions - our demo theme
        // has a lighter primary color than the default theme
        @Suppress("UnsafeCastFromDynamic")
        val themeOptions: ThemeOptions = js("({palette: { type: 'placeholder', primary: {main: 'placeholder'}}})")
        themeOptions.palette?.type = state.themeColor
        themeOptions.palette?.primary.main = Colors.Blue.shade500.toString()

        mThemeProvider(createMuiTheme(themeOptions)) {
            mainFrame("Alibaba") { setState { themeColor = if (themeColor == "dark") "light" else "dark" } }
        }
    }
}

fun RBuilder.app() = child(App::class) {}