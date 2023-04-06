package hs.project.water.ui.theme.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainApp(modifier: Modifier = Modifier) {

    MainHomeScreen(
        currentTab = BottomMenuType.Home,
        onTabPressed = {
                       // TODO 클릭 했을 때 화면 전환 시킬 수 있도록 추가 필요
        },
        modifier = modifier
    )
}
