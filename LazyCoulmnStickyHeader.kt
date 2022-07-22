                stickyHeader {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = logsDate.key,
                            style = MaterialTheme.typography.button,
                            modifier = Modifier
                                .padding(start = 20.dp, top = 10.dp, bottom = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                }
