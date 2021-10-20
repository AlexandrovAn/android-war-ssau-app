package com.example.android_war_ssau_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.android_war_ssau_app.R
import com.example.android_war_ssau_app.ui.theme.primaryColor
import com.example.android_war_ssau_app.ui.theme.whiteBackground

@Preview
@Composable
fun LoginPage() {

    val logo = painterResource(id = R.drawable.gerb_vuts)
    val passIcon = painterResource(id = R.drawable.password_eye)

    val loginValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val rememberScrollState = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val (vuc_logo, login_block) = createRefs()

        Image(
            painter = logo,
            contentDescription = "Герб ВУЦ",
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .constrainAs(vuc_logo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(login_block.top, margin = 0.dp)
                },
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .padding(10.dp, 0.dp, 10.dp, 10.dp)
                .constrainAs(login_block) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(vuc_logo.bottom, margin = 0.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }

        ) {
            Text(
                text = "Войти",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                ),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                OutlinedTextField(
                    value = loginValue.value,
                    onValueChange = { loginValue.value = it },
                    label = { Text(text = "Логин") },
                    placeholder = { Text("Логин") },
                    modifier = Modifier.background(Color.Transparent)
                )

                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    label = { Text("Пароль") },
                    visualTransformation =
                    if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                painter = passIcon,
                                "Пароль",
                                tint = if (passwordVisibility.value) primaryColor else Color.Gray
                            )
                        }
                    },
                    placeholder = { Text("Пароль") },
                    singleLine = true,
                    modifier = Modifier.background(Color.Transparent)
                )

                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(text = "Войти", fontSize = 20.sp, color = Color.White)
                }

                Spacer(modifier = Modifier.padding(20.dp))
                Text(text = "Зарегистироваться в личном кабинете")
                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}