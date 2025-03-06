package com.arbeat.mybankingapps

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.SsidChart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arbeat.mybankingapps.data.Finance
import com.example.mybankingapps.ui.theme.BlueStart
import com.example.mybankingapps.ui.theme.GreenStart
import com.example.mybankingapps.ui.theme.OrangeStart
import com.example.mybankingapps.ui.theme.PurpleStart

val financeList = listOf(
    Finance(
        icon = Icons.Rounded.Star,
        name = "My\nBusiness",
        background = OrangeStart
    ),

    Finance(
        icon = Icons.Rounded.Wallet,
        name = "Finance\nAnalytics",
        background = BlueStart
    ),

    Finance(
        icon = Icons.Rounded.SsidChart,
        name = "Chart\nGraphic",
        background = PurpleStart
    ),

    Finance(
        icon = Icons.Rounded.Money,
        name = "My\nSpend",
        background = GreenStart
    )
)

@Preview(showBackground = true)
@Composable
fun FinanceSection(){
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }

    LazyRow {
        items(financeList.size){
            FinanceItem(it)
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val finance = financeList[index]
    val lastItemPaddingEnd = if(index == financeList.size-1) 16.dp else 0.dp

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable { }
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ){
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }

            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }


}
