// Apache Commons Lang WordUtils
public static String initials(String str, char[] delimiters) {
    if (str == null || str.length() == 0) {
        return str;
    }
    if (delimiters != null && delimiters.length == 0) {
        return "";
    }
    // continues...