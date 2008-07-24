import scala.io.Source

def widthOfLength(s: String) = s.length.toString.length
if (args.length > 0) {
  val lines = Source.fromFile(args(0)).getLines.toList
  val widths = lines.map(widthOfLength)
  val maxWidth = widths.reduceLeft((a,b) => a.max(b))
  for (line <- lines) {
    val padding = " " * (maxWidth - widthOfLength(line))
    print(padding + line.length + " " + line)
  }
}
else 
  Console.err.println("Please enter filename")
