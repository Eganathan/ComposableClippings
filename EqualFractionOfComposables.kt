Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            DatedBox(false, modifier = Modifier.weight(1f), cropTask)

                            Divider(
                                modifier = Modifier
                                    .heightIn(min = 84.dp)
                                    .width(1.dp)
                                    .background(MarudhamBackground)
                            )

                            DatedBox(true, modifier = Modifier.weight(1f), cropTask)
                        }

//-- Checkout the date sample composable for the child
