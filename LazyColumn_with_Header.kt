@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskList(tasks: List<Task>) {
    val groupedTask = groupingTaskData(tasks)
    LazyColumn {
        groupedTask.forEach { group ->

            item {
                StickyHeader(text = group.flag)
            }
            items(
                items = group.list
            ) { item ->
                TaskItem(task = item, {})
            }
        }
    }
}

//Data class of the entity
data class Task(
    var taskTitle: String,
    var taskDescription: String? = null,
    val createdDate: LocalDate,
    var isCompleted: Boolean,
    var taskDueDate: LocalDate,
    var completionDate: LocalDate? = null,
    var listTaskAttachments: List<Int>? = null,
    val imageCount: Int
)
//Data Class of the Task Group with a flag
data class TaskDataGroup(
    val flag: String
) {
    val list = mutableListOf<Task>()
}

//Login of Sorting with flags
fun groupingTaskData(listData: List<Task>): List<TaskDataGroup> {
    val list = mutableListOf<TaskDataGroup>()

    if (listData.isNotEmpty()) {

        list.add(TaskDataGroup(dateToString(listData[0].taskDueDate)))

        //Creating Group
        for (task in listData) {
            if (dateToString(task.taskDueDate) !== list.last().flag) {
                list.add(TaskDataGroup(dateToString(task.taskDueDate)))
            }
        }

        for (taskDataGroupItem in list) {
           taskDataGroupItem.list.clear()
            for (task in listData) {
                if (dateToString(task.taskDueDate) == taskDataGroupItem.flag) {
                    taskDataGroupItem.list.add(task)
                }
            }

        }
    }
    return list
}


//Accomponaying Composables
@Composable
fun StickyHeader(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h1,
        color = Color.Gray,
        modifier = Modifier.padding(top = 20.dp)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
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

@Composable
fun RoundCheckBox(
    isComplete: Boolean,
    onToggle: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(top = 6.dp, start = 12.dp, end = 10.5.dp)
            .clickable(onClick = { onToggle.invoke() })
    ) {

        if (isComplete) {
            Icon(
                painter = painterResource(id = R.drawable.ic_checked_round),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                tint = MarudhamGreen
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_unchecked_round),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
