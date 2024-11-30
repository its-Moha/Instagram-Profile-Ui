package com.example.instagramprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar("moham3d_amin", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.padding(4.dp))
        ProfileDescription()

    }
}

 @Composable
 fun AppBar(
     name:String,
     modifier: Modifier = Modifier
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
         Text(name, overflow = TextOverflow.Ellipsis, fontSize = 20.sp, fontWeight = FontWeight.Bold)

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

@Composable
fun ProfileDescription(
    modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id =R.drawable.aa),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f) // this means our image will take 30% of our width
                                // and our stat section will take the other 70%
            )
            Spacer(modifier =Modifier.padding(16.dp))
            StatSection(
                modifier = Modifier
                    .weight(7f)
            )
        }
    }

}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier) {

    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(
                1f, // the square
                matchHeightConstraintsFirst = true // this will look the height of our image and it adjust the width accordingly
                //and what ever our height is it will sign to width
            )
            .border(width = 1.dp
                , color = Color.Gray,
                shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat("100","Posts")
        ProfileStat("900k","Followers")
        ProfileStat("300","Following")
    }
}

@Composable
fun ProfileStat(

    textNumber:String,
    text:String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(textNumber, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text)
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun ScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar("moham3d_amin", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.padding(4.dp))
        ProfileDescription()
    }
}


