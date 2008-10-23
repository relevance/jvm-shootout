// from Apache Commons Lang
public static String strip(String str, String stripChars) {
    if (isEmpty(str)) {
        return str;
    }
    str = stripStart(str, stripChars);
    return stripEnd(str, stripChars);
}