package com.example.instagramprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
        Spacer(modifier = Modifier.padding(18.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(18.dp))
        Highlights(
            highlights = listOf(
                StoryHighlights(
                    image = painterResource(id = R.drawable.aboutme),
                    text = "About Me"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.quran),
                    text = "Quran"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.learning),
                    text = "Learning"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.coding),
                    text = "Coding"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.travelimage),
                    text = "Travel"
                )

            ),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        )
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
                    .size(90.dp)
                    .weight(3f) // this means our image will take 30% of our width
                                // and our stat section will take the other 70%
            )
            Spacer(modifier =Modifier.padding(16.dp))
            StatSection(
                modifier = Modifier
                    .weight(7f)
            )

        }
        Spacer(modifier =Modifier.padding(4.dp))
        ProfileInfo(
            displayName = "Mohamed Amiin",
            description = "Software Engineer/Android Dev \n" +
                    "funniest man a live \n" +
                    "follow me on Github",
            url = "https://github.com/its-Moha?tab=repositories",
            followedBy = listOf("Bil Gates", "Elon Musk"),
            otherCount = 17
        )
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
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = CircleShape
            )
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

@Composable
fun ProfileInfo(
    displayName:String,
    description:String,
    url:String,
    followedBy:List<String>,
    otherCount:Int

) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {

        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = url,
            color = Color(0xff3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if (followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    append("followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                        if (otherCount > 2){
                            append(" and ")
                            pushStyle(boldStyle)
                            append("$otherCount others")
                        }


                },
                lineHeight = lineHeight,
                letterSpacing = letterSpacing

            )
        }

    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Filled.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(

            icon = Icons.Filled.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )
    }
    
}

@Composable
fun ActionButton(

    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null){
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
    
}

@Composable
fun Highlights(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlights>
) {

    LazyRow(modifier = modifier){
        //how many items do we have
        items(highlights.size ){
            // how our one single highlight will look like
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    highlights[it].text,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}



@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun ScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar("moham3d_amin", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.padding(4.dp))
        ProfileDescription()
        Spacer(modifier = Modifier.padding(18.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(20.dp))
        Highlights(
            highlights = listOf(
                StoryHighlights(
                    image = painterResource(id = R.drawable.aboutme),
                    text = "About Me"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.quran),
                    text = "Quran"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.learning),
                    text = "Learning"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.coding),
                    text = "Coding"
                ),
                StoryHighlights(
                    image = painterResource(id = R.drawable.travelimage),
                    text = "Travel"
                )

            ),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        )
    }
}


