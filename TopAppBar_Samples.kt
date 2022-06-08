// not center TOPAPPBAR but with navigation
@Composable
fun TopBar(title: String, navController: NavController) {
    TopAppBar(
        title = { Text(text = title, color = Color.Black) },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        },
        backgroundColor = MarudhamBackground,
        elevation = 0.dp
    )
}
