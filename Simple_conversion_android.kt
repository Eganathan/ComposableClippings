
//HEX to ARGB -> To match the exact colors of the figma
//.background(color = "#F4F4F4".hexConverter)
val String.hexConverter
    get() = Color(parseColor(this))
