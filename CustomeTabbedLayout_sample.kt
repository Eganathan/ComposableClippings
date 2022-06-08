@Composable
fun CustomTabs() {
    var selectedIndex by remember { mutableStateOf(1) }
    val list = listOf("All", "Open", "Completed")

    TabRow(
        selectedTabIndex = selectedIndex,
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20)),
        indicator = {}
    ) {
        list.forEachIndexed { index, text ->
            val selected = selectedIndex == index
            Tab(
                modifier = if (!selected) Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .padding(5.dp)
                    .background(Color.White)
                else Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .padding(5.dp)
                    .background(MarudhamGreen),
                selected = selected,
                onClick = { selectedIndex = index },
                text = {
                    Text(
                        text = text,
                        color = if (!selected) Color.Black else Color.White,
                        fontSize = 14.sp
                    )
                }
            )
        }
    }
}
