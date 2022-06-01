@Composable
fun FourCards() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .background(MarudhamBackground),
          //  .padding(10.dp, bottom = 25.dp),
        content = {
            item {
                //AppCardExpenses()
                CropActionCard(
                    title = "Expenses",
                    icon = painterResource(R.drawable.ic_expense_icon),
                    summary = { IncomeOrExpensesSummary(amount = 899L, isIncome = false) }
                )
            }
            item {
                //AppCardLogs()
                CropActionCard(
                    title = "Logs",
                    icon = painterResource(R.drawable.ic_log_icon),
                    summary = { LogOrTaskSummary(primaryValue = 24,isTask = false) }
                )

            }
            item {
                CropActionCard(
                    title = "Income",
                    icon = painterResource(R.drawable.ic_income_icon),
                    summary = { IncomeOrExpensesSummary(amount = 899L, isIncome = true) }
                )
            }
            item {
                //AppCardTask()
                CropActionCard(
                    title = "Tasks",
                    icon = painterResource(R.drawable.ic_task_icon),
                    summary = { LogOrTaskSummary(primaryValue = 15, secondayValue = 24,isTask = true) }
                )
            }
            item {
                Spacer(modifier = Modifier.padding(5.dp))
            }
        })
}
