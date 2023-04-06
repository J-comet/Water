package hs.project.water.ui.theme.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hs.project.water.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHomeScreen(
    currentTab: BottomMenuType,
    onTabPressed: (BottomMenuType) -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        BottomNavItem(
            type = BottomMenuType.Home,
            icon = Icons.Default.Home,
            name = stringResource(id = R.string.main_bottom_tab_home)
        ),
        BottomNavItem(
            type = BottomMenuType.Record,
            icon = Icons.Default.Send,
            name = stringResource(id = R.string.main_bottom_tab_record)
        ),
        BottomNavItem(
            type = BottomMenuType.Price,
            icon = Icons.Default.Add,
            name = stringResource(id = R.string.main_bottom_tab_price)
        ),
    )

    MainBottomNavigationBar(
        currentTab = currentTab,
        onTabPressed = onTabPressed,
        navigationItemContentList = navigationItemContentList
    )
}

@Composable
private fun MainBottomNavigationBar(
    currentTab: BottomMenuType,
    onTabPressed: ((BottomMenuType) -> Unit),
    navigationItemContentList: List<BottomNavItem>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
        NavigationBar(modifier = modifier.clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))) {
            for (navItem in navigationItemContentList) {
                NavigationBarItem(
                    selected = currentTab == navItem.type,
                    onClick = { onTabPressed(navItem.type) },
                    icon = {
                        Icon(
                            imageVector = navItem.icon,
                            contentDescription = navItem.name
                        )
                    }
                )
            }
        }
    }
}

data class BottomNavItem(
    val type: BottomMenuType,
    val name: String,
    val icon: ImageVector
)