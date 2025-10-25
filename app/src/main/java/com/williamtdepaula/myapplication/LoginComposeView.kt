package com.williamtdepaula.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LoginComposeView: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyView()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyView() {
    val context = LocalContext.current

    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }

    Column (
        modifier = Modifier.fillMaxHeight().safeDrawingPadding().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextView(placeholder = "E-mail", isPassword = false, value = email, onValueChange = { email = it })
        TextView(placeholder = "Senha", isPassword = true, value = password, onValueChange = { password = it })

        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MyButton(text = "Entrar", modifier = Modifier.weight(1f)) { Log.d("Press", "Pressinou pra entrar $email $password ") }
            MyButton(text = "Cadastrar", modifier = Modifier.weight(1f)) {
                val toast = Toast(context)
                toast.setText("Pressinou pra cadastrar $email $password")
                toast.show()
            }
        }

    }
}

@Composable
fun TextView(placeholder: String, isPassword: Boolean, value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
        placeholder = { Text(placeholder) },
        visualTransformation = if (isPassword) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    )
}

@Composable
fun MyButton(text: String, modifier: Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonColors(containerColor = Color.Black, contentColor = Color.White, disabledContentColor = Color.Gray, disabledContainerColor = Color.Gray)
    ) {
        Text(text)
    }
}