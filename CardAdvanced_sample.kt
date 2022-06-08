@Composable
fun TaskItem(task: Task, onToggle: () -> Unit) {
    Card(
        modifier = Modifier.padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White),
            horizontalArrangement = Arrangement.Start
        ) {
            RoundCheckBox(task.isCompleted, {})

            Column(
                modifier = Modifier
                    .padding(top = 6.dp)
            ) {
                Text(
                    text = task.taskTitle,
                    style = MaterialTheme.typography.h1
                )
                Row(
                    modifier = Modifier
                        .padding(top = 9.dp, bottom = 19.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Due On ${dateToMarudhamStyle(task.taskDueDate)}",
                        style = MaterialTheme.typography.h2
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dot),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_imglogo),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = "${task.imageCount}",
                        style = MaterialTheme.typography.h2
                    )
                }
            }

        }
    }
}
