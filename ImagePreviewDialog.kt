
@Composable
fun ImagePreviewDialog(
    imageResourse: Int,
    showDialog:Boolean,
    onDismiss:()-> Unit){

    var show = showDialog

    if(show){
    Dialog(onDismissRequest = {onDismiss.invoke()}){

            Column(
                modifier = Modifier.padding(top = 10.dp)
            ){

                Button( onClick = { onDismiss.invoke()},
                    modifier = Modifier.clip(RoundedCornerShape(50.dp)).padding(top = 0.dp)){
                    Text(text = "X")
                }

                Image(
                    painter = painterResource(id = imageResourse),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

//Sample Caller of the above composable without pagination..

@Composable
fun ImageAttachmentSection(attachments: List<Int>) {

    var showDialog = remember{mutableStateOf(false)}

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp)
    ) {
        Text(
            text = "Attachments",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 10.dp)
        )

        if (attachments.size > 0) {
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(attachments) { item ->
                    Image(
                        painter = painterResource(id = item),
                        contentDescription = null,
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                            .padding(end = 10.dp, bottom = 5.dp, top = 10.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .clickable(onClick = { showDialog.value = true }),
                        contentScale = ContentScale.Crop,
                    )
                    ImagePreviewDialog(imageResourse = item, showDialog = showDialog.value, onDismiss = {showDialog.value = false})
                }
            }
        } else {
//           Column(
//               modifier = Modifier.heightIn(min = 130.dp)
//           ){
//               SimpleDivider()
//           }

            Text(
                text = "No attachments",
                style = MaterialTheme.typography.h2,
                color = MarudhamGrey,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}
