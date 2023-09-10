package com.example.logincap3.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import com.example.logincap3.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.logincap3.data.AuthenticationState
import com.example.logincap3.Login.components.LoginButton
import com.example.logincap3.Login.components.PasswordInputField
import com.example.logincap3.Login.components.UserNameField
import com.example.logincap3.util.TestTags.LoginContent.ANDROID_TEXT
import com.example.logincap3.util.TestTags.LoginContent.LOGO_IMAGE

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    uiState: AuthenticationState,
    onUsernameUpdated: (String) -> Unit,
    onPasswordUpdated: (String) -> Unit,
    onLogin: () -> Unit,
    passwordToggleVisibility: (Boolean) -> Unit,
    //onRegister: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.Magenta),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = modifier
                    .testTag(LOGO_IMAGE),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = stringResource(id = R.string.logo)
            )

            Text(
                text = stringResource(id = R.string.hello),
                color = MaterialTheme.colorScheme.surfaceVariant,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(18.dp)
                    .semantics { heading() }
                    .testTag(ANDROID_TEXT),
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
        }

    }

    Card(
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.Magenta)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .scrollable(scrollState, Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            UserNameField(authState = uiState, onValueChanged = onUsernameUpdated)
            PasswordInputField(
                text = "Password",
                authState = uiState,
                onValueChanged = onPasswordUpdated,
                passwordToggleVisibility = passwordToggleVisibility
            )
            LoginButton(
                text = "Sign In",
                enabled = !uiState.loading && uiState.isValidForm(),
                onLoginClicked = onLogin,
                isLoading = uiState.loading
            )
        }
    }
}