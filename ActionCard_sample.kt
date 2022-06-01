@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CropActionCard(
    title: String,
    onClick: () -> Unit = {},
    icon: Painter,
    summary: @Composable() () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = 10.dp,
        onClick = { onClick.invoke() },
        modifier = Modifier
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(25.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = icon,
                contentDescription = ""
            )

            Text(
                text = title,
                style = MaterialTheme.typography.h4,
                color = Color.Black,
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight.Bold ,
                modifier = Modifier.padding(top = 36.dp, bottom = 5.dp)
            )
            summary.invoke()
        }
    }
}
