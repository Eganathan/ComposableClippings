//Same life Lazy row but the balance composables will come to next line,
//if there is n number of items but a row fits only y number of composables then
// the composable will flow to the next line..


FlowRow {
        fieldList.forEach { item -> FieldClickable(fieldName = item.fieldName) }
    }

//Clickable box
@Composable
fun FieldClickable(fieldName: String) {
    Box(
        modifier = Modifier
            .padding(end = 9.dp, top = 9.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                letterSpacing = 0.25.sp,
                lineHeight = 16.sp,
                color = MarudhamGreen,
                textAlign = TextAlign.Center,
                text = fieldName,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1)
        }
    }
}
