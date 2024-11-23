package com.example.instagramprofileui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar("moham3d_amin", modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .padding(top = 20.dp)
            .padding(5.dp))

    }
}

 @Composable
 fun AppBar(
     name:String,
     modifier: Modifier
 ){
     Row(
         horizontalArrangement = Arrangement.SpaceBetween,
         verticalAlignment = Alignment.CenterVertically,
         modifier = modifier
             .fillMaxWidth()
             .padding(10.dp)
     ) {
         Icon(
             imageVector = Icons.AutoMirrored.Filled.ArrowBack,
             contentDescription = "Arrow Back",
             tint = Color.Black,
             modifier = Modifier.size(30.dp)
         )
         Text(name, fontSize = 20.sp, fontWeight = FontWeight.Bold)

         Icon(
             imageVector = Icons.Outlined.Notifications,
             contentDescription = "Notification",
             tint = Color.Black,
             modifier = Modifier.size(30.dp)
         )

         Icon(
             imageVector = Icons.Filled.MoreVert,
             contentDescription = "MoreVert",
             tint = Color.Black,
             modifier = Modifier.size(30.dp)
         )
     }
 }

@Preview(showSystemUi = true)
@Composable
fun ScreenPreview() {
    ProfileScreen()
}


