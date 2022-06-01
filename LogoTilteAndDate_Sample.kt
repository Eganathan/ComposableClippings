@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatedBox(isCompleted: Boolean, modifier: Modifier, cropTask: CropTask) {
    var title = "Due on"
    var date = dateToString(cropTask.taskDueDate)
    var icon = painterResource(R.drawable.ic_coolicondate)

    if (isCompleted) {
        title = "Completed on"
        icon = painterResource(R.drawable.ic_vectorflag)

        date = if (cropTask.completionDate != null) {
            dateToString(cropTask.completionDate!!)
        } else {
            ""
        }
    }

    Column(
        modifier = modifier
            //.padding(horizontal = 20.dp, vertical = 15.dp)
            .background(Color.White)
            .heightIn(min = 75.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icon,
                contentDescription = null,
                tint = MarudhamGreen,
                modifier = Modifier
                    .padding(start = 21.17.dp, top = 20.dp, end = 6.7.dp, bottom = 10.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(top = 15.dp, bottom = 5.dp)
            )
        }

        if (isCompleted) {

            if (!date.isEmpty()) {
                Text(
                    text = date,
                    Modifier.padding(start = 20.dp, bottom = 15.dp),
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center
                )
            } else {
                SimpleDivider()
            }

        } else {
            Text(
                text = date,
                modifier = Modifier.padding(start = 20.dp, bottom = 15.dp),
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center
            )
        }
    }
}
