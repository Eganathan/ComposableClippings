@Composable
fun AppTopBar() {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MarudhamBackground
        ),
            modifier = Modifier.background(Color.White),
            title = { Text("Your Title",
                        style = MaterialTheme.typography.h2,
                        color = MarudhamBlack)},
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            }
        )
    }
    
    dependency:
    implementation "androidx.compose.material3:material3:1.0.0-alpha12"
    implementation "androidx.compose.material3:material3-window-size-class:1.0.0-alpha12"
