// Logo and Text
@Composable
fun FAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = MarudhamGreen,
        contentColor = Color.White,
        shape = RoundedCornerShape(16.dp)
    )
    {
        Row(
            modifier = Modifier.padding(start = 18.dp, top = 13.dp, end = 14.dp, bottom = 13.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_checked_round),
                contentDescription = "",
                modifier = Modifier.padding(end = 14.dp)
            )
            Text(text = "Create Task")
        }
    }
}

//FAB With Text center and custome width here 9 Fractions
@Composable
fun FAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth(0.9F),
    ) {
        Text(text = "Log out", color = MarudhamRed)
    }
}

